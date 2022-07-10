package org.rhubarb.web.views;

/**
 * @author Arpan Mukhopadhyay
 */
public interface I_ViewConstants {
  
  String REDIRECT = "redirect:";
  String PATHNAME_KEY = "pathName";
  String FORM_KEY = "form";
  String SIGNIN_VIEW = "signin";
  String SIGNUP_VIEW = "signup";
  String ADMIN_SETTINGS="admin/settings";
  String ADMIN_DASHBOARD = "admin/index";
  String ADMIN_DASHBOARD_PATH ="/admin";
  String ADMIN_DATABASE = "admin/database/index";
  String ADMIN_DATABASE_PATH = "/admin/databases";
  String ADMIN_DATABASE_NEW = "admin/database/new";
  String ADMIN_DATABASE_NEW_PATH = "/admin/databases/new";
  String DASHBOARD_VIEW = "/";
  String DASHBOARD_VIEW_REDIRECTED = REDIRECT + DASHBOARD_VIEW;
  
  String PROFILE_PAGE = "profile/index";
}
