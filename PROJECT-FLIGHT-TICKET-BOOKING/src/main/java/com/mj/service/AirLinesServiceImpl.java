package com.mj.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.model.Passenger;
import com.mj.model.Ticket;
import com.mj.repository.IPassengerRepository;
import com.mj.repository.ITicketRepository;

@Service("AirLinesService")
public class AirLinesServiceImpl implements IAirLinesService {
	
	//Passenger Repository
	@Autowired
	IPassengerRepository pRepo;
	
	//Ticket Repository
	@Autowired
	ITicketRepository tRepo;

	
	
//=================Ticket Booking ===========
	@Override
	public Ticket bookTicket(Passenger p) 
	{
		
		if(p!=null)
		{
			 
			Passenger ps = pRepo.save(p); // save the Passenger first
			
			
			Integer randomNo= (int) (Math.random()*10000); // Generate Ticket Number 
				
	//Create and set the Ticket details from the Passenger 
			Ticket t= new Ticket();
			t.setTicket_No(randomNo);
			t.setName(ps.getName());
			t.setAge(ps.getAge());
			t.setGender(ps.getGender());
			t.setMobileNo(ps.getMobileNo());
			t.setSource(ps.getSource());
			t.setDestination(ps.getDestination());
			t.setFlight_Name(ps.getFlight_Name());
			t.setFlight_Date(ps.getFlight_Date());
			t.setLd(LocalDate.now());// Set the Current Date
			
			//save the Ticket
			Ticket tic= tRepo.save(t);
			
			//Return the Saved Object
			return tic;
			
			
		}
			
		
		//if Details are Invalid
		else
		{
			throw new IllegalArgumentException("Invalid Details");
			
		}
		
		
		
		
	}

//===============View the Ticket=============================
	@Override
	public Ticket checkTicket(Integer ticketNo) {
		
		if(ticketNo !=null)
		{
			Optional<Ticket> getTicket=tRepo.findById(ticketNo);
			if(getTicket.isPresent())
			{
				return getTicket.get() ; // Return Ticket if found
			}
			//if Ticket number is not found, throw an Exception
			else
			{
				 throw new IllegalArgumentException("Flight Ticket " + ticketNo + " not found. Cancellation failed.");
			}
		}
		//if Ticket number is null
		else
		{
			 throw new IllegalArgumentException("Ticket number cannot be null.");
		}
		
			
		}
		
	
	
	//===============Cancel the Ticket=============================
	@Override
	public String cancelTicket(Integer ticketNo) {
		
		Optional<Ticket> getTicket=tRepo.findById(ticketNo);
		
		//Check the Ticket is Available or not
		if(getTicket.isPresent())
		{
			
			tRepo.deleteById(ticketNo); // Delete the Ticket
			return "Flight Ticket " + ticketNo + " has been successfully cancelled.";
			
		}
		
		//if Ticket number is not found
		
		return "Flight Ticket " + ticketNo + " not found. Cancellation failed." ;
		
	}

}
