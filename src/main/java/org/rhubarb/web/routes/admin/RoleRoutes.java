package org.rhubarb.web.routes.admin;

import lombok.extern.slf4j.Slf4j;
import org.rhubarb.domain.application.service.admin.impl.RoleServiceImpl;
import org.rhubarb.web.forms.admin.RoleForm;
import org.rhubarb.web.routes.BaseRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Arpan Mukhopadhyay
 */
@Controller
@RequestMapping(path = {"/admin/roles"})
@Slf4j
public class RoleRoutes extends BaseRoute {
  
  @Autowired
  private RoleServiceImpl roleService;
  
  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping(path = {"/", ""})
  String index(Model m) {
    m.addAttribute(PATHNAME_KEY, ADMIN_ROLES_PATH);
    m.addAttribute(Roles.ROLE_LIST_KEY, roleService.listRoles());
    return ADMIN_ROLES_VIEW;
  }
  
  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping(path = {"/new", ""})
  String create(Model m, @ModelAttribute(name = "form") RoleForm form) {
    m.addAttribute(PATHNAME_KEY, ADMIN_ROLES_PATH);
    m.addAttribute(Roles.ROLE_LIST_KEY, roleService.listRoles());
    return ADMIN_ROLES_VIEW;
  }
}
