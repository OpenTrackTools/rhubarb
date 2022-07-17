package org.rhubarb.web.forms.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author Arpan Mukhopadhyay
 */
@Getter
@Setter
@NoArgsConstructor
public class UserForm implements Serializable {
  
  @Serial
  private static final long serialVersionUID = -3681249180726399586L;
  
  private String name;
  private String username;
  private String email;
  
  
  /**
   *
   * @param name
   * @param username
   * @param email
   */
  public UserForm(String name, String username, String email) {
    this.name = name;
    this.username = username;
    this.email = email;
  }
}
