package org.rhubarb.web.forms.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Arpan Mukhopadhyay
 */
@Getter
@AllArgsConstructor
public class SignupForm implements Serializable {
  
  @Serial
  private static final long serialVersionUID = -1332927017585253717L;
  
  private String username;
  private String email;
  private String password;
}
