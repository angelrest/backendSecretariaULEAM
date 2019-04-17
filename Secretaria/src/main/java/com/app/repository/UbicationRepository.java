package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Ubication;

@Repository
public interface UbicationRepository extends JpaRepository<Ubication, Long> {

	Ubication findByName(String name);

}
