package org.example.petwell_clinic.repository;

import org.example.petwell_clinic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {



}
