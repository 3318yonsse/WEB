package ANoticeCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.aNoticeDAO;
import DAO.noticeDAO;

public class ACommentWriteCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		
		String nNo = request.getParameter("nNo");
		String wcContent = request.getParameter("wcContent"); //jsp에 있는 내용을 여기서 받아주는 것이다.
		String mId = (String)session.getAttribute("mId");
		System.out.println(mId);
		System.out.println(nNo);
		System.out.println(wcContent);
		aNoticeDAO dao = new aNoticeDAO();
		dao.commentWrite(nNo, wcContent, mId);
	}

}
