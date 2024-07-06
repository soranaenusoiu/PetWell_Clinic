package org.example.petwell_clinic.service;

import lombok.RequiredArgsConstructor;
import org.example.petwell_clinic.entity.Owner;
import org.example.petwell_clinic.entity.Pet;
import org.example.petwell_clinic.repository.OwnerRepository;
import org.example.petwell_clinic.repository.PetRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class PetService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;


    public void addPet(Pet pet, Long ownerId) {
        Owner owner = ownerRepository.getReferenceById(ownerId);
        pet.setOwner(owner);
        petRepository.save(pet);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

//    public List<Pet> getAllPetsByOwner() {
//        return petRepository.findAll().stream()
//                .map(pet -> pet.getName())
//                .collect(Collectors.toList());
//    }
    public List<Pet> getPetsByOwner(String name) {
        return (List<Pet>) petRepository.findPetsByOwner_Name(name);
    }

    public void updatePetByField(Pet pet, Long petId) {
        Pet petToUpdate = petRepository.findById(petId).orElseThrow(NoSuchElementException::new);
        petToUpdate.setSpecies(pet.getSpecies());
        petToUpdate.setBreed(pet.getBreed());
        petToUpdate.setName(pet.getName());
        petToUpdate.setAge(pet.getAge());
        petToUpdate.setWeight(pet.getWeight());
        petRepository.save(petToUpdate);
    }

    public void deletePet(Long petId) {
        Pet petToDelete = petRepository.findById(petId).orElseThrow(NoSuchElementException::new);
        petRepository.delete(petToDelete);
    }


}
