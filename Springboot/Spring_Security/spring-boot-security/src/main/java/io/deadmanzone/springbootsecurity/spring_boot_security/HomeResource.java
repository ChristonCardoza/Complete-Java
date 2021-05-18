package io.deadmanzone.springbootsecurity.spring_boot_security;

import io.deadmanzone.springbootsecurity.spring_boot_security.jwt.models.AuthenticationRequest;
import io.deadmanzone.springbootsecurity.spring_boot_security.jwt.models.AuthenticationResponse;
import io.deadmanzone.springbootsecurity.spring_boot_security.jwt.service.MyJWTUserDetailsService;
import io.deadmanzone.springbootsecurity.spring_boot_security.jwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {


	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyJWTUserDetailsService myJWTUserDetailsService;

	@Autowired
	private JwtUtil jwtTokenUtil;

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

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws  Exception{

		try{
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}catch (BadCredentialsException e){
			throw new Exception("Incorrect Username or Password", e);
		}

		final UserDetails userDetails = myJWTUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
