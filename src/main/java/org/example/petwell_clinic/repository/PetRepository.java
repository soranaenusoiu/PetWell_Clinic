package org.example.petwell_clinic.repository;

import org.example.petwell_clinic.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
