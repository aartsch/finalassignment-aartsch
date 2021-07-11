package nl.hu.bep.webservices;

import nl.hu.bep.domein.AquariumManager;
import nl.hu.bep.domein.Toebehoren;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
@Path("toebehorens")
public class ToebehorensResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response voegToebehorenToe(@FormParam("model") String model, @FormParam("serienummer") int serienummer, @FormParam("omschrijving") String omschrijving) {
        if ("".equals(serienummer)) {
            return Response.status(Response.Status.CONFLICT)
                    .entity(new AbstractMap.SimpleEntry<>("message", "name is empty"))
                    .build();
        }

        Toebehoren toebehoren = new Toebehoren(model, serienummer, omschrijving);
        AquariumManager.getAquariumManager().voegToebehorenToe(toebehoren);
        return Response.ok().build();
    }
}
