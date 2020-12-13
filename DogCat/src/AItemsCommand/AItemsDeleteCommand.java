package AItemsCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.aItemDAO;

public class AItemsDeleteCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub
		
		String iNo = request.getParameter("iNo");
		
		
		aItemDAO dao = new aItemDAO();
		
		dao.itemdelete(iNo);
	}

}
