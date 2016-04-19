/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.inria.smilk.ws.smilknel.rest.resources;

import fr.inria.smilk.ws.smilknel.rest.exception.DataNotFoundException;
import fr.inria.smilk.ws.smilknel.rest.model.AssessmentRecord;
import fr.inria.smilk.ws.smilknel.rest.services.PipelineService;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

//import javax.ws.rs.BeanParam;
/**
 *
 * @author fnoorala
 */
@Path("annotate")
@Consumes(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.TEXT_XML})
@Produces(value = {MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
public class PipelineResource {

    URL config;
    PipelineService pipelineService;

    private final static List<String> FR_NE = Arrays.asList("opennlp", "renco");
    private final static List<String> EN_NE = Arrays.asList("inria", "stanford");

@GET 
@Produces("text/xml")
public String display() {
    StringBuffer outputXML = new StringBuffer();
    
    String fr_NE="/fr?spotter=NE&amp;tool=&lt;[renco,openNLP]&gt;&amp;method=&lt;[pagerank,linear]&gt;";
    String fr_wiki="/fr?spotter=wiki&amp;method=&lt;[pagerank,linear]&gt;";
    
    String en_NE="/en?spotter=NE&amp;tool=&lt;[inria,stanford]&gt;&amp;method=&lt;[pagerank,linear]&gt;";
    String en_wiki="/en?spotter=wiki&amp;method=&lt;[pagerank,linear]&gt;";
    
    outputXML.append("<?xml version='1.0' standalone='yes'?>");
    outputXML.append("<help>");
      
        outputXML.append("<french value='To annotate french text'>");
            outputXML.append("<fr value=\""+fr_NE+"\">"+"</fr>");
            outputXML.append("<fr value=\""+fr_wiki+"\">"+"</fr>");
        outputXML.append("</french>");
       
        outputXML.append("<english value='To annotate english text'>");
            outputXML.append("<en value=\""+en_NE+"\">"+"</en>");
            outputXML.append("<en value=\""+en_wiki+"\">"+"</en>");
        outputXML.append("</english>");
       
    outputXML.append("</help>");
    
    
  return (outputXML.toString());  
  }
    
    @Path("fr")
    @POST
    public String getFrAnnotation(@Context ServletContext servlet,
            @QueryParam("taggerName") String taggerName,
            @QueryParam("spotter") String spotter,
            @QueryParam("tool") String NEtool,
            @QueryParam("method") String disambiguator,
            String textInput) throws IOException {
        //   
        config = servlet.getResource("/WEB-INF/dexter-conf.xml");

        if (spotter.equalsIgnoreCase("NE") && NEtool != null) {

            if (FR_NE.contains(NEtool.toLowerCase())) {
                spotter = "namedEntity";
                pipelineService = new PipelineService(config.getPath(), "fr", "smilk", spotter, NEtool, disambiguator);
            } else {
                 throw new DataNotFoundException("Spotter as : " + spotter + " not found! for French you have to use /fr?spotter=NE&tool= {one element from "+  FR_NE.toString() +"}");
            }

        } else if (spotter.equalsIgnoreCase("wiki")) {
            spotter = "wiki-dictionary";
            pipelineService = new PipelineService(config.getPath(), "fr", "smilk", spotter, disambiguator);

        } else {
                  throw new DataNotFoundException("Spotter as : " + spotter + " not found! for French if you want to spot based on wiki just put {/fr?spotter=wiki} without sepecifying the tool ");

        }
        String output =pipelineService.annotate(textInput);
       
        return output;

    }

    @Path("en")
    @POST
    public String getEnAnnotation(@Context ServletContext servlet,
            @QueryParam("taggerName") String taggerName,
            @QueryParam("spotter") String spotter,
            @QueryParam("tool") String NEtool,
            @QueryParam("method") String disambiguator,
            String textInput) throws IOException {
        //   
        config = servlet.getResource("/WEB-INF/dexter-conf.xml");
        if (spotter.equalsIgnoreCase("NE") && NEtool != null) {
            if (EN_NE.contains(NEtool.toLowerCase())) {
                spotter = "namedEntity";
                
                if(NEtool.equalsIgnoreCase("stanford")){
                    NEtool="stanfordwithoutcoref";
                }
                pipelineService = new PipelineService(config.getPath(), "en", "smilk", spotter, NEtool, disambiguator);

            } else {
               throw new DataNotFoundException("Spotter as : " + spotter + " not found! for English you have to use /en?spotter=NE&tool= {one element from "+  EN_NE.toString() +"}");

            }
        } else if (spotter.equalsIgnoreCase("wiki")) {
            spotter = "wiki-dictionary";
            pipelineService = new PipelineService(config.getPath(), "en", "smilk", spotter, disambiguator);

        }else{
              throw new DataNotFoundException("Spotter as : " + spotter + " not found! for English if you want to spot based on wiki just put {/en?spotter=wiki} without sepecifying the tool");
        }

       String output =pipelineService.annotate(textInput);
       
        return output;

    }

}
