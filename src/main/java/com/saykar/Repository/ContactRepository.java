package com.saykar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.saykar.Model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
