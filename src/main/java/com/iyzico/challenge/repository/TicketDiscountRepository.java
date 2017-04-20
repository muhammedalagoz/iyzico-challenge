package com.iyzico.challenge.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iyzico.challenge.entity.TicketDiscount;

@Repository
@Transactional
public interface TicketDiscountRepository extends JpaRepository<TicketDiscount, Long> {
	Optional<TicketDiscount> findByCode(String code);
}
