package ec.restclient.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Episode {

    private String id;
    private String name;
    private Integer season;
    private String summary;

}
