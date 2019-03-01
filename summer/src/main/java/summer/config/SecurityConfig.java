package summer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
		  http
	    	.authorizeRequests() // 요청에 어떻게 보안을 걸것인가
	    		.antMatchers("/login","/join").permitAll() // 모든 접근 허용
	    		.antMatchers("/admin/**").hasRole("ADMIN")
	    		.anyRequest().authenticated() // 그 외 모드접근 인증체크(로그인한 사용자만 볼수있다)
	    		.and()
			.formLogin()
				.loginPage("/login").permitAll()  // 로그인 페이지로 가는 요청
				.and()
			.logout()
				.logoutSuccessUrl("/login")
		        .permitAll()
		        .and()
		  .csrf().disable();
	    // .csrf().disable() .httpBasic(); ??
	  }

	  @Bean
	  public PasswordEncoder passwordEncoder() {
		  return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	  }

	  
//	  @Bean
//	  protected UserDetailsService userDetailsService() {
//		  return super.userDetailsService();
//	  }
//	  
//	  @Override
//	  protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		  auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
//	  }
//	  
//	  public PasswordEncoder passwordEncoder() {
//		  return new BCryptPasswordEncoder();
//	  }
}
