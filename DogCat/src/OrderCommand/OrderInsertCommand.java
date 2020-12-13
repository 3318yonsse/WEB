package OrderCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.orderDAO;
import DTO.orderDTO;

public class OrderInsertCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		orderDAO dao = new orderDAO();

		String nowId = (String)session.getAttribute("mId");
		int iNo = Integer.parseInt(request.getParameter("iNo"));
		String iImage = request.getParameter("iImage");
		String iName = request.getParameter("iName");
		int oQty = Integer.parseInt(request.getParameter("oQty"));
		int iPrice = Integer.parseInt(request.getParameter("iPrice"));
		
		int oSum = (iPrice * oQty) + 2500;
		
		dao.orderSum(iNo, oQty, oSum, nowId);
		

		orderDTO Orderlist = dao.orderlist(oSum);
		orderDTO itemlist = dao.itemlist(iNo);
		orderDTO NOWID = dao.infolist(nowId);
		
		request.setAttribute("Orderlist", Orderlist);
		request.setAttribute("itemlist", itemlist);
		request.setAttribute("NOWID", NOWID);
		
		
	}

}
