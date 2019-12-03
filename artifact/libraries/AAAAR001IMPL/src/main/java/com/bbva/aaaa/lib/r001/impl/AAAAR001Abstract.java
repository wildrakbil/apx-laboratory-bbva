package com.bbva.aaaa.lib.r001.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.aaaa.lib.r001.AAAAR001;
import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.library.AbstractLibrary;

public abstract class AAAAR001Abstract extends AbstractLibrary implements AAAAR001 {

	private static final Logger LOGGER = LoggerFactory.getLogger(AAAAR001.class);
	
	protected ApplicationConfigurationService applicationConfigurationService;
	
	/**
	 * @param applicationConfigurationService the applicationConfigurationService to set
	 */
	public void setApplicationConfigurationService(
			ApplicationConfigurationService applicationConfigurationService) {
		this.applicationConfigurationService = applicationConfigurationService;
	}
}
