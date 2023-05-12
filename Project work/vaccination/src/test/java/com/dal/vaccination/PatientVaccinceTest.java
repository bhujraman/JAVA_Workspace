package com.dal.vaccination;
	import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
	import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
    import org.aspectj.lang.annotation.Before;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
	import org.springframework.test.web.servlet.setup.MockMvcBuilders;
	import org.springframework.web.context.WebApplicationContext;

import com.dal.vaccination.controller.PatientController;
import com.dal.vaccination.entity.Patient;
import com.dal.vaccination.repo.PatientRepo;
import com.dal.vaccination.service.PatientService;

	@SpringBootTest
	public class PatientVaccinceTest extends PatientVaccineTests {

		@Autowired
		private WebApplicationContext webApplicationContext;

		private MockMvc mockMvc;
		
		 	@Mock
		    private PatientRepo patientRepo;

		    @Mock
		    private PatientService patientService;

		    @InjectMocks
		    private PatientController patientController;

		@BeforeEach
		public void setup() {
			mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		}

	
		
		 @Test
		    public void testHelloWelcome() {
		        String result = patientController.helloWorld();
		        assertEquals("Hello Welcome to our Team5 Baby Vaccination System ", result);
		    }

		   



	}


