package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Folder;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {

	Folder findByName(String name);

}
