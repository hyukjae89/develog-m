package pe.oh29oh29.develogm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import pe.oh29oh29.develogm.service.MemberService;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private SignInSuccessHandler signInSuccessHandler;

    @Autowired
    private SignInFailureHandler signInFailureHandler;

    @Autowired
    private SignOutSuccessHandler signOutSuccessHandler;

    @Autowired
    private MemberService memberService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 허용되어야 할 경로들
        web.ignoring().antMatchers("/css/**", "/script/**", "image/**", "/fonts/**", "lib/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/**").permitAll();

        http.formLogin()
            .loginPage("/sign-in")
            .loginProcessingUrl("/sign-in")
            .usernameParameter("id")
            .passwordParameter("passwd")
            .successHandler(signInSuccessHandler)
            .failureHandler(signInFailureHandler)
            .permitAll();

        http.logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/sign-out"))
            .logoutSuccessHandler(signOutSuccessHandler)
            // 인증정보 무효화
            .clearAuthentication(true)
            // 세션 무효화
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID");

        http.sessionManagement()
            // 같은 아이디로 1명만 로그인 할 수 있음
            .maximumSessions(1)
            // 신규 로그인 사용자의 로그인이 허용되고, 기존 사용자는 로그아웃
            .maxSessionsPreventsLogin(false);

        // csrf 사용유무 설정
        // csrf 설정을 사용하면 모든 request에 csrf 값을 함께 전달해야한다.
        http.csrf()
            .disable();

        http.addFilterAfter(new SessionCheckFilter(), BasicAuthenticationFilter.class);
    }

}
