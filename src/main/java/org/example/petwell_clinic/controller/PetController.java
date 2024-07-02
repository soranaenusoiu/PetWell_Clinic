package org.example.petwell_clinic.controller;

import lombok.RequiredArgsConstructor;
import org.example.petwell_clinic.entity.Owner;
import org.example.petwell_clinic.entity.Pet;
import org.example.petwell_clinic.service.OwnerService;
import org.example.petwell_clinic.service.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pet")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PetController {

    private final OwnerService ownerService;
    private final PetService petService;

//    public PetController(PetService petService, OwnerService ownerService) {
//        this.petService = petService;
//        this.ownerService = ownerService;
//    }

    @PostMapping("/add/{owner_id}")
    public String addPet(@RequestBody Pet pet, @PathVariable(name = "owner_id") Long ownerId) {
        return petService.addPet(pet, ownerId);
    }

    @GetMapping("/get")
    public List<Pet> getPets() {
        return petService.getAllPets();
    }

//    @GetMapping("/get/{owner_id}")
//    public Pet getPetsByOwner(@PathVariable(name = "owner_id") Long ownerId) {
//        Owner owner = ownerService.getOwnerById(ownerId);
//        return petService.getPetsByOwner(owner);
//    }
     @GetMapping("/get_by_name")
     public List<Pet> getPetsByOwner(@RequestParam String name) {
         return petService.getPetsByOwner(name);
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
