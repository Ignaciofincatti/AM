/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ignacio
 */
@Named(value = "logoutBean")
@RequestScoped
public class logoutBean {

    /**
     * Creates a new instance of logoutBean
     */
    public logoutBean() {
    }
    
    
    
    public void logout() throws IOException{
        FacesContext context = FacesContext.getCurrentInstance();

        ExternalContext externalContext = context.getExternalContext();

        Object session = externalContext.getSession(false);

        HttpSession httpSession = (HttpSession) session;

        httpSession.invalidate();
        externalContext.redirect("http://localhost:8080/GestorLigas/index.html");
        
    }
    
}
