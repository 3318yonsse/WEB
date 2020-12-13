package NoticeCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.noticeDAO;
import DAO.postDAO;



public class CommentWriteCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String nNo = request.getParameter("nNo");
		String wcContent = request.getParameter("wcContent"); //jsp에 있는 내용을 여기서 받아주는 것이다.
		String mId = (String)session.getAttribute("mId");
		noticeDAO dao = new noticeDAO();
		dao.commentWrite(nNo, wcContent, mId);
	
		
		session.setAttribute("pmId", mId);
		
		
	}

}
