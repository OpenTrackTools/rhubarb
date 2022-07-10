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
public class SigninForm implements Serializable {
  
  @Serial
  private static final long serialVersionUID = 870905568727474579L;
  
  private String login;
  private String password;
}
