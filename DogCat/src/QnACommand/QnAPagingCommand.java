package QnACommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;
import com.mysql.cj.Session;

import DAO.noticeDAO;
import DAO.qnaDAO;
import DTO.noticeDTO;
import DTO.qnaDTO;

public class QnAPagingCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)throws ServletException, IOException{
//		String url = "/main_view.jsp";
		
		qnaDAO qnadao = new qnaDAO();
		ArrayList<qnaDTO> dtos = qnadao.list(request, null);
		int noticeViewRowCount = qnadao.noticeViewRowCount();
		int RowCount = noticeViewRowCount;
		
		
		int nowPage = Integer.parseInt(request.getParameter("page"));
		int pageRow=10;
		int beginNum=(nowPage*pageRow)-pageRow;
		int endNum=(nowPage*pageRow)-1;
		int totalPage=(RowCount/pageRow);
		if(RowCount%10!=0) {
			totalPage++;
		}
		
//		for(int i=1;i<=totalPage;i++) {
//			if(nowPage==i) {
//				beginNum=(i*pageRow)-pageRow;
//				endNum=(i*pageRow)-1;
//			}
//		}
		
		
		// 리스트
		request.setAttribute("list", dtos);
		//페이지
		request.setAttribute("beginNum", beginNum);
		request.setAttribute("endNum", endNum);
		request.setAttribute("totalPage", totalPage);
	}

	
}
