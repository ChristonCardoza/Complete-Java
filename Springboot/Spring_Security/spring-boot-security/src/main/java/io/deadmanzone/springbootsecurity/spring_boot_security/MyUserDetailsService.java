package io.deadmanzone.springbootsecurity.spring_boot_security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.deadmanzone.springbootsecurity.spring_boot_security.models.MyUserDetails;
import io.deadmanzone.springbootsecurity.spring_boot_security.models.User;
import io.deadmanzone.springbootsecurity.spring_boot_security.models.UserRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
//		return new MyUserDetails(username);
		
		Optional<User> user = userRepository.findByUserNmae(username);
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not Found: "+ username));
		
		return user.map(MyUserDetails::new).get();
	}

}
   