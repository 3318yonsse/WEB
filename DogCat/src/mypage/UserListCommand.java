package mypage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;
import com.mysql.cj.Session;

import DAO.listDAO;
import DAO.postDAO;
import DAO.qnaDAO;
import DTO.listDTO;
import DTO.postDTO;
import DTO.qnaDTO;

public class UserListCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

		
		String nowID = (String) session.getAttribute("mId");
		
		listDAO listdao1 = new listDAO();
		
		ArrayList<listDTO> dtos1 = listdao1.postlist(request,nowID);
		
		
		
		
		//--------------
		
		request.setAttribute("postlist", dtos1);
		
		int noticeViewRowCount = listdao1.postlistViewRowCount(nowID);
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