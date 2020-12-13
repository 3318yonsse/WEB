package mypage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;
import com.mysql.cj.Session;

import DAO.memberDAO;
import DTO.memberDTO;

public class UserInfoCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		
		String nowID = (String)session.getAttribute("mId");
		memberDAO dao = new memberDAO();
		ArrayList<memberDTO> dtos = dao.list(nowID);
		
		request.setAttribute("member", dtos);

	}
}
