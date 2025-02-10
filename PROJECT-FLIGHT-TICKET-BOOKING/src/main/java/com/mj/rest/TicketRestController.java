package com.mj.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mj.model.Passenger;
import com.mj.model.Ticket;
import com.mj.service.AirLinesServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/AirLines-Ticket")
@Tag(name="INDIAN AIRLINES", description = "TICKET BOOKING")
public class TicketRestController 
{
	@Autowired
	 private AirLinesServiceImpl tService;
	
	
	
	
		 
	//Booking the Flight Ticket
	@Operation(summary = "Book the Ticket's" ,description = "Here")
	  @PostMapping("/Book_Ticket") 
	  public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger pr) 
	  {
	  
	  Ticket tBook=tService.bookTicket(pr);
	  
	  
	  
	  return new ResponseEntity<Ticket>(tBook,HttpStatus.OK);
	  
	  }
	
	  
	//Check the Flight Ticket 
	@Operation(summary="Check the Ticket", description="Here")
	  @GetMapping("getTicket/{Ticket_No}")
	  
	  public ResponseEntity<Ticket> getTicket(@PathVariable Integer Ticket_No)
	  {
		 
		  Ticket ticket=tService.checkTicket(Ticket_No);
		  
		   return new ResponseEntity<Ticket>(ticket,HttpStatus.ACCEPTED); 
		 
	  }
	  
	
	@Operation(summary="Cancel the Ticket", description="Here")  
	  @DeleteMapping("/Cancellation/{ticketNo}")
	  public ResponseEntity<String> cancleTicket(@PathVariable Integer ticketNo)
	  {
		  String msg= tService.cancelTicket(ticketNo);
		  return new ResponseEntity<String>(msg,HttpStatus.OK);
	  }
	  
	  
	  
	 
	

}
