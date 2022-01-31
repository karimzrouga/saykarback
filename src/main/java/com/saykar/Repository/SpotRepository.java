package com.saykar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saykar.Model.Spot;

public interface SpotRepository extends JpaRepository<Spot, Integer> {
	

}
