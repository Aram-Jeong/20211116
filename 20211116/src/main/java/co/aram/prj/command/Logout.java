package co.aram.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.aram.prj.comm.Command;

public class Logout implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃 처리 세션을 끊으면 된다
		HttpSession session = request.getSession();
		session.invalidate();
		return "home.do";
	}

}
