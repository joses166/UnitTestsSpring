package br.com.josehamilton.api.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.josehamilton.api.service.HelloService;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

	private static final String CONTROLLER_API = "/api/v1/hello";
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	HelloService helloService;
	
	@Autowired
	ObjectMapper mapper;
	
	@Test
	public void testeHelloObject() throws Exception {
		// Cenário
		Map<String, Object> map = new HashMap<>();
		map.put("dado", "dado");

		// Execução
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(CONTROLLER_API)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(map));
		
		// Verificações
		mockMvc.perform(requestBuilder)
			.andExpect(status().isNoContent());
	}
	
	@Test
	public void testeHelloObjectNull() throws Exception {
		// Execução
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(CONTROLLER_API)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(null));
		
		// Verificações
		mockMvc.perform(requestBuilder)
			.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testeHelloObjectEmpty() throws Exception {
		// Execução
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(CONTROLLER_API)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(""));
		
		// Verificações
		mockMvc.perform(requestBuilder)
			.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testeHelloVariousObject() throws Exception {
		// Cenário
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<>();
		map.put("dado", "dado");
		mapList.add(map);

		// Execução
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(CONTROLLER_API + "/various")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(mapList));
		
		// Verificações
		mockMvc.perform(requestBuilder)
			.andExpect(status().isNoContent());
	}
	
	@Test
	public void testeHelloVariousObjectNull() throws Exception {
		// Execução
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(CONTROLLER_API + "/various")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(null));
		
		// Verificações
		mockMvc.perform(requestBuilder)
			.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testeHelloVariousObjectEmpty() throws Exception {
		// Execução
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(CONTROLLER_API + "/various")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(""));
		
		// Verificações
		mockMvc.perform(requestBuilder)
			.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testeHelloVariousListObjectEmpty() throws Exception {
		// Execução
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(CONTROLLER_API + "/various")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(new ArrayList<Map<String, Object>>()));
		
		// Verificações
		mockMvc.perform(requestBuilder)
			.andExpect(status().isBadRequest());
	}
	
}
