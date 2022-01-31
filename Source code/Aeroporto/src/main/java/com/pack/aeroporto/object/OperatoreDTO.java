package com.pack.aeroporto.object;

public class OperatoreDTO {
    private String email;
    private String PSW;
    
    public OperatoreDTO() {
	}

	public OperatoreDTO(String email, String PSW) {
    	this.email = email;
    	this.PSW = PSW;
	}
    
    private String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }
}