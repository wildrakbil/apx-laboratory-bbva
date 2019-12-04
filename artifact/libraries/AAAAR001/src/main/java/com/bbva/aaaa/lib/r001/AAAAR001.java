package com.bbva.aaaa.lib.r001;

import java.util.List;

import com.bbva.aaaa.dto.customers.CustomerDTO;

public interface AAAAR001 {

	List<CustomerDTO> execute();
	List<CustomerDTO> executeDocument(String identityDocumentType, String identityDocument);

}
