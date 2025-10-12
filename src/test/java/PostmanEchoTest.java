import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
    void shouldReturnSentData() {
        RestAssured.baseURI = "https://postman-echo.com";
// Given - When - Then
// Предусловия
        given()
                .contentType("text/plain; charset=UTF-8")
                .body("some data")
// отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("current data"));
    }
}