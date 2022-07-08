package org.rhubarb.domain.application.service.impl;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.rhubarb.domain.models.user.RoleEntity;
import org.rhubarb.domain.models.user.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Arpan Mukhopadhyay
 */
@Slf4j
public class ApplicationUserDetails implements UserDetails {
  
  @Serial
  private static final long serialVersionUID = 3089429869630991347L;
  
  private final UserEntity userEntity;
  private final List<String> roles = new ArrayList<>();
  
  /**
   *
   * @param userEntity
   */
  public ApplicationUserDetails(UserEntity userEntity) {
    this.userEntity = userEntity;
  }
  
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    List<RoleEntity> roles = (List<RoleEntity>) this.userEntity.getRoles();
    log.info("User roles {}", roles);
    roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName().toUpperCase())));
    return authorities;
  }
  
  @Override
  public String getPassword() {
    return userEntity.getPassword();
  }
  
  @Override
  public String getUsername() {
    return userEntity.getUsername();
  }
  
  @Override
  public boolean isAccountNonExpired() {
    return !userEntity.isDeleted();
  }
  
  @Override
  public boolean isAccountNonLocked() {
    return !userEntity.isLocked();
  }
  
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }
  
  @Override
  public boolean isEnabled() {
    return !userEntity.isDeleted();
  }
}
