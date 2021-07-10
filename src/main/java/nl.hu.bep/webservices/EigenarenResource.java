package nl.hu.bep.webservices;

import nl.hu.bep.domein.AquariumManager;
import nl.hu.bep.domein.Eigenaar;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("eigenaren")
public class EigenarenResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEigenaren() {
        AquariumManager aqmanager = AquariumManager.getAquariumManager();

        List<Eigenaar> eigenaren = aqmanager.getAllEigenaren();
        if(eigenaren.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(eigenaren).build();
    }
}
