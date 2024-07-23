package com.example.demo.model;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.stereotype.Component;

import com.google.api.client.util.Key;

import java.util.List;


@Component

public class SearchResults {
	@Key("organic_results")
	@Field("docs")
    private List<Metadata> metadataResultList;
	@Field("numFound")
	private long numFound;
    public List<Metadata> getMetadataResultList() {
        return metadataResultList;
    }
    
	@Field("docs")
    public void setMetadataResultList(List<Metadata> metadataResultList) {

        this.metadataResultList = metadataResultList;
    }

	public long getNumFound() {
		return numFound;
	}
	
	@Field("numFound")
	public void setNumFound(long numFound) {
		this.numFound = numFound;
	}

}
