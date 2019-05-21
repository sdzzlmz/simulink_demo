package io.netty.transmit.pojo;

import java.util.HashMap;
import java.util.Map;

public class TransmitDataPojo {
	public Map input = new HashMap();
	public String body;
	public Map output = new HashMap();
	public Map getInput() {
		return input;
	}
	public void setInput(Map input) {
		this.input = input;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Map getOutput() {
		return output;
	}
	public void setOutput(Map output) {
		this.output = output;
	}
	
}
