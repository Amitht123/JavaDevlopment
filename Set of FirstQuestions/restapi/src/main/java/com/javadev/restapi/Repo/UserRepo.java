package com.javadev.restapi.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javadev.restapi.Model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
