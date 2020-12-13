package APostCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.aPostDAO;

public class ACommentDelteCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		aPostDAO dao = new aPostDAO();
		String pwcNo = request.getParameter("pwcNo");

		
		dao.commentdelete(pwcNo);

	}

}
