package org.example.petwell_clinic.service;

import org.example.petwell_clinic.entity.Owner;
import org.example.petwell_clinic.entity.Pet;
import org.example.petwell_clinic.repository.OwnerRepository;
import org.example.petwell_clinic.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetService {

    private final OwnerRepository ownerRepository;
    private PetRepository petRepository;

    public PetService(PetRepository petRepository, OwnerRepository ownerRepository) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
    }

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
        Optional<Pet> PetToUpdate = petRepository.findById(pet_id);
        if (PetToUpdate.isPresent()) {
            PetToUpdate.get().setSpecies(pet.getSpecies());
            PetToUpdate.get().setBreed(pet.getBreed());
            PetToUpdate.get().setName(pet.getName());
            PetToUpdate.get().setAge(pet.getAge());
            PetToUpdate.get().setWeight(pet.getWeight());

            petRepository.save(PetToUpdate.get());
            return "Pet updated successfully";
        }
        return "Pet not found";
    }

    public String deletePet(Long pet_id) {
        Optional<Pet> petToDelete = petRepository.findAll().stream()
                .filter(pet -> pet.getPet_id().equals(pet_id))
                .findFirst();

        if (petToDelete.isPresent()) {
            petRepository.delete(petToDelete.get());
            return "Pet deleted successfully";
        }
        return "Pet not found";
    }


}
