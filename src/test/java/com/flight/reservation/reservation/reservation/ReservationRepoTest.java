package com.flight.reservation.reservation.reservation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.flight.reservation.reservation.domain.Flight;
import com.flight.reservation.reservation.domain.Reservation;
import com.flight.reservation.reservation.domain.ReservationStatus;
import com.flight.reservation.reservation.repo.ReservationRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReservationRepoTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private ReservationRepo reservationRepo;

	private final Reservation testReservation1 = new Reservation();
	private final Reservation testReservation2 = new Reservation();
	
	 private final Reservation testReservation3 = new Reservation(ReservationStatus.CONFIRMED,"VA");

	private final Flight flight1 = new Flight(1, 100);
	private final Flight flight2 = new Flight(2, 200);

	List<Flight> list = Arrays.asList(flight1, flight2);
	List<Flight> list2 = Arrays.asList(flight1);

	@Before
	public void setUp() {

		testReservation2.setCode("cs544A");
		testReservation1.setCode("ea1234");
		testReservation1.setFlights(list);
		testReservation2.setFlights(list2);

		testEntityManager.persist(flight1);
		testEntityManager.persist(flight2);
		testEntityManager.persist(testReservation1);
		testEntityManager.persist(testReservation2);
		 testEntityManager.persist(testReservation3);

		testEntityManager.flush();

	}

	@After
	public void cleanUp() {
		
		testEntityManager.remove(flight1);
		testEntityManager.remove(flight2);
		testEntityManager.remove(testReservation1);
		testEntityManager.remove(testReservation2);
		testEntityManager.remove(testReservation3);

		testEntityManager.flush();

	}

	@Test
	public void testExistsByCode(String code) {

		boolean existsByCode = reservationRepo.existsByCode("cs544A");
		
		assertEquals(true, existsByCode);


	}

	@Test
	public void testFindOneEagerLoadFlights(int id) {

		List<Reservation> reservation1 = Arrays.asList(reservationRepo.findOneEagerLoadFlights(1).get());
		

        assertThat(reservation1, hasItem(hasProperty("flights", is(testReservation1.getFlights()))));


	}
	
	@Test
    public void testGetReservationByDepartureAirport() {

        Page<Reservation> reservations =  reservationRepo.findAllByCreatedByUserPublicIdOrCreatedForUserPublicId(PageRequest.of(0, 10), UUID.randomUUID(), UUID.randomUUID());

        assertThat(reservations, hasItem(hasProperty("name", is(testReservation3.getReservationStatus()))));

    }

}
