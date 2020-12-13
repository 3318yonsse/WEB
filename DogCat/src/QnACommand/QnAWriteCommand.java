package QnACommand;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;
import com.mysql.cj.Session;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import DAO.aPostDAO;
import DAO.qnaDAO;
import DTO.qnaDTO;

public class QnAWriteCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
			
		String directory = request.getServletContext().getRealPath("/upload/"); 
   		int maxSize = 300 * 300 * 10;
   		String encoding = "UTF-8";
   		
   		//사용자가 전송한 파일 'upload '파일로 간다.
   		MultipartRequest multi;
   		String nowID = (String)session.getAttribute("mId");
		try {
			multi = new MultipartRequest(request, directory, maxSize, encoding, new DefaultFileRenamePolicy());
			String qCategory = multi.getParameter("qCategory"); //jsp에 있는 내용을 여기서 받아주는 것이다.
			String qTitle = multi.getParameter("qTitle"); //jsp에 있는 내용을 여기서 받아주는 것이다.
			String qContent = multi.getParameter("qContent");
			
			//file 이란 이름은 wineList.jsp에 있는 name ="file" / DB에 넣기위해 스트링 변환
			String qImage = multi.getOriginalFileName("file");
			String qImageReal = multi.getFilesystemName ("file");
			
			// 확장자 정해주기
			if(qImage.endsWith(".doc") && qImage.endsWith(".hwp") &&
					qImage.endsWith(".pdf") && qImage.endsWith(".xls")){
				File file = new File(directory + qImageReal);
				file.delete(); 
				
				System.out.println("업로드할 수 없는 확장자 입니다.");
			}else{
				
				qnaDAO dao = new qnaDAO();
				dao.qnawrite(qCategory, qTitle, qContent,qImage, qImageReal,nowID);
				System.out.println("파일명 : " + qImage + "<br>"); 
				System.out.println("실제 파일명 : " + qImageReal + "<br>"); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		qnaDAO dao = new qnaDAO();
//		dao.qnawrite(qCategory,qTitle,qContent,nowID);
		
		
		
		
//			String qCategory = request.getParameter("qCategory");
//			String qTitle = request.getParameter("qTitle");
//			String qContent = request.getParameter("qContent");
		
	}
}
