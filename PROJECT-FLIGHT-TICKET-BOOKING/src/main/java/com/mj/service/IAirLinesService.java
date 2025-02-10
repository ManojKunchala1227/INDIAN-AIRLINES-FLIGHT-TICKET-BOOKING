package com.mj.service;

import com.mj.model.Passenger;
import com.mj.model.Ticket;

public interface IAirLinesService 
{
	public Ticket bookTicket(Passenger p);
	public Ticket checkTicket(Integer ticketNo);
	public String cancelTicket(Integer tickerNo);

}
