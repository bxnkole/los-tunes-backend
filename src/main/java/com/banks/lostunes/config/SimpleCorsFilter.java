package com.banks.lostunes.config;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Created by banks on 002 Aug 02 2017 6:26 AM.
 */
@Component
@Log4j
public class SimpleCorsFilter extends CorsFilter {

    public SimpleCorsFilter(CorsConfigurationSource configSource) {
        super(getConfigSource());
        log.debug("Registering CORS filter");
    }

    private static CorsConfigurationSource getConfigSource() {
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/api/**", new CorsConfiguration().applyPermitDefaultValues());
        return configurationSource;
    }
}
