package AOrderCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.aMemberDAO;
import DAO.aOrderDAO;

public class AOrderDeleteCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub

		String oNo = request.getParameter("oNo");
		
		aOrderDAO dao = new aOrderDAO();
		dao.orderdelete(oNo);
	}

}
