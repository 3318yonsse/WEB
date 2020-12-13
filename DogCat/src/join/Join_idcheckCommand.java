package join;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.joinDAO;

public class Join_idcheckCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String chkId = request.getParameter("chkId");
		
		joinDAO joinDAO =new joinDAO();
		int rs = joinDAO.idCheck(chkId);
		session.setAttribute("rs", rs);
		session.setAttribute("chkId", chkId);
	}

}
