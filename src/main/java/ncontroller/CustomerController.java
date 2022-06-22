package ncontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.CustomerService;
import vo.Notice;

//import  ctrl + shift + O  정리하기

@Controller
@RequestMapping("/customer/")
public class CustomerController {

	//CustomerController 는  CustomerService 에 의존합니다 (필요)
	
	private CustomerService customerservice;
	
	@Autowired	
	public void setCustomerservice(CustomerService customerservice) {
		this.customerservice = customerservice;
	}

	
	@RequestMapping("notice.do")   //   /customer/notice.do
	public String notices(HttpServletRequest request, String pg , String f , String q , Model model) 
	{
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("loginok");
		
		if(login.equals("ok"))
		{
			List<Notice> list = customerservice.notices(pg, f, q);
			model.addAttribute("list", list);
			return "notice.jsp";
		}
		else
		{
			System.out.println("권한없음");
			return "redirect:/joinus/login_no_right.jsp";
		}
		
	}
	
	
	@RequestMapping("noticeDetail.do")  //    /customer/noticeDetail.do
	public String noticesDetail(String seq  , Model model) {
	
		Notice notice = customerservice.noticesDetail(seq);
		model.addAttribute("notice", notice);
		return "noticeDetail.jsp";
	}
	
		
	//글쓰기 화면 (GET)
	@RequestMapping(value="noticeReg.do",  method = RequestMethod.GET)
	public String noticeReg() {
		return  "noticeReg.jsp";
	}
		
	//글쓰기 처리(POST)
	@RequestMapping(value="noticeReg.do",  method = RequestMethod.POST)
	public String noticeReg(Notice n , HttpServletRequest request) {
		String url = null;
		try {
			 url = customerservice.noticeReg(n, request);
		} catch (Exception e) {
			
		}
	  return url;
	}
		
	//글수정하기 (화면) GET
	@RequestMapping(value="noticeEdit.do"  , method = RequestMethod.GET)
	public String noticeEdit(String seq , Model model) {
			Notice notice=null;
			try {
			   notice =  customerservice.noticeEdit(seq);
			} catch( Exception e) {
					e.printStackTrace();
			} 
			
			model.addAttribute("notice", notice);
			return "noticeEdit.jsp";
		}
	
	
	//글수정 (처리) POST
	@RequestMapping(value="noticeEdit.do"  , method = RequestMethod.POST)
	public String noticeEdit(Notice n , HttpServletRequest request) {
			 
			return customerservice.noticeEdit(n, request);
		}
		
	//글 삭제하기 
	@RequestMapping("noticeDel.do")
	public String noticeDel(String seq) {
		return customerservice.noticeDel(seq);
		
	}
	
}
