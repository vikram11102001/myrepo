package com.springexample.controller;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Scope("prototype")

public class DashboardController {
	@GetMapping("/blockrequest2")
	 public ResponseEntity < ? > getSimpeResponse() throws InterruptedException {

	  Thread.sleep(3000);
	  return ResponseEntity.ok("OK");
	 }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}



