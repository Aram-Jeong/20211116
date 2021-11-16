package co.aram.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.aram.prj.comm.Command;
import co.aram.prj.member.service.MemberService;
import co.aram.prj.member.service.MemberVO;
import co.aram.prj.member.serviceImpl.MemberServiceImpl;

public class LoginCommand implements Command {
	
	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession(); // 서버가 가지고 있는 세션객체 가져옴
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password")); // home.jsp의 name 값들
		vo = memberDao.memberSelect(vo);
		String message = null;
		if(vo != null) {
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			session.setAttribute("author", vo.getAuthor());
			message = vo.getName() + "님 환영합니다.";
 		}else {
 			message = "아이디 또는 패스워드가 틀립니다.";
 		}
		request.setAttribute("message", message); // 결과를 담아 보낼 때
		
		return "member/memberLogin"; // 보여줄 페이지
	}

}
