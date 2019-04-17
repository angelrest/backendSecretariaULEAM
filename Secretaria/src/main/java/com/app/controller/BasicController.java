package com.app.controller;


import java.io.IOException;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.model.ArchivePdf;
import com.app.model.Department;
import com.app.model.Documentation;
import com.app.model.FileType;
import com.app.model.Folder;
import com.app.model.Hanger;
import com.app.model.Row;
import com.app.model.SendName;
import com.app.model.Ubication;
import com.app.request.DocumentationRequest;
import com.app.response.ApiResponse;
import com.app.response.ArchivePdfResponse;
import com.app.response.DocumentationResponse;
import com.app.response.PageResponse;
import com.app.response.UploadFileResponse;
import com.app.service.BasicService;
import com.app.service.FileStorageService;
import com.app.util.Constants;




@RestController
@RequestMapping("/api")
public class BasicController {
	private static final Logger logger = LoggerFactory.getLogger(BasicController.class);
	
	 @Autowired
	 private FileStorageService fileStorageService;
	
	@Autowired
	private BasicService service;
	/*-----------------------------------------------------------------------------------------------*/
	@GetMapping("/department")
    public ApiResponse searchByDepartmentName(@RequestParam(value = "name") String name) {
        Department result=new Department();
        result=service.getDepartment(name);
        if (result==null) {
			return new ApiResponse(null,null,false);
		}
        return new ApiResponse(result.getId(), result.getName(), true);
    }
	
	@GetMapping("/department/list")
	
    public List<Department> searchByDepartmentNameList() {
        List<Department> result=new ArrayList<>();
        result=service.getDepartmentList();
        if (result==null) {
			return new ArrayList<>();
		}
        return result;
    }
	
	/*-----------------------------------------------------------------------------------------------*/
	
	@GetMapping("/filetype")
    public ApiResponse searchByFileType(@RequestParam(value = "name") String name) {
		FileType result=new FileType();
        result=service.getFileType(name);
        if (result==null) {
			return new ApiResponse(null,null,false);
		}
        return new ApiResponse(result.getId(), result.getName(), true);
    }
	
	@GetMapping("/filetype/list")
    public List<FileType> searchByFiletypeList() {
        List<FileType> result=new ArrayList<>();
        result=service.getFileTypeList();
        if (result==null) {
			return new ArrayList<>();
		}
        return result;
    }
	/*-----------------------------------------------------------------------------------------------*/
	
	@GetMapping("/folder")
    public ApiResponse searchByFolder(@RequestParam(value = "name") String name) {
		Folder result=new Folder();
        result=service.getFolder(name);
        if (result==null) {
			return new ApiResponse(null,null,false);
		}
        return new ApiResponse(result.getId(), result.getName(), true);
    }
	@GetMapping("/folder/list")
    public List<Folder> searchByFolderList() {
        List<Folder> result=new ArrayList<>();
        result=service.getFolderList();
        if (result==null) {
			return new ArrayList<>();
		}
        return result;
    }
	/*-----------------------------------------------------------------------------------------------*/
	
	
	@GetMapping("/hanger")
    public ApiResponse searchByHanger(@RequestParam(value = "name") String name) {
		Hanger result=new Hanger();
        result=service.getHanger(name);
        if (result==null) {
			return new ApiResponse(null,null,false);
		}
        return new ApiResponse(result.getId(), result.getName(), true);
    }
	@GetMapping("/hanger/list")
    public List<Hanger> searchByHangerList() {
        List<Hanger> result=new ArrayList<>();
        result=service.getHangerList();
        if (result==null) {
			return new ArrayList<>();
		}
        return result;
    }
	/*-----------------------------------------------------------------------------------------------*/
	
	@GetMapping("/row")
    public ApiResponse searchByRow(@RequestParam(value = "name") String name) {
		Row result=new Row();
        result=service.getRow(name);
        if (result==null) {
			return new ApiResponse(null,null,false);
		}
        return new ApiResponse(result.getId(), result.getName(), true);
    }
	
	@GetMapping("/row/list")
    public List<Row> searchByRowList() {
        List<Row> result=new ArrayList<>();
        result=service.getRowList();
        if (result==null) {
			return new ArrayList<>();
		}
        return result;
    }
	/*-----------------------------------------------------------------------------------------------*/
	
	@GetMapping("/sendname")
    public ApiResponse searchBySendName(@RequestParam(value = "name") String name) {
		SendName result=new SendName();
        result=service.getSendName(name);
        if (result==null) {
			return new ApiResponse(null,null,false);
		}
        return new ApiResponse(result.getId(), result.getName(), true);
    }
	@GetMapping("/sendname/list")
    public List<SendName> searchBySendNameList() {
        List<SendName> result=new ArrayList<>();
        result=service.getSendNameList();
        if (result==null) {
			return new ArrayList<>();
		}
        return result;
    }
	/*-----------------------------------------------------------------------------------------------*/
	
	
	@GetMapping("/ubication")
    public ApiResponse searchByUbication(@RequestParam(value = "name") String name) {
		Ubication result=new Ubication();
        result=service.getUbicationv(name);
        if (result==null) {
			return new ApiResponse(null,null,false);
		}
        return new ApiResponse(result.getId(), result.getName(), true);
    }
	@GetMapping("/ubication/list")
    public List<Ubication> searchByUbicationList() {
        List<Ubication> result=new ArrayList<>();
        result=service.getUbicationList();
        if (result==null) {
			return new ArrayList<>();
		}
        return result;
    }
	/*-----------------------------------------------------------------------------------------------*/
	
