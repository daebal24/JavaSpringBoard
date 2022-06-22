package service;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDao;
import vo.Member;

@Service
public class MemberService 
{
	private SqlSession sqlsession;
	
	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}

	public Member getMember(String userid) throws ClassNotFoundException, SQLException
	{
		Member m = null;
		MemberDao memberdao = sqlsession.getMapper(MemberDao.class);
		m=memberdao.getMember(userid);
		return m;
	}
	
	public int insert(Member m) throws ClassNotFoundException, SQLException
	{
		int result = 0;
		MemberDao memberdao = sqlsession.getMapper(MemberDao.class);
		result = memberdao.insert(m);
		return result;
	}
	
}
