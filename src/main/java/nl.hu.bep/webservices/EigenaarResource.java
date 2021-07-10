package nl.hu.bep.webservices;

import nl.hu.bep.domein.Aquarium;
import nl.hu.bep.domein.AquariumManager;
import nl.hu.bep.domein.Eigenaar;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("eigenaar/{name}")
public class EigenaarResource {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEigenaarByName(@PathParam("name") String name) {
        if (AquariumManager.getAquariumManager().getEigenaarByName(name) == null) return Response.noContent().build();
        return Response.ok(AquariumManager.getAquariumManager().getEigenaarByName(name)).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteEigenaar(@PathParam("name") String name) {
        if (AquariumManager.removeEigenaar(name))
            return Response.ok().build();
        else
            return Response.status(Response.Status.NOT_FOUND).build(); //dit geeft een 404
    }
}
