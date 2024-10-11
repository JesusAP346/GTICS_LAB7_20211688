package org.example.gtics_lab7_20211688.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig {
    @Autowired
    DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.formLogin().successHandler((request,response,authentication) -> {

            DefaultSavedRequest dafaultSavedRequest =
                    (DefaultSavedRequest) request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");
            //SI VENGO POR URL -> defaultSR existe
            if(dafaultSavedRequest != null){
                String targetURL = dafaultSavedRequest.getRequestURL();
                new DefaultRedirectStrategy().sendRedirect(request,response,targetURL);
            }else{//vengo del boton de login
                String rol = "";
                for(GrantedAuthority role : authentication.getAuthorities()){
                    rol = role.getAuthority();
                    break;
                }
                if(rol.equals("ADMIN")){
                    response.sendRedirect("/Admin");
                }else{
                    response.sendRedirect("/Gerente");
                }
            }
        });


        http.logout();
        http.authorizeHttpRequests()
                .requestMatchers("/Admin","/Admin/**").hasAuthority("ADMIN") // si son varios, es hasAnyAuthority
                .requestMatchers("/Gerente","/Gerente/**").hasAuthority("GERENTE")
                .requestMatchers("/Cliente","/Cliente/**").hasAuthority("CLIENTE")
                .anyRequest().permitAll();//cualquier otro queda permitido

        return http.build();
    }




    @Bean
    public UserDetailsManager users(DataSource dataSource){
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        String sql1 = "select email,password,activo from users where email = ?"; //autenticacion : forma autenticacion -> username | password (150) | enable
        String sql2 = "select u.email,r.name from users u \n" +
                "inner join roles r on u.roleId = r.id\n" +
                "where u.email = ?"; //autorizacion: forma autorizacion -> username | nombreRol

        users.setUsersByUsernameQuery(sql1);
        users.setAuthoritiesByUsernameQuery(sql2);
        return users;
    }
}
