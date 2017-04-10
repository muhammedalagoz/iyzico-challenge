package com.iyzico.challenge.service;

import java.util.List;
import java.util.Optional;

import com.iyzico.challenge.entity.Speaker;

/**
 * @author alican
 * @created at 04-04-2017
 * */

public interface SpeakerService {

	List<Speaker> findAll();

	Optional<List<Speaker>> findByFirstName(String firstName);

	Optional<List<Speaker>> findBySubject(String subject);

}
