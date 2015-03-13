package org.thcic.ejw.security;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.RequestMatcher;

public interface RequestMapGenerator {
	public void populateRequestMap(
			Map<RequestMatcher, Collection<ConfigAttribute>> map);
}
