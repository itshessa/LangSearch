package com.example.demo.config;

//import java.io.IOException;


import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
//import org.springframework.data.solr.server.support.EmbeddedSolrServerFactory;

@Configuration
@EnableSolrRepositories(basePackages = "com.example.demo.repository")
@ComponentScan

public class ApplicationConfig {
	 @Value("spring.data.solr.host") String solrURL;
	  @Bean
	  public SolrClient solrClient() 
//			  throws ParserConfigurationException, IOException, SAXException 
	  {
//	    EmbeddedSolrServerFactory factory = new EmbeddedSolrServerFactory("classpath:com/acme/solr");
//	    return factory.getSolrClient();
	        return new HttpSolrClient.Builder(solrURL).build();
	  }

	  @Bean
	  public SolrOperations solrTemplate()
//			  throws ParserConfigurationException, IOException, SAXException 
	  {
	    return new SolrTemplate(solrClient());
	  }
}
