package com.udea.GestionFinanciera.Security;

import com.udea.GestionFinanciera.Service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SuccessGoogle implements AuthenticationSuccessHandler {

    @Autowired
    UserServiceI userServiceI;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        DefaultOidcUser user = (DefaultOidcUser) authentication.getPrincipal();

        String correouser = user.getEmail();
        try {
            userServiceI.consultarUserById(correouser);
            response.sendRedirect("/home");
        } catch (Exception e) {
            //logout
            new SecurityContextLogoutHandler().logout(request,response,authentication);
            response.sendRedirect("/login");
        }
    }
}
