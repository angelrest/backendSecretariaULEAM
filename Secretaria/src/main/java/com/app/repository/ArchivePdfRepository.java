package com.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.ArchivePdf;


@Repository
public interface ArchivePdfRepository extends JpaRepository<ArchivePdf, Long> {

	ArchivePdf findByDocumentationId(Long id);
	
	ArchivePdf findByOriginalfilename(String originalfilename);

	Page<ArchivePdf> findByDocumentationId(Long documentation, Pageable pageable);

}
