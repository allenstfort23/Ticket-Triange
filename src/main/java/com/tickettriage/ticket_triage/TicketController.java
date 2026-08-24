package com.tickettriage.ticket_triage;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;


@RestController
@RequestMapping("/tickets")
public class TicketController {

    @PostMapping
    public ResponseEntity<Map<String, String>> receive(@RequestBody TicketRequest request) {
        System.out.println("Received: " + request);
        return ResponseEntity.accepted().body(Map.of("status", "accepted"));
    }
}