	/*****************************************************************************************************************/
	@GetMapping("/documentation/all")
	public PageResponse<DocumentationResponse> getbyall(
			@RequestParam(value = "department") Long department,
			@RequestParam(value = "page", defaultValue = Constants.DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(value = "size", defaultValue = Constants.DEFAULT_PAGE_SIZE) int size) {
		Page<Documentation> documentation=service.byall(department,page, size);
		return service.getBy(documentation);
	}
	
	
	@GetMapping("/documentation/pdf")
	public PageResponse<ArchivePdfResponse> getbypdf(
			@RequestParam(value = "id") Long id,
			@RequestParam(value = "page", defaultValue = Constants.DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(value = "size", defaultValue = Constants.DEFAULT_PAGE_SIZE) int size) {
		Page<ArchivePdf> documentation=service.bypdf(id,page, size);
		return service.getBypdf(documentation);
	}
	
	
	
	@GetMapping("/documentation/equals/or/name")
	public PageResponse<DocumentationResponse> getby(
			@RequestParam(value = "department") Long department,
			@RequestParam(value = "filetype") String filetype,
			@RequestParam(value = "ubication") String ubication,
			@RequestParam(value = "hanger") String hanger,
			@RequestParam(value = "row") String row,
			@RequestParam(value = "folder") String folder,
			@RequestParam(value = "sender") String sender,
			@RequestParam(value = "addressee") String addressee,
			@RequestParam(value = "page", defaultValue = Constants.DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(value = "size", defaultValue = Constants.DEFAULT_PAGE_SIZE) int size) {
		logger.info(department+"");
		logger.info(filetype);
		logger.info(ubication);
		logger.info(hanger);
		logger.info(row);
		logger.info(folder);
		logger.info(addressee);
		Page<Documentation> documentation=service.byallLike(department, filetype, ubication, hanger, row, folder, sender, addressee, page, size);
		return service.getBy(documentation);
	}
	
	@GetMapping("/documentation/equals/or/id")
	public PageResponse<DocumentationResponse> getbylike(
			@RequestParam(value = "department") Long department,
			@RequestParam(value = "filetype") Long filetype,
			@RequestParam(value = "ubication") Long ubication,
			@RequestParam(value = "hanger") Long hanger,
			@RequestParam(value = "row") Long row,
			@RequestParam(value = "folder") Long folder,
			@RequestParam(value = "sender") Long sender,
			@RequestParam(value = "addressee") Long addressee,
			@RequestParam(value = "page", defaultValue = Constants.DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(value = "size", defaultValue = Constants.DEFAULT_PAGE_SIZE) int size) {
		Page<Documentation> documentation=service.byallLikeid(department, filetype, ubication, hanger, row, folder, sender, addressee, page, size);
		return service.getBy(documentation);
	}
	
	/***************************************************************************************************************************/
	
	@GetMapping("/documentation/description")
	public PageResponse<DocumentationResponse> getbydescription(
			@RequestParam(value = "department") Long department,
			@RequestParam(value = "description") String description,
			@RequestParam(value = "page", defaultValue = Constants.DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(value = "size", defaultValue = Constants.DEFAULT_PAGE_SIZE) int size) {
		Page<Documentation> documentation=service.bydescriptionbyor(department, description, page, size);
		return service.getBy(documentation);
	}
	
	
	@GetMapping("/documentation/department/date")
	public PageResponse<DocumentationResponse> getDocuemntationBy(
			@RequestParam(value = "department") Long department,
			@RequestParam(value = "date") Date date,
			@RequestParam(value = "page", defaultValue = Constants.DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(value = "size", defaultValue = Constants.DEFAULT_PAGE_SIZE) int size) {
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		logger.info("veamos la fecha "+formatter.format(date));
		Page<Documentation> documentation=service.bydate(department, formatter.format(date), page, size);
		return service.getBy(documentation);
	}
	
	@PostMapping
	public ResponseEntity<?> createDocumentation(@Valid @RequestBody DocumentationRequest request) {
		ApiResponse res=service.createDocumentation(request);
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/documentation/{id}")
                .buildAndExpand(res.getId()).toUri();
		return ResponseEntity.created(location)
                .body(res);
	}
	
	@GetMapping("/documentation/{id}")
	public Documentation getDocumentation(@PathVariable(value = "id") Long id) {
		return service.getDocumentation(id);
	}
	
	
	@PostMapping("/pdf")
	public ResponseEntity<?> createDocumentationPdf(@Valid @RequestParam("file") MultipartFile file) {
		return ResponseEntity.ok(true);
	}
	
	@PostMapping("/uploadFile/{id}")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file,
    		@PathVariable("id") Long id) {
			
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			if (file.getContentType().equals("application/pdf") && fileName.length()<50) {
				ArchivePdf fileAcrhive = fileStorageService.storeFile(file,id);
				return new UploadFileResponse(fileAcrhive.getOriginalfilename(), fileAcrhive.getFiledownloaduri(),
	                file.getContentType(), file.getSize());
			}else {
				return null;
			}
			
			
    }

    /*@PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files,@PathVariable("id") Long id) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }*/

    @GetMapping("/downloadfile/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                //esta linea que se comenta abajo sirve para descargar el arvhivo
                //.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
    
    
    

	
	

}
