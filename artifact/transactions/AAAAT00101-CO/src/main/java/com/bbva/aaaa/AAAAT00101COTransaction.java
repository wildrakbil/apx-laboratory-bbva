package com.bbva.aaaa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.aaaa.dto.customers.CustomerDTO;
import com.bbva.aaaa.lib.r001.AAAAR001;
import com.bbva.elara.domain.transaction.Severity;
import com.bbva.elara.domain.transaction.response.HttpResponseCode;

/**
 * Codelab transaction Implementacion de logica de negocio.
 * 
 * @author CFP-6685
 *
 */
public class AAAAT00101COTransaction extends AbstractAAAAT00101COTransaction {

	private static final Logger LOGGER = LoggerFactory.getLogger(AAAAT00101COTransaction.class);

	@Override
	public void execute() {
		AAAAR001 aaaaR001 = (AAAAR001) getServiceLibrary(AAAAR001.class);

		LOGGER.info("Execution of AAAAT00101COTransaction");
		if (AAAAT00101COAction.GET.name().equals(getRestfulMethod())) {
			LOGGER.info("GET method");
			String identityDocument = getIdenityDocument();
			String identityDocumentType = getIdentityDocumentType();
			List<CustomerDTO> listCustomer = null;
			if (identityDocumentType == null || identityDocument == null) {
				listCustomer = aaaaR001.execute();
			} else {
				listCustomer = aaaaR001.executeDocument(identityDocumentType, identityDocument);
			}
			if (listCustomer == null || listCustomer.isEmpty()) {
				setHttpResponseCode(HttpResponseCode.HTTP_CODE_204);
				setSeverity(Severity.WARN);
			} else {
				setEntitylist(listCustomer);
				setHttpResponseCode(HttpResponseCode.HTTP_CODE_200);
				setSeverity(Severity.OK);
			}

		} else {
			LOGGER.info("Not GET method");
			setHttpResponseCode(HttpResponseCode.HTTP_CODE_204);
			setSeverity(Severity.WARN);
		}
	}

	private String getIdenityDocument() {
		List<String> identityDocument = getQueryParameter("identityDocument");
		if (identityDocument != null && !identityDocument.isEmpty()) {
			LOGGER.info("Identity Document <" + identityDocument.get(0) + ">");
			return identityDocument.get(0);
		}
		return null;
	}

	private String getIdentityDocumentType() {
		List<String> identityDocumentType = getQueryParameter("identityDocumentType");
		if (identityDocumentType != null && !identityDocumentType.isEmpty()) {
			LOGGER.info("Documento Type <" + identityDocumentType.get(0) + ">");
			return identityDocumentType.get(0);
		}
		return null;
	}

}
