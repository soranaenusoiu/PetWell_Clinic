package org.example.petwell_clinic.service;

import lombok.RequiredArgsConstructor;
import org.example.petwell_clinic.entity.Owner;
import org.example.petwell_clinic.entity.Veterinary;
import org.example.petwell_clinic.repository.OwnerRepository;
import org.example.petwell_clinic.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;

    public void addOwner(Owner owner) {
        ownerRepository.save(owner);
    }
//    public String addPetToOwner(Long pet_id, Long owner_id) {
//        Pet pet = petRepository.findById(pet_id)
//                .orElseThrow(() -> new RuntimeException("Pet not found"));
//        Owner owner = ownerRepository.findById(owner_id)
//                .orElseThrow(() -> new RuntimeException("Owner not found"));
//        owner.getPets().add(pet);
//        pet.setOwner(owner);
//        petRepository.save(pet);
//        ownerRepository.save(owner);
//        return "Pet added successfully";
//    }

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public Owner getOwnerByPhone(String phone) {
        return ownerRepository.findByPhone(phone);
    }


    public Owner getOwnerById(Long ownerId) {
        return ownerRepository.findById(ownerId).orElseThrow(NoSuchElementException::new);
    }

    public Owner getOwnerByName(String name) {
        return  ownerRepository.findByName(name);
    }

    public void updateOwnerByField(Owner owner, Long ownerId) {
        Owner ownerToUpdate = ownerRepository.findById(ownerId).orElseThrow(NoSuchElementException::new);
        ownerToUpdate.setName(owner.getName());
        ownerToUpdate.setPhone(owner.getPhone());
        ownerToUpdate.setAddress(owner.getAddress());
        ownerToUpdate.setEmail(owner.getEmail());
        ownerRepository.save(ownerToUpdate);
    }

//    public String deleteOwner(Long ownerId) {
////        Owner owner = ownerRepository.findById(id)
////                .orElseThrow(() -> new RuntimeException("Owner not found"));
////        ownerRepository.delete(owner);
////        return "Owner deleted successfully";
//
//        Optional<Owner> ownerToDelete = ownerRepository.findAll().stream()
//                .filter(owner -> owner.getOwnerId().equals(ownerId))
//                .findFirst();
//
//        if (ownerToDelete.isPresent()) {
//            ownerRepository.delete(ownerToDelete.get());
//            return "Owner deleted successfully";
//        }
//        return "Owner not found";

    public void deleteOwner(Long ownerId) {
        Owner ownerToDelete = ownerRepository.findById(ownerId).orElseThrow(NoSuchElementException::new);
        ownerRepository.delete(ownerToDelete);
    }


}
