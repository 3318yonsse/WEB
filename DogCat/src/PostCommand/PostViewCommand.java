package PostCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.jsplec.command.command;

import DAO.postDAO;
import DTO.noticeDTO;
import DTO.postDTO;

public class PostViewCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		postDAO dao = new postDAO();
		String pNo = request.getParameter("pNo");
		dao.addview(pNo);
		postDTO dto = dao.postview(pNo);

				
		ArrayList<postDTO> dtocomment = dao.commentlist(pNo);
		request.setAttribute("commentlist", dtocomment);
		
		
		
		String pmId =request.getParameter("mId");
		request.setAttribute("post_view", dto);
		session.setAttribute("pmId", pmId);	
			
		
		
	}

}
