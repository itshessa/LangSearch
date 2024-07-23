package com.example.demo.classes;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.beans.DocumentObjectBinder;
import org.apache.solr.common.SolrDocumentList;

import com.example.demo.model.Metadata;


public class MetasearchEngineService{
	

	GoogleEngine google=new GoogleEngine();
	SearchSolr solr=new SearchSolr();
	
	public List<Metadata> searchData(QueryData query) throws SolrServerException, IOException {
		List<Metadata> docs=new LinkedList<Metadata>();
		SolrDocumentList d=solr.searchSolr(query);
		DocumentObjectBinder binder = new DocumentObjectBinder();
		docs=binder.getBeans(Metadata.class, d);
		if(docs.size()==0) {
			google.searchEngines(query);
			SolrDocumentList docL=solr.searchSolr(query);
			docs=binder.getBeans(Metadata.class, docL);
		}

		return docs;
	}

}

