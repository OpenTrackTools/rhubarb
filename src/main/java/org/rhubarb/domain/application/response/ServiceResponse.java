package org.rhubarb.domain.application.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Arpan Mukhopadhyay
 */
@Getter
@Setter
public abstract class ServiceResponse {

  private short errorCode;
  private String errorMessage;
  private Object result;
  
  /**
   *
   */
  public void success() {
    this.errorCode = 0;
  }
  
  /**
   * @return
   */
  public boolean isSuccess() {
    return this.errorCode == 0;
  }
  
  /**
   *
   */
  public ServiceResponse() {
    this.errorCode = 1;
  }
}
