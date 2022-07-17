package org.rhubarb.web.forms.admin;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Arpan Mukhopadhyay
 */
public class RoleForm implements Serializable {
  
  @Serial
  private static final long serialVersionUID = 216083851018988217L;
  
  private String name;
  private String description;
}
