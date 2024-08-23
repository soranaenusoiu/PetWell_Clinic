package org.example.petwell_clinic.service;

import lombok.RequiredArgsConstructor;
import org.example.petwell_clinic.entity.User;
import org.example.petwell_clinic.entity.Veterinary;
import org.example.petwell_clinic.repository.UsersRepository;
import org.example.petwell_clinic.repository.VeterinaryRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class VeterinaryService {

    private final VeterinaryRepository veterinaryRepository;
    private final UsersRepository usersRepository;

    public void addVeterinary(Veterinary veterinary, String password, String authority) {
        veterinaryRepository.save(veterinary);
        String pw_hash = BCrypt.hashpw(password, BCrypt.gensalt());
        usersRepository.save(new User(veterinary.getMail(), "{bcrypt}" + pw_hash, true, authority));
    }

    public List<Veterinary> getAllVeterinary() {
        return veterinaryRepository.findAll();
    }

    public Veterinary getVeterinaryByID(long id) {
        return veterinaryRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Veterinary getVeterinaryByName(String name) {
        return veterinaryRepository.findVeterinaryByName(name);
    }

    public void updateVeterinaryByObject(Veterinary veterinary) {
        veterinaryRepository.save(veterinary);
    }

    public void deleteVeterinaryById(long id) {
        Veterinary veterinaryToDelete = veterinaryRepository.findById(id).orElseThrow(NoSuchElementException::new);
        veterinaryRepository.delete(veterinaryToDelete);
    }

}
