package com.example.demo;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.classes.GoogleEngine;
import com.example.demo.classes.QueryData;
import com.example.demo.classes.SearchSolr;

@SpringBootTest
class LangSearchApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void searchSolr() {
		SearchSolr solr=new SearchSolr();
		QueryData query=new QueryData();
		query.setDesiredLanguage("English");
		query.setNativeLanguage("Arabic");
		query.setLevel("Beginner");
		query.setSkill("Course");
			try {
				solr.searchSolr(query);
			} catch (SolrServerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}