package org.example.petwell_clinic.service;

import lombok.RequiredArgsConstructor;
import org.example.petwell_clinic.entity.Invoice;
import org.example.petwell_clinic.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public String addInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
        return "Invoice added";
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceByOwnerId(Long ownerId) {
        return invoiceRepository.findInvoiceById(ownerId);
    }

    public String updateInvoice(Long invoiceId, Invoice invoice) {
        Invoice existingInvoice = invoiceRepository.findById(invoiceId).orElseThrow(NoSuchElementException::new);
        existingInvoice.setSum(invoice.getSum());
        existingInvoice.setStatus(invoice.isStatus());
        invoiceRepository.save(existingInvoice);
        return "Invoice updated successfully";
    }

}
