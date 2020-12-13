package AQnAListCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;
import com.mysql.cj.Session;

import DAO.aQnaDAO;

public class AQnAModiCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
		String qComment = request.getParameter("qComment");
		String qNo = request.getParameter("qNo");
		
		aQnaDAO dao = new aQnaDAO();
		
		dao.qnamodi(qComment, qNo);
	}
}
