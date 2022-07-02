package org.rhubarb.web.routes;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.rhubarb.domain.application.response.auth.AuthServiceResponse;
import org.rhubarb.domain.application.service.impl.UserAuthenticationServiceImpl;
import org.rhubarb.web.forms.SigninForm;
import org.rhubarb.web.forms.SignupForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Arpan Mukhopadhyay
 */
@Controller
@Slf4j
public class UserAuthenticationRoute extends BaseRoute {
  
  @Autowired
  private UserAuthenticationServiceImpl userAuthenticationService;
  
  @GetMapping(path = {"/signin"})
  String signin(@ModelAttribute("form") SigninForm form) {
    return SIGNIN_VIEW;
  }
  
  @GetMapping(path = {"/signup"})
  String signup(@ModelAttribute("form") SignupForm form) {
    return SIGNUP_VIEW;
  }
  
  @PostMapping(path = {"/signup"})
  String signup(@ModelAttribute("form") @Valid final SignupForm form, BindingResult bindingResult) {
    if (!bindingResult.hasErrors()) {
      AuthServiceResponse authServiceResponse = userAuthenticationService.registerUser(form);
      if (authServiceResponse.isSuccess()) return SIGNIN_VIEW;
    }
    return SIGNUP_VIEW;
  }
}