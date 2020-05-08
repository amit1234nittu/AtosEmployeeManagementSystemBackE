package net.guides.springboot2.crud.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import net.guides.springboot2.crud.Controller.EmployeeController;
import net.guides.springboot2.crud.Model.Employee;
import net.guides.springboot2.crud.Service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class, secure = false)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService employeeService;
	
	Employee mockCourse = new Employee(3, "bittu", "nandgave", "amit@gmail.com");

	String exampleCourseJson = "";

	@Test
	public void retrieveDetailsForCourse() throws Exception {

		Mockito.when(employeeService.getEmployeeById(Mockito.anyLong())).thenReturn(mockCourse);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/v1/employee/3").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		
		String expected = "{id:3,first_name:bittu,last_name:nandgave,email_address:amit@gmail.com}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

}
