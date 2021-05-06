package stu.webtuyendung.controllers;

import java.math.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import stu.webtuyendung.models.Admin;
import stu.webtuyendung.models.Congviec;
import stu.webtuyendung.models.Recruiter;
import stu.webtuyendung.services.AdminService;
import stu.webtuyendung.services.CongviecService;
import stu.webtuyendung.services.RecruiterService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	CongviecService congviecService;
	
	@Autowired
	RecruiterService recruiterService;
	
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
	

	@GetMapping(value = {"","/"})
	public String getLogin(HttpSession session)
	{
		if(session.getAttribute("USERNAMEADMIN") != null) {
			return "admin/home";
		}
		return "admin/login";
	}
	 
	@GetMapping("/home")
	public String getHome(HttpSession session)
	{
		if(session.getAttribute("USERNAMEADMIN") != null) {
			return "admin/home";
		}
		return "admin/login";	
	}
	
	
	@PostMapping(value = {"/checkLoginAdmin"})
    public String checkLoginAdmin(ModelMap model , @RequestParam("username")String username,
                                  @RequestParam("password")String password,
                                  HttpSession session){
		
		if(session.getAttribute("USERNAMEADMIN") != null)
		{
			return "admin/home";
		} else {
			 String shaPass = convertPassToSHA(password);
			 Optional<Admin> ad = adminService.findById(username);
			 if(adminService.checkLoginAdmin(username, shaPass)){
				 	String fullname = ad.get().getFullName();
		            System.out.println("Login thanh cong");
		            session.setAttribute("USERNAMEADMIN", username);
		            session.setAttribute("FULLNAMEADMIN", fullname);
		            return "admin/home";
		        } else {
		            System.out.println("Login that bai");
		            model.addAttribute("ERROR", "Tài khoản hoặc mật khẩu không đúng");
		        }
		        return "admin/login";
		}   
    }

    @GetMapping(value = {"admin-logout"})
    public String logoutAdmin(HttpSession session) {
    	if(session.getAttribute("USERNAMEADMIN") != null) {   		
    		session.removeAttribute("USERNAMEADMIN");
    		session.setAttribute("USERNAMEADMIN", null);
    		session.removeAttribute("FULLNAMEADMIN");
    		session.setAttribute("FULLNAMEADMIN", null);
            return "redirect:";
    	} 
    	return "admin/login";   	
    }
    
    @GetMapping("/job-list")
	public String getJobList(HttpSession session, ModelMap model)
	{
		if(session.getAttribute("USERNAMEADMIN") != null) {
			model.addAttribute("JOBLIST", congviecService.findAll());
			
			return "admin/job-list";
		}
		return "admin/login";
		
	}
    @GetMapping("/job-detail/{macv}")
   	public String getJobDetail(HttpSession session, ModelMap model, @PathVariable(name ="macv") Long macv)
   	{  	
   		if(session.getAttribute("USERNAMEADMIN") != null) {
   			Optional<Congviec> cv = congviecService.findById(macv);
   	        if(cv.isPresent()) {
   	        	
   	            model.addAttribute("JOBDETAIL", cv.get());
   	            
   	            return "admin/job-detail";
   	        } else {
   	            model.addAttribute("msg", "Không tồn tại công việc này");
   	            return "admin/job-list";
   	        }		
   		}
   		return "admin/login";   		
   	}
    @GetMapping("/job-add")
	public String getJobAdd(HttpSession session)
	{
		if(session.getAttribute("USERNAMEADMIN") != null) {						
			return "admin/job-add";
		}
		return "admin/login";
	}
    @PostMapping("/job-add")
    public String postJobAdd(ModelMap model, @RequestParam("chucdanh")String chucdanh,
    		@RequestParam("capbac")String capbac, @RequestParam("loaicv")int loaicv,
    		@RequestParam("nguoilienhe")String nguoilienhe, @RequestParam("diadiem")String diadiem,
    		@RequestParam("status")int status, @RequestParam("mucluong")Long mucluong,
    		@RequestParam("yeucau")String yeucau, @RequestParam("mota")String mota,
    		@RequestParam("email")String email, @RequestParam("ngonngu")String ngonngu)
    {    	
    	
    	Optional<Recruiter> optinalRecruiter = recruiterService.findById(email);
    	System.out.println(optinalRecruiter.get().getEmail());
    	if(optinalRecruiter.isPresent())
    	{   		
    		Congviec cv = new Congviec();
    		cv.setChucdanh(chucdanh);
    		cv.setCapbac(capbac);
    		cv.setDiadiem(diadiem);
    		cv.setLoaicv(loaicv);
    		cv.setMota(mota);
    		cv.setMucluong(mucluong);
    		cv.setNgonngu(ngonngu);
    		cv.setNguoilienhe(nguoilienhe);
    		cv.setStatus(status);
    		cv.setYeucau(yeucau);
    		cv.setEmail(optinalRecruiter.get().getEmail());
    		congviecService.save(cv);
    		model.addAttribute("ADDJOBMESSAGE", "Thêm Công Việc Thành Công");
    		return "admin/job-add";
    	} 
    	model.addAttribute("ADDJOBMESSAGE", "Thêm Thất Bại");
    	return "admin/job-add";   	    
    }
    
    @RequestMapping("/job-delete/{macv}")
    public String delete(HttpSession session, ModelMap model, @PathVariable(name ="macv") Long macv) {
    	if(session.getAttribute("USERNAMEADMIN") != null) {						
    		congviecService.deleteById(macv);
    		model.addAttribute("JOBLIST", congviecService.findAll());
    		model.addAttribute("DELJOBMESSAGE", "Xoá Công Việc Thành Công");
            return "admin/job-list";
		}
		return "admin/login";     
    }
    
    @GetMapping("/job-edit/{macv}")
   	public String getJobEdit(HttpSession session, ModelMap model, @PathVariable(name ="macv") Long macv)
   	{  	
   		if(session.getAttribute("USERNAMEADMIN") != null) {
   			Optional<Congviec> cv = congviecService.findById(macv);
   	        if(cv.isPresent()) {
   	        	
   	            model.addAttribute("JOBEDIT", cv.get());
   	            
   	            return "admin/job-edit";
   	        } else {
   	            model.addAttribute("msg", "Không tồn tại công việc này");
   	            return "admin/job-list";
   	        }		
   		}
   		return "admin/login";   		
   	}
    @PostMapping("/job-edit/{macv}")
    public String postJobEdit(ModelMap model,@PathVariable(name ="macv") Long macv,
    		@ModelAttribute("JOBEDIT") Congviec cv)
    {    	   	
		congviecService.save(cv);
		model.addAttribute("JOBLIST", congviecService.findAll());
		model.addAttribute("EDITJOBMESSAGE", "Sửa Công Việc Thành Công");
		return "admin/job-list"; 	    
    }
    
    @GetMapping("/recruiter-list")
    public String getRecruiterList(HttpSession session, ModelMap model)
    {
    	if(session.getAttribute("USERNAMEADMIN") != null) {
			model.addAttribute("RECRUITERLIST", recruiterService.findAll());
			model.addAttribute("RECRUITERCOUNT", recruiterService.count());
			return "admin/recruiter-list";
		}
		return "admin/login";  
    }
   
	
	
}
