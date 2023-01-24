package ec.restclient.proxy;

import ec.restclient.model.Episode;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/shows")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface EpisodeProxy {

    @GET
    @Path("{id}/episodes")
    List<Episode> get(@PathParam("id") Long id);
}
