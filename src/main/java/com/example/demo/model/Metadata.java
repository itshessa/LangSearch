package com.example.demo.model;

//import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import com.google.api.client.util.Key;

import lombok.Data;

@Data
@SolrDocument
public class Metadata {
    @Field("title")
	@Key
    private String title;
	@Key
	@Field("snippet")
    private String snippet;
	@Key
	@Field("id")
    private String link;
	@Field("targeted")
    private String targeted;
	@Field("level")
    private String level;
	public String getTargeted() {
		return targeted;
	}
	public void setTargeted(String targeted) {
		this.targeted = targeted;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	@Field("skill")
    private String skill;
	public String getTitle() {
		return title;
	}
    @Field("title")
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSnippet() {
		return snippet;
	}
	@Field("snippet")

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}
	public String getLink() {
		return link;
	}
	@Field("id")
	public void setLink(String link) {
		this.link = link;
	}
	@Override
	public String toString() {
		return "Metadata [title=" + title + ", snippet=" + snippet + ", link=" + link + "]";
	}
    
    
}
