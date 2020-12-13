package QnACommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;
import com.mysql.cj.Session;

import DAO.qnaDAO;
import DTO.qnaDTO;

public class QnAViewCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

		
		qnaDAO dao = new qnaDAO();
		String qNo = request.getParameter("qNo");
		dao.addview(qNo);;
		qnaDTO dto = dao.qnaview(qNo);
		
		request.setAttribute("qna_view", dto);
	}
}
