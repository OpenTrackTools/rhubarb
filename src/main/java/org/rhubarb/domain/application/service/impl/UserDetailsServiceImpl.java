package org.rhubarb.domain.application.service.impl;

import org.rhubarb.domain.models.user.UserEntity;
import org.rhubarb.infra.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author Arpan Mukhopadhyay
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
  
  @Autowired
  private UserRepository userRepository;
  
  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    if (null == login) throw new UsernameNotFoundException("No user found with login " + null);
    UserEntity retrievedUser;
    //TODO check using pattern if required
    if (login.contains("@")) {
      retrievedUser = userRepository.findUserEntityByEmail(login).orElse(null);
    } else {
      retrievedUser = userRepository.findUserEntityByUsername(login).orElse(null);
    }
    if (null == retrievedUser) {
      throw new UsernameNotFoundException("No user found with login " + login);
    }
    return new ApplicationUserDetails(retrievedUser);
  }
}
