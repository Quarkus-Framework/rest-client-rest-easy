package ec.restclient;

import ec.restclient.model.Episode;
import ec.restclient.model.TvSerie;
import ec.restclient.proxy.EpisodeProxy;
import ec.restclient.proxy.TvSeriesProxy;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/tvseries")
@Produces("application/json")
@Tag(name = "TvSeriesResource", description = "Tv Series Resource")
public class TvSeriesResource {

    @RestClient
    TvSeriesProxy tvSeriesProxyproxy;

    @RestClient
    EpisodeProxy episodeProxy;


    private List<TvSerie> tvSeries = new ArrayList();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            operationId = "getEpisodesTvSerie",
            summary ="Get Episodes of a Tv Serie",
            description = "Get all episodes of a  tv series")
    @APIResponse(
            responseCode = "200",
            description = "Operation Completed",
            content = @Content(mediaType = MediaType.APPLICATION_JSON))
    public Response getEpisodesTvSerie(
            @Parameter(
                    description = "title of tv series",
                    required = true)
            @QueryParam("title") String title
    ) {
        TvSerie tvSerie = this.getTvSeries(title);
        List<Episode> episodeList = this.getEpisodies(tvSerie.getId());
        //tvSeries.add(tvSerie);
        //return Response.ok(tvSeries).build();

        return Response.ok(episodeList).build();
    }

    /**
     * Method called with @Fallback annotation for to handle a fallback
     * It have to has public
     */
    @Fallback(fallbackMethod = "fallBackGetTvSeries")
    public TvSerie getTvSeries(String title) {
        return tvSeriesProxyproxy.get(title);
    }

    /*
     * Fallback method have to has same signature of calling method
     */
    private TvSerie fallBackGetTvSeries(String title) {
        TvSerie tvSerie = new TvSerie();
        tvSerie.setId(1L);
        return tvSerie;
    }


    /**
     * Method called with @Fallback annotation for to handle a fallback
     * It have to has public
     */
    @Fallback(fallbackMethod = "fallBackGetEpisodes")
    public List<Episode> getEpisodies(Long id) {
        return episodeProxy.get(id);
    }

    /*
     * Fallback method have to has same signature of calling method
     */
    private List<Episode> fallBackGetEpisodes(Long id) {
        return new ArrayList<>();
    }

}
