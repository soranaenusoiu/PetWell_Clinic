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
public class OwnerService {


    private OwnerRepository ownerRepository;
    private PetRepository petRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public String addOwner(Owner owner) {
        ownerRepository.save(owner);
        return "Owner added successfully";

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
        return ownerRepository.findAll().stream().filter(owner -> owner.getPhone().equals(phone))
                .collect(Collectors.toList()).get(0);
    }


    public String updateOwnerByField(Owner owner, Long owner_id) {
        Optional<Owner> ownerToUpdate = ownerRepository.findById(owner_id);
        if (ownerToUpdate.isPresent()) {
            ownerToUpdate.get().setName(owner.getName());
            ownerToUpdate.get().setPhone(owner.getPhone());
            ownerToUpdate.get().setAddress(owner.getAddress());
            ownerToUpdate.get().setEmail(owner.getEmail());

            ownerRepository.save(ownerToUpdate.get());
            return "Owner updated successfully";
        }
        return "Owner not found";
    }

    public String deleteOwner(Long owner_id) {
//        Owner owner = ownerRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Owner not found"));
//        ownerRepository.delete(owner);
//        return "Owner deleted successfully";

        Optional<Owner> ownerToDelete = ownerRepository.findAll().stream()
                .filter(owner -> owner.getOwner_id().equals(owner_id))
                .findFirst();

        if (ownerToDelete.isPresent()) {
            ownerRepository.delete(ownerToDelete.get());
            return "Owner deleted successfully";
        }
        return "Owner not found";
    }


}
