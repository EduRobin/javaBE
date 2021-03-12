package cz.educanet.logreg;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    private UserManager userManager;
    @Inject
    private LoginManager loginManager;

    @GET
    public Response dostanVsechny(UserToken token) {
        if (!loginManager.validate(token))
            return Response.status(401, "invalid token").build();
        return Response.ok(userManager.dostanJmenos()).build();
    }

    @GET
    @Path("/test")
    public Response fckit(@HeaderParam("token") String token) {
        if (!loginManager.validate(token))
            return Response.status(401, "invalid token").build();
        return Response.ok(userManager.dostanJmenos()).build();
    }

    @GET
    @Path("{id}")
    public Response dostanUsera(UserToken token, @PathParam("id") int id) {
        if (!loginManager.validate(token))
            return Response.status(401, "invalid token").build();
        return Response.ok(userManager.dostanJmenos(id)).build();
    }

    @POST
    @Path("/register")
    public Response vytvorJmeno(User jmeno) {
        if (!userManager.create(jmeno))
            return Response.status(400).build();
        return Response.ok(jmeno).build();
    }

    @POST
    @Path("/login")
    public Response checkniJmeno(User jmeno){
        UserToken token = userManager.checkniJmenos(jmeno);
        if (token == null)
            return Response.status(404).build();
        return Response.ok(token).build();
    }

    @DELETE
    @Path("{id}")
    public Response odstranUsera(@PathParam("id") int id, UserToken token) {
        if (!loginManager.validate(token))
            return Response.status(401).build();
        if (userManager.odstranJmenos(id)) {
            return Response.ok("User byl odstranen ").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
