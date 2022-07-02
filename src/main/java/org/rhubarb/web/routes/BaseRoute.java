package org.rhubarb.web.routes;

import lombok.NonNull;
import org.rhubarb.domain.application.service.impl.ApplicationUserDetails;
import org.rhubarb.web.views.I_ViewConstants;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Arpan Mukhopadhyay
 */
public abstract class BaseRoute implements I_ViewConstants {
  
  /**
   * @param username
   * @return
   */
  protected boolean isMe(@NonNull String username) {
    Object principalObject = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (principalObject instanceof ApplicationUserDetails userDetails) {
      final String sessionUsername = userDetails.getUsername();
      return sessionUsername.equals(username);
    }
    return false;
  }
}
