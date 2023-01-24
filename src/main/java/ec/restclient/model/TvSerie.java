package ec.restclient.model;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.Set;

@Getter
@Setter
public class TvSerie {

    private Long id;
    private URL url;
    private URL officialSite;
    private String name;
    private String type;
    private String language;
    private Set<String> genres;

}
