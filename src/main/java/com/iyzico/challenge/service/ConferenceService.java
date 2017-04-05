package com.iyzico.challenge.service;

import java.util.Date;
import java.util.List;

import com.iyzico.challenge.entity.Conference;

/**
 * @author alican
 * @created at 04-04-2017
 * */

public interface ConferenceService {

	List<Conference> findByConferenceTitle(String title);

	List<Conference> findByConferenceDateBetween(Date start, Date end);

}
