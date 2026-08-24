# Ticket Triage Service

A backend service that takes in support tickets, uses an LLM to classify them (urgency, category, sentiment), and routes them accordingly. Built with Java and Spring Boot.

The interesting part isn't the API call to the model — it's what happens around it. LLMs return malformed output, time out, and cost money per call, so this treats the model like any other unreliable dependency: validated output, retries, fallbacks, and a real accuracy number instead of a vibe.

**Status:** actively building this. Checklist below is honest about what's done vs. planned.

## What's working

- [x] `GET /health`
- [x] `POST /tickets` — accepts a ticket, returns `202 Accepted`
- [ ] Postgres persistence + idempotent ticket handling
- [ ] Queue + async worker (Redis)
- [ ] LLM classification with schema validation and retry-on-malformed-output
- [ ] Retries with backoff, dead-letter queue, replay endpoint
- [ ] Eval set — accuracy measured against hand-labeled tickets
- [ ] CI + deployment

## Stack

Java 21, Spring Boot, Maven · Postgres + Redis (planned) · Anthropic/OpenAI API · Fly.io (planned)

## Running it

```bash
git clone https://github.com/allenstfort23/Ticket-Triage.git
cd Ticket-Triage
./mvnw spring-boot:run
```

```bash
curl -X POST localhost:8080/tickets \
  -H "Content-Type: application/json" \
  -d '{"externalId":"t-1","subject":"Cannot log in","body":"Locked out since Friday"}'
```

## Notes on decisions

- Ticket submission returns `202`, not `200` — the request is accepted, not yet processed. Matters once a webhook sender is retrying based on status codes.
- (More added here as each piece gets built.)
