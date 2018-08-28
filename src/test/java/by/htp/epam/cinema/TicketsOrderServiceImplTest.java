package by.htp.epam.cinema;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import by.htp.epam.cinema.domain.TicketsOrder;
import by.htp.epam.cinema.domain.User;
import by.htp.epam.cinema.service.TicketsOrderService;
import by.htp.epam.cinema.service.impl.TicketsOrderServiceImpl;

public class TicketsOrderServiceImplTest {

	private TicketsOrderService ticketsOrderService;
	private User user;

	@Before
	public void initGenreService() {
		ticketsOrderService = Mockito.mock(TicketsOrderServiceImpl.class);
		user = User.newBuilder().setId(1).build();
		Mockito.when(ticketsOrderService.readUserNonPaidOrder(user)).thenReturn(
				TicketsOrder.newBuilder().setId(1).setOrderNumber(776170).setIsPaid(false).setUser_id(2).build());
		Mockito.when(ticketsOrderService.createTicketsOrder(user)).thenReturn(
				TicketsOrder.newBuilder().setId(2).setOrderNumber(745287).setIsPaid(false).setUser_id(1).build());
	}

	@Test
	public void readUserNonPaidOrderTest() {
		TicketsOrder ticketsOrder = ticketsOrderService.readUserNonPaidOrder(user);
		Assert.assertEquals(false, ticketsOrder.getIsPaid());
	}

	@Test
	public void createTicketsOrderTest() {
		TicketsOrder ticketsOrder = ticketsOrderService.createTicketsOrder(user);
		Assert.assertEquals(745287, ticketsOrder.getOrderNumber());
	}

	@Test
	public void deleteNonPaidOrderTest() {
		ticketsOrderService.deleteNonPaidOrder(user);
		Mockito.verify(ticketsOrderService, Mockito.times(1)).deleteNonPaidOrder(Mockito.any(User.class));
	}

	@Test
	public void payOrderTest() {
		TicketsOrder ticketsOrder = ticketsOrderService.readUserNonPaidOrder(user);
		ticketsOrderService.payOrder(ticketsOrder.getId());
		Mockito.verify(ticketsOrderService).readUserNonPaidOrder(Mockito.any(User.class));
		Mockito.verify(ticketsOrderService).payOrder(Mockito.anyInt());
	}
}
