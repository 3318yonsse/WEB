package join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;
import com.mysql.cj.Session;

import DAO.joinDAO;
import DTO.joinDTO;

public class JoinCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String mId = request.getParameter("mId"); //jsp에 있는 내용을 여기서 받아주는 것이다.
		String mPw = request.getParameter("mPw");
		String mEmail = request.getParameter("mEmail");
		String mName = request.getParameter("mName");
		String postcode = request.getParameter("postcode");
		String mAddress = request.getParameter("mAddress");
		String mTel = request.getParameter("mTel");
		String mBirth = request.getParameter("mBirth");
		String mGender = request.getParameter("mGender");
		String mState = request.getParameter("mState");
		String mDate = request.getParameter("mDate");
	
		 joinDAO joinDAO =new joinDAO();
		 joinDAO.join(mId,mPw,mEmail,mName,postcode,mAddress,mTel,mBirth,mGender,mState,mDate);
	}
}
