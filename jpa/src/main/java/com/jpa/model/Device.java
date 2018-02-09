package com.jpa.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Device implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -254830618567945985L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String node;
	private String ipAddress;
	private String terminalIP;
	private String port;
	
	public Device() {
		
	}
	public Device(String node, String ipAddress, String terminalIp, String port) {
		this.node=node;
		this.ipAddress=ipAddress;
		this.terminalIP=terminalIp;
		this.port=port;
	}
	
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
