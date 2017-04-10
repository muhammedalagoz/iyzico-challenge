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
	public void testGetAllToDo() {
		List<Ticket> ticketList = new ArrayList<Ticket>();
		ticketList.add(new Ticket());
		ticketList.add(new Ticket());
		ticketList.add(new Ticket());
		when(ticketRepository.findAll()).thenReturn(ticketList);

		List<Ticket> result = ticketService.findAll();
		assertEquals(3, result.size());
	}
	// @Test
	// public void testGetToDoById() {
	// ToDo toDo = new ToDo(1, "Todo Sample 1", true);
	// when(toDoRepository.findOne(1L)).thenReturn(toDo);
	// ToDo result = toDoService.getToDoById(1);
	// assertEquals(1, result.getId());
	// assertEquals("Todo Sample 1", result.getText());
	// assertEquals(true, result.isCompleted());
	// }
	//
	// @Test
	// public void saveToDo() {
	// ToDo toDo = new ToDo(8, "Todo Sample 8", true);
	// when(toDoRepository.save(toDo)).thenReturn(toDo);
	// ToDo result = toDoService.saveToDo(toDo);
	// assertEquals(8, result.getId());
	// assertEquals("Todo Sample 8", result.getText());
	// assertEquals(true, result.isCompleted());
	// }
	//
	// @Test
	// public void removeToDo() {
	// ToDo toDo = new ToDo(8, "Todo Sample 8", true);
	// toDoService.removeToDo(toDo);
	// verify(toDoRepository, times(1)).delete(toDo);
	// }

}
