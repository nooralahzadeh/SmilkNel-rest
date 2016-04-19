/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.inria.smilk.ws.smilknel.rest.model;

/**
 *
 * @author fnoorala
 */

import com.google.gson.Gson;
import javax.xml.bind.annotation.XmlRootElement;

 
public class ErrorMessage {
    private String errorMessage;
	private int errorCode;
	private String documentation;
	private static Gson gson = new Gson();
        
	public ErrorMessage() {
		
	}
		
	public ErrorMessage(String errorMessage, int errorCode, String documentation) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.documentation = documentation;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
    
        public String toJson() {
		return gson.toJson(this);
	}
    
    
}
