package com.app.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.exception.BadRequestException;
import com.app.model.ArchivePdf;
import com.app.model.Department;
import com.app.model.Documentation;
import com.app.model.FileType;
import com.app.model.Folder;
import com.app.model.Hanger;
import com.app.model.Row;
import com.app.model.SendName;
import com.app.model.Ubication;
import com.app.repository.ArchivePdfRepository;
import com.app.repository.DepartmentRepository;
import com.app.repository.DocumentationRepository;
import com.app.repository.FileTypeRepository;
import com.app.repository.FolderRepository;
import com.app.repository.HangerRepository;
import com.app.repository.RowRepository;
import com.app.repository.SendNameRepository;
import com.app.repository.UbicationRepository;
import com.app.request.DepartmentRequest;
import com.app.request.DocumentationRequest;
import com.app.request.FileTypeRequest;
import com.app.request.FolderRequest;
import com.app.request.HangerRequest;
import com.app.request.RowRequest;
import com.app.request.SendNameRequest;
import com.app.request.UbicationRequest;
import com.app.response.ApiResponse;
import com.app.response.ArchivePdfResponse;
import com.app.response.DocumentationResponse;
import com.app.response.PageResponse;
import com.app.util.Constants;



@Service
public class BasicService {
	@Autowired
	private ArchivePdfRepository archiveRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private DocumentationRepository documentationRepository;
	
	@Autowired
	private FileTypeRepository fileTypeRepository;
	
	@Autowired
	private FolderRepository folderRepository;
	
	@Autowired
	private HangerRepository hangerRepository;
	
	@Autowired
	private RowRepository rowRepository;
	
	@Autowired
	private SendNameRepository sendnameRepository;
	
	@Autowired
	private UbicationRepository ubicationRepository;
	
	/**************************************************************************************************/
	private static final Logger logger = LoggerFactory.getLogger(BasicService.class);
	
	public Department createDepartment(DepartmentRequest request) {
		return departmentRepository.save(new Department(request.getName(), request.isActive()));
	}
	
	public FileType createFileType(FileTypeRequest request) {
		
		return fileTypeRepository.save(new FileType(request.getName(), request.isActive()));
	}
	
	public Folder createFolder(FolderRequest request) {
		return folderRepository.save(new Folder(request.getName(), request.isActive()));
	}
	
	public Hanger createHanger(HangerRequest request) {
		return hangerRepository.save(new Hanger(request.getName(), request.isActive()));
	}
	
	public Row createRow(RowRequest request) {
		return rowRepository.save(new Row(request.getName(), request.isActive()));
	}
	
	public SendName createSendName(SendNameRequest request) {
		return sendnameRepository.save(new SendName(request.getName(), request.isActive()));
	}
	
	public Ubication createUbication(UbicationRequest request) {
		return ubicationRepository.save(new Ubication(request.getName(), request.isActive()));
	}
	
	public ArchivePdf createArchivePdf(long id, String filename, String originalfilename, String filedownloaduri,String filetype, Long size) {
		Optional<Documentation> doc= documentationRepository.findById(id);
		ArchivePdf result= new ArchivePdf();
		result.setDocumentation(doc.get());
		result.setFilename(filename);
		result.setOriginalfilename(originalfilename);
		result.setFiledownloaduri(filedownloaduri);
		result.setFiletype(filetype);
		result.setSize(size);
		result=archiveRepository.save(result);
		return result;
	}
	
	
	public ApiResponse createDocumentation(DocumentationRequest request) {
		
		Optional<Department> departments=  departmentRepository.findById(request.getDepartment());
		Department department=new Department(departments.get().getId(),departments.get().getName(),departments.get().isActive());
		
		FileType filetype=getFileType(request.getFiletype());
		if (filetype==null) {
			filetype=createFileType(new FileTypeRequest(request.getFiletype().toUpperCase(),true));
		}
		
		Ubication ubication=getUbicationv(request.getUbication());
		if (ubication==null) {
			ubication=createUbication(new UbicationRequest(request.getUbication().toUpperCase(),true));
		}
		
		Hanger hanger= getHanger(request.getHanger());
		if (hanger==null) {
			hanger=createHanger(new HangerRequest(request.getHanger().toUpperCase(),true));
		}
		
		Row row=getRow(request.getRow());
		if (row==null) {
			row=createRow(new RowRequest(request.getRow().toUpperCase(),true));
		}
		
		Folder folder=getFolder(request.getFolder());
		if (folder==null) {
			folder=createFolder(new FolderRequest(request.getFolder().toUpperCase(),true));
		}
		
		SendName sender=getSendName(request.getSender());
		if (sender==null) {
			sender=createSendName(new SendNameRequest(request.getSender().toUpperCase(),true));
		}
		
		SendName addressee=getSendName(request.getAddressee());
		if (addressee==null) {
			addressee=createSendName(new SendNameRequest(request.getAddressee().toUpperCase(),true));
		}
		
		Documentation save=new Documentation(
		department,
		filetype,
		ubication,
		new Date(),//request.getDate(),
		hanger,
		row,
		folder,
		sender,
		addressee,
		request.getDescription());
		Documentation result= documentationRepository.save(save);
		if (result==null) {
			return new ApiResponse(null,"Error de ingreso, todo los campos son obligatorios",false);	
		} else {
			return new ApiResponse(save.getId(),"Agregado con éxito",true);
		}
		  
	}
	
