package com.bbva.aaaa.lib.r001;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.Advised;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.aaaa.dto.customers.CustomerDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/AAAAR001-app.xml",
		"classpath:/META-INF/spring/AAAAR001-app-test.xml", "classpath:/META-INF/spring/AAAAR001-arc.xml",
		"classpath:/META-INF/spring/AAAAR001-arc-test.xml" })
public class AAAAR001Test {

	private static final Logger LOGGER = LoggerFactory.getLogger(AAAAR001.class);

	@Resource(name = "aaaaR001")
	private AAAAR001 aaaaR001;

	@Before
	public void setUp() throws Exception {
		getObjectIntrospection();
	}

	private Object getObjectIntrospection() throws Exception {
		Object result = this.aaaaR001;
		if (this.aaaaR001 instanceof Advised) {
			Advised advised = (Advised) this.aaaaR001;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}

	@Test
	public void executeTest() {
		LOGGER.info("Executing the test: Get all customers");
		Assert.assertEquals(aaaaR001.execute().size() > 0, true);
	}

	@Test
	public void executeDocumentTest() {
		LOGGER.info("Executing the test: Get a customer");
		Assert.assertEquals(aaaaR001.executeDocument("DNI", "42029511F").size(), 1);
	}

	@Test
	public void executeNotDocumentTest() {
		LOGGER.info("Executing the test: Not get customer");
		Assert.assertEquals(aaaaR001.executeDocument("DNI", "12345678F").size(), 0);
	}

	@Test
	public void executeNotDocumentErrorTest() {
		LOGGER.info("Executing the test: Return null");
		List<CustomerDTO> customer = aaaaR001.executeDocument("Notdocument", "12345678F");
		Assert.assertNull(customer);
	}

}
