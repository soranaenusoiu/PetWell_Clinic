package org.example.petwell_clinic.controller;

import org.example.petwell_clinic.entity.Veterinary;
import org.example.petwell_clinic.service.VeterinaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veterinary")
public class VeterinaryController {

    private final VeterinaryService veterinaryService;

    public VeterinaryController(VeterinaryService veterinaryService) {
        this.veterinaryService = veterinaryService;
    }


    @PostMapping("/add")
    public void addCar(@RequestBody Veterinary veterinary) {
        veterinaryService.addVeterinary(veterinary);
    }

    @GetMapping("/getAll")
    public List<Veterinary> getAllVeterinary() {
        return veterinaryService.getAllVeterinary();
    }

    @GetMapping("/getById/{veterinaryId}")
    public Optional<Veterinary> getVeterinaryById(@PathVariable(name = "veterinaryId") long id) {
        return veterinaryService.getVeterinaryByID(id);
    }

    @GetMapping("getName/{veterinaryName}")
    public Optional<Veterinary> getVeterinaryByName(@PathVariable(name = "veterinaryName") String name) {
        return veterinaryService.getVeterinaryByName(name);
    }

    @PutMapping("/update")
    public void updateVeterinary(@RequestBody Veterinary veterinary) {
        veterinaryService.updateVeterinaryByObject(veterinary);
    }

    @DeleteMapping("/deleteId/{veterinaryId}")
    public void deleteVeterinaryById(@PathVariable(name = "veterinaryId") long id) {
        veterinaryService.deleteVeterinaryById(id);
    }

}
