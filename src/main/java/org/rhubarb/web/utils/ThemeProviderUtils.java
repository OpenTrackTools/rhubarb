package org.rhubarb.web.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Arpan Mukhopadhyay
 */
@Component("themeProvider")
@Slf4j
public class ThemeProviderUtils {

  private static final String THEME_LIGHT = "light";
  private static final String THEME_DARK = "dark";
  private static final String DEFAULT_THEME = THEME_LIGHT;
  private static final String ACTIVE_THEME = THEME_DARK;
  
  /**
   *
   * @return the current theme
   */
  public String getCurrentTheme() {
    log.info("Current theme {}", ACTIVE_THEME);
    return ACTIVE_THEME;
  }
}
