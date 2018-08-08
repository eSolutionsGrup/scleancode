package ro.esolutions.scleancode.scleancode.example3;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin/**")                             .hasAuthority(Roles.ADMIN.name())
                .antMatchers("/newEmployeeRequest/**")                .hasAnyAuthority(Roles.INITIATOR.name())
                .antMatchers("/workFromHome/**")                      .hasAuthority(Roles.WORK_FROM_HOME.name())
                .antMatchers("/maintenance/admin/**")                 .hasAuthority(Roles.MAINTAINANCE_ADMIN.name())
                .antMatchers("/maintenance/approver/**")              .hasAuthority(Roles.MAINTAINANCE_ADMIN.name())
                .antMatchers("/requestNewEmployee/profile/**")        .hasAnyAuthority(Roles.ADMIN.name(), Roles.INITIATOR.name())
                .antMatchers("/prices/shops/**", "/prices/reports/**").hasAnyAuthority(Roles.PRICE_ADMIN.name(), Roles.ADMIN.name())
                .antMatchers("/approver/**")                          .hasAnyAuthority(Roles.MANAGER.name(), Roles.INCIDENT_MANAGER.name())
                .antMatchers("/prices/**")                            .hasAnyAuthority(Roles.PRICE_USER.name(), Roles.PRICE_USER_PV.name(), Roles.PRICE_ADMIN.name(), Roles.ADMIN.name())
                .antMatchers("/maintenance/**")                       .hasAnyAuthority(Roles.MAINTAINANCE_ADMIN.name(), Roles.MAINTAINANCE_MANAGER.name(), Roles.MAINTAINANCE_USER.name())
                .antMatchers("/my_application/**")                    .hasAnyAuthority(Roles.MANAGER.name(), Roles.DEPARTMENT_MANAGER.name(), Roles.MAINTAINANCE_MANAGER.name(), Roles.OPERATION_MANAGER.name(), Roles.APPLICATION_MANAGER.name(), Roles.ADMIN.name())

                .antMatchers("/css/**", "/js/**", "/font-awesome/**", "/font-omnes/**", "/fonts/**", "/vendor/**", "/img/**", "/lib/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login").permitAll()
                .and()
                .csrf().disable();
    }
}
