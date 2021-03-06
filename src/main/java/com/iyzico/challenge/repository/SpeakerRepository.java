package com.iyzico.challenge.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iyzico.challenge.entity.Speaker;

/**
 * @author alican
 * @created at 04-04-2017
 * */

@Repository
@Transactional
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

	Optional<List<Speaker>> findByFirstName(String firstName);

	Optional<List<Speaker>> findBySubject(String subject);

}
