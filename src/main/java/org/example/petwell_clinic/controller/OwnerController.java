package org.example.petwell_clinic.controller;


import lombok.RequiredArgsConstructor;
import org.example.petwell_clinic.entity.Owner;
import org.example.petwell_clinic.entity.Veterinary;
import org.example.petwell_clinic.service.OwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OwnerController {

    private final OwnerService ownerService;

    @PostMapping("/add")
    public void addOwner(@RequestBody Owner owner) {
        ownerService.addOwner(owner);
    }

    @GetMapping("/get")
    public List<Owner> getOwners() {
        return ownerService.getAllOwners();
    }

    @GetMapping("/getOwnerByPhone/{phone}")
    public Owner getOwnerByPhone(@PathVariable(name = "phone") String phone) {
        return ownerService.getOwnerByPhone(phone);
    }

    @GetMapping("getByName/{name}")
    public Owner getOwnerByName(@PathVariable(name = "name") String name) {
        return ownerService.getOwnerByName(name);
    }

    @GetMapping("getById/{owner_id}")
    public Owner getOwnerById(@PathVariable(name = "owner_id") Long ownerId) {
        return ownerService.getOwnerById(ownerId);
    }

    @PutMapping("/update/{owner_id}")
    public void updateOwner(@RequestBody Owner owner, @PathVariable(name = "owner_id") Long ownerId) {
        ownerService.updateOwnerByField(owner, ownerId);
    }

    @DeleteMapping("/delete/{owner_id}")
    public void deleteOwner(@PathVariable(name = "owner_id") Long ownerId) {
        ownerService.deleteOwner(ownerId);
    }

}
