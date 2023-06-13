package pt.st.infra.conf;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import pt.ansr.scotplus.backoffice.infra.seguranca.filter.JWTAuthenticationFilter;

import pt.st.infra.security.filter.JWTAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Bean
	public JWTAuthenticationFilter factoryJWTAuthenticationFilter(){
		return new JWTAuthenticationFilter();
	}
	
	@Bean
    public FilterRegistrationBean<JWTAuthenticationFilter> jwtFilter() {
		
        FilterRegistrationBean<JWTAuthenticationFilter> registrationBean = new FilterRegistrationBean<JWTAuthenticationFilter>();
        registrationBean.setFilter(factoryJWTAuthenticationFilter());
        
        return registrationBean;
    }
	
	
	
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests()
				
		   
		    .antMatchers(HttpMethod.POST, "/v1/login").permitAll()
			.anyRequest().authenticated()
					
			
			.and()
			.addFilterBefore(factoryJWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		
		
		httpSecurity.cors();
		//httpSecurity.headers().addHeaderWriter(        new StaticHeadersWriter("Access-Control-Allow-Origin", "*"));
		

		
	}
	
	 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 	
		
		
	//	auth.inMemoryAuthentication()
	//	    .passwordEncoder(NoOpPasswordEncoder.getInstance())
	//		.withUser("gma")
	//		.password("1967")
	//		.roles("ADMIN");
	}
  

}
