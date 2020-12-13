package mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.aNoticeDAO;
import DAO.listDAO;

public class CommentDelCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String pwcNo = request.getParameter("pwcNo");
		
		
		listDAO dao = new listDAO();
		
		dao.commetnDel(pwcNo);
	}
		
		
	

}
