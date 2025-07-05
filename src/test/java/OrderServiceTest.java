import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class OrderServiceTest {

    @Test
    public void testGetOrderById() {
        RestAssured.baseURI = "http://host.docker.internal:8090";

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/order/1235")
                .then()
                .statusCode(200) // expect success
                .body("orderId", equalTo(1235))  ;// check specific fields if applicable
    }
}

