package mypage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;
import com.mysql.cj.Session;

import DAO.orderlistDAO;
import DTO.aItemDTO;
import DTO.orderlistDTO;

public class OrderListCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

		
		String nowID = (String)session.getAttribute("mId");
		orderlistDAO dao = new orderlistDAO();
		ArrayList<orderlistDTO> dtos = dao.list(request,nowID);
		

		
		request.setAttribute("list", dtos);
		
		
		int noticeViewRowCount = dao.orderlistViewRowCount(nowID);
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