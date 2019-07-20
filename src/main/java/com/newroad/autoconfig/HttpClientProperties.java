package com.newroad.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

/*@ConfigurationProperties(prefix = "spring.httpclient")*/

@ConfigurationProperties(prefix = "spring.httpclient")
public class HttpClientProperties {

    private Integer connectTimeout=1000;
    private Integer socketTimeOut=10000;
    private String agent="agent";
    private Integer maxConnPerRoute = 10;
    private Integer maxConnTotal=50;

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Integer getSocketTimeOut() {
        return socketTimeOut;
    }

    public void setSocketTimeOut(Integer socketTimeOut) {
        this.socketTimeOut = socketTimeOut;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public Integer getMaxConnPerRoute() {
        return maxConnPerRoute;
    }

    public void setMaxConnPerRoute(Integer maxConnPerRoute) {
        this.maxConnPerRoute = maxConnPerRoute;
    }

    public Integer getMaxConnTotal() {
        return maxConnTotal;
    }

    public void setMaxConnTotal(Integer maxConnTotal) {
        this.maxConnTotal = maxConnTotal;
    }

    @Override
    public String toString() {
        return "HttpClientProperties{" +
                "connectTimeout=" + connectTimeout +
                ", socketTimeOut=" + socketTimeOut +
                ", agent='" + agent + '\'' +
                ", maxConnPerRoute=" + maxConnPerRoute +
                ", maxConnTotal=" + maxConnTotal +
                '}';
    }
}
