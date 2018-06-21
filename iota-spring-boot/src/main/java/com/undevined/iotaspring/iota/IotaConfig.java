package com.undevined.iotaspring.iota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import jota.IotaAPI;
import static java.util.Objects.requireNonNull;

@Configuration
@ConditionalOnClass(IotaAPI.class)
@EnableConfigurationProperties(IotaProperties.class)
public class IotaConfig {
	
    private final IotaProperties properties;

    @Autowired
    public IotaConfig(IotaProperties properties) {
        this.properties = requireNonNull(properties);
    }


	@Bean
	@Primary
	public IotaAPI iotaApi() {
		return new IotaAPI.Builder()
                .protocol(properties.getProtocol())
                .host(properties.getHost())
                .port(String.valueOf(properties.getPort()))
                .build();
	}
	
}
