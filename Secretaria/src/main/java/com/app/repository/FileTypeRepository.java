package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.FileType;

@Repository
public interface FileTypeRepository extends JpaRepository<FileType, Long> {

	FileType findByName(String name);

}
