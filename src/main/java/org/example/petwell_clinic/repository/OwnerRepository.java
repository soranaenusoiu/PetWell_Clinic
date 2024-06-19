package org.example.petwell_clinic.repository;

import org.example.petwell_clinic.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
