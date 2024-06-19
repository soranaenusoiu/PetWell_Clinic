package org.example.petwell_clinic.repository;

import org.example.petwell_clinic.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
