package com.example.istakip;

import com.example.istakip.domain.DepartmanDO;
import com.example.istakip.domain.PersonelDO;
import com.example.istakip.domain.isDO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class IstakipApplicationTests {

	//@Autowired
	//private WebApplicationContext context;

	@Autowired
	private MockMvc mockMvc;
/*
	@Before
	public void setup(){
		mockMvc= MockMvcBuilders
				.webAppContextSetup(context)
				.build();
	}*/

	/*@Test
	void contextLoads() {
	}*/

	@Test
	public void testGetAllPersonel() throws Exception{
		RequestBuilder requestBuilder;
		mockMvc.perform(MockMvcRequestBuilders.get("/api/is/personels")
						.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
				//.andExpect(jsonPath(expression,matcher));

	}



	@Test
	public void testPersonelById() throws Exception{
		String personelId="9";
		mockMvc.perform(MockMvcRequestBuilders.get("/api/is/personels/{personelId}", personelId)
								.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name ").exists())
		;

	}

	@Test
	public void testCreatePersonel() throws Exception{

		PersonelDO personelDO= new PersonelDO();
		//personelDO.setId(personelDO.getId());
		personelDO.setName("Lila");
		personelDO.setSurname("Mai");
		DepartmanDO departmanDO=new DepartmanDO();
		//departmanDO.setId(departmanDO.getId());
		departmanDO.setDepartmanadi("Makine Mühendisliği");

		personelDO.setDepartman(departmanDO);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/is/personel")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(personelDO)))
						.andExpect(MockMvcResultMatchers.status().isCreated())
						.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
				        //.andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
				        .andExpect(MockMvcResultMatchers.jsonPath("$.surname").exists())

		;


	}

	@Test
	public void testUpdatePersonel() throws Exception{

		PersonelDO personelDO= new PersonelDO();
		personelDO.setId(9L);
		personelDO.setName("Siyah");
		personelDO.setSurname("Beyaz");
		DepartmanDO departmanDO=new DepartmanDO();
		departmanDO.setId(7L);
		departmanDO.setDepartmanadi("Endüstri Mühendisliği");

		personelDO.setDepartman(departmanDO);

		mockMvc.perform(MockMvcRequestBuilders.put("/api/is/personel")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(personelDO)))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
				//.andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.surname").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(9L))

		;

	}

	@Test
	public void testDeletePersonel() throws Exception{
		String personelId="9";
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/is/personels/{personelId}",personelId)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()

	);

	}
	@Test
	public void testgetAllis() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/is/isler")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void testgetIsById() throws Exception{
		String isId="5";
		mockMvc.perform(MockMvcRequestBuilders.get("/api/is/personel/isler/{isId}", isId)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.isadi ").exists())
		;

	}

	@Test
	public void testCreateIs() throws Exception{
		isDO isdo=new isDO();

		isdo.setIsadi("muhasebe");

		PersonelDO personelDO=new PersonelDO();

		personelDO.setId(5L);
		personelDO.setName(personelDO.getName());
		personelDO.setSurname(personelDO.getSurname());


		isdo.setPersonel(personelDO);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/is/personel/{id}/isler",5L)
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(isdo)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
				//.andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.isadi").exists())

		;

	}

	@Test
	public void testUpdateIs() throws Exception{

		isDO isdo=new isDO();
		isdo.setId(7L);

		isdo.setIsadi("Mobil Uygulama");

		PersonelDO personelDO=new PersonelDO();

		personelDO.setId(5L);
		personelDO.setName(personelDO.getName());
		personelDO.setSurname(personelDO.getSurname());


		isdo.setPersonel(personelDO);

		mockMvc.perform(MockMvcRequestBuilders.put("/api/is/personel/isler/{isId}",7L)
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(isdo)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
				//.andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.isadi").exists())

		;

	}
	@Test
	public void testdeleteIs() throws  Exception{
		String isId="9";
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/is/personel/isler/{isId}",isId)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}




	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}




}
