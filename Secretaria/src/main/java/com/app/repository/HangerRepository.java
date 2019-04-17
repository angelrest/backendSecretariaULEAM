package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Hanger;

@Repository
public interface HangerRepository extends JpaRepository<Hanger, Long> {

	Hanger findByName(String name);

}
