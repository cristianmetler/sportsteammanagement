package com.fortech.stm.authentification;

import javax.validation.constraints.NotNull;

public class AuthenticateUserRequest {

	    @NotNull
	    private String username;

	    @NotNull
	    private String password;

	    public String getUsername(){return this.username;}
	    public void setUsername(String username){this.username = username;}
	    public String getPassword(){return this.password;}
	    public void setPassword(String password){this.password = password;
}
}
