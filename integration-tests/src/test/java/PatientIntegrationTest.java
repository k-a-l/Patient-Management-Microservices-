import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;


public class PatientIntegrationTest {
    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI="http://localhost:4004";

    }
//String InsertionplayLoad= """
//        {
//            "id": "2f831bbe-440a-49e4-9076-9958b694d929",
//            "name": "Kafka Test 2",
//            "email": "kafka2@gmail.com",
//            "address": "123 Main St",
//            "dateOfBirth": "1987-10-17T00:00"
//          }
//        """;
    String loginPayLoad= """
            {
            "email": "testuser@test.com",
            "password": "password123"
            }
            """;
    @Test
    public void shouldReturnValidToken(){
        String token= given()
                .contentType(ContentType.JSON)
                .body(loginPayLoad)
                .when()
                .post("/auth/login")
                .then()
                .extract()
                .jsonPath().getString("token");

        given().
                header("Authorization","Bearer "+token)
                .when()
                .get("/api/patients")
                .then()
                .statusCode(200)
                .body("patients",notNullValue());


    }
    public void shouldReturnValidTokenforInsertion(){
        String token= given()
                .contentType(ContentType.JSON)
                .body(loginPayLoad)
                .when()
                .post("/auth/login")
                .then()
                .extract()
                .jsonPath().getString("token");

        given().
                header("Authorization","Bearer "+token)
                .when()
                .post("/api/patients/add")
                .then()
                .statusCode(200)
                .body("patients",notNullValue());


    }


}
