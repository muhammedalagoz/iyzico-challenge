package com.iyzico.challenge.mvc.test;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TicketControllerTest {

	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void verifyAllSpeakersList() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/ticket/speakers").accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$", hasSize(3)))
		.andDo(print());
	}

	@Test
	public void verifyAllPriceList() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/ticket/prices").accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$", hasSize(4)))
		.andDo(print());
	}

	@Test
	public void verifyAllDiscountList() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/ticket/discounts").accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$", hasSize(4)))
		.andDo(print());
	}

}