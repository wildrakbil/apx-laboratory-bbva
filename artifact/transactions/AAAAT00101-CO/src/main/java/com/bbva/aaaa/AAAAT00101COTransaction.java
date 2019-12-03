package com.bbva.aaaa;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.aaaa.dto.customers.CustomerDTO;
import com.bbva.aaaa.lib.r001.AAAAR001;

/**
 * Codelab transaction
 * Implementacion de logica de negocio.
 * @author CFP-6685
 *
 */
public class AAAAT00101COTransaction extends AbstractAAAAT00101COTransaction {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AAAAT00101COTransaction.class);

	@Override
	public void execute() {
		AAAAR001 aaaaR001 = (AAAAR001)getServiceLibrary(AAAAR001.class);
		LOGGER.info("Execition of AAAAT00101COTransaction...");
		List<CustomerDTO> customerList = aaaaR001.execute();
		this.setEntitylist(customerList);
	}

}
