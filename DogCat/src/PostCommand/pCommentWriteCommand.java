package PostCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;
import com.sun.javafx.css.CssError.StringParsingError;

import DAO.postDAO;



public class pCommentWriteCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String pNo = request.getParameter("pNo");
		String pwcContent = request.getParameter("pwcComment"); //jsp에 있는 내용을 여기서 받아주는 것이다.
		String mId = (String)session.getAttribute("mId");
		
		
		postDAO dao = new postDAO();
		dao.pcommentWrite(pNo, pwcContent, mId);
		System.out.println(pwcContent);
		
		session.setAttribute("pmId", mId);
	
		
	}

}
