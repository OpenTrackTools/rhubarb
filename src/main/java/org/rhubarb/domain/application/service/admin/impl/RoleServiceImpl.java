package org.rhubarb.domain.application.service.admin.impl;

import lombok.extern.slf4j.Slf4j;
import org.rhubarb.domain.models.user.RoleEntity;
import org.rhubarb.infra.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Arpan Mukhopadhyay
 */
@Service
@Slf4j
public class RoleServiceImpl {
  
  @Autowired
  private RoleRepository roleRepository;
  
  public List<RoleEntity> listRoles() {
    return roleRepository.findAll();
  }
}
