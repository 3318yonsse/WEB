package AItemsCommand;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import DAO.aItemDAO;
import DAO.aPostDAO;

public class AItemsModiCommand implements command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		// TODO Auto-generated method stub
	
		
		
		
		
		String directory = request.getServletContext().getRealPath("/upload/"); 
   		int maxSize = 500 * 500 * 10;
   		String encoding = "UTF-8";
   		
   		//사용자가 전송한 파일 'upload '파일로 간다.
   		MultipartRequest multi;
   		
		try {
			multi = new MultipartRequest(request, directory, maxSize, encoding, new DefaultFileRenamePolicy());
			
			int iNo = Integer.parseInt(multi.getParameter("iNo"));
			String iName = multi.getParameter("iName");
			String iNation = multi.getParameter("iNation");
			String iCategory = multi.getParameter("iCategory");
			int iPrice = Integer.parseInt(multi.getParameter("iPrice"));
			String iInfo = multi.getParameter("iInfo");
			int iStock = Integer.parseInt(multi.getParameter("iStock"));
			String iState = multi.getParameter("iState");
			
			
			
			
			//file 이란 이름은 wineList.jsp에 있는 name ="file" / DB에 넣기위해 스트링 변환
			String iImage = multi.getOriginalFileName("file");
			String iImageReal = multi.getFilesystemName ("file");
			
			String iImage2 = multi.getOriginalFileName("file1");
			String iImageReal2 = multi.getFilesystemName ("file1");
			
			// 확장자 정해주기
			if(iImage.endsWith(".doc") && iImage.endsWith(".hwp") &&
					iImage.endsWith(".pdf") && iImage.endsWith(".xls")){
				File file = new File(directory + iImageReal);
				file.delete(); 
				
				System.out.println("업로드할 수 없는 확장자 입니다.");
			}else{
				
				aItemDAO dao = new aItemDAO();
				
				dao.itemmodi(iNo, iImage, iImageReal, iImage2, iImageReal2,iName, iNation, iCategory, iPrice, iInfo, iStock, iState);
				System.out.println("파일명 : " + iImage + "<br>"); 
				System.out.println("실제 파일명 : " + iImageReal + "<br>"); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
