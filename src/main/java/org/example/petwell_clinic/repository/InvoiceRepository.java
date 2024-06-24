package org.example.petwell_clinic.repository;

import org.example.petwell_clinic.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    Invoice findInvoiceByInvoiceId(long invoiceId);
}
