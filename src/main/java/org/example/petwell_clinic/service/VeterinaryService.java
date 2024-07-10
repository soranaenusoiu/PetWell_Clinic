package org.example.petwell_clinic.service;

import lombok.RequiredArgsConstructor;
import org.example.petwell_clinic.entity.Veterinary;
import org.example.petwell_clinic.repository.VeterinaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class VeterinaryService {

    private final VeterinaryRepository veterinaryRepository;


    public void addVeterinary(Veterinary veterinary) {
        veterinaryRepository.save(veterinary);
    }

    public List<Veterinary> getAllVeterinary() {
        return veterinaryRepository.findAll();
    }

    public Veterinary getVeterinaryByID(long id) {
        return veterinaryRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Veterinary getVeterinaryByName(String name) {
        return veterinaryRepository.findVeterinaryByName(name);
    }

    public void updateVeterinaryByObject(Veterinary veterinary) {
        veterinaryRepository.save(veterinary);
    }

    public void deleteVeterinaryById(long id) {
        Veterinary veterinaryToDelete = veterinaryRepository.findById(id).orElseThrow(NoSuchElementException::new);
        veterinaryRepository.delete(veterinaryToDelete);
    }

}
