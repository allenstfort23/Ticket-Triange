package com.tickettriage.ticket_triage;

import com.tickettriage.ticket_triage.ticket.Ticket;
import com.tickettriage.ticket_triage.ticket.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private  final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void submit(TicketRequest request) {
        Ticket ticket = new Ticket(
                request.externalId(),
                request.subject(),
                request.body()
        );

        ticketRepository.save(ticket);
    }
}
