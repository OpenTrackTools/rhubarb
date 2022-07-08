package org.rhubarb.web.routes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
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
  @GetMapping(path = {"/settings"})
  String settings() {
    return ADMIN_SETTINGS;
  }
}
