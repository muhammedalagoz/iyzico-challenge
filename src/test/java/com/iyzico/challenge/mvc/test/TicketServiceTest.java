package com.iyzico.challenge.mvc.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.iyzico.challenge.entity.Ticket;
import com.iyzico.challenge.repository.TicketRepository;
import com.iyzico.challenge.service.impl.TicketServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TicketServiceTest {

	@Mock
	private TicketRepository ticketRepository;

	@InjectMocks
	private TicketServiceImpl ticketService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void findAllTickets() {
		List<Ticket> ticketList = new ArrayList<Ticket>();
		ticketList.add(new Ticket());
		ticketList.add(new Ticket());
		ticketList.add(new Ticket());
		when(ticketRepository.findAll()).thenReturn(ticketList);

		List<Ticket> result = ticketService.findAll();
		assertEquals(3, result.size());
	}

}
