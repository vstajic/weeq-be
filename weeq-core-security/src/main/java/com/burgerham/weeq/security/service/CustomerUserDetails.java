package com.burgerham.weeq.security.service;

import java.util.Collection;
import java.util.HashSet;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Setter
public class CustomerUserDetails implements UserDetails {

  final Collection<GrantedAuthority> authorities = new HashSet<>();
  private String username;
  private boolean accountNonLocked;
  private boolean credentialsNonExpired;
  private String password;
  private boolean enabled;
  private boolean accountNonExpired = true;

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
    return accountNonExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return accountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return credentialsNonExpired;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }
}
