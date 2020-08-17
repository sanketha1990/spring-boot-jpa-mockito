package com.springboot.app.web;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class PersonControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void init() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void verifyPersonList() {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/person/getAll").accept("application/json"))
					.andExpect(jsonPath("$", hasSize(4))).andDo(print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void getPersonById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/person/{personId}").accept("application/json"))
				.andExpect(jsonPath("$.personId").exists()).andExpect(jsonPath("$.name").exists())
				.andExpect(jsonPath("$.age").exists()).andExpect(jsonPath("$.name").exists())
				.andExpect(jsonPath("$.personId").value(3)).andExpect(jsonPath("$.age").value(30))
				.andExpect(jsonPath("$.name").value("Sanketh")).andDo(print());
	}

}
