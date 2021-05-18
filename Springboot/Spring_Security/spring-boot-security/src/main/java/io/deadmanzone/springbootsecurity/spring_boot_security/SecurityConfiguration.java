package io.deadmanzone.springbootsecurity.spring_boot_security;

import javax.sql.DataSource;

import io.deadmanzone.springbootsecurity.spring_boot_security.jwt.service.MyJWTUserDetailsService;
import io.deadmanzone.springbootsecurity.spring_boot_security.jwt.util.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.encoding.LdapShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

//	@Autowired
//	DataSource dataSource;

//	@Autowired
//	MyUserDetailsService myUserDetailsService;

	@Autowired
	private MyJWTUserDetailsService myJWTUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub

		//		TODO This is for HardCoded Username $ Password authentication

//		auth.inMemoryAuthentication()
//		.withUser("root")
//		.password("root")
//		.roles("USER")
//		.and()
//		.withUser("toor")
//		.password("toor")
//		.roles("ADMIN");

//		auth.jdbcAuthentication()
//		.dataSource(dataSource)
//		.withDefaultSchema()
//		.withUser(
//				User.withUsername("user")
//				.password("pass")
//				.roles("USER")
//		)
//		.withUser(
//				User.withUsername("admin")
//				.password("pass")
//				.roles("ADMIN")
//		);

		//		TODO This is for h2 authentication

//		auth.jdbcAuthentication()
//		.dataSource(dataSource);

//		auth.userDetailsService(userDetailsService);

		//		TODO This is for LDAP authentication

//		auth.ldapAuthentication()
//				.userDnPatterns("uid={0},ou=people")
//				.groupSearchBase("ou=groups")
//				.contextSource()
//				.url("ldap://localhost:8399/dc=springframework,dc=org")
//				.and()
//				.passwordCompare()
//				.passwordEncoder(new LdapShaPasswordEncoder())
//				.passwordAttribute("userPassword");

		//		TODO This is for JWT authentication

		auth.userDetailsService(myJWTUserDetailsService);


	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub

//		http.authorizeRequests()
//		.antMatchers("/admin").hasAnyRole("ADMIN")
//		.antMatchers("/user").hasAnyRole("ADMIN","USER")
//		.antMatchers("/").permitAll()
//		.and().formLogin();

//		TODO This is for LDAP authorization

//		http
//				.authorizeRequests()
//				.anyRequest().fullyAuthenticated()
//				.and()
//				.formLogin();

//		TODO This is for jwt authorization
		http.
				csrf().disable()
				.authorizeRequests().antMatchers("/authenticate").permitAll()
				.anyRequest().authenticated()
				.and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
