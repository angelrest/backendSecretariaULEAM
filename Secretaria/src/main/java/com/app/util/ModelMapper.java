package com.app.util;



import com.app.model.ArchivePdf;
import com.app.model.Documentation;
import com.app.response.ArchivePdfResponse;
import com.app.response.DocumentationResponse;

public class ModelMapper {

    public static DocumentationResponse mapDocumentationToDocumentationResponse(Documentation documentation) {
    	
    	DocumentationResponse documentationResponse = new DocumentationResponse();
    	documentationResponse.setId(documentation.getId());
    	documentationResponse.setDepartment(documentation.getDepartment());
    	documentationResponse.setFiletype(documentation.getFiletype());
    	documentationResponse.setUbication(documentation.getUbication());
    	documentationResponse.setDate(documentation.getDate());
    	documentationResponse.setHanger(documentation.getHanger());
    	documentationResponse.setRow(documentation.getRow());
    	documentationResponse.setFolder(documentation.getFolder());
    	documentationResponse.setSender(documentation.getSender());
    	documentationResponse.setAddressee(documentation.getAddressee());
    	documentationResponse.setDescription(documentation.getDescription());
    	documentationResponse.setCreated_at(documentation.getCreatedAt());
    	documentationResponse.setUpdated_at(documentation.getUpdatedAt());
    	return documentationResponse;
    }

	public static ArchivePdfResponse mapArchiveToArchiveResponse(ArchivePdf item) {
		ArchivePdfResponse res=new ArchivePdfResponse();
		res.setId(item.getId());
		res.setFilename(item.getFilename());
		res.setFiledownloaduri(item.getFiledownloaduri());
		res.setFiletype(item.getFiletype());
		res.setSize(item.getSize());
		res.setDocumentation(item.getDocumentation());
		return res;
	}

}

