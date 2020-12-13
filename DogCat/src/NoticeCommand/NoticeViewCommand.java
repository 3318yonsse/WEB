package NoticeCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;
import com.mysql.cj.Session;

import DAO.noticeDAO;
import DTO.noticeDTO;
import DTO.postDTO;

public class NoticeViewCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

		
	
		
		noticeDAO dao = new noticeDAO();
		String nNo = request.getParameter("nNo");
		dao.addview(nNo);
		noticeDTO dto = dao.noticeview(nNo);
		
		ArrayList<noticeDTO> dtocomment = dao.commentlist(nNo);
		request.setAttribute("commentlist", dtocomment);
		dao.commentlist(nNo);
		
		
		request.setAttribute("notice_view", dto);
		
		
		
	}
	
}
