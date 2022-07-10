package org.rhubarb.domain.application.service.impl;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.rhubarb.domain.application.response.auth.AuthServiceResponse;
import org.rhubarb.domain.models.user.RoleEntity;
import org.rhubarb.domain.models.user.UserEntity;
import org.rhubarb.infra.RoleRepository;
import org.rhubarb.infra.UserRepository;
import org.rhubarb.web.forms.auth.SignupForm;
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
  
  @Autowired
  private RoleRepository roleRepository;
  
  //TODO - Create Admin user during installation process
  @PostConstruct
  @Transactional
  private void createAdmin() {
    UserEntity adminUserEntity = userRepository.findUserEntityByUsername("admin").orElse(null);
    if (null == adminUserEntity) {
      adminUserEntity = new UserEntity("arpan", "arpan@rhubarb.com");
      adminUserEntity.setPassword(passwordEncoder.encode("admin"));
      RoleEntity adminRole = new RoleEntity("ADMIN", "Admin role", (short) 0);
      adminUserEntity.addRoles(adminRole);
      try {
        roleRepository.save(adminRole);
        userRepository.save(adminUserEntity);
        log.info("Admin user created successfully, {}", adminUserEntity);
      } catch (Exception e) {
        log.error("Error - ", e);
      }
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
