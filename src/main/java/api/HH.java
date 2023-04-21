package api;

import java.util.HashMap;
import java.util.Map;

import com.github.dockerjava.core.dockerfile.DockerfileStatement.Add;

import config.AuthorizationManager;

public class HH {
	private String url;
	private Map<String, String> headers;
	private AuthorizationManager authorizationManager;
	public HH(AuthorizationManager authorizationManager) {
		headers = new HashMap<String, String>();
		
	
			this.authorizationManager = authorizationManager;

		}
	
	public HH withHeader(String name, String value) {

		 headers.put(name, value);

		return this;
	}
	
	public Map<String, String> getHeader() {

		 

		return headers;
	}
	
	
	
	
	
	public HH withUrl(String url) {
		this.url = url;
		return this;
	}
	
	public String getrul() {
		
		return url;
	}

	}


