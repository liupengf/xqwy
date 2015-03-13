package org.thcic.ejw.security;

import java.util.Collection;
import java.util.LinkedHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.RequestMatcher;
import org.springframework.stereotype.Component;

@Component
public class RequestMap extends
		LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> {

	private static final long serialVersionUID = 2552270978662177214L;

	@Autowired
	//@Qualifier("defaultRequestMapGenerator")
	@Qualifier("defaultRequestMapGenerator")
	private RequestMapGenerator requestMapGenerator;

	@PostConstruct
	public void populateRequestMap() {
		requestMapGenerator.populateRequestMap(this);
	}

}
