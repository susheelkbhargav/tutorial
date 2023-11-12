package com.example.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.helper.CSVHelper;
import com.example.model.Tutorial;
import com.example.repository.TutorialRepository;

@Service
public class TutorialService {
	@Autowired
	TutorialRepository tutorialRepository;

	public void save(MultipartFile file) {
		try {
			List<Tutorial> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
			tutorialRepository.saveAll(tutorials);
		} catch (IOException e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
	}

	public List<Tutorial> getAllTutorials() {
		return tutorialRepository.findAll();
	}

}
