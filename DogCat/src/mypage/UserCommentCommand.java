package mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.listDAO;
import DTO.listDTO;

public class UserCommentCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	
		String nowID = (String) session.getAttribute("mId");
		listDAO listdao = new listDAO();
		ArrayList<listDTO> dtos = listdao.commentlist(nowID);
		
		request.setAttribute("commentlist", dtos);
		
		System.out.println(nowID);
		
		int noticeViewRowCount = listdao.commentlistViewRowCount(nowID);
		int RowCount = noticeViewRowCount;
		
		int totalPage=(noticeViewRowCount/10);
		if(noticeViewRowCount%10!=0) {
			totalPage++;
		}

		int beginNum=0;
		int endNum=9;
		
		
		request.setAttribute("beginNum", beginNum);
		request.setAttribute("endNum", endNum);
		request.setAttribute("totalPage", totalPage);
	
	}

}
