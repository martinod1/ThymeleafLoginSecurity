package ie.cit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

//import ie.cit.security.MongoDBAuthenticationProvider;
@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
/*@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
*/public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*@Autowired
	private MongoDBAuthenticationProvider authenticationProvider;
	*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        //.antMatchers("/gallery").hasRole("USER")

		 http
         .authorizeRequests()
             .antMatchers("/", "/home, /registration").permitAll()
             .anyRequest().authenticated()
             .and()
         .formLogin()
             .loginPage("/login")
             .permitAll()
             .and()
             
         .logout()
             .permitAll();
	}

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("pw").roles("USER");
        
      //  auth.authenticationProvider(authenticationProvider);
        
        
    }

}
