package com.example.controller;

import com.example.message.ResponseMessage;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.DataInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class TutorialControllerDiffblueTest {
    /**
     * Method under test: {@link TutorialController#uploadFile(MultipartFile)}
     */
    @Test
    void testUploadFile() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   jakarta.servlet.ServletException: Request processing failed: org.springframework.web.multipart.MultipartException: Current request is not a multipart request
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   org.springframework.web.multipart.MultipartException: Current request is not a multipart request
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   See https://diff.blue/R013 to resolve this issue.

        TutorialController tutorialController = new TutorialController();
        String csv = "1,Test Title,Test Description,true";
        MockMultipartFile csvFile = new MockMultipartFile("file", "test.csv", "text/csv", csv.getBytes());
        ResponseEntity<ResponseMessage> actualUploadFileResult = tutorialController.uploadFile(csvFile);
        //  assertEquals("Please upload a csv file!", actualUploadFileResult.getBody().getMessage());
        assertEquals(200, actualUploadFileResult.getStatusCodeValue());
        assertTrue(actualUploadFileResult.hasBody());
        assertTrue(actualUploadFileResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link TutorialController#uploadFile(MultipartFile)}
     */
    @Test
    void testUploadFile2() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   jakarta.servlet.ServletException: Request processing failed: org.springframework.web.multipart.MultipartException: Current request is not a multipart request
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   org.springframework.web.multipart.MultipartException: Current request is not a multipart request
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   See https://diff.blue/R013 to resolve this issue.

        TutorialController tutorialController = new TutorialController();
        DataInputStream contentStream = mock(DataInputStream.class);
        when(contentStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
        doNothing().when(contentStream).close();
        ResponseEntity<ResponseMessage> actualUploadFileResult = tutorialController
                .uploadFile(new MockMultipartFile("Name", contentStream));
        verify(contentStream).close();
        verify(contentStream).readAllBytes();
        assertEquals("Please upload a csv file!", actualUploadFileResult.getBody().getMessage());
        assertEquals(400, actualUploadFileResult.getStatusCodeValue());
        assertTrue(actualUploadFileResult.hasBody());
        assertTrue(actualUploadFileResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link TutorialController#uploadFile(MultipartFile)}
     */
    @Test
    void testUploadFile3() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   jakarta.servlet.ServletException: Request processing failed: org.springframework.web.multipart.MultipartException: Current request is not a multipart request
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   org.springframework.web.multipart.MultipartException: Current request is not a multipart request
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   See https://diff.blue/R013 to resolve this issue.

        TutorialController tutorialController = new TutorialController();
        ResponseEntity<ResponseMessage> actualUploadFileResult = tutorialController
                .uploadFile(new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
        assertEquals("Please upload a csv file!", actualUploadFileResult.getBody().getMessage());
        assertEquals(400, actualUploadFileResult.getStatusCodeValue());
        assertTrue(actualUploadFileResult.hasBody());
        assertTrue(actualUploadFileResult.getHeaders().isEmpty());
    }
}
