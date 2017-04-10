package com.iyzico.challenge.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyzico.challenge.entity.Speaker;
import com.iyzico.challenge.repository.SpeakerRepository;
import com.iyzico.challenge.service.SpeakerService;

/**
 * @author alican
 * @created at 04-04-2017
 * */

@Service
public class SpeakerServiceImpl implements SpeakerService {

	@Autowired
	SpeakerRepository speakerRepository;

	@Override
	public Optional<List<Speaker>> findByFirstName(String firstName) {
		return this.speakerRepository.findByFirstName(firstName);
	}

	@Override
	public Optional<List<Speaker>> findBySubject(String subject) {
		return this.speakerRepository.findBySubject(subject);
	}

	@Override
	public List<Speaker> findAll() {
		return this.speakerRepository.findAll();
	}

}
