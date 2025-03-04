package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    private CustomerClient customerClient;

    @Test
    void getCustomer() {
        CustomerDto customerDto = customerClient.getCustomer(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void postCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Mayra").build();
        URI uri = customerClient.postCustomer(customerDto);

        assertNotNull(uri);
    }

    @Test
    void putCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Mayra").build();
        customerClient.putCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }
}