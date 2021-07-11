package nl.hu.bep.webservices;

import nl.hu.bep.domein.Aquarium;
import nl.hu.bep.domein.AquariumManager;
import nl.hu.bep.domein.Eigenaar;
import nl.hu.bep.domein.Toebehoren;
import nl.hu.bep.domein.Ornament;
import nl.hu.bep.domein.Bewoner;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
import java.util.List;

@Path("aquarium/{eigenaar}")
public class AquariumResource {

    @GET
    @Produces("application/json")
    public String getAquariumByEigenaar(@PathParam("eigenaar") String name) {
        Eigenaar eigenaar = AquariumManager.getAquariumManager().getEigenaarByName(name);
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


    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAquarium(@PathParam("eigenaar") String name) {

        if (Eigenaar.removeAquarium(name))
            return Response.ok().build();
        else
            return Response.status(Response.Status.NOT_FOUND).build(); //dit geeft een 404
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response voegAquariumToe(@PathParam("eigenaar") String eigenaar, @FormParam("name") String naam, @FormParam("lengte") int lengte, @FormParam("breedte") int breedte, @FormParam("hoogte") int hoogte, @FormParam("bodemsoort") String bodemsoort, @FormParam("watersoort") String watersoort) {
        if ("".equals(naam)) {
            return Response.status(Response.Status.CONFLICT)
                    .entity(new AbstractMap.SimpleEntry<>("message", "name is empty"))
                    .build();
        }

        new Aquarium(naam, lengte, breedte, hoogte, bodemsoort, watersoort);
        return Response.ok().build();
    }

    @GET
    @Path("toebehoren")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getToebehoren(@PathParam("eigenaar") String eigenaar) {
        AquariumManager aq1 = AquariumManager.getAquariumManager();
        List<Toebehoren> lists = aq1.getAllToebehoren();
        if (lists == null) {
            return Response.status(Response.Status.NO_CONTENT).build(); //dit geeft een 204
        }
        return Response.ok(lists).build(); //inclusief lijstitems dus weer
    }

    @GET
    @Path("bewoner")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBewoners(@PathParam("eigenaar") String eigenaar) {
        AquariumManager aq1 = AquariumManager.getAquariumManager();
        List<Bewoner> lists = aq1.getAllBewoners();
        if(lists == null){
            return Response.status(Response.Status.NO_CONTENT).build(); //dit geeft een 204
        }
        return Response.ok(lists).build(); //inclusief lijstitems dus weer
    }
    @GET
    @Path("ornament")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrnamenten(@PathParam("eigenaar") String eigenaar) {
        Eigenaar eigenaar1 = AquariumManager.getAquariumManager().getEigenaarByName(eigenaar);
        Aquarium aq1 = (Aquarium) eigenaar1.getAquarium();
        List<Ornament> lists = aq1.getOrnamenten();
        if(lists == null){
            return Response.status(Response.Status.NO_CONTENT).build(); //dit geeft een 204
        }
        return Response.ok(lists).build(); //inclusief lijstitems dus weer
    }
}


