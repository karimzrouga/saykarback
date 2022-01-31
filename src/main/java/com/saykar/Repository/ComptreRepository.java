package com.saykar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saykar.Model.Compte;

public interface ComptreRepository extends JpaRepository<Compte, Integer> {

}
