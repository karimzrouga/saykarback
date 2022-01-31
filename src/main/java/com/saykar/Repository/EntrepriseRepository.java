package com.saykar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.saykar.Model.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {
	Entreprise findByUsername(String username);
}
