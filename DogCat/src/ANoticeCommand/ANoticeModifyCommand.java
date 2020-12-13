package ANoticeCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.aNoticeDAO;

public class ANoticeModifyCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub
		String nNo = request.getParameter("nNo");
		String nTitle = request.getParameter("nTitle");
		String nContent = request.getParameter("nContent");
		
		aNoticeDAO dao = new aNoticeDAO();
		
		dao.Noticemodi(nTitle, nContent, nNo);
	}

}
