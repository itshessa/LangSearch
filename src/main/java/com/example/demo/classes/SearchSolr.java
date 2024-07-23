package com.example.demo.classes;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

public class SearchSolr {
	
	private SolrClient client =new HttpSolrClient.Builder("https://ss900697-vw5yg8u1-ap-south-1-aws.searchstax.com/solr/LangSearchDocs_shard1_replica_n1").withConnectionTimeout(10000)
		    .withSocketTimeout(60000).build();
	
	public SolrDocumentList searchSolr(QueryData q) throws SolrServerException, IOException {
		((HttpSolrClient) client).setParser(new XMLResponseParser());
		SolrQuery query=new SolrQuery();
		if(q.getLevel().equalsIgnoreCase("Beginner"))
			query.setQuery("targeted:"+q.getDesiredLanguage()+" AND skill:"+q.getSkill()+" AND level:"+q.getLevel());
		else if(q.getLevel().equalsIgnoreCase("Intermediate")) 
			query.setQuery("targeted:"+q.getDesiredLanguage()+" AND skill:"+q.getSkill()+" AND level:"+q.getLevel());
		else
			query.setQuery("targeted:"+q.getDesiredLanguage()+" AND skill:"+q.getSkill());
		query.setStart(0);
		query.setRows(200);
		QueryResponse response=client.query(query);
		SolrDocumentList docList=response.getResults();
		return docList;
	}
}

