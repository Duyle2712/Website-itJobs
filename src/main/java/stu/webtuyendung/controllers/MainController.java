package stu.webtuyendung.controllers;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import stu.webtuyendung.models.Congviec;
import stu.webtuyendung.models.Jobseeker;
import stu.webtuyendung.services.CongviecService;
import stu.webtuyendung.services.JobseekerService;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	CongviecService congviecService;
	
	@Autowired
	JobseekerService jobseekerService;
	
	
	
	@GetMapping(value = {"","home"})
	public String getHome(ModelMap model)
	{	
		Pageable firstPageWithTwoElements = PageRequest.of(0, 5);
		Page<Congviec> cv = congviecService.findAll(firstPageWithTwoElements);
		 System.out.println(cv);
		model.addAttribute("JOBLISTJOBSEEKER", cv);
		return "jobseeker/home";
	}
	
	@GetMapping("login")
	public String getLoginJobseeker(HttpSession session)
	{		
		if(session.getAttribute("USERNAME") != null)
		{
			return "jobseeker/home";
		}
		return "jobseeker/login";
	}
	
	@GetMapping("signup")
	public String getSignUpJobseeker(HttpSession session)
	{
		if(session.getAttribute("USERNAME") != null)
		{
			return "jobseeker/home";
		}
		return "jobseeker/signup";
	}
	
	public boolean validation(String validation)
	{
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		 
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(validation);
		if(matcher.matches()) {
			return true;
		} else {
			return false;
		}		
	}
	public String convertPassToSHA(String password) {
	    String sha = null;
	    try {
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");

	        // Update input string in message digest
	        digest.update(password.getBytes(), 0, password.length());

	        // Converts message digest value in base 16 (hex)
	        sha = new BigInteger(1, digest.digest()).toString(16);
	        System.out.println(sha);
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
		
	    return sha;
	}
	
	@PostMapping("signup/createAcc")
	public String postSignUpJobseeker(ModelMap model, @RequestParam("email")String email,
    		@RequestParam("password")String password)
	{
		if(validation(email))
		{			
			String shaPass = convertPassToSHA(password);
			Optional<Jobseeker> oJobseeker = jobseekerService.findById(email);
			
			if(oJobseeker.isPresent()) {
				model.addAttribute("CREATEACCMESS", "Email "+ email +" này đã đăng ký tài khoản");
				model.addAttribute("Email", email);
				model.addAttribute("Password", password);
				return "jobseeker/signup";
				
			} else {
				Jobseeker jsker = new Jobseeker();
				jsker.setEmail(email);
				jsker.setPassword(shaPass);
				jobseekerService.save(jsker);
				model.addAttribute("CREATEACCSUCCESS", "Success! ");
				return "jobseeker/signup-sucess";
			}					
		} else {
			model.addAttribute("CREATEACCMESS", "Email không đúng định dạng");
			model.addAttribute("Email", email);
			model.addAttribute("Password", password);
			return "jobseeker/signup";
		}		
	}
	
	@PostMapping("checkLogin")
	public String postCheckLogin(ModelMap model,HttpSession session, @RequestParam("email")String email,
    		@RequestParam("password")String password)
	{
		if(validation(email))
		{			
			String shaPass = convertPassToSHA(password);
			Optional<Jobseeker> oJobseeker = jobseekerService.findById(email);
			
			if(jobseekerService.checkLoginJobseeker(email, shaPass)) {
				session.setAttribute("USERNAME", email);
				if(oJobseeker.get().getFullname() == null) {
					session.setAttribute("FULLNAME", email);;
				} else {					
		            session.setAttribute("FULLNAME", oJobseeker.get().getFullname());					
				}
				return "redirect:/home";
				
			} else {
				model.addAttribute("ERROR", "Nhập sai email hoặc mật khẩu");
				model.addAttribute("Email", email);
				model.addAttribute("Password", password);
				return "jobseeker/login";
			}					
		} else {
			model.addAttribute("ERROR", "Email không đúng định dạng");
			model.addAttribute("Email", email);
			model.addAttribute("Password", password);
			return "jobseeker/login";
		}		
	}
	@GetMapping(value = {"logout"})
    public String getLogoutJobseeker(HttpSession session) {
    	if(session.getAttribute("USERNAME") != null) {   		
    		session.removeAttribute("USERNAME");
    		session.setAttribute("USERNAME", null);
    		session.removeAttribute("FULLNAME");
    		session.setAttribute("FULLNAME", null);
            return "redirect:";
    	} 
    	return "jobseeker/home";   	
    }
	
}
