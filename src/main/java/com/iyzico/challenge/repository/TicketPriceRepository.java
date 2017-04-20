package com.iyzico.challenge.repository;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iyzico.challenge.entity.TicketPrice;

/**
 * @author alican
 * @created at 04-04-2017
 * */

@Repository
@Transactional
public interface TicketPriceRepository extends JpaRepository<TicketPrice, Long> {

	Optional<TicketPrice> findByType(String ticketType);

	Optional<TicketPrice> findByFromLessThanEqualAndToGreaterThanEqual(Date start, Date end);

}
