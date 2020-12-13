package ANoticeCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.aNoticeDAO;
import DAO.aPostDAO;
import DTO.aNoticeDTO;
import DTO.aPostDTO;

public class ANoticeWriteCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub
		aNoticeDAO dao = new aNoticeDAO();
		String nTitle = request.getParameter("nTitle");
		String nContent = request.getParameter("nContent");
		
		dao.noticeWrite(nTitle, nContent);

	}

}
