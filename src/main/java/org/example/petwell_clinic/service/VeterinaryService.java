package org.example.petwell_clinic.service;

import org.example.petwell_clinic.entity.Appointment;
import org.example.petwell_clinic.entity.Schedule;
import org.example.petwell_clinic.entity.Veterinary;
import org.example.petwell_clinic.repository.VeterinaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinaryService {

    private final VeterinaryRepository veterinaryRepository;

    public VeterinaryService(VeterinaryRepository veterinaryRepository) {
        this.veterinaryRepository=veterinaryRepository;
    }


    public void addVeterinary(Veterinary veterinary){
            veterinaryRepository.save(veterinary);
    }

    public List<Veterinary> getAllVeterinary(){
            return veterinaryRepository.findAll();
    }

    public Optional <Veterinary> getVeterinaryByID (long id){
        return (veterinaryRepository.findById(id));
    }

    public Optional <Veterinary> getVeterinaryByName(String name) {
        return (veterinaryRepository.findAll().stream().filter(veterinary -> veterinary.getName().equals(name))).findFirst();
///  de corectat
    }

    public String updateVeterinaryByObject(Veterinary veterinary){
        Optional <Veterinary> veterinaryToUpdate=veterinaryRepository.findById(veterinary.getVeterinary_id());
        if(veterinaryToUpdate.isPresent()) {
            veterinaryRepository.save(veterinary);
            return("veterinary updated");
        }
        return ("veterinary not found");
    }

    public String deleteVeterinaryById(long id) {
        Optional <Veterinary> veterinaryToDelete=veterinaryRepository.findById(id);
        if (veterinaryToDelete.isPresent()){
            veterinaryRepository.deleteById(id);
            return ("veterinary deleted");
        }
        return ("veterinary not found");
    }

}
