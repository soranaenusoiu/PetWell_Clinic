package org.example.petwell_clinic.controller;

import lombok.RequiredArgsConstructor;
import org.example.petwell_clinic.entity.Veterinary;
import org.example.petwell_clinic.service.VeterinaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/veterinary")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VeterinaryController {

    @RequiredArgsConstructor
    public static class NewVeterinary {
        public Veterinary veterinary;
        public String password;
    }

    private final VeterinaryService veterinaryService;

    @PostMapping("/add")
    public void addVeterinary(@RequestBody NewVeterinary newVeterinary) {
        veterinaryService.addVeterinary(newVeterinary.veterinary, newVeterinary.password, "ROLE_VETERINARY");
    }

    @GetMapping("getByName/{veterinaryName}")
    public Veterinary getVeterinaryByName(@PathVariable(name = "veterinaryName") String name) {
        return veterinaryService.getVeterinaryByName(name);
    }

//    @GetMapping("getById/{veterinaryId}")
//    public Veterinary getVeterinaryById(@PathVariable(name = "veterinaryId") long id) {
//        return veterinaryService.getVeterinaryByID(id);
//    }

    @GetMapping("/getAll")
    public List<Veterinary> getAllVeterinary() {
        return veterinaryService.getAllVeterinary();
    }

    @PutMapping("/update")
    public void updateVeterinary(@RequestBody Veterinary veterinary) {
        veterinaryService.updateVeterinaryByObject(veterinary);
    }
    
    @DeleteMapping("/deleteById/{veterinaryId}")
    public void deleteVeterinaryById(@PathVariable(name = "veterinaryId") long id) {
        veterinaryService.deleteVeterinaryById(id);
    }
}
