# Kafka Patterns Learning Lab

**Disclaimer:** This is a learning/demo repository for Kafka fundamentals.

## Overview
Kafka Patterns Learning Lab is a small Spring Boot project built to help you understand core Kafka ideas through runnable code.
It is intentionally simple and focuses on learning flow, terminology, and behavior instead of production-scale architecture.

## Kafka concepts covered
- **Topic**: A named stream/channel where messages are written.
- **Partition**: A topic is split into partitions so Kafka can scale reads/writes.
- **Offset**: The position number of a message inside a partition.
- **Producer**: The component that sends messages to a topic.
- **Consumer group**: A set of consumers that share work for a topic.
- **Rebalance**: Kafka redistributes partitions among consumers when group membership changes.

## Architecture summary
- REST endpoint receives a JSON payload.
- Service layer forwards payload to Kafka via a producer.
- Message is also stored in an in-memory H2 table for easy inspection.
- Kafka consumer listens to the same topic and logs incoming messages.

## Tech stack
- Java 17+
- Spring Boot 2.7.x
- Spring Kafka
- Spring Web
- Spring Data JPA
- H2 Database (in-memory)
- Gradle

## How to run
### 1) Start Kafka locally
You can use Docker, local binaries, or any local Kafka setup. Ensure Kafka is reachable at `localhost:9092`.

### 2) Start the application
From the project root:

```bash
./gradlew bootRun
```

On Windows PowerShell:

```powershell
.\gradlew.bat bootRun
```

### 3) Send a test message

```bash
curl -X POST http://localhost:8080/kafka/send \
	-H "Content-Type: application/json" \
	-d '{"data":"hello kafka"}'
```

PowerShell example:

```powershell
Invoke-RestMethod -Method Post -Uri "http://localhost:8080/kafka/send" -ContentType "application/json" -Body '{"data":"hello kafka"}'
```

## View Javadocs
Generate API docs from source comments:

```bash
./gradlew javadoc
```

On Windows PowerShell:

```powershell
.\gradlew.bat javadoc
```

Open `build/docs/javadoc/index.html` in your browser to browse class and method documentation.

## Example message flow
1. You POST `{ "data": "hello kafka" }` to `/kafka/send`.
2. The controller calls the service.
3. The service publishes the message to topic `companies`.
4. The same payload is saved to H2 for learning visibility.
5. Consumer group `group_id` reads from the topic and logs message + metadata.

## Key learning points
- Producer and consumer can run independently using Kafka as the transport layer.
- Offsets are tracked per partition and per consumer group.
- Rebalance events can move partition ownership between consumers.
- Serialization matters: producer/consumer payload types must match.
- Local experiments are easiest with small payloads and clear logs.

## Limitations
- Not production-hardened (no retries, no dead-letter topic, limited error handling).
- Single-topic, single-use-case sample for clarity.
- In-memory H2 storage is temporary.
- Security, monitoring, and scaling concerns are intentionally out of scope.

## License
This project is released under the MIT License and is free to use for learning purposes.
