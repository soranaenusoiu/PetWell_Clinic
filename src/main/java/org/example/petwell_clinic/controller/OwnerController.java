package org.example.petwell_clinic.controller;


import org.example.petwell_clinic.entity.Owner;
import org.example.petwell_clinic.service.OwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/add")
    public String addOwner(@RequestBody Owner owner) {
        return ownerService.addOwner(owner);
    }

//    @PostMapping("/addPetToOwner")
//    public String addPetToOwner(@RequestParam Long pet_id, @RequestParam Long owner_id) {
//        return ownerService.addPetToOwner(pet_id, owner_id);
//    }


    @GetMapping("/get")
    public List<Owner> getOwners() {
        return ownerService.getAllOwners();
    }

    @GetMapping("/getOwnerByPhone/{phone}")
    public Owner getOwnerByPhone(@PathVariable(name = "phone") String phone) {
        return ownerService.getOwnerByPhone(phone);
    }

    @PutMapping("/update/{owner_id}")
    public String updateOwner(@RequestBody Owner owner, @PathVariable(name = "owner_id") Long owner_id) {
        return ownerService.updateOwnerByField(owner, owner_id);
    }


    @DeleteMapping("/delete/{owner_id}")
    public String deleteOwner(@PathVariable(name = "owner_id") Long owner_id) {
        return ownerService.deleteOwner(owner_id);
    }

}
