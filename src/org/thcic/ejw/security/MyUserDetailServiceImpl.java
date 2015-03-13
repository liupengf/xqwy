package org.thcic.ejw.security;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.thcic.ejw.util.WebUtil;
import org.thcic.xqwy.user.service.UsersService;
import org.thcic.xqwy.user.vo.Users;
@SuppressWarnings("deprecation")
@Service
    public class MyUserDetailServiceImpl implements UserDetailsService {  
          @Autowired
        private UsersService usersService;  
        public UserDetails loadUserByUsername(String username) {  
        	System.out.println("jinru");
            Users users =usersService.getUser(username) ;  
            if(users == null) {  
                throw new UsernameNotFoundException(username);  
            }  
            Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities();  
              
            boolean enables = true;  
            boolean accountNonExpired = true;  
            boolean credentialsNonExpired = true;  
            boolean accountNonLocked = true;  
            WebUtil.getHttpServletRequest().getSession().setAttribute("username", username);  
            User userdetail = new User(users.getUsername(), users.getPwd(), enables, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);  
            return userdetail;  
        }  
          
        //取得用户的权限  
        private Set<GrantedAuthority> obtionGrantedAuthorities() {  
            Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();  
            authSet.add(new GrantedAuthorityImpl("admin"));  
            return authSet;  
        }  
    }  


