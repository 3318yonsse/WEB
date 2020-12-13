package OrderCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.orderDAO;

public class OrderCancelCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int oNo = Integer.parseInt(request.getParameter("oNo"));
		
		System.out.println(oNo);
		orderDAO dao = new orderDAO();
		dao.ordercancel(oNo);
	}

}
