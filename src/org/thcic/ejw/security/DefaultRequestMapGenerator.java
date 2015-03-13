package org.thcic.ejw.security;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;
import org.springframework.stereotype.Component;
import org.thcic.ejw.security.RequestMapGenerator;

@Component
public class DefaultRequestMapGenerator implements RequestMapGenerator {
	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(this.getClass());
    
	/**
	 * 各个角色所具备的系统访问路径
	 */ 
	@Override
	public void populateRequestMap(
			Map<RequestMatcher, Collection<ConfigAttribute>> map) {

		map.clear();
		ConfigAttribute jcxxgly = new SecurityConfig("admin");
		Collection<ConfigAttribute> all = new ArrayList<ConfigAttribute>();//基础信息管理员+guest访问
		all.add(jcxxgly);
		map.put(new AntPathRequestMatcher("/**"), all);//
	}

}
