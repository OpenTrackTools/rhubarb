package org.rhubarb.web.forms.admin;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
public class DatabaseForm implements Serializable {

  @Serial
  private static final long serialVersionUID = 5826345662440698145L;
  
  private String name;
  private String description;
  private String notes;
  private String shortCode;
  private Visibility visibility;
}
