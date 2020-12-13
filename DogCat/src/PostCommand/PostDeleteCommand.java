package PostCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import DAO.postDAO;

public class PostDeleteCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		String pNo = request.getParameter("pNo");
		
		
		postDAO dao = new postDAO();
		
		dao.postdelete(pNo);
	}

}
