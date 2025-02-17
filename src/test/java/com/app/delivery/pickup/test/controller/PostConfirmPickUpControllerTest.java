package com.app.delivery.pickup.test.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.app.delivery.pickup.application.ports.in.service.IOrchestratorConfirmPickUpService;
import com.app.delivery.pickup.infrastructure.controller.PostConfirmPickUpController;
import com.app.delivery.pickup.infrastructure.dto.response.ResponseConfirmPickUpDTO;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PostConfirmPickUpController.class)
//@SpringBootTest(classes = DemoApplication.class)
public class PostConfirmPickUpControllerTest {

	private MockMvc mockMvc;
	
	@MockBean
	private IOrchestratorConfirmPickUpService orchestratorConfirmPickUpService; 

	public PostConfirmPickUpControllerTest(MockMvc mockMvc) {
		super();
		this.mockMvc = mockMvc;
	}

	@Test
	void shouldReturnExpectedResponse() throws Exception {
		when(orchestratorConfirmPickUpService.process(null)).thenReturn(new 
				ResponseConfirmPickUpDTO.Builder("OK").build());

        mockMvc.perform(get("/v1/api/purchase/pick-up/confirm")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
	}

}

