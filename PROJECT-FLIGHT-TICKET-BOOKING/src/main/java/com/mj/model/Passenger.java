package com.mj.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name="INDIAN_AIRLINES_PASSENGER_DETAILS")

public class Passenger 
{
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="SNO")
	private Integer sNo;
	
	@NonNull
	@Column(name="Name")
	private String name;
	
	@NonNull
	@Column(name="Age")
	private Integer age;
	
	@NonNull
	@Column(name="Gender")
	private String gender;
	
	@NonNull
	@Column(name="Mobile_No")
	private Integer mobileNo;
	
	@Column(name="Source")
	@NonNull
	private String source;
	
	@Column(name="Destination")
	@NonNull
	private String destination;
	
	@Column(name="Flight_Name")
	@NonNull
	private String flight_Name;
	
	@Column(name="Flight_Date")
	@NonNull
	private String flight_Date;
	
	

}
