package com.example.hairremoval.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

private final CustomAuthenticationProvider customAuthenticationProvider;

   public WebSecurityConfig(CustomAuthenticationProvider customAuthenticationProvider){
           this.customAuthenticationProvider = customAuthenticationProvider;
       }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    http
        .authenticationProvider(customAuthenticationProvider)
        .cors(customizer -> customizer.configurationSource(
            (CorsConfigurationSource) corsConfigurationSource()))
        // CSRFの保護を無効にする
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(authorizeRequests ->
            authorizeRequests
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                .permitAll()
                // 以下のパスへのリクエストはすべて許可
                .requestMatchers("/login/**","/accountInput/**","/accountRegister/**","/accountRegistrationComplete/**").permitAll()
                // その他のリクエストは認証が必要
                .anyRequest().authenticated()
        )
        .formLogin(formLogin ->
            formLogin
                .usernameParameter("userId")
                // ログイン処理のURLを指定(フロントがログインボタン実行時にPOSTする場所)
                .loginProcessingUrl("/login")
                // カスタムログインページのURLを指定(Spring Securityデフォルトの画面を置き換える)
                .loginPage("/login")
                // ログイン成功時のリダイレクト先URLを指定
                .defaultSuccessUrl("/home",true)
        );
    return http.build();
  }

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource(){
      CorsConfiguration configuration = new CorsConfiguration();
      configuration.setAllowCredentials(true);
      configuration.addAllowedOrigin("http://localhost:8080");
      configuration.addAllowedHeader("*");
      configuration.addAllowedMethod("*");
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/**",configuration);
      return source;
    }
}
