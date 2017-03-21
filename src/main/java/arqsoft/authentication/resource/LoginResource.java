package arqsoft.authentication.resource;

import arqsoft.authentication.model.Login;
import arqsoft.authentication.service.LoginService;

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
    public Response login(Login login) {
        if (login.getUsername() == null || login.getPassword() == null) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
        return loginService.login(login.getUsername(), login.getPassword())
                ? Response.status(Response.Status.OK).build()
                : Response.status(Response.Status.BAD_REQUEST).build();
    }

}