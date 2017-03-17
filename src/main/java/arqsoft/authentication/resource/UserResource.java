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

@Path("/users")
public class UserResource {

    @Context
    UriInfo uriInfo;

    @EJB
    RegisterService registerService;
    LoginService loginService;
    UserService userService;

    @GET
    public List<User> getAllUsers(@QueryParam("first") int first, @QueryParam("maxResult") int maxResult) {
        return userService.getAllUsers(first, maxResult);
    }

    @GET
    @Path("{id}")
    public User getUserById(@PathParam("id") long id) {
        return userService.getUserById(id);
    }

    @POST
    public Response register(User user) {
        registerService.registerUser(user);
        return Response.status(Response.Status.CREATED).build();
    }

    @POST
    @Path("{username}/{password}")
    public Response login(@PathParam("username") String username, @PathParam("password") String password) {
        return loginService.login(username, password)
                ? Response.status(Response.Status.OK).build()
                :Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}")
    public Response updateUser(@PathParam("id") long id, User user) {
        userService.updateUser(id, user);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") long id) {
        userService.deleteUser(id);
        return Response.status(Response.Status.OK).build();
    }

}
