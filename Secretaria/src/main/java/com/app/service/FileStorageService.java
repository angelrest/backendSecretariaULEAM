package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.exception.FileStorageException;
import com.app.exception.MyFileNotFoundException;
import com.app.model.ArchivePdf;
import com.app.response.FileStorageProperties;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;

@Service
public class FileStorageService {

	private final Path fileStorageLocation;
	
	@Autowired
	private BasicService service;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public ArchivePdf storeFile(MultipartFile file, Long id) {
        

    	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	
    	String fileNameUnique=Long.toString(timestamp.getTime())+"-"+id+".pdf";
    	
    	try {
    		
    		if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            
    			Path targetLocation = this.fileStorageLocation.resolve(fileNameUnique);
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
                String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/api/downloadfile/")
                        .path(fileNameUnique)
                        .toUriString();
                ArchivePdf result=service.createArchivePdf(id, fileNameUnique, fileName, fileDownloadUri, file.getContentType(), file.getSize());
    		
                return result;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
	
	
}
