package org.example.petwell_clinic.repository;

import org.example.petwell_clinic.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    Pet findByOwner(Long ownerId);
}
