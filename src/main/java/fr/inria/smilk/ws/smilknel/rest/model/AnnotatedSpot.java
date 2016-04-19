/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.inria.smilk.ws.smilknel.rest.model;

import java.util.Comparator;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fnoorala
 */
  

    public class AnnotatedSpot {

    

    String docId;
    String spot;
    int start;
    int end;
    String entity;
    String wikiname;
    String dbpedia;
    String type;
    double confidenceScore;
//    String entityFinderProcess;

    //<fnoorala>
   // public List<String> pos;

//    public void setPos(List<String> pos) {
//        this.pos = pos;
//    }
//
//    public List<String> getPos() {
//        return this.pos;
//    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
//    
//     public void setEntityFinderProcess(String process) {
//        this.entityFinderProcess = process;
//    }
//
//    public String getEntityFinderProcess() {
//        return this.entityFinderProcess;
//    }
    //</fnoorala>

    public AnnotatedSpot() {

    }

   
    public String getDocId() {
        return docId;
    }
//
    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getSpot() {
        return spot;
    }

    public void setSpot(String spot) {
        this.spot = spot;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    /**
     * the length of the spot *
     */
    public int getLength() {
        return getEnd() - getStart();
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public double getConfidenceScore() {
        return confidenceScore;
    }

    public void setConfidenceScore(double confidenceScore) {
        this.confidenceScore = confidenceScore;
    }

    public String getWikiname() {
        return wikiname;
    }

 
    public void setWikiname(String wikiname) {
        this.wikiname = wikiname;
    }
    
public String getDbpedia() {
        return dbpedia;
    }

    public void setDbpedia(String dbpedia) {
        this.dbpedia = dbpedia;
    }
     

}
