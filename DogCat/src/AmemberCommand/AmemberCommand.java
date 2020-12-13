package AmemberCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.aMemberDAO;
import DTO.aMemberDTO;

public class AmemberCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub

		aMemberDAO dao = new aMemberDAO();
		ArrayList<aMemberDTO> dtos = dao.list(request);  
		// ---화면에 뜨기 전 부분까지다.
		
	
		
		int noticeViewRowCount = dao.noticeViewRowCount();
		int RowCount = noticeViewRowCount;
		
		int totalPage=(noticeViewRowCount/10);
		if(noticeViewRowCount%10!=0) {
			totalPage++;
		}

		int beginNum=0;
		int endNum=9;
		
		
		request.setAttribute("mList", dtos); // 화면에 띄운다.
		request.setAttribute("beginNum", beginNum);
		request.setAttribute("endNum", endNum);
		request.setAttribute("totalPage", totalPage);
	
		
	}

}
