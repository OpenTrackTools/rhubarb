package org.rhubarb.web.routes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Arpan Mukhopadhyay
 */
@Controller
@Slf4j
public class UserSettingRoutes extends BaseRoute {
  
  /**
   * Opens the user profile page
   *
   * @param username the username.
   * @return
   */
  @GetMapping(path = {"/{username}"})
  String profile(@PathVariable(name = "username") String username) {
    return PROFILE_PAGE;
  }
}
