package org.rhubarb.web.routes.admin;

import lombok.extern.slf4j.Slf4j;
import org.rhubarb.web.routes.BaseRoute;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Arpan Mukhopadhyay
 */
@Controller
@RequestMapping(path = "/admin")
@Slf4j
public class AdminRoutes extends BaseRoute {
  
  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping(path = {"/", ""})
  String adminHome(Model m) {
    m.addAttribute(PATHNAME_KEY, ADMIN_DASHBOARD_PATH);
    return ADMIN_DASHBOARD;
  }
}
