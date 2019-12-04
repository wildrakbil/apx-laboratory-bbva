package com.bbva.aaaa.lib.r001.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.aaaa.dto.customers.CustomerDTO;
import com.bbva.aaaa.lib.r001.AAAAR001;

public class AAAAR001Impl extends AAAAR001Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(AAAAR001.class);

	@Override
	public List<CustomerDTO> execute() {
		List<CustomerDTO> listDTO = new ArrayList<CustomerDTO>();
		listDTO.add(customer1());
		listDTO.add(customer2());
		listDTO.add(customer3());
		return listDTO;
	}

	@Override
	public List<CustomerDTO> executeDocument(String identityDocumentType, String identityDocument) {
		List<CustomerDTO> listDTO = null;
		if (identityDocumentType.equals("DNI")) {
			listDTO = new ArrayList<CustomerDTO>();
			if (identityDocument.equals("42029511F")) {
				listDTO.add(customer3());
			}
		}
		return listDTO;
	}

	private CustomerDTO customer1() {
		CustomerDTO cust1 = new CustomerDTO();
		Date date = new Date();
		cust1.setCustomerId("00001");
		cust1.setFirstName("Jhon");
		cust1.setLastName("Freeman");
		cust1.setNationality("EN");
		cust1.setPersonalTitle("Sr");
		cust1.setGenderId("Male");
		cust1.setIdentityDocumentType("1");
		cust1.setIdentityDocumentNumber("12345678N");
		cust1.setBirthDate(date);
		cust1.setMaritalStatus("Single");
		return cust1;
	}

	private CustomerDTO customer2() {
		CustomerDTO cust2 = new CustomerDTO();
		Date date = new Date();
		cust2.setCustomerId("00002");
		cust2.setFirstName("Juan");
		cust2.setLastName("Perez");
		cust2.setNationality("ES");
		cust2.setPersonalTitle("Sr");
		cust2.setGenderId("Male");
		cust2.setIdentityDocumentType("1");
		cust2.setIdentityDocumentNumber("98765432N");
		cust2.setBirthDate(date);
		cust2.setMaritalStatus("Single");
		return cust2;
	}

	private CustomerDTO customer3() {
		CustomerDTO cust3 = new CustomerDTO();
		Date date = new Date();
		cust3.setCustomerId("00003");
		cust3.setFirstName("Marco");
		cust3.setLastName("Zambrano");
		cust3.setNationality("ES");
		cust3.setPersonalTitle("Sr");
		cust3.setGenderId("Male");
		cust3.setIdentityDocumentType("1");
		cust3.setIdentityDocumentNumber("42029511F");
		cust3.setBirthDate(date);
		cust3.setMaritalStatus("Single");
		return cust3;
	}

}
