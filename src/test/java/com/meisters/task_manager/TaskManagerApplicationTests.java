package com.meisters.task_manager;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.meisters.task_manager.entity.Tasks;
import com.meisters.task_manager.entity.Tasks.status;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TaskManagerApplicationTests {
	@Autowired
	private WebTestClient webTestClient;


	@Test
	void testCreateSuccess() {
		var tasks = new Tasks("Tests", "test the backend", LocalDate.of(2024,6,25), status.COMPLETED);
		webTestClient.post().uri("/tasks")
		.bodyValue(tasks)
		.exchange()
		.expectStatus().isOk()
		.expectBody()
		.jsonPath("$").isArray()
		.jsonPath("$[0].name").isEqualTo(tasks.getName())
		.jsonPath("$[0].description").isEqualTo(tasks.getDescription())
		.jsonPath("$[0].due_date").isEqualTo(tasks.getDueDate())
		.jsonPath("$[0].status").isEqualTo("COMPLETED");
	}

	@Test
	void contextLoads() {
	}

}
