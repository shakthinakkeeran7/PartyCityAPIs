package com.partycity.api.baseclass;

public class Endpoints {
	public static final String BASE_URI="https://api.github.com";
	
	//CreateSub Class for Endpoints
public static class singleUser{
	
	//CreateConstructor and set us Private
		private singleUser() {
		
		
	}
	
	public static final String  GET_SINGLE_USER= BASE_URI +"/repos/{Owner}/{Repo}";
	public static final String CREATE_SINGLE_USER =BASE_URI +"/user/repos";
	public static final String PUT_SINGLE_USER =BASE_URI +"/repos/{Owner}/{Repo}/topics";
	public static final String PATCH_SINGLE_USER = BASE_URI +"repos/{Owner}/{Repo}";
	public static final String DELETE_SINGLE_USER =BASE_URI + "/repos/{Owner}/{Repo}";
	
	public static final String HHH = BASE_URI;
	
}
}
