package com.DeepakDey.MediSlot_bakend.repository;


import com.DeepakDey.MediSlot_bakend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Long , User> {
    Optional<User> findByContact(String contact);
    boolean existsByContact(String contact);
}
