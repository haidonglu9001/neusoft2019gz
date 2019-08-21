package com.neusoft.security.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUser implements UserDetails {

	private Integer id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    
    public JwtUser() {
    }

    // 写一个能直接使用user创建jwtUser的构造器
    public JwtUser(UserModel user) {
        id = user.getId();
        username = user.getUsername();
        password = user.getPassword();
        System.out.println("用户角色:"+user.getRole());
       
        authorities =Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		 return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		 return true;
	}

	@Override
	public boolean isEnabled() {
		 return true;
	}

}
