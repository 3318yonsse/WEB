package mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.memberDAO;

public class UserOutCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String nowId = (String) session.getAttribute("mId");
		
		System.out.println("------------------nowId = "+ nowId);
		memberDAO dao = new memberDAO();
		dao.memberOut(nowId);
		
		
		
	}

}
