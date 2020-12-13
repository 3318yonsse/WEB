package QnACommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;
import com.mysql.cj.Session;

import DAO.noticeDAO;
import DAO.qnaDAO;
import DTO.noticeDTO;
import DTO.qnaDTO;

public class QnACommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

		String nowID = (String)session.getAttribute("mId");
		qnaDAO qnadao = new qnaDAO();
		ArrayList<qnaDTO> dtos = qnadao.list(request,nowID);
		int noticeViewRowCount = qnadao.noticeViewRowCount();
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
	
	
