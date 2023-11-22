import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.ResponsePojo;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ArrayliBodyPojoAssert {
    @Test
    public void Test2() throws JsonProcessingException {
       /*
       RestAssured.baseURI = "https://6d11d5ef-61dc-4c0b-8a8a-32cf76d0f5d2.mock.pstmn.io";
        Response response = given().get("/getInstructor")
                .then().log().all()
                .assertThat().statusCode(200)       // hocanın kodu
                .extract().response();
       */
        //1-Set the url
        String url = "https://6d11d5ef-61dc-4c0b-8a8a-32cf76d0f5d2.mock.pstmn.io/getInstructor";

        //2- no expected Data

        //3- Send the request and get response
        Response response = given().when().get(url);
        String body = response.body().asString();
        ObjectMapper mapper = new ObjectMapper();
        List<ResponsePojo> responseBodyList = mapper.readValue(body, new TypeReference<>() {
        });
        System.out.println(responseBodyList.get(0).getCourses().getMobile().get(2).getCourseTitle());
        Assert.assertEquals("Appium",responseBodyList.get(0).getCourses().getMobile().get(2).getCourseTitle());
    }
}
