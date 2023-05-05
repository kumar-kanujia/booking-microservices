package org.jfs.driveinmovie.driveinmovieapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("xyzSecurity")
    public String loginLogout(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()){
            authentication.setAuthenticated(false);
            return "redirect:/logout";
        }
		return "redirect:/login";
    }
}
