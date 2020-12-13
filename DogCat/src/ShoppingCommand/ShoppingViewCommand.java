package ShoppingCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.aItemDAO;
import DAO.aPostDAO;
import DAO.shoppingDAO;
import DTO.aItemDTO;
import DTO.aPostDTO;
import DTO.shoppingDTO;

public class ShoppingViewCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub
		shoppingDAO dao = new shoppingDAO();
		String iNo = request.getParameter("iNo");
		dao.addview(iNo);
		shoppingDTO dto = dao.shoppingview(iNo);
		String iName = request.getParameter("iName");
		String iPrice = request.getParameter("iPrice");
		String nowId = (String)session.getAttribute("mId");

		
		request.setAttribute("shopping_view", dto);
		
			
	}

}
