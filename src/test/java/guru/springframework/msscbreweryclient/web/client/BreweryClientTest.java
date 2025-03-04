package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeer() {
        BeerDto dto = breweryClient.getBeer(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void postBeer() {
        BeerDto dto = BeerDto.builder().beerName("Beer Mayra").build();

        URI uri = breweryClient.postBeer(dto);

        assertNotNull(uri);
    }

    @Test
    void updateBeer() {
        BeerDto dto = BeerDto.builder().beerName("Beer Mayra").build();

        breweryClient.updateBeer(UUID.randomUUID(), dto);
    }
}