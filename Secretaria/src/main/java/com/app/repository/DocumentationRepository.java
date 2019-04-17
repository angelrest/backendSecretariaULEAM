package com.app.repository;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.model.Documentation;

@Repository
public interface DocumentationRepository extends JpaRepository<Documentation, Long> {

	@Query("select o from Documentation o where o.department.id=:department and DATE_FORMAT(o.date, '%Y/%m/%d')=:date ")
	Page<Documentation> findByDepartmentIdAndDateOrderByDateDesc(@Param("department") long department,@Param("date") String date, Pageable pageable);
	
	Page<Documentation> findByDepartmentIdAndFiletypeNameStartingWithOrUbicationNameStartingWithOrHangerNameStartingWithOrRowNameStartingWithOrFolderNameStartingWithOrSenderNameStartingWithOrAddresseeNameStartingWith(
			Long id,
			String filetype,
			String ubication,
			String hanger,
			String row,
			String folder,
			String sender,
			String addressee,
			Pageable pageable);
	Page<Documentation> findByDepartmentIdAndFiletypeIdOrUbicationIdOrHangerIdOrRowIdOrFolderIdOrSenderIdOrAddresseeId(
			Long department, Long filetype, Long ubication, Long hanger, Long row, Long folder, Long sender,
			Long addressee, Pageable pageable);
	Page<Documentation> findByDepartmentIdAndDescriptionContaining(Long department, String description, Pageable pageable);

	Optional<Documentation> findById(Long id);
	Page<Documentation> findByDepartmentIdOrderByDateDesc(Long department, Pageable pageable);
}
