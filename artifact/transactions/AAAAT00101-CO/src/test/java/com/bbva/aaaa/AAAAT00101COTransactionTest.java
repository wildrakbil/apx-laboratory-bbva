package com.bbva.aaaa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.cxf.jaxrs.ext.MessageContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ParameterTable;
import com.bbva.elara.domain.transaction.Severity;
import com.bbva.elara.domain.transaction.TransactionParameter;
import com.bbva.elara.domain.transaction.request.HttpMethodCode;
import com.bbva.elara.domain.transaction.request.TransactionRequest;
import com.bbva.elara.domain.transaction.request.body.CommonRequestBody;
import com.bbva.elara.test.osgi.DummyBundleContext;
import com.bbva.elara.test.restful.MessageContextTest;

/**
 * Test for transaction AAAAT00101COTransaction
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/elara-test.xml",
		"classpath:/META-INF/spring/AAAAT00101COTest.xml" })
public class AAAAT00101COTransactionTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(AAAAT00101COTransactionTest.class);

	@Autowired
	private AAAAT00101COTransaction transaction;

	@Resource(name = "dummyBundleContext")
	private DummyBundleContext bundleContext;

	private TransactionRequest transactionRequest;

	@Before
	public void initializeClass() throws Exception {
		this.transaction.start(bundleContext);

		// Initializing transaction to test
		this.transaction.setContext(new Context());
		this.transaction.getContext().setLanguageCode("ES");

		transactionRequest = Mockito.mock(TransactionRequest.class);
		CommonRequestBody commonRequestBody = new CommonRequestBody();
		commonRequestBody.setTransactionParameters(new ArrayList<TransactionParameter>());
		transactionRequest.setBody(commonRequestBody);
		Mockito.when(transactionRequest.getRestfulMethod()).thenReturn(null);
		this.transaction.getContext().setTransactionRequest(transactionRequest);

	}

	@Test
	public void testNotNull() {
		LOGGER.info("Test 1.start");
		Assert.assertNotNull(this.transaction);
		// The method getRestfulMethod() will return null by default. To test
		// other methods add a line like this
		// Mockito.when(transactionRequest.getRestfulMethod()).thenReturn("getBancos");
		this.transaction.execute();
		LOGGER.info("Test 1.finish");
	}

	@Test
	public void testNotMethodGET() {
		LOGGER.info("Test.02.start");
		Assert.assertNotNull(this.transaction);
		Mockito.when(transactionRequest.getRestfulMethod()).thenReturn(null);
		this.transaction.execute();
		Assert.assertEquals(this.transaction.getContext().getSeverity(), Severity.WARN);
		LOGGER.info("Test.02.finish");
	}

	@Test
	public void testMethodGET() {
		LOGGER.info("Test.03.start");
		Assert.assertNotNull(this.transaction);
		Mockito.when(transactionRequest.getRestfulMethod()).thenReturn("GET");
		this.transaction.execute();
		Assert.assertEquals(this.transaction.getContext().getSeverity(), Severity.OK);
		LOGGER.info("Test.03.finish");
	}

	@Test
	public void testMethodGETDocumentType() {
		LOGGER.info("Test.04.start");
		Assert.assertNotNull(this.transaction);
		Mockito.when(transactionRequest.getRestfulMethod()).thenReturn("GET");

		MultivaluedHashMap<String, String> queryParams = new MultivaluedHashMap<>();
		queryParams.add("identityDocumentType", "DNI");
		queryParams.add("identityDocument", "42029511F");

		MessageContext m = MessageContextTest.build(HttpMethodCode.METHOD_CODE_GET,
				"/customers/v0/customers?identityDocumentType=DNI&identityDocument=42029511F", queryParams,
				new MultivaluedHashMap<String, String>());

		Mockito.when(this.transactionRequest.getMessageContext()).thenReturn(m);

		this.transaction.execute();
		Assert.assertEquals(this.transaction.getContext().getSeverity(), Severity.OK);
		LOGGER.info("Test.04.finish");
	}

	@Test
	public void testMethodGETDocumentTypeOK() {
		LOGGER.info("Test.05.start");
		Assert.assertNotNull(this.transaction);
		Mockito.when(transactionRequest.getRestfulMethod()).thenReturn("GET");

		MultivaluedHashMap<String, String> queryParams = new MultivaluedHashMap<>();
		queryParams.add("identityDocumentType", "DNI");
		queryParams.add("identityDocument", "12345678N");

		MessageContext m = MessageContextTest.build(HttpMethodCode.METHOD_CODE_GET,
				"/customers/v0/customers?identityDocumentType=DNI&identityDocument=12345678N", queryParams,
				new MultivaluedHashMap<String, String>());

		Mockito.when(this.transactionRequest.getMessageContext()).thenReturn(m);
		this.transaction.execute();
		Assert.assertEquals(this.transaction.getContext().getSeverity(), Severity.WARN);
		LOGGER.info("Test.05.finish");
	}

	@Test
	public void testMethodGETNotDocumentType() {
		LOGGER.info("Test.06.start");
		Assert.assertNotNull(this.transaction);

		Mockito.when(transactionRequest.getRestfulMethod()).thenReturn("GET");

		MultivaluedHashMap<String, String> queryParams = new MultivaluedHashMap<>();

		queryParams.add("identityDocumentType", "NotDocument");
		queryParams.add("identityDocument", "42029511F");

		MessageContext m = MessageContextTest.build(HttpMethodCode.METHOD_CODE_GET,
				"/customers/v0/customers?identityDocumentType=NotDocument&identityDocument=42029511F", queryParams,
				new MultivaluedHashMap<String, String>());

		Mockito.when(this.transactionRequest.getMessageContext()).thenReturn(m);
		this.transaction.execute();

		Assert.assertEquals(this.transaction.getContext().getSeverity(), Severity.WARN);
		LOGGER.info("Test.06.finish");
	}

	private void addTable(final String key, final List<Map<String, Object>> table) {
		ParameterTable parameterTable = new ParameterTable();
		parameterTable.setParameterTableList(table);
		this.addParameter(key, parameterTable);
	}

	private void addParameter(final String parameter, final Object value) {
		final TransactionParameter tParameter = new TransactionParameter(parameter, value);
		transaction.getContext().getParameterList().put(parameter, tParameter);
	}

	private Object getParameter(final String parameter) {
		final TransactionParameter param = transaction.getContext().getParameterList().get(parameter);
		return param.getValue();
	}

	private Object getTableParameter(final int rowNumber, final String table, final String key) {
		ParameterTable param = (ParameterTable) getParameter(table);
		Map<String, Object> row = param.get(rowNumber);
		return row.get(key);
	}
}
