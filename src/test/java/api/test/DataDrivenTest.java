package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utils.Dataprovider;
import io.restassured.response.Response;

public class DataDrivenTest {
	//here dataprovider is in different pacakage so  we put dataProviderClass=Dataprovider.class
	@Test(priority=1, dataProvider="Data", dataProviderClass=Dataprovider.class)
	public void testPostUser(String userID, String username, String firstname, String lastname,String email, String psw, String phn ) {
		
		User userPayload=new User();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(username);
		userPayload.setFirstName(firstname);
		userPayload.setLastName(lastname);
		userPayload.setEmail(email);
		userPayload.setPassword(psw);
		userPayload.setPhone(phn);
		
       Response response=UserEndpoints.createUser(userPayload);	
	    Assert.assertEquals(response.getStatusCode(), 500);

	}
	
	
	@Test(priority=2, dataProvider="UserNames", dataProviderClass=Dataprovider.class)
	public void testDeleteUser(String userName) {
		
		Response response=UserEndpoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(),500);
		
	}
	
	
		
	}


