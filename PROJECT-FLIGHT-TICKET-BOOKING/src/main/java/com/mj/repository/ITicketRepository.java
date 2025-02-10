package com.mj.repository;

import org.springframework.data.repository.CrudRepository;

import com.mj.model.Ticket;

public interface ITicketRepository extends CrudRepository<Ticket, Integer> {

}
