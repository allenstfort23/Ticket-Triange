package com.tickettriage.ticket_triage;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> receive(@Valid @RequestBody TicketRequest request) {
        ticketService.submit(request);
        return ResponseEntity.accepted().body(Map.of("status", "accepted"));
    }
}

