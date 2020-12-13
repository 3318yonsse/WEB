package AmemberCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.aMemberDAO;

public class AMemberDeleteCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub

		String mNo = request.getParameter("mNo");
		
		aMemberDAO dao = new aMemberDAO();
		dao.delete(mNo);
	}

}
