package com.vervevault.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SPA redirect controller:
 * Forwards any non-API, non-static request to index.html so client-side routing works
 * (fixes 404 when user refreshes or navigates client routes like /dashboard or /edit).
 */
@Controller
public class SpaRedirectController {

    // Match paths without a dot (to exclude static files like .js, .css, .png) and forward to index.html
    @RequestMapping(value = {"/{path:[^\\.]*}", "/**/{path:[^\\.]*}"})
    public String forward() {
        return "forward:/index.html";
    }
}
