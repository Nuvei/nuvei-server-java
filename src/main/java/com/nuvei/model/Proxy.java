/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.model;

/**
 * <p>
 * Holder for the data needed to connect to the Nuvei's servers via Proxy.
 *
 * @author <a mailto:nikolad@nuvei.com>Nikola Dichev</a>
 * @since 2/15/2017
 */
public class Proxy {

    private String host;

    private String protocol;

    private int port;

    public Proxy(String host, String protocol, int port) {
        this.host = host;
        this.protocol = protocol;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
