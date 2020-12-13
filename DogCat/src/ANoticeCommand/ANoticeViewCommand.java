package ANoticeCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.aNoticeDAO;
import DAO.aPostDAO;
import DTO.aNoticeDTO;
import DTO.aPostDTO;
import DTO.noticeDTO;

public class ANoticeViewCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub
		String mId = request.getParameter("mId");
		aNoticeDAO dao = new aNoticeDAO();
		String nNo = request.getParameter("nNo");
		dao.addview(nNo);
		aNoticeDTO dto = dao.noticeview(nNo);
		
		ArrayList<aNoticeDTO> dtocomment = dao.commentlist(nNo);
		request.setAttribute("commentlist", dtocomment);
		dao.commentlist(nNo);

		request.setAttribute("anotice_view", dto);
		
		session.setAttribute("nNo", nNo);
		session.setAttribute("mId", mId);
			
	}

}
