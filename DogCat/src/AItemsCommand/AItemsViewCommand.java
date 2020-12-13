package AItemsCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.aItemDAO;
import DAO.aPostDAO;
import DTO.aItemDTO;
import DTO.aPostDTO;

public class AItemsViewCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub
		aItemDAO dao = new aItemDAO();
		String iNo = request.getParameter("iNo");
		dao.addview(iNo);
		aItemDTO dto = dao.itemview(iNo);

		request.setAttribute("aitems_view", dto);
			
	}

}
