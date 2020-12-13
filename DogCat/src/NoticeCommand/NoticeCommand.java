package NoticeCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;
import com.mysql.cj.Session;

import DAO.noticeDAO;
import DTO.noticeDTO;

public class NoticeCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response , HttpSession session)throws ServletException, IOException{
//		String url = "/main_view.jsp";
		
		noticeDAO dao = new noticeDAO();
		ArrayList<noticeDTO> dtos = dao.list(request);
		int noticeViewRowCount = dao.noticeViewRowCount();
		int RowCount = noticeViewRowCount;
		
		int totalPage=(noticeViewRowCount/10);
		if(noticeViewRowCount%10!=0) {
			totalPage++;
		}

		int beginNum=0;
		int endNum=9;
		
		request.setAttribute("list", dtos);
		request.setAttribute("beginNum", beginNum);
		request.setAttribute("endNum", endNum);
		request.setAttribute("totalPage", totalPage);
	}

	
}
