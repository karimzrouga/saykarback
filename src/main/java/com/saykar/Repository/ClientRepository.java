package com.saykar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saykar.Model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	Client findByUsername(String username);

}
