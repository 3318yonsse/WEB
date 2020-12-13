package AOrderCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.aOrderDAO;
import DAO.aQnaDAO;

public class AOrderModifyCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub
		String oState = request.getParameter("oState");
		int oNo = Integer.parseInt(request.getParameter("oNo"));
		
		aOrderDAO dao = new aOrderDAO();
		System.out.println(oState);
		System.out.println(oNo);
		
		dao.ordermodi(oState, oNo);
	}

}
