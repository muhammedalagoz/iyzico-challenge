package com.iyzico.challenge.service;

import java.util.List;

import com.iyzico.challenge.entity.Speaker;

/**
 * @author alican
 * @created at 04-04-2017
 * */

public interface SpeakerService {

	List<Speaker> findAll();

	List<Speaker> findByFirstName(String firstName);

	List<Speaker> findBySubject(String subject);

}
