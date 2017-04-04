package com.iyzico.challenge.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iyzico.challenge.entity.Conference;

/**
 * @author alican
 * @created at 04-04-2017
 * */

@Repository
@Transactional
public interface ConferenceRepository extends JpaRepository<Conference, Long> {

	List<Conference> findByConferenceTitle(String title);

	List<Conference> findByConferenceDateBetween(Date start, Date end);

}
