package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Metadata;
@Repository
public interface MetadataRepository extends SolrCrudRepository<Metadata, String> {
//    @Query("targeted:? AND level:? AND skill:?")
    Page<Metadata> findByTargetedContainsAndLevelContainsAndSkillContains(String targeted,String level, String skill, Pageable pageable);
}
