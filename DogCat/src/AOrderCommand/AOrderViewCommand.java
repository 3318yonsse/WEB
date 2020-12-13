package AOrderCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.aOrderDAO;
import DAO.aQnaDAO;
import DTO.aOrderDTO;
import DTO.aQnaDTO;

public class AOrderViewCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub
		aOrderDAO dao = new aOrderDAO();
		int oNo = Integer.parseInt(request.getParameter("oNo"));
		
		aOrderDTO dto = dao.orderview(oNo);

		request.setAttribute("aorder_view", dto);
	}

}
