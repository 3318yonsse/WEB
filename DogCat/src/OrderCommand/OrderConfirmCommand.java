package OrderCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.aItemDAO;
import DAO.orderDAO;

public class OrderConfirmCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	throws ServletException, IOException {
		aItemDAO dao = new aItemDAO();
		orderDAO odao = new orderDAO();
		
		int oNo = Integer.parseInt(request.getParameter("oNo"));
		String oName = request.getParameter("oName");
		String oTel = request.getParameter("oTel");
		
		String oToName = request.getParameter("oToName");
		String oToTel = request.getParameter("oToTel");
		String postcode = request.getParameter("postcode");
		String oAddress = ((request.getParameter("oAddress1"))+(" ")+(request.getParameter("oAddress2"))+(" ")+(request.getParameter("oAddress3")));
		String oToContent = request.getParameter("oToContent");
		String oPaymentMethod = request.getParameter("oPaymentMethod");
		
		int stock = Integer.parseInt(request.getParameter("iStock")); 
		int oQty = Integer.parseInt(request.getParameter("oQty"));
		int iNo = Integer.parseInt(request.getParameter("iNo")); 
		int iStock = stock-oQty;
		
		
		System.out.println("oToName = -----------------------------------"+oToName);
		System.out.println("oToName = -----------------------------------"+oToTel);
		System.out.println("oToName = -----------------------------------"+oToName);
		System.out.println("oToName = -----------------------------------"+oAddress);
		System.out.println("oToName = -----------------------------------"+oQty);
		System.out.println("oToName = -----------------------------------"+oToName);
		

		odao.ordermodi(oName, oTel, oToName, oToTel, postcode ,oAddress, 
				oToContent, oPaymentMethod, oNo);
		
		dao.chagestock(iStock,iNo);
		
		request.setAttribute("oNo", oNo);
		
		
		
		
		
	}

}
