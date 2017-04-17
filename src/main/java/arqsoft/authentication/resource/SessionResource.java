package arqsoft.authentication.resource;

import arqsoft.authentication.model.Session;
import arqsoft.authentication.model.User;
import arqsoft.authentication.service.SessionService;
import arqsoft.authentication.service.UserService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/sessions")
public class SessionResource {

    @Context
    UriInfo uriInfo;

    @EJB
    SessionService sessionService;

    UserService userService;

    @GET
    @Path("{userId}")
    public Session getSessionByUserId(@PathParam("userId") long userId) {
        return sessionService.getSessionByUserId(userId);
    }

    @POST
    public Response createSession(User user) {
        if(user.getUsername() != null){
            User u = userService.getUserByUsername(user.getEmail());
            Session session = new Session();
            session.setUserId(u.getId());
            sessionService.createSession(session);
            return Response.status(Response.Status.CREATED).build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("{token}")
    public Response deleteSession(@PathParam("token") String token) {
        sessionService.deleteSession(token);
        return Response.status(Response.Status.OK).build();
    }

}