	/***************************************************************************************/
	
	
	
	public Department getDepartment(String name) {
		return departmentRepository.findByName(name);
		
	}
	
	public FileType getFileType(String name) {
		return fileTypeRepository.findByName(name);
	}
	
	public Folder getFolder(String name) {
		return folderRepository.findByName(name);
	}
	
	public Hanger getHanger(String name) {
		return hangerRepository.findByName(name);
	}
	
	public Row getRow(String name) {
		return rowRepository.findByName(name);
	}
	
	public SendName getSendName(String name) {
		return sendnameRepository.findByName(name);
	}
	
	public Ubication getUbicationv(String name) {
		return ubicationRepository.findByName(name);
	}
	
	public ArchivePdf getArchivePdf(Long id) {
		return archiveRepository.findByDocumentationId(id);
	}
	
	/***************************************************************************************************************************/
	public Page<Documentation> bydate(long department, String string, int page, int size){
		validatePageNumberAndSize(page, size);
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
		Page<Documentation> documentation= documentationRepository.findByDepartmentIdAndDateOrderByDateDesc(
				department,string, pageable);
		return documentation;
	}
	
	public Page<Documentation> byallLike(Long id, 
			String filetype, String ubication, String hanger, String row, String folder, 
			String sender, String addressee, int page, int size){
		validatePageNumberAndSize(page, size);
		logger.info("Busqueda por nombres completos");
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
		Page<Documentation> documentation= documentationRepository.findByDepartmentIdAndFiletypeNameStartingWithOrUbicationNameStartingWithOrHangerNameStartingWithOrRowNameStartingWithOrFolderNameStartingWithOrSenderNameStartingWithOrAddresseeNameStartingWith(
				id, filetype, ubication, hanger, row, folder, sender, addressee,pageable);
		return documentation;
	}
	
	public PageResponse<DocumentationResponse> getBy(Page<Documentation> documentation) {
		
		if(documentation.getNumberOfElements() == 0) {
            return new PageResponse<>(Collections.emptyList(), documentation.getNumber(),
            		documentation.getSize(), documentation.getTotalElements(), documentation.getTotalPages(), documentation.isLast());
        }
		
		List<DocumentationResponse> documentationResponse = documentation.map(item -> {
            return com.app.util.ModelMapper.mapDocumentationToDocumentationResponse(item);
        }).getContent();
		 
		 return new PageResponse<>(documentationResponse, documentation.getNumber(),
				 documentation.getSize(), documentation.getTotalElements(), documentation.getTotalPages(), documentation.isLast());
	}
	
	
	public PageResponse<ArchivePdfResponse> getBypdf(Page<ArchivePdf> archive) {
			
			if(archive.getNumberOfElements() == 0) {
	            return new PageResponse<>(Collections.emptyList(), archive.getNumber(),
	            		archive.getSize(), archive.getTotalElements(), archive.getTotalPages(), archive.isLast());
	        }
			
			List<ArchivePdfResponse> archiveResponse = archive.map(item -> {
	            return com.app.util.ModelMapper.mapArchiveToArchiveResponse(item);
	        }).getContent();
			 
			 return new PageResponse<>(archiveResponse, archive.getNumber(),
					 archive.getSize(), archive.getTotalElements(), archive.getTotalPages(), archive.isLast());
	}
	
	
	public PageResponse<DocumentationResponse> getAll(int page, int size) {
		validatePageNumberAndSize(page, size);
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
		 
		Page<Documentation> documentation=(Page<Documentation>) documentationRepository.findAll(pageable);
		if(documentation.getNumberOfElements() == 0) {
            return new PageResponse<>(Collections.emptyList(), documentation.getNumber(),
            		documentation.getSize(), documentation.getTotalElements(), documentation.getTotalPages(), documentation.isLast());
        }
		
		List<DocumentationResponse> documentationResponse = documentation.map(item -> {
            return com.app.util.ModelMapper.mapDocumentationToDocumentationResponse(item);
        }).getContent();
		 
		 return new PageResponse<>(documentationResponse, documentation.getNumber(),
				 documentation.getSize(), documentation.getTotalElements(), documentation.getTotalPages(), documentation.isLast());
	}
	
