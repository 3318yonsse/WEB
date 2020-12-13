package APostCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.aPostDAO;

public class APostDeleteCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub
		String pNo = request.getParameter("pNo");
		
		
		aPostDAO dao = new aPostDAO();
		
		dao.postdelete(pNo);
	}

}
