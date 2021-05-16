package com.example.demo.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

public class JwtUser implements UserDetails {

    private final Integer id;
    private final String login;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean enabled;
    private final Date lastPasswordResetDate;
    public JwtUser(
            Integer id,
            String login,
            String password,
             Collection<? extends GrantedAuthority> authorities,
            boolean enabled,
            Date lastPasswordResetDate

    )
    {
        this.id=id;
        this.login=login;
        this.password=password;
        this.authorities=authorities;
        this.enabled=enabled;
        this.lastPasswordResetDate=lastPasswordResetDate;
    }

    @JsonIgnore
    public Integer getId()
    {
        return id;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate()
    {
        return lastPasswordResetDate;
    }

//    public  String getLogin(){return login;}
}