	public PageResponse<ArchivePdfResponse> getByResonse(Long id,int page, int size) {
		validatePageNumberAndSize(page, size);
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
		 
		Page<ArchivePdf> archive=archiveRepository.findByDocumentationId(id,pageable);
		if(archive.getNumberOfElements() == 0) {
            return new PageResponse<>(Collections.emptyList(), archive.getNumber(),
            		archive.getSize(), archive.getTotalElements(), archive.getTotalPages(), archive.isLast());
        }
		
		List<ArchivePdfResponse> archiveResponse = archive.map(item -> {
            return com.app.util.ModelMapper.mapArchiveToArchiveResponse(item);
        }).getContent();
		 
		 return new PageResponse<>(archiveResponse, archive.getNumber(),
				 archive.getSize(), archive.getTotalElements(), archive.getTotalPages(), archive.isLast());
	}
	
	private void validatePageNumberAndSize(int page, int size) {
		if(page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if(size > Constants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Size max: " + Constants.MAX_PAGE_SIZE);
        }		
	}

	public Documentation getDocumentation(Long id) {
		Optional<Documentation> doc=documentationRepository.findById(id);
		Documentation result=new Documentation(doc.get().getId(),
				doc.get().getDepartment(), doc.get().getFiletype(), 
				doc.get().getUbication(), doc.get().getDate(), doc.get().getHanger(), 
				doc.get().getRow(), doc.get().getFolder(), doc.get().getSender(), doc.get().getAddressee(), 
				doc.get().getDescription());
				
		return result;
	}

	public Page<Documentation> byallLikeid(Long department, Long filetype, Long ubication, Long hanger, Long row,
			Long folder, Long sender, Long addressee, int page, int size) {
		validatePageNumberAndSize(page, size);
		logger.info("Busqueda por Id completos");
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
		Page<Documentation> documentation= documentationRepository.findByDepartmentIdAndFiletypeIdOrUbicationIdOrHangerIdOrRowIdOrFolderIdOrSenderIdOrAddresseeId(
				department, filetype, ubication, hanger, row, folder, sender, addressee,pageable);
		return documentation;
	}

	public Page<Documentation> bydescriptionbyor(Long department, String description, int page, int size) {
		validatePageNumberAndSize(page, size);
		logger.info("Busqueda por description like");
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
		Page<Documentation> documentation= documentationRepository.findByDepartmentIdAndDescriptionContaining(
				department, description,pageable);
		return documentation;
	}

	public List<Department> getDepartmentList() {
		return departmentRepository.findAll();
	}

	public List<FileType> getFileTypeList() {
		return fileTypeRepository.findAll();
	}

	public List<Folder> getFolderList() {
		return folderRepository.findAll();
	}

	public List<Hanger> getHangerList() {
		return hangerRepository.findAll();
	}

	public List<Row> getRowList() {
		return rowRepository.findAll();
	}

	public List<SendName> getSendNameList() {
		return sendnameRepository.findAll();
	}

	public List<Ubication> getUbicationList() {
		return ubicationRepository.findAll();
	}

	public ArchivePdf getArchivePdfString(String fileName) {
		return archiveRepository.findByOriginalfilename(fileName);
	}

	public Page<Documentation> byall(Long department, int page, int size) {
		validatePageNumberAndSize(page, size);
		logger.info("Busqueda por completos");
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
		Page<Documentation> documentation= documentationRepository.findByDepartmentIdOrderByDateDesc(department,pageable);
		return documentation;
	}

	public Page<ArchivePdf> bypdf(Long id, int page, int size) {
		logger.info("Busqueda por pdf");
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
		Page<ArchivePdf> documentation= archiveRepository.findByDocumentationId(id,pageable);
		return documentation;
	}


	
	
	

}
