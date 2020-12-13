package QnACommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;
import com.mysql.cj.Session;

import DAO.aQnaDAO;
import DAO.qnaDAO;

public class QnADelCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String qNo = request.getParameter("qNo");	
		
		
		qnaDAO dao = new qnaDAO();
		
		dao.qnaDelete(qNo);
	}
}
