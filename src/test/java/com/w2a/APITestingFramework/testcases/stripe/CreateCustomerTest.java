package com.w2a.APITestingFramework.testcases.stripe;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static io.restassured.RestAssured.given;

import java.util.Hashtable;

//import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.w2a.APITestingFramework.APIs.stripe.CreateCustomerAPI;

import com.w2a.APITestingFramework.listeners.ExtentListeners;

import com.w2a.APITestingFramework.setUp.BaseTest;
import com.w2a.APITestingFramework.utilities.DataUtil;

import io.restassured.response.Response;

public class CreateCustomerTest extends BaseTest  {

	/*
	@Test
	public void validateCreateCustomerAPIWithValidSecretKey() {

		Response response = given().auth().basic("sk_test_51HQU3cExTlHjvtDdlzlZ3VQ83nypuLA8q7KHfSu1Np2zJSa8xsJsbEw4hhYzSKnkQ0ovAW25n5P7RG1cVoJ0THgJ00ykUtoVDy", "")
				.formParam("email", "sangramthorat9689@gmail.com").formParam("description", "this is the test api customer")
				.post("https://api.stripe.com/v1/customers");
	//	ExtentListeners.testReport.get().info(data.toString());
		///ExtentListeners.testReport.get().log(Status.INFO, data.toString());	
		response.prettyPrint();

		System.out.println(response.statusCode());

		Assert.assertEquals(response.statusCode(), 200);

	}
	*/
	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void validateCreateCustomerAPIWithValidSecretKey(Hashtable<String, String> data) {

		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithValidAuthKey(data);
		ExtentListeners.testReport.get().info(data.toString());
		ExtentListeners.testReport.get().log(Status.INFO, data.toString());	
		response.prettyPrint();

		System.out.println(response.statusCode());

		AssertJUnit.assertEquals(response.statusCode(), 200);

	}

	/*
	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void validateCreateCustomerAPIWithInValidSecretKey(Hashtable<String, String> data) {

		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithInValidAuthKey(data);
		ExtentListeners.testReport.get().info(data.toString());
		response.prettyPrint();

		System.out.println(response.statusCode());

		Assert.assertEquals(response.statusCode(), 200);

	}
	
	*/

}
