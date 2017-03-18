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

@Path("/register")
public class RegisterResource {

    @EJB
    RegisterService registerService;

    @POST
    public Response register(User user) {
        registerService.registerUser(user);
        return Response.status(Response.Status.CREATED).build();
    }

}
