package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.SendName;

@Repository
public interface SendNameRepository extends JpaRepository<SendName, Long> {

	SendName findByName(String name);

}
