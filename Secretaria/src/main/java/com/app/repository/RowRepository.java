package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Row;

@Repository
public interface RowRepository extends JpaRepository<Row, Long> {

	Row findByName(String name);

}
