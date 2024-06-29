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
//        return (veterinaryRepository.findAll().stream().filter(veterinary -> veterinary.getName().equals(name))).findFirst()
//                .orElseThrow(NoSuchElementException::new);
        return veterinaryRepository.findVeterinaryByName(name);
    }

    public String updateVeterinaryByObject(Veterinary veterinary) {
        System.out.println(veterinary);
        Veterinary veterinaryToUpdate = veterinaryRepository.findById(veterinary.getId())
                .orElseThrow(NoSuchElementException::new);
        veterinaryToUpdate.setName(veterinary.getName());
        veterinaryToUpdate.setMail(veterinary.getMail());
        veterinaryToUpdate.setPhone(veterinary.getPhone());
        veterinaryToUpdate.setSpeciality(veterinary.getSpeciality());
        veterinaryRepository.save(veterinaryToUpdate);
        return ("veterinary updated");
    }

    public String deleteVeterinaryById(long id) {
        Veterinary veterinaryToDelete = veterinaryRepository.findById(id).orElseThrow(NoSuchElementException::new);
        veterinaryRepository.delete(veterinaryToDelete);
        return ("veterinary deleted");
    }

}
