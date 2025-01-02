package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.services.BeerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;
import java.util.function.Consumer;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
@WebMvcTest(BeerController.class)
class BeerControllerTest {

//    @Autowired
//    BeerController beerController;

    @MockitoBean
    BeerService beerService;
    @Autowired
    MockMvc mockMvc;

    @Test
    void getBeerById() throws Exception {
         mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID())
                   .accept(MediaType.APPLICATION_JSON))
                 .andExpect(status().isOk());

//         System.out.println(beerController.getBeerById(UUID.randomUUID()));
        
    }
}