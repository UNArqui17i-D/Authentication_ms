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

    @GET
    @Path("{userId}")
    public Session getSessionByUserId(@PathParam("userId") long userId) {
        return sessionService.getSessionByUserId(userId);
    }

    @POST
    public Session createSession(Session session) {
        if(session.getUserId() != 0){
	    Session s = sessionService.createSession(session);
            if(s != null) {
                return s;
            }
            return null;
        }else{
            return null;
        }
    }

    @DELETE
    @Path("{userId}")
    public Response deleteSession(@PathParam("userId") long userId) {
        sessionService.deleteSession(userId);
        return Response.status(Response.Status.OK).build();
    }

}