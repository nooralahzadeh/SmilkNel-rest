/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.inria.smilk.ws.smilknel.rest.resources.bean;

import javax.ws.rs.QueryParam;

/**
 *
 * @author fnoorala
 */
public class ParameterBean {

    public String getLanguage() {
        return lang;
    }

    public void setLanguage(String language) {
        this.lang = language;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public String getTaggerName() {
        return taggerName;
    }

    public void setTaggerName(String taggerName) {
        this.taggerName = taggerName;
    }

    public String getSpotter() {
        return spotter;
    }

    public void setSpotter(String spotter) {
        this.spotter = spotter;
    }

    public String getDisambiguator() {
        return disambiguator;
    }

    public void setDisambiguator(String disambiguator) {
        this.disambiguator = disambiguator;
    }
    
   
    
    private  @QueryParam("lang")  String lang;
    private  @QueryParam("taggerName")  String taggerName;
    private  @QueryParam("spotter") String spotter;
    private  @QueryParam("tool") String tool;
    private  @QueryParam("disambiguator") String disambiguator;
    
    
   
    
}
