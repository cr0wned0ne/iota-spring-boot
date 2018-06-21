package com.undevined.iotaspring.iota;

import org.springframework.boot.context.properties.ConfigurationProperties;



@ConfigurationProperties("iota")
public class IotaProperties {

	private String protocol;
    private String host;
    private int port;
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
}
