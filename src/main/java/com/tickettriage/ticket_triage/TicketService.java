package com.tickettriage.ticket_triage;

import org.springframework.stereotype.Service;

@Service
public class TicketService {

    public void submit(TicketRequest request) {
        System.out.println("Recieved" + request);
    }
}
