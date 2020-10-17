//package com.flight.reservation.reservation.reservation;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.flight.reservation.reservation.domain.Reservation;
//import com.flight.reservation.reservation.repo.ReservationRepo;
//import com.flight.reservation.reservation.service.ReservationService;
//import com.flight.reservation.reservation.service.impl.ReservationServiceImpl;
//
//@RunWith(SpringRunner.class)
////public class ReservationServiceTest {
////
////    @TestConfiguration
////    static class ReservationServiceTestConfig {
////        @Bean
////        ReservationService testableReservationService() {
////            return new ReservationServiceImpl();
////        }
////    }
////
////    @MockBean
////    private ReservationRepo reservationRepo;
////
////    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
////    @Autowired
////    private ReservationService reservationService;
////
////
////
////    @Test
////    public void testGetReservationByCode() {
////
////        List<Reservation> reservations = new ArrayList<>();
////        
////        Reservation r = new Reservation();
////        r.setCode("cs544A");
////        reservations.add(r);
////
////        when(reservationRepo.existsByCode("cs544A")).thenReturn(true);
////
////        assertEquals(reservationService.getReservationByDepartureAirport("CID"), reservations);
////    }
////
////
//}
