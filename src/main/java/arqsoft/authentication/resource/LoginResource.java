package arqsoft.authentication.resource;

import arqsoft.authentication.model.Login;
import arqsoft.authentication.model.Session;
import arqsoft.authentication.model.User;
import arqsoft.authentication.service.LoginService;
import arqsoft.authentication.service.SessionService;
import arqsoft.authentication.service.UserService;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginResource {

    @EJB
    LoginService loginService;

    @POST
    @Consumes("application/json")
    public User login(Login login) {
        if (login.getUsername() == null || login.getPassword() == null) {
            return null;
        }
            return loginService.login(login.getUsername(), login.getPassword());
    }

}