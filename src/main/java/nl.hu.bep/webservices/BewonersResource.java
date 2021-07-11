package nl.hu.bep.webservices;

import nl.hu.bep.domein.Aquarium;
import nl.hu.bep.domein.AquariumManager;
import nl.hu.bep.domein.Bewoner;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;

@Path("bewoners")
public class BewonersResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response voegBewonerToe(@FormParam("soortnaam") String soortnaam, @FormParam("kleurnaam")String kleurnaam, @FormParam("aantal") int aantal, @FormParam("groepsDier") String groepsDier, @FormParam("type") int type) {
        if ("".equals(soortnaam)) {
            return Response.status(Response.Status.CONFLICT)
                    .entity(new AbstractMap.SimpleEntry<>("message", "name is empty"))
                    .build();
        }
        Bewoner bewoner = new Bewoner(soortnaam, kleurnaam, aantal, groepsDier, type);
        AquariumManager.getAquariumManager().voegBewonerToe(bewoner);
        return Response.ok().build();
    }
}

