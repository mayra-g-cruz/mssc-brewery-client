package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    @Setter
    private String apihost;

    private final RestTemplate restTemplate;
    public final String BEER_PATH_V1 = "/api/v1/beer";

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeer(UUID beerId) {
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + "/" + beerId, BeerDto.class);
    }

    public URI postBeer(BeerDto beer) {
        return restTemplate.postForLocation(apihost + BEER_PATH_V1, beer);
    }

    public void updateBeer(UUID beerId, BeerDto beer) {
        restTemplate.put(apihost + BEER_PATH_V1 + "/" + beerId, beer);
    }
}
