package org.rhubarb.domain.application.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.rhubarb.domain.application.response.auth.AuthServiceResponse;
import org.rhubarb.domain.models.user.UserEntity;
import org.rhubarb.infra.UserRepository;
import org.rhubarb.web.forms.SignupForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Arpan Mukhopadhyay
 */
@Service
@Slf4j
public class UserAuthenticationServiceImpl {

  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private PasswordEncoder passwordEncoder;
  
  //TODO - Create Admin user during installation process
  @PostConstruct
  private void createAdmin() {
    UserEntity adminUserEntity = userRepository.findUserEntityByUsername("admin").orElse(null);
    if (null == adminUserEntity) {
      adminUserEntity = new UserEntity("admin", "admin@rhubarb.com");
      adminUserEntity.setPassword(passwordEncoder.encode("admin"));
      adminUserEntity.setRole((short) 1);
    }
  }
  
  /**
   *
   * @param form
   * @return
   */
  public AuthServiceResponse registerUser(SignupForm form) {
    AuthServiceResponse authServiceResponse = new AuthServiceResponse();
    UserEntity user = new UserEntity(form.getUsername(), form.getEmail());
    final String encryptedPassword = passwordEncoder.encode(form.getPassword());
    user.setPassword(encryptedPassword);
    try {
      userRepository.save(user);
      authServiceResponse.success();
    } catch (Exception e) {
      authServiceResponse.setErrorMessage("Could not register new user.");
    }
    return authServiceResponse;
  }
}
