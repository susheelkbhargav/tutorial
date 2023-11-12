package com.example.controller;

import com.example.exception.InvalidPageException;
import com.example.helper.CSVHelper;
import com.example.message.ResponseMessage;
import com.example.model.Tutorial;
import com.example.repository.TutorialRepository;
import com.example.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
public class TutorialController {

    @Autowired
    TutorialService tutorialService;

    @Autowired
    TutorialRepository tutorialRepository;

    public static final int SIZE = 2;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (CSVHelper.hasCSVFormat(file)) {
            try {
                tutorialService.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                System.out.println(e);
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

//	@PostMapping("/uploadWithFile")
//	public ResponseEntity<ResponseMessage> uploadFileFromResources() {
//		String message = "";
//		ClassLoader classLoader = getClass().getClassLoader();
//		File file = new File(classLoader.getResource("tutorialData.csv").getFile());
//
//		MultipartFile result = new MultipartFile
//
//		if (CSVHelper.hasCSVFormat(file)) {
//			try {
//				tutorialService.save(file);
//
//				message = "Uploaded the file successfully: " + file.getOriginalFilename();
//				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
//			} catch (Exception e) {
//				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
//				System.out.println(e);
//				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
//			}
//		}
//
//		message = "Please upload a csv file!";
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
//	}

    @GetMapping("/getByPage")
    public ResponseEntity<Page<Tutorial>> getAllTutorialsWithPagination(@RequestParam(value = "page") int page) {
        Pageable pageable = PageRequest.of(page, SIZE);
        Page<Tutorial> tutorialsPage = tutorialRepository.findAll(pageable);
        return ResponseEntity.ok().body(tutorialsPage);

    }

    @GetMapping("/getByPageNoParam")
    public Page<Tutorial> getAllTutorialsWithPagination1(@RequestParam Optional<Integer> page) {

        int pageNumber = page.orElseGet(() -> 0);
        Pageable pageable = PageRequest.of(pageNumber, SIZE);
        Page<Tutorial> tutorialsPage = tutorialRepository.findAll(pageable);

        return tutorialsPage;

    }

    @GetMapping("/getByPageException")
    public ResponseEntity<Page<Tutorial>> getAllTutorialsWithPagination2(@RequestParam Optional<Integer> page) {

        int pageNumber = page.orElseGet(() -> 0);
        Pageable pageable = PageRequest.of(pageNumber, SIZE);

        Page<Tutorial> tutorialsPage = tutorialRepository.findAll(pageable);
        int maxPages = tutorialsPage.getTotalPages();
        if (pageNumber > maxPages)
            throw new InvalidPageException(pageNumber, maxPages);

        return ResponseEntity.ok().body(tutorialsPage);

    }

    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getAllTutorials() {
        try {
            List<Tutorial> tutorials = tutorialService.getAllTutorials();

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}