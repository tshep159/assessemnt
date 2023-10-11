package za.co.momentum.investment.app.controller.impl;

import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.co.momentum.investment.app.entity.Client;
import za.co.momentum.investment.app.service.ClientService;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.util.Lists.list;
@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerImplTest {
    private static final String ENDPOINT_URL = "/api/client";
    @InjectMocks
    private ClientControllerImpl clientController;
    @MockBean
    private ClientService clientService;

    @Autowired
    private MockMvc mockMvc;

    @Before("")
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.clientController).build();
    }

 /* @Test
    public void getAll() throws Exception {
        String url = "/1/products";
        List<Client> someModelList = clientService.findAll();

        Mockito.when(clientService.findAll()).thenReturn(someModelList);

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL+url))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }*/

    /*@Test
    public void getById() throws Exception {

        String url = "/1";
        Optional<Client> client = clientService.findById(1);
        Mockito.when(clientService.findById(1)).thenReturn(client);

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + url))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(clientService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(clientService);
    }*/
   /* @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(clientService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(clientService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(clientService);
    }
*/
}