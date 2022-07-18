package org.rhubarb.web.forms.admin;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Arpan Mukhopadhyay
 */
@Getter
@Setter
@NoArgsConstructor
public class RoleForm implements Serializable {
  
  @Serial
  private static final long serialVersionUID = 216083851018988217L;
  
  @NotEmpty(message = "Role name can not be empty")
  @Min(message = "Role name must be at least 3 characters long", value = 3)
  private String name;
  private String description;
  @NotEmpty(message = "Key can not be empty")
  @Min(message = "Key must be at least 3 characters long", value = 3)
  private String key;
}
