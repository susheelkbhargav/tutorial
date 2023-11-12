package com.example.controller;

import com.example.repository.TutorialRepository;
import com.example.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
	@MockBean
	private TutorialService tutorialService;

	@Autowired
	private TutorialRepository tutorialRepository;

	@Autowired
	private MockMvc mvc;

//	@Test
//	public void testUploadFileSuccess() throws Exception {
//		String csv = "1,Test Title,Test Description,true";
//		MockMultipartFile csvFile = new MockMultipartFile("file", "test.csv", "text/csv", csv.getBytes());
//
//		mvc.perform(multipart("/upload").file(csvFile)).andExpect(status().isOk());
//		verify(tutorialService).save(csvFile);
//		mvc.perform(get("/tutorials")).andExpect(status().isOk()).andExpect(jsonPath("$[0].id", is("1")))
////				.andExpect(jsonPath("$[1].title", is("Test Title")));
////		List<Tutorial> tutorials = tutorialRepository.findAll();
////
////		Assertions.assertEquals(1, tutorials.size());
////		Tutorial tutorial = tutorials.get(0);
////		Assertions.assertEquals(1, tutorial.getId());
////		Assertions.assertEquals("Test Title", tutorial.getTitle());
////		Assertions.assertEquals("Test Description", tutorial.getDescription());
////		Assertions.assertTrue(tutorial.isPublished());
//
//	}

}
