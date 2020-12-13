package APostCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.aPostDAO;
import DAO.postDAO;

public class APCommentWriteCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pNo = request.getParameter("pNo");
		String pwcContent = request.getParameter("pwcComment"); //jsp에 있는 내용을 여기서 받아주는 것이다.
		String mId = (String)session.getAttribute("mId");
		
		
		aPostDAO dao = new aPostDAO();
		dao.pcommentWrite(pNo, pwcContent);
		
	
	}

}
