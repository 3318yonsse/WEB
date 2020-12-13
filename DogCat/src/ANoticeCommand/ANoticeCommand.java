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

public class ANoticeCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub
		aNoticeDAO dao = new aNoticeDAO();
		ArrayList<aNoticeDTO> dtos = dao.list(request);
		
		aNoticeDTO dto = dao.mIdview();
	
		int noticeViewRowCount = dao.noticeViewRowCount();
		int RowCount = noticeViewRowCount;
		
		int totalPage=(noticeViewRowCount/10);
		if(noticeViewRowCount%10!=0) {
			totalPage++;
		}

		int beginNum=0;
		int endNum=9;
		
		request.setAttribute("MID", dto);
		
		request.setAttribute("list", dtos);
		request.setAttribute("beginNum", beginNum);
		request.setAttribute("endNum", endNum);
		request.setAttribute("totalPage", totalPage);
	
	}

}
