package org.example.petwell_clinic.service;

import lombok.RequiredArgsConstructor;
import org.example.petwell_clinic.entity.Veterinary;
import org.example.petwell_clinic.repository.VeterinaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    public Optional<Veterinary> getVeterinaryByName(String name) {
        return (veterinaryRepository.findAll().stream().filter(veterinary -> veterinary.getName().equals(name))).findFirst();
///  de corectat
    }

    public String updateVeterinaryByObject(Veterinary veterinary) {
        Optional<Veterinary> veterinaryToUpdate = veterinaryRepository.findById(veterinary.getVeterinaryId());
        if (veterinaryToUpdate.isPresent()) {
            veterinaryRepository.save(veterinary);
            return ("veterinary updated");
        }
        return ("veterinary not found");
    }

    public String deleteVeterinaryById(long id) {
        Optional<Veterinary> veterinaryToDelete = veterinaryRepository.findById(id);
        if (veterinaryToDelete.isPresent()) {
            veterinaryRepository.deleteById(id);
            return ("veterinary deleted");
        }
        return ("veterinary not found");
    }

}
