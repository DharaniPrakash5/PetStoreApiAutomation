package api.endpoints;

/*
 * Create user-https://petstore3.swagger.io/api/v3/user
 * Get user-https://petstore3.swagger.io/api/v3/user/{username}
 * update user-https://petstore3.swagger.io/api/v3/user/{username}
 * delete user-https://petstore3.swagger.io/api/v3/user/{username}
 
 */

//here we have all uri
public class routes {
	
	public static String base_url="https://petstore3.swagger.io/api/v3";
	
	public static String  post_url=base_url+"/user";
	public static String  get_url=base_url+"/user/{username}";
	public static String  put_url=base_url+"/user/{username}";
	public static String  delete_url=base_url+"/user/{username}";
}
