package br.miranda.zup.proposta.desafioDeProposta.seguranca;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http.cors().and()
              .authorizeRequests()
                 .antMatchers(HttpMethod.GET, "/proposta")
                    .hasAuthority("user")
                 .anyRequest()
                 .authenticated()
              .and()
                  .oauth2ResourceServer()
                        .jwt()
                            .jwtAuthenticationConverter(getJwtAuthenticationConverter());

    }

    JwtAuthenticationConverter getJwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter converter = new JwtGrantedAuthoritiesConverter();
        converter.setAuthoritiesClaimName("authorities");
        converter.setAuthorityPrefix("");
        JwtAuthenticationConverter authenticationConverter = new JwtAuthenticationConverter();
        authenticationConverter.setJwtGrantedAuthoritiesConverter(converter);
        return  authenticationConverter;
    }
}
