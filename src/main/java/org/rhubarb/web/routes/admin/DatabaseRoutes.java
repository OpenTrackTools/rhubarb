package org.rhubarb.web.routes.admin;

import lombok.extern.slf4j.Slf4j;
import org.rhubarb.web.forms.admin.DatabaseForm;
import org.rhubarb.web.routes.BaseRoute;
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
@RequestMapping(path = "/admin/databases")
@Slf4j
public class DatabaseRoutes extends BaseRoute {
  
  /**
   *
   * @param m
   * @return
   */
  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping(path = {"/", ""})
  String index(Model m) {
    m.addAttribute(PATHNAME_KEY, ADMIN_DATABASE_PATH);
    return ADMIN_DATABASE;
  }
  
  /**
   *
   * @param m
   * @return
   */
  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping(path = {"/new"})
  String create(Model m, @ModelAttribute(name = "form") DatabaseForm form) {
    m.addAttribute(PATHNAME_KEY, ADMIN_DATABASE_NEW_PATH);
//    m.addAttribute(FORM_KEY)
    return ADMIN_DATABASE_NEW;
  }
}
