package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.loginDAO;
import DTO.loginDTO;

public class LoginFindCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		String findName = request.getParameter("findName");
		String findEmail = request.getParameter("findEmail");
		
		loginDAO dao = new loginDAO();
		dao.findIdChk(findName, findEmail, response);
		
		loginDTO dto = dao.findIdChk(findName, findEmail, response);
		
		request.setAttribute("findIdChk", dto);
		
				
//		PrintWriter out = response.getWriter();
//		out.print("<script language = 'javascript'>");
//		out.print("alert(getId);");
//		out.print("</script>");
		
		
		
		
	
		
//		System.out.println(getId + "ahdi");
	}
}
