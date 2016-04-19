/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.inria.smilk.ws.smilknel.rest.model;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fnoorala
 */
 
@XmlRootElement
public class AssessmentRecord {
       
        public String docId;
	public String text;
	public List<AnnotatedSpot> annotatedSpot=new ArrayList<AnnotatedSpot>();;

	private static Gson gson = new Gson();

	public AssessmentRecord() {
		 

	}

	public void addAnnotatedSpot(AnnotatedSpot as) {
		annotatedSpot.add(as);
	}
//
	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String toJson() {
		return gson.toJson(this);
	}

	public List<AnnotatedSpot> getAnnotatedSpot() {
		return annotatedSpot;
	}

	public void setAnnotatedSpot(List<AnnotatedSpot> annotatedSpot) {
		this.annotatedSpot = annotatedSpot;
	}

}
