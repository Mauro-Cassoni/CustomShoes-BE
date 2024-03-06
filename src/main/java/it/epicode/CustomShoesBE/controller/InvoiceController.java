package it.epicode.CustomShoesBE.controller;

import it.epicode.CustomShoesBE.exception.BadRequestExceptionHandler;
import it.epicode.CustomShoesBE.exception.NotFoundException;
import it.epicode.CustomShoesBE.repository.InvoiceRepository;
import it.epicode.CustomShoesBE.request.InvoiceRequest;
import it.epicode.CustomShoesBE.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import it.epicode.CustomShoesBE.responses.DefaultResponse;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceRepository invoiceRepository;


    @GetMapping("")
    public ResponseEntity<DefaultResponse> getAll(Pageable pageable){
        return DefaultResponse.noMessage(invoiceService.getAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getById(@PathVariable long id)throws NotFoundException {
        return DefaultResponse.noMessage(invoiceService.getById(id),HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<DefaultResponse> create(@RequestBody @Validated InvoiceRequest invoiceRequest, BindingResult bindingResult) throws BadRequestExceptionHandler, NotFoundException {
        if (bindingResult.hasErrors()) throw new BadRequestExceptionHandler(bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList().toString());
        return DefaultResponse.noMessage(invoiceService.save(invoiceRequest), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> update(@PathVariable long id, @RequestBody @Validated InvoiceRequest invoiceRequest, BindingResult bindingResult) throws BadRequestExceptionHandler, NotFoundException {
        if (bindingResult.hasErrors()) throw new BadRequestExceptionHandler(bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList().toString());
        return DefaultResponse.noMessage(invoiceService.update(id, invoiceRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> delete(@PathVariable long id) throws NotFoundException {
        invoiceService.delete(id);
        return DefaultResponse.noObject("Invoice with number " + id + " has been deleted", HttpStatus.OK);
    }
}
