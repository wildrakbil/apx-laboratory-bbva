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
		List<CustomerDTO> customerList = new ArrayList<CustomerDTO>();

		CustomerDTO CustomerDTO = new CustomerDTO();
		CustomerDTO.setBirthDate(new Date());
		CustomerDTO.setCustomerId("001");
		CustomerDTO.setFristName("Jhon");
		CustomerDTO.setGenerarId("Male");
		CustomerDTO.setIdentityDocumentNumber("125457568s");
		CustomerDTO.setIdentityDocumentType("1");
		CustomerDTO.setLastName("Ferman");
		CustomerDTO.setMaritalStatus("Single");
		CustomerDTO.setNationality("EN");
		CustomerDTO.setPersonalTitle("Sr.");
		customerList.add(CustomerDTO);

		return customerList;
	}
}
