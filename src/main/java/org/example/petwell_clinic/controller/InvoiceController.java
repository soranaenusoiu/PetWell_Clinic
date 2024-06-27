package org.example.petwell_clinic.controller;

import lombok.RequiredArgsConstructor;
import org.example.petwell_clinic.entity.Invoice;
import org.example.petwell_clinic.entity.Owner;
import org.example.petwell_clinic.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping("/add")
    public String addInvoice(@RequestBody Invoice invoice) {
        return invoiceService.addInvoice(invoice);
    }

    @GetMapping("/get")
    public List<Invoice> getInvoices() {
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/getInvoiceByOwnerId/{owner_id}")
    public Invoice getInvoiceByOwnerId(@PathVariable(name = "owner_id") Long ownerId) {
       return invoiceService.getInvoiceByOwnerId(ownerId);
    }

    @PutMapping("/pay/{invoice_id}")
    public String payInvoice(@PathVariable(name = "invoice_id") Long invoiceId) {
        return invoiceService.payInvoice(invoiceId);
    }

}
