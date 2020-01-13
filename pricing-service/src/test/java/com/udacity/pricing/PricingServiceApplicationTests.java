package com.udacity.pricing;

import com.udacity.pricing.domain.Price;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class PricingServiceApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private JacksonTester<Price> json;

	@Test
	public void contextLoads() {
	}

	/**
	 * Tests if the read operation appropriately returns a list of prices.
	 * @throws Exception if the read operation of the prices list fails
	 */
	@Test
	public void listPrices() throws Exception {
		mvc.perform(
				get(new URI("/prices"))
						.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("_embedded.prices", hasSize(3)))
				.andExpect(jsonPath("_embedded.prices[0].currency", is("EUR")))
				.andExpect(jsonPath("_embedded.prices[0].price", is(14999.99)))
				.andExpect(jsonPath("_embedded.prices[0].vehicleId", is(1)));
	}

	/**
	 * Tests the read operation for a single price by ID.
	 * @throws Exception if the read operation for a single price fails
	 */
	@Test
	public void findPrice() throws Exception {
		mvc.perform(
				get(new URI("/prices/2"))
						.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("currency", is("EUR")))
				.andExpect(jsonPath("price", is(26999.99)))
				.andExpect(jsonPath("vehicleId", is(2)));
	}
}
