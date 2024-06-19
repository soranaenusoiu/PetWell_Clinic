package org.example.petwell_clinic.repository;

import org.example.petwell_clinic.entity.Veterinary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinaryRepository extends JpaRepository<Veterinary, Long> {
}
