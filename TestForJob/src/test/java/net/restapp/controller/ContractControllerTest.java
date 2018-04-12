package net.restapp.controller;

import com.sun.jndi.toolkit.url.Uri;
import net.restapp.servise.ContractService;
import net.restapp.servise.DocumentService;
import net.restapp.servise.IService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.persistence.ManyToOne;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ContractController.class)
public class ContractControllerTest {

    @MockBean
    DocumentService documentService;

    @MockBean
    ContractService contractService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testIndex() throws Exception{

        String contract = "ffb2e977797440719208b510ed91548b";

        this.mockMvc.perform(get("/contract/addByRestLink/"+contract))
                .andExpect(status().isOk());
    }



}
