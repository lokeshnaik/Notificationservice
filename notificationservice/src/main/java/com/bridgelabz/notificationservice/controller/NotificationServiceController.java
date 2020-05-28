package com.bridgelabz.notificationservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.bridgelabz.notificationservice.serviceimplementation.NotificationServiceImplementation;
@RestController
public class NotificationServiceController {
	@Autowired
	private NotificationServiceImplementation notificationServiceImplementation;
	@Autowired
	private RestTemplate restTemplate;
	@GetMapping("/notification/regVerification/{email}")
	public String sendVerification(@PathVariable String email)
	{
		System.out.println("coming in notification------------------------------------");
		String subject="verification email";
		String token=restTemplate.exchange("http://localhost:8097/user/gettokenbyemail/"+email,HttpMethod.GET,null,String.class).getBody();
		String body="http://localhost:8097/verify/"+token;
		NotificationServiceImplementation.sendEmail(email,subject,body);
		return "verification mail sent";
	}
	@GetMapping("/notification/resetPwd/{email}/{token}")
	public String sendLinkForForgetPassword(@PathVariable String email,@PathVariable String token)
	{
		String body="http://localhost:8097/user/updatepassword/{token}"+token;
		NotificationServiceImplementation.sendEmail(email,"Update Password",body);
		return "reset password link sent";
	}
}

