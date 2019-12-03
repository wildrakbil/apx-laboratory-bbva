package com.bbva.aaaa;

import java.util.List;
import com.bbva.aaaa.dto.customers.CustomerDTO;

import com.bbva.elara.transaction.AbstractTransaction;

public abstract class AbstractAAAAT00101COTransaction extends AbstractTransaction {

	public AbstractAAAAT00101COTransaction(){
	}
	
	

	
	

	/**
	 * Set value for output parameter EntityList
	 */
	protected void setEntitylist(final List<CustomerDTO> field){
		this.addParameter("EntityList", field);
	}			
	
}
