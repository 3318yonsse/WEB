package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.loginDAO;
import DTO.loginDTO;

public class PwFindCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String findId = request.getParameter("findId");
		String findName = request.getParameter("findName");
		String findEmail = request.getParameter("findEmail");
		String getPw = null;
		
		loginDAO dao = new loginDAO();
		
		getPw= dao.findPwChk(findId, findName, findEmail,response);
		
		
		
		request.setAttribute("getPw", getPw);
		
	}

}
