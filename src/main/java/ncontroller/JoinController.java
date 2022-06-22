package ncontroller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.MemberService;
import vo.Member;

@Controller
@RequestMapping("/joinus/")
public class JoinController {

	private MemberService memberservice;

	@Autowired
	public void setMemberservice(MemberService memberservice) {
		this.memberservice = memberservice;
	}
	
	@RequestMapping(value="join.do" , method=RequestMethod.GET )
	public String join() {
		return "join.jsp";
	}
	
	@RequestMapping(value="join.do" , method=RequestMethod.POST )
	public String join(Member member) 
	{
		System.out.println(member.toString());
		int result = 0;
		try 
		{
			result = memberservice.insert(member);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		 
		return "redirect:/index.do";
	}
	
	@RequestMapping(value="login.do" , method=RequestMethod.GET )
	public String login(HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		session.setAttribute("loginok", "");
		return "redirect:../joinus/login.jsp";
	}
	
	@RequestMapping(value="logout.do" , method=RequestMethod.GET )
	public String logout(HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		session.setAttribute("loginok", "");
		return "redirect:../joinus/login.jsp";
	}
	
	@RequestMapping(value="loginConfirm.do" , method=RequestMethod.POST )
	public String loginconfirm(HttpServletRequest request) 
	{
		String id = request.getParameter("UserName");
		String pw = request.getParameter("Password");
		Member m= new Member();
		try 
		{
			m=memberservice.getMember(id);
		} 
		catch (ClassNotFoundException e)
		{			
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		if(m.getPwd().equals(pw))
		{
			System.out.println("로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("loginok", "ok");
			session.setAttribute("id",id);
			System.out.println("세션저장 " + session.getAttribute("id"));
			return "redirect:/customer/notice.do";
		}
		else if(!m.getPwd().equals(pw))
		{
			System.out.println("로그인 실패");
			return "redirect:/joinus/login_no_right.jsp";
		}
		return null;
	}
}
