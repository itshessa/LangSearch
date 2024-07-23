package com.example.demo.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.solr.client.solrj.SolrServerException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.classes.MetasearchEngineService;
import com.example.demo.classes.QueryData;
import com.example.demo.model.Metadata;
import com.example.demo.model.User;
import com.example.demo.repository.MetadataRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.MyUserDetails;

@Controller
public class MainController {
    @Autowired
    public UserRepository repo;
    
    @Autowired
    public MetadataRepository rep;
    
    
	@RequestMapping(value= "/", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, 
			HttpServletResponse response){
		QueryData query=new QueryData();
		ModelAndView model=new ModelAndView("index");
		model.addObject("query",query);
		request.setAttribute("query", query);
		return model;
	}

	@RequestMapping("search/page/{pageNum}")
	public String Results(Model model, @PathVariable(name = "pageNum") int pageNum, @ModelAttribute("query")QueryData q,HttpServletRequest request) throws SolrServerException, IOException, JSONException {
		MetasearchEngineService me=new MetasearchEngineService();
	    int pageSize=10;
	    QueryData query=new QueryData();
	    query.setDesiredLanguage(q.getDesiredLanguage());
	    query.setLevel(q.getLevel());
	    query.setNativeLanguage(q.getNativeLanguage());
	    query.setSkill(q.getSkill());
	    
		List<Metadata> res=(ArrayList<Metadata>) me.searchData(query);
	    Pageable pageable =PageRequest.of(pageNum-1, pageSize);
	    int start = (int) pageable.getOffset();
	    int end = (int) ((start + pageable.getPageSize()) > res.size() ? res.size()
	    		  : (start + pageable.getPageSize()));
	    Page<Metadata> page=new PageImpl<Metadata>(res.subList(start, end), pageable, res.size());
	    long totalItems=page.getTotalElements();
	    List<Metadata> re=page.getContent();
	    LinkedList<Metadata> results = new LinkedList<Metadata>(); 
	    results.addAll(re);
	    int totalPages=page.getTotalPages();
	    model.addAttribute("searchresults", results);
	    model.addAttribute("currentPage", pageNum);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("totalItems", totalItems);
	    model.addAttribute("NativeLanguage",query.getNativeLanguage());
	    model.addAttribute("DesiredLanguage",query.getDesiredLanguage());
	    model.addAttribute("Skill",query.getSkill());
	    model.addAttribute("Level",query.getLevel());

		return "result";
	}
	
	@RequestMapping(value="/Test", method=RequestMethod.GET)
	public ModelAndView takeTest() {
		ModelAndView model=new ModelAndView("Test");
		
		return model;
	}
	
	@RequestMapping(value="/English_Test",  method = RequestMethod.GET)
	public ModelAndView englishTest(HttpServletRequest request,HttpServletResponse response){
		 ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("englishTest");
	        return modelAndView;
	}
	
	@RequestMapping(value="/Answers_Test",  method = RequestMethod.POST)
	public ModelAndView answersTest(HttpServletRequest request,HttpServletResponse response){
		 ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("answersTest");
	        return modelAndView;
	}
	
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
	
    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }
    @RequestMapping(value="/reg_action", method = RequestMethod.POST)
    public String createNewUser(@ModelAttribute("user")User user, BindingResult bindingResult) {
        User userExists = repo.findByEmail(user.getEmail());
        if (userExists == null) {
        	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        	String encodedPassword = passwordEncoder.encode(user.getPassword());
        	user.setPassword(encodedPassword);
                repo.save(user);
        }
        
        return "login";
    }
    
    @RequestMapping(value="/profile", method = RequestMethod.POST)
    public ModelAndView showProfile(@AuthenticationPrincipal MyUserDetails userDetails){
    	ModelAndView model=new ModelAndView("profile");
    	User user=repo.findByEmail(userDetails.getUsername());
    	user.setPassword("");
    	model.addObject("user",user);
    	return model;
    }

    @RequestMapping(value="/edit", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user")User user) {
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	String encodedPassword = passwordEncoder.encode(user.getPassword());
    	user.setPassword(encodedPassword);
    	repo.save(user);
    	return "edit";
    	
    }

    
    @RequestMapping(value="/home", method = RequestMethod.GET)
    public ModelAndView home(@AuthenticationPrincipal MyUserDetails userDetails,
            Model model){
        ModelAndView modelAndView = new ModelAndView("home");
        String email=userDetails.getUsername();
        User user=repo.findByEmail(email);
        modelAndView.addObject("user",user);
		QueryData query=new QueryData();
		modelAndView.addObject("query",query);
        return modelAndView;
    }
	@RequestMapping(value="/searchu/page/{pageNum}",  method = RequestMethod.GET)
	public String res(Model model, @PathVariable(name = "pageNum") int pageNum, @ModelAttribute("query")QueryData q,HttpServletRequest request) throws SolrServerException, IOException {
		MetasearchEngineService me=new MetasearchEngineService();
	    int pageSize=10;
	    QueryData query=new QueryData();
	    query.setDesiredLanguage(q.getDesiredLanguage());
	    query.setLevel(q.getLevel());
	    query.setNativeLanguage(q.getNativeLanguage());
	    query.setSkill(q.getSkill());
	    
		List<Metadata> res=(ArrayList<Metadata>) me.searchData(query);
	    Pageable pageable =PageRequest.of(pageNum-1, pageSize);
	    int start = (int) pageable.getOffset();
	    int end = (int) ((start + pageable.getPageSize()) > res.size() ? res.size()
	    		  : (start + pageable.getPageSize()));
	    Page<Metadata> page=new PageImpl<Metadata>(res.subList(start, end), pageable, res.size());
	    long totalItems=page.getTotalElements();
	    List<Metadata> re=page.getContent();
	    LinkedList<Metadata> results = new LinkedList<Metadata>(); 
	    results.addAll(re);
	    int totalPages=page.getTotalPages();
	    model.addAttribute("searchresults", results);
	    model.addAttribute("currentPage", pageNum);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("totalItems", totalItems);
	    model.addAttribute("NativeLanguage",query.getNativeLanguage());
	    model.addAttribute("DesiredLanguage",query.getDesiredLanguage());
	    model.addAttribute("Skill",query.getSkill());
	    model.addAttribute("Level",query.getLevel());

		return "SearchResults";
	}
}
