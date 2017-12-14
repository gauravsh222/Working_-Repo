package com.cisco.consumer;

import java.io.Serializable;

public class Device implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -254830618567945985L;
	String node;
	String ipAddress;
	String terminalIP;
	String port;
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getTerminalIP() {
		return terminalIP;
	}
	public void setTerminalIP(String terminalIP) {
		this.terminalIP = terminalIP;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	@Override
	public String toString() {
		StringBuilder device = new StringBuilder("Node : ");
		device.append(node).append(", IP : ").append(ipAddress).
						append(", Terminal : ").append(terminalIP).append(", Port : ").append(port);
		return device.toString();
	}
}
