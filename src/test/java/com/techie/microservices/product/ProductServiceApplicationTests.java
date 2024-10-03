package com.techie.microservices.product;

import io.restassured.RestAssured;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {
	@ServiceConnection
    static MongoDBContainer mongoDBContainer= new MongoDBContainer("mongo:7.0.5");
	@LocalServerPort
	private Integer port;
	@BeforeEach
	void setup(){
		RestAssured.baseURI="http://localhost";
		RestAssured.port=port;


	}
	static {
		mongoDBContainer.start();
	}
	@Test
	void shouldCreateProduct() {
		String requestBody= """
				{
				        "name": "Habtamu15",
				        "description": "coder",
				        "price": 30100
				}
				""";
		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.then()
				.statusCode(201)
				.body("id", Matchers.notNullValue())
				.body("name",Matchers.equalTo("Habtamu15"))
				.body("description",Matchers.equalTo("coder"))
				.body("price",Matchers.equalTo(30100));

	}

}
