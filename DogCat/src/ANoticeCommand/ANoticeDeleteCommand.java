package ANoticeCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.aNoticeDAO;
import DAO.aPostDAO;

public class ANoticeDeleteCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String nNo = request.getParameter("nNo");
		
		
		aNoticeDAO dao = new aNoticeDAO();
		
		dao.noticedelete(nNo);
	}

}
