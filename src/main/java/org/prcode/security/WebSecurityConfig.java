package org.prcode.security;

import org.prcode.business.support.basic.security.config.CsrfSecurityRequestMatcher;
import org.prcode.business.support.basic.security.config.CustomerAccessDecisionManager;
import org.prcode.business.support.basic.security.config.CustomerFilterSecurityInterceptor;
import org.prcode.business.support.basic.security.config.CustomerSecurityMetadataSource;
import org.prcode.business.support.basic.security.dao.SecurityDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

/**
 * @ClassName: WebSecurityConfig
 * @Date: 2017-4-16 14:23
 * @Auther: kangduo
 * @Description: (安全控制配置)
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private CustomerUserDetailService customerUserDetailService;
    @Resource
    private LoginSuccessHandler loginSuccessHandler;
    @Resource
    private CsrfSecurityRequestMatcher csrfSecurityRequestMatcher;
    @Resource
    private SecurityDao securityDao;
    @Resource
    private AuthenticationManager authenticationManager;


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CustomerAccessDecisionManager customerAccessDecisionManager() {
        return new CustomerAccessDecisionManager(securityDao);
    }
    @Bean
    public CustomerSecurityMetadataSource customerSecurityMetadataSource() {
        return new CustomerSecurityMetadataSource(securityDao);
    }
    @Bean
    public CustomerFilterSecurityInterceptor customerFilterSecurityInterceptor() {
        CustomerFilterSecurityInterceptor customFilter = new CustomerFilterSecurityInterceptor();
        customFilter.setCustomerSecurityMetadataSource(customerSecurityMetadataSource());
        customFilter.setAccessDecisionManager(customerAccessDecisionManager());
        customFilter.setAuthenticationManager(authenticationManager);
        return customFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customerUserDetailService).passwordEncoder(passwordEncoder());
        auth.eraseCredentials(false);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login").failureUrl("/login?error").permitAll().successHandler(loginSuccessHandler)
                .and().authorizeRequests().antMatchers("/css/**","/images/**", "/js/**").permitAll()
                .anyRequest().authenticated()
                .and().logout().logoutSuccessUrl("/login")
                .and().exceptionHandling().accessDeniedPage("/deny")
                .and().csrf().requireCsrfProtectionMatcher(csrfSecurityRequestMatcher);
    }

}
