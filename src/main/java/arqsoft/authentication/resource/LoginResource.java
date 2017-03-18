package arqsoft.authentication.resource;

import arqsoft.authentication.model.User;
import arqsoft.authentication.service.LoginService;
import arqsoft.authentication.service.RegisterService;
import arqsoft.authentication.service.UserService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/login")
public class LoginResource {

    @EJB
    LoginService loginService;

    @POST
    public Response login(User user) {
        if (user.getUsername() == null || user.getPassword() == null) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
        return loginService.login(user.getUsername(), user.getPassword())
                ? Response.status(Response.Status.OK).build()
                : Response.status(Response.Status.UNAUTHORIZED).build();
    }

}