package io.deadmanzone.springbootsecurity.spring_boot_security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

	@GetMapping("/")
	public String home() {
		return("<h1>Welome To Hell</h1>");
	}
	
	@GetMapping("/user")
	public String user() {
		return("<h1>Welome User</h1>");
	}
	
	@GetMapping("/admin")
	public String admin() {
		return("<h1>Welome Admin</h1>");
	}
}
