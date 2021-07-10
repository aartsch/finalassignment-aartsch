package nl.hu.bep.webservices;

import nl.hu.bep.domein.Aquarium;
import nl.hu.bep.domein.AquariumManager;
import nl.hu.bep.domein.Eigenaar;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("aquarium/{eigenaar}")
public class AquariumResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAquariumByEigenaar(@PathParam("eigenaar") String name) {
        Eigenaar eigenaar = AquariumManager.getAquariumManager().getEigenaarByName(name);
        if (!eigenaar.getAquarium().isEmpty()) {
            JsonArrayBuilder jab = Json.createArrayBuilder();

            for (Aquarium a : eigenaar.getAquarium()) {
                JsonObjectBuilder job = Json.createObjectBuilder();
                job.add("naam", a.getNaam());
                job.add("lengte", a.getLengte());
                job.add("breedte", a.getBreedte());
                job.add("hoogte", a.getHoogte());
                job.add("bodemsoort", a.getBodemsoort());
                job.add("watersoort", a.getWatersoort());
                jab.add(job);
            }
            JsonArray array = jab.build();
            return array.toString();
        }
        else {
            return null;
        }
    }


@DELETE
@Produces(MediaType.APPLICATION_JSON)
public Response deleteAquarium(@PathParam("eigenaar") String name) {

    if(Eigenaar.removeAquarium(name))
        return Response.ok().build();
    else
        return Response.status(Response.Status.NOT_FOUND).build(); //dit geeft een 404
}
}
