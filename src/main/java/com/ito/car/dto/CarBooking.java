package com.ito.car.dto;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "car_booking")
public class CarBooking {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	@Column
	private String personName;
	
	@Column
	private long contactNumber;
	
	@Column
	private String email;
	
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "bookingId")
	private List<Car> carDetails;
	
	public List<Car> getCarDetails() {
		return carDetails;
	}
	public void setCarDetails(List<Car> carDetails) {
		this.carDetails = carDetails;
	}
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}

