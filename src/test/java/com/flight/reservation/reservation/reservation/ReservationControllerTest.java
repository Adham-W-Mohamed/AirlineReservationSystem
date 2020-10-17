//
//package com.flight.reservation.reservation.reservation;
//
//import com.flight.reservation.reservation.controller.ReservationController;
//import com.flight.reservation.reservation.domain.Reservation;
//import com.flight.reservation.reservation.service.ReservationService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.hamcrest.Matchers.hasSize;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(ReservationController.class)
////public class ReservationControllerTest {
////
////    @MockBean
////    private ReservationService reservationService;
////
////    @Autowired
////    private MockMvc mockMvc;
////
////    @Test
////    public void testGetAllReservations() throws Exception {
////        Reservation reservation = new Reservation();
////        reservation.setCode("cs544A");
////        
////        List<Reservation> reservations = new ArrayList<>();
////        reservations.add(reservation);
////
////        when(reservationService.findAll()).thenReturn(reservations);
////
////        mockMvc.perform(get("/reservations"))
////                .andExpect(status().isOk())
////                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
////                .andExpect(jsonPath("$", hasSize(1)))
////                .andExpect(jsonPath("$[0].code").value(reservation.getCode()));
////    }
//}
