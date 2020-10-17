package com.flight.reservation.reservation.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Ticket implements Serializable {
	@Id
	@GeneratedValue
	private int id;
	
	
	@Column(length = 20,  insertable = false, columnDefinition = "serial")
	@Generated(GenerationTime.INSERT)
//	@Pattern(message = "Invalid number", regexp = "^[0-9]{20}$")
	private BigInteger number;
	@Column(length = 6)
	@Pattern(message = "Invalid reservationCode", regexp = "^[a-zA-Z0-9]{6}$")
	private String reservationCode;
	@ManyToOne
	@JsonBackReference
	private Flight flight;

	@Type(type="uuid-char")
	private UUID userPublicId;

	@Enumerated(EnumType.STRING)
	ReservationStatus ticketStatus;
	
	
	
	public ReservationStatus getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(ReservationStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public Ticket() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigInteger getNumber() {
		return number;
	}

	public void setNumber(BigInteger number) {
		this.number = number;
	}

	public String getReservationCode() {
		return reservationCode;
	}

	public void setReservationCode(String reservationDate) {
		this.reservationCode = reservationDate;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public UUID getUserPublicId() {
		return userPublicId;
	}

	public void setUserPublicId(UUID user) {
		this.userPublicId = user;
	}
}
