package dao;

import java.sql.SQLException;
import vo.Member;



public interface MemberDao {
	
	//회원조회
	public Member getMember(String uid) throws ClassNotFoundException, SQLException;
	
	//회원가입
	public int insert(Member member) throws ClassNotFoundException, SQLException;
	
}
