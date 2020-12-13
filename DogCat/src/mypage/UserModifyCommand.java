package mypage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;
import com.mysql.cj.Session;

import DAO.memberDAO;
import DTO.memberDTO;

public class UserModifyCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		String nowID = (String)session.getAttribute("mId");
		String mPw = request.getParameter("mPw");
		String mEmail = request.getParameter("mEmail");
		String mTel = request.getParameter("mTel");
		String mAddress = request.getParameter("mAddress1")+request.getParameter("mAddress2")+request.getParameter("mAddress3");
		String mBirth = request.getParameter("mBirth");

		memberDAO dao = new memberDAO();
		
		dao.usermodi(mPw, mEmail, mTel,mAddress,mBirth,nowID);
	}
}
