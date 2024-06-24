package org.example.petwell_clinic.repository;

import org.example.petwell_clinic.entity.Veterinary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinaryRepository extends JpaRepository<Veterinary, Long> {
    Veterinary findVeterinaryByName(String veterinaryName);
}
