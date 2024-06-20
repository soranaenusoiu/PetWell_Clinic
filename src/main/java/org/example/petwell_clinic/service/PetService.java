package org.example.petwell_clinic.service;

import lombok.RequiredArgsConstructor;
import org.example.petwell_clinic.entity.Owner;
import org.example.petwell_clinic.entity.Pet;
import org.example.petwell_clinic.repository.OwnerRepository;
import org.example.petwell_clinic.repository.PetRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;


    public String addPet(Pet pet, Long owner_id) {
        Owner owner = ownerRepository.getReferenceById(owner_id);
        pet.setOwner(owner);
        petRepository.save(pet);
        return "Pet added successfully";
    }


    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }


//    public List<String> getAllPetsByOwner() {
//        return petRepository.findAll().stream()
//                .map(pet -> pet.getName())
//                .collect(Collectors.toList());
//    }


    public String updatePetByField(Pet pet, Long pet_id) {
        Pet petToUpdate = petRepository.findById(pet_id).orElseThrow(NoSuchElementException::new);
        petToUpdate.setSpecies(pet.getSpecies());
        petToUpdate.setBreed(pet.getBreed());
        petToUpdate.setName(pet.getName());
        petToUpdate.setAge(pet.getAge());
        petToUpdate.setWeight(pet.getWeight());
        petRepository.save(petToUpdate);
        return "Pet updated successfully";
    }

    public String deletePet(Long pet_id) {
        Pet petToDelete = petRepository.findById(pet_id).orElseThrow(NoSuchElementException::new);
        petRepository.delete(petToDelete);
        return "Pet deleted successfully";
    }


}
