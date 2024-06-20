package org.example.petwell_clinic.controller;

import org.example.petwell_clinic.entity.Owner;
import org.example.petwell_clinic.entity.Pet;
import org.example.petwell_clinic.service.OwnerService;
import org.example.petwell_clinic.service.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    private final OwnerService ownerService;
    private PetService petService;

    public PetController(PetService petService, OwnerService ownerService) {
        this.petService = petService;
        this.ownerService = ownerService;
    }

    @PostMapping("/add/{owner_id}")
    public String addOwner(@RequestBody Pet pet, @PathVariable(name = "owner_id") Long ownerId) {
        return petService.addPet(pet, ownerId);
    }

    @GetMapping("/get")
    public List<Pet> getPets() {
        return petService.getAllPets();
    }

    @PutMapping("/update/{pet_id}")
    public String updatePet(@RequestBody Pet pet, @PathVariable(name = "pet_id") Long petId) {
        return petService.updatePetByField(pet, petId);
    }

    @DeleteMapping("/delete/{pet_id}")
    public String deletePet(@PathVariable(name = "pet_id") Long petId) {
        return petService.deletePet(petId);
    }


}
