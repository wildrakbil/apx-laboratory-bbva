package com.bbva.aaaa.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bbva.aaaa.dto.customers.CustomerDTO;
import com.bbva.aaaa.lib.r001.AAAAR001;

public class AAAAR001Mock implements AAAAR001 {
	
	@Override
    public List<CustomerDTO> execute() {
            List<CustomerDTO> listCustomer = new ArrayList<CustomerDTO>();
            listCustomer.add(getCustomerTest1());
            listCustomer.add(getCustomerTest2());
            listCustomer.add(getCustomerTest3());
            return listCustomer;
    }
    @Override
    public List<CustomerDTO> executeDocument(String identityDocumentType, String identityDocument) {
            List<CustomerDTO> listCustomer = null;
            if (identityDocumentType.equals("DNI")){
                    listCustomer = new ArrayList<CustomerDTO>();
                    if (identityDocument.equals("42029511F")){
                            listCustomer.add(getCustomerTest3());
                    }
            }
            return listCustomer;
    }
    
    private CustomerDTO getCustomerTest1(){
            CustomerDTO cust1 = new CustomerDTO();
            Date date = new Date();
            cust1.setCustomerId("10001");
            cust1.setFirstName("Customer1 First Name test");
            cust1.setLastName("Customer1 Last Name test");
            cust1.setNationality("EN");
            cust1.setPersonalTitle("Sr");
            cust1.setGenderId("Male");
            cust1.setIdentityDocumentType("1");
            cust1.setIdentityDocumentNumber("12345678N");
            cust1.setBirthDate(date );
            cust1.setMaritalStatus("Single");
            return cust1 ;
    }
    
    private CustomerDTO getCustomerTest2(){
            CustomerDTO cust2 = new CustomerDTO();
            Date date = new Date();
            cust2.setCustomerId("10002");
            cust2.setFirstName("Customer2 First Name test");
            cust2.setLastName("Customer2 Last Name test");
            cust2.setNationality("ES");
            cust2.setPersonalTitle("Sr");
            cust2.setGenderId("Male");
            cust2.setIdentityDocumentType("1");
            cust2.setIdentityDocumentNumber("98765432N");
            cust2.setBirthDate(date);
            cust2.setMaritalStatus("Single");
            return cust2;
    }
    private CustomerDTO getCustomerTest3(){
            CustomerDTO cust3 = new CustomerDTO();
            Date date = new Date();
            cust3.setCustomerId("10003");
            cust3.setFirstName("Customer3 First Name test");
            cust3.setLastName("Customer3 Last Name test");
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
