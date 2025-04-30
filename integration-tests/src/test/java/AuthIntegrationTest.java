import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class AuthIntegrationTest {
    @BeforeAll
    static void setUp(){
        RestAssured.baseURI = "http://localhost:4004/";

    }

    @Test
    public void shouldReturnTokenOKWithValidationToken(){

        String loginPayload= """
                {
                "email" : "testuser@test.com",
                "password" : "password123"
                }
                
                """;
        Response response=given()
                .contentType(ContentType.JSON)
                .body(loginPayload)
                .when()
                .post("auth/login")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("token",notNullValue())
                .extract()
                .response();
        System.out.println(response +" Generated Token "+ response.jsonPath().getString("token"));




    }
}
