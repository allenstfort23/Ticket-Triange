package com.tickettriage.ticket_triage;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TicketRequest(
        @NotBlank @Size(max = 255) String externalId,
        @NotBlank @Size(max = 255) String subject,
        @NotBlank String body
) {
}