package com.micro.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.demo.domain.Customer;
import com.micro.demo.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	private MockMvc mockMvc;
	
	private CustomerService service;
	public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
    @Autowired
    private WebApplicationContext webApplicationContext;
	
	 @Before
	 public void setUp() {
		 service=mock(CustomerService.class);
//	    Mockito.reset(service);

	    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	  }

	
	@Test
	public void contextLoads() {
	}
	
	@Test
    public void getByFirstNameTest() throws Exception {
		Customer cust = new Customer("nash","kg","25");
		when(service.getByFirstName("nash")).thenReturn(cust);
		mockMvc.perform(get("/customer?firstName=nash.json")).andExpect(status().isOk());
	}
	
	@Test
    public void saveCustomerTest() throws Exception {
		CustomerRequest cust = new CustomerRequest();cust.setFirstName("ram");cust.setLastName("kg");cust.setAge("33");
	
		mockMvc.perform(post("/customer").contentType(TestUtil.APPLICATION_JSON_UTF8).content(TestUtil.convertObjectToJsonBytes(cust))).andExpect(status().isOk());
	}

}
