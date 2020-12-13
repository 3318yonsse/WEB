package APostCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.aPostDAO;
import DTO.aPostDTO;

public class APostViewCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub
		aPostDAO dao = new aPostDAO();
		int pNo = Integer.parseInt(request.getParameter("pNo"));
		dao.addview(pNo);
		aPostDTO dto = dao.postview(pNo);
		
		ArrayList<aPostDTO> dtocomment = dao.commentlist(pNo);
		request.setAttribute("commentlist", dtocomment);
		
		
		
		String pmId =request.getParameter("mId");
			
		request.setAttribute("post_view", dto);
		session.setAttribute("pNo", pNo);
		session.setAttribute("mId", pmId);
	}

}
