package com.iyzico.challenge.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.iyzico.challenge.entity.Conference;
import com.iyzico.challenge.repository.ConferenceRepository;
import com.iyzico.challenge.service.ConferenceService;

/**
 * @author alican
 * @created at 04-04-2017
 * */
public class ConferenceServiceImpl implements ConferenceService {

	@Autowired
	ConferenceRepository conferenceRepository;

	@Override
	public List<Conference> findByConferenceTitle(String title) {
		return conferenceRepository.findByConferenceTitle(title);
	}

	@Override
	public List<Conference> findByConferenceDateBetween(Date start, Date end) {
		return conferenceRepository.findByConferenceDateBetween(start, end);
	}

}
