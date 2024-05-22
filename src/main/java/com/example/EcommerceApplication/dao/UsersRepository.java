package com.example.EcommerceApplication.dao;

import com.example.EcommerceApplication.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long > {

}
