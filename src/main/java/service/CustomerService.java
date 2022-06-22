package service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.NoticeDao;
import vo.Notice;

@Service
public class CustomerService {

	//DB작업
	//Mybatis >> 관련된  bean 객체 >> Root IOC 
	//CustomerService 객체  dis.. >> Child IOC
	
	//Child  IOC 에서는 Root IOC 자원 (bean  ref  할 수 있다)
	
	//CustomerService 는  SqlSessionTemplate 에 의존한다 (필요하다)
	
	private SqlSession sqlsession;

	@Autowired  //By type
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	//글 목록보기 서비스
	public List<Notice> notices(String pg , String f , String q)
	{
			
			//default 값 설정
			int page = 1;
			String field="TITLE";
			String query = "%%";
			
			if(pg != null   && ! pg.equals("")) {
				page  = Integer.parseInt(pg);
			}
			
			if(f != null   && ! f.equals("")) {
				field = f;
			}
	
			if(q != null   && ! q.equals("")) {
				query = q;
			}
			
			//DAO 작업
			List<Notice> list = null;
			try {
					//list = noticedao.getNotices(page, field, query);
				    //Mybatis  통해서 DAO 작업
				    NoticeDao noticedao =  sqlsession.getMapper(NoticeDao.class);  //POINT
				    list = noticedao.getNotices(page, field, query);
				    
			} catch (ClassNotFoundException e) {
						e.printStackTrace();
			} catch (SQLException e) {
						e.printStackTrace();
			}

			return  list;
		}
	
	   //글 상세보기 서비스
		public Notice noticesDetail(String seq) {
			
			Notice notice = null;
			try {
				 
				 NoticeDao noticedao =  sqlsession.getMapper(NoticeDao.class);  //POINT		
				 notice = noticedao.getNotice(seq);
			} catch (ClassNotFoundException e) {
							e.printStackTrace();
			} catch (SQLException e) {
							e.printStackTrace();
			}
			
		
			return notice;
		}
		
		//글쓰기 서비스
		public String noticeReg(Notice n , HttpServletRequest request) 
		{
			System.out.println("here");			
			String filename = "";
			/*
		    filename=n.getFile().getOriginalFilename();
			String path = request.getServletContext().getRealPath("/customer/upload"); //배포된 서버 경로 
			String fpath = path + "\\" + filename;
			
			FileOutputStream fs =null;
			try 
			{
			     fs = new FileOutputStream(fpath);
			     fs.write(n.getFile().getBytes());
				     
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally 
			{
				 try 
				 {
					fs.close();
				 } 
				 catch (IOException e)
				 {
					e.printStackTrace();
				 }
			}
			*/
			//파일명 (DTO)
			n.setFileSrc(filename);
			try 
			{
				
			    NoticeDao noticedao =  sqlsession.getMapper(NoticeDao.class);  //POINT
			    HttpSession session = request.getSession();
			    n.setWriter((String)session.getAttribute("id"));
				noticedao.insert(n);  //DB insert
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
							
			
		  return "redirect:notice.do";
		}
		
		
		
		
		//글수정하기 서비스 (select ) 화면
		public Notice noticeEdit(String seq ) {
			Notice notice=null;
			try {
				 NoticeDao noticedao =  sqlsession.getMapper(NoticeDao.class);  //POINT	
			     notice =  	noticedao.getNotice(seq);
			} catch( Exception e) {
					e.printStackTrace();
			} 
			return notice;
		}
	
	
		
		//글수정하기 서비스 (update ) 처리 
		public String noticeEdit(Notice n , HttpServletRequest request) {
			 
		    //파일 업로드 가능
		    String filename =n.getFile().getOriginalFilename();
			String path = request.getServletContext().getRealPath("/customer/upload"); //배포된 서버 경로 
			String fpath = path + "\\" + filename;
			System.out.println(fpath);
			
			FileOutputStream fs =null;
			try {
				     fs = new FileOutputStream(fpath);
				     fs.write(n.getFile().getBytes());
				     
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				 try {
					fs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			//파일명 (DTO)
			n.setFileSrc(filename);
		
			try {
				    NoticeDao noticedao =  sqlsession.getMapper(NoticeDao.class);  //POINT	
					noticedao.update(n);  //DB insert
				} catch (Exception e) {
					e.printStackTrace();
				} 
		//처리가 끝나면 상세 페이지로 : redirect  글번호를 가지고 ....
		return "redirect:noticeDetail.do?seq="+n.getSeq();    //서버에게 새 요청 ....
	}
		
		//글삭제하기 서비스
		public String noticeDel(String  seq) {
			NoticeDao noticedao =  sqlsession.getMapper(NoticeDao.class);
			try {
				noticedao.delete(seq);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:notice.do";
			
		}
	
}
