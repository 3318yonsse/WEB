package PostCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.postDAO;
import DTO.postDTO;

public class PostListCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

			postDAO dao = new postDAO();
			ArrayList<postDTO> dtos = dao.list(request);
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
