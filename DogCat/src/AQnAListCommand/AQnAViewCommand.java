package AQnAListCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;
import com.mysql.cj.Session;

import DAO.aQnaDAO;
import DTO.aQnaDTO;

public class AQnAViewCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		aQnaDAO dao = new aQnaDAO();
		String qNo = request.getParameter("qNo");
		dao.addview(qNo);
		
		aQnaDTO dto = dao.QNAview(qNo);

		request.setAttribute("aqna_view", dto);
	}
	
}