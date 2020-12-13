package com.jsplec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.command.command;

import AItemsCommand.AItemPagingCommand;
import AItemsCommand.AItemsCommand;
import AItemsCommand.AItemsDeleteCommand;
import AItemsCommand.AItemsModiCommand;
import AItemsCommand.AItemsViewCommand;
import AItemsCommand.AItemsWriteCommand;
import ANoticeCommand.ACommentWriteCommand;
import ANoticeCommand.ANCommentDelteCommand;
import ANoticeCommand.ANoticeCommand;
import ANoticeCommand.ANoticeDeleteCommand;
import ANoticeCommand.ANoticeModifyCommand;
import ANoticeCommand.ANoticeViewCommand;
import ANoticeCommand.ANoticeWriteCommand;
import ANoticeCommand.AnoticePagingCommand;
import AOrderCommand.AOrderCommand;
import AOrderCommand.AOrderDeleteCommand;
import AOrderCommand.AOrderModifyCommand;
import AOrderCommand.AOrderPagingCommand;
import AOrderCommand.AOrderViewCommand;
import APostCommand.ACommentDelteCommand;
import APostCommand.APCommentWriteCommand;
import APostCommand.APostCommand;
import APostCommand.APostDeleteCommand;
import APostCommand.APostModiCommand;
import APostCommand.APostPagingCommand;
import APostCommand.APostViewCommand;
import APostCommand.APostWriteCommand;
import AQnAListCommand.AQnADeleteCommand;
import AQnAListCommand.AQnAListCommand;
import AQnAListCommand.AQnAModiCommand;
import AQnAListCommand.AQnAPagingCommand;
import AQnAListCommand.AQnAViewCommand;
import AmemberCommand.AMemberDeleteCommand;
import AmemberCommand.AMemberModifyCommand;
import AmemberCommand.AMemberViewCommand;
import AmemberCommand.AmemberCommand;
import AmemberCommand.AmemberPagingCommand;
import MainCommand.MainCommand;
import NoticeCommand.CommentWriteCommand;
import NoticeCommand.NoticeCommand;
import NoticeCommand.NoticePagingCommand;
import NoticeCommand.NoticeViewCommand;
import OrderCommand.OrderCancelCommand;

import OrderCommand.OrderConfirmCommand;
import OrderCommand.OrderInsertCommand;
import PostCommand.PostDeleteCommand;
import PostCommand.PostListCommand;
import PostCommand.PostModifyCommand;
import PostCommand.PostPagingCommand;
import PostCommand.PostViewCommand;
import PostCommand.PostWriteCommand;
import PostCommand.pCommentWriteCommand;
import QnACommand.QnACActCommand;
import QnACommand.QnACommand;
import QnACommand.QnADelCommand;
import QnACommand.QnAModiCommand;
import QnACommand.QnAPagingCommand;
//import QnACommand.QnAMyListCommand;
//import QnACommand.QnAMyViewCommand;
import QnACommand.QnAViewCommand;
import QnACommand.QnAWriteCommand;
import ShopCatCommand.ShopCatBeautyCommand;
import ShopCatCommand.ShopCatFoodCommand;
import ShopCatCommand.ShopCatSnackCommand;
import ShopCatCommand.ShopCatTotalCommand;
import ShopDetailCommand.ShopDetailCommand;
import ShoppingCommand.ShoppingCatCommand;
import ShoppingCommand.ShoppingCatPagingCommand;
import ShoppingCommandOld.ShoppingCommand;
import ShoppingCommandOld.ShoppingPagingCommand;
import ShoppingCommandOld.ShoppingViewCommand;
import cart.CartCommand;
import join.JoinActionCommand;
import join.JoinCommand;
import join.Join_idcheckComCommand;
import join.Join_idcheckCommand;
import login.LoginActionCommand;
import login.LoginFindCommand;
import login.PwFindCommand;
import logout.LogOutCommand;
import mypage.CommentDelCommand;
import mypage.OrderListCommand;
import mypage.UserCommentCommand;
import mypage.UserCommentPagingCommand;
import mypage.UserInfoCommand;
import mypage.UserModifyCommand;
import mypage.UserOrderListPagingCommand;
import mypage.UserOutCommand;
import mypage.UserListCommand;
import mypage.UserListDelCommand;
import mypage.UserListPagingCommand;



/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.cnd")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	// -----------------------------------------------------------
	
		private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("actionDo");
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			
			
			//***.do만 빼오기 - 가변적인 IP주소때문에
			String uri = request.getRequestURI();
			// /MVCBoard/aaa.do
			String conPath = request.getContextPath();
			// /MVCBoard
			String com = uri.substring(conPath.length());
			
			command command = null;
			String viewPage = null;                                                                                                                                                                                                                                                                                              
			
			
			switch (com) {
			
			// -------------------------------//
			//                메인			  //
			// -------------------------------//
			
			
			case ("/main.cnd") : // 게시판 전부 보이기
				command = new MainCommand();
				command.execute(request, response, session);
				viewPage = "main.jsp";
				break;
				
			case ("/admin.cnd") : 
				viewPage = "admin.jsp";
				break;	
				
//admin-------------------------------------------------//
			
				// -------------------------------//
				//       회원 관리					  //
				// -------------------------------//
					
				
					 
					// 관리자 회원(리스트)페이지 [select]
				case ("/amember.cnd") : 
					command = new AmemberCommand();
					command.execute(request, response, session);
					viewPage = "amember.jsp";
					break;
					
				// 관리자 회원 정보 보기 페이지 [select]
				case("/amember_view.cnd"): 
					command = new AMemberViewCommand();
					command.execute(request, response, session);
					viewPage = "amember_view.jsp";
					break;	
				
				// 관리자 회원 정보 수정 페이지 [update]
				case("/amember_modi.cnd"): 
					command = new AMemberModifyCommand();
					command.execute(request, response, session);
					viewPage = "amember.jsp";
					break;	
					
				
				// 관리자 회원 정보 탈퇴 페이지 [update]
				case("/amember_del.cnd"): 
					command = new AMemberDeleteCommand();
					command.execute(request, response, session);
					viewPage = "amember.cnd";
					break;	
					
					// 관리자 상품 페이징 [delete]
				case("/amemberPaging.cnd"): 
					command = new AmemberPagingCommand();
					command.execute(request, response, session);
					viewPage = "amember.jsp";
					break;		
				
					
				// -------------------------------//
				//       공지사항 관리				  //
				// -------------------------------//
			
					// 관리자 공지(리스트) 페이지 [select]
				case ("/anotice.cnd") : 
					command = new ANoticeCommand();
					command.execute(request, response, session);
					viewPage = "anotice.jsp";
					break;
					
				 
				// 관리자 공지 내용 보기 페이지 [select]
				case("/anotice_view.cnd"): 
					command = new ANoticeViewCommand();
					command.execute(request, response, session);
					viewPage = "anotice_view.jsp";
					break;	
				
				// 관리자 공지 등록페이지 [insert]
					case ("/anotice_write.cnd") : 
					command = new ANoticeWriteCommand();
					command.execute(request, response, session);
					viewPage = "anotice.cnd";
					break;	
					
				// 관리자 공지 내용 수정 페이지 [update]
				case("/anotice_modi.cnd"):
					command = new ANoticeModifyCommand();
					command.execute(request, response, session);
					viewPage = "anotice.cnd";
					break;	
					
				// 관리자 공지 내용 삭제 페이지 [delete]
				case("/anotice_del.cnd"): 
					command = new ANoticeDeleteCommand();
					command.execute(request, response, session);
					viewPage = "anotice.cnd";
					break;	
					
				// 관리자 상품 페이징 [delete]
				case("/anoticePaging.cnd"): 
					command = new AnoticePagingCommand();
					command.execute(request, response, session);
					viewPage = "anotice.jsp";
					break;	
					
				case ("/ancomment_write.cnd") :
					command = new ACommentWriteCommand();
					command.execute(request, response, session);
					viewPage = "anotice_view.cnd";
					break;
					
					// 관리자 댓글 삭제 [update]
				case("/ancomment_del.cnd"):
					command = new ANCommentDelteCommand();
					command.execute(request, response, session);
					viewPage = "anotice_view.cnd";
					break;	
					
				// -------------------------------//
				//       상품 관리			 	      //
				// -------------------------------//
				
					// 관리자 상품(리스트) 페이지 [select]
					case ("/aitems.cnd") : 
						command = new AItemsCommand();
						command.execute(request, response, session);
						viewPage = "aitems.jsp";
						break;
					
					
					// 관리자 상품 정보 보기 페이지 [select]
					case("/aitems_view.cnd"): 
						command = new AItemsViewCommand();
						command.execute(request, response, session);
						viewPage = "aitems_view.jsp";
						break;	
					
					// 관리자 상품 등록페이지 [insert]
					case ("/aitems_write.cnd") : 
						command = new AItemsWriteCommand();
						command.execute(request, response, session);
						viewPage = "aitems.cnd";
						break;	
						
					// 관리자 상품 내용 수정 페이지 [update]
					case("/aitems_modi.cnd"):
						command = new AItemsModiCommand();
						command.execute(request, response, session);
						viewPage = "aitems.cnd";
						break;	
						
					// 관리자 상품 내용 삭제 페이지 [delete]
					case("/aitems_del.cnd"): 
						command = new AItemsDeleteCommand();
						command.execute(request, response, session);
						viewPage = "aitems.cnd";
						break;	
						
					// 관리자 상품 페이징 [delete]
					case("/aitemsPaging.cnd"): 
						command = new AItemPagingCommand();
						command.execute(request, response, session);
						viewPage = "aitems.jsp";
						break;		

					
				// -------------------------------//
				//       게시판관리			 	      //
				// -------------------------------//
			
					// 관리자 게시판(리스트) 페이지 [select]
				case ("/apost.cnd") : 
					command = new APostCommand();
					command.execute(request, response, session);
					viewPage = "apost.jsp";
					break;
					
				// 관리자 게시판 내용 보기 페이지 [select]
				case("/apost_view.cnd"): 
					command = new APostViewCommand();
					command.execute(request, response, session);
					viewPage = "apost_view.jsp";
					break;	
					
				// 관리자 게시판 등록페이지 [insert]
				case ("/apost_write.cnd") : 
					command = new APostWriteCommand();
					command.execute(request, response, session);
					viewPage = "apost.cnd";
					break;	
					
				// 관리자 게시판 내용 수정 페이지 [update]
				case("/apost_modi.cnd"):
					command = new APostModiCommand();
					command.execute(request, response, session);
					viewPage = "apost.cnd";
					break;	
					// 관리자 댓글 삭제 [update]
				case("/acomment_del.cnd"):
					command = new ACommentDelteCommand();
					command.execute(request, response, session);
					viewPage = "apost_view.cnd";
					break;	
				
				// 관리자 댓글 작성 
				case("/apcomment_write.cnd"): 
					command = new APCommentWriteCommand();
				command.execute(request, response, session);
				viewPage = "apost_view.cnd";
				break;	
				
				// 관리자 게시판 내용 삭제 페이지 [delete]
				case("/apost_del.cnd"): 
					command = new APostDeleteCommand();
					command.execute(request, response, session);
					viewPage = "apost.cnd";
					break;	
				
//					// 관리자 댓글쓰기
//				case ("/acomment_write.cnd") :
//					command = new ACommentWriteCommand();
//				command.execute(request, response, session);
//				viewPage = "apost_view.cnd";
//				break;
				
//				// 관리자 댓글삭제
//				case ("/acomment_del.cnd") :
//					command = new ACommentDeleteCommand();
//					command.execute(request, response, session);
//					viewPage = "apost_view.cnd";
//					break;
					
				//관리자 상품 페이징 [delete]
				case("/apostPaging.cnd"): 
					command = new APostPagingCommand();
					command.execute(request, response, session);	
					viewPage = "apost.jsp";
					break;	
					
				// -------------------------------//
				//       QNA 관리			 	      //
				// -------------------------------//
					
					// 관리자 QNA(리스트) 페이지 [select]
				case ("/aqna.cnd") : 
					command = new AQnAListCommand();
					command.execute(request, response, session);
					viewPage = "aqna.jsp";
					break;
					
				// 관리자 QNA 내용 보기 페이지 [select]
				case("/aqna_view.cnd"): 
					command = new AQnAViewCommand();
					command.execute(request, response, session);
					viewPage = "aqna_view.jsp";
					break;	
					
					
				// 관리자 QNA 내용 수정 페이지 [update]
				case("/aqna_modi.cnd"):
					command = new AQnAModiCommand();
					command.execute(request, response, session);
					viewPage = "aqna.cnd";
					break;	
					
				// 관리자 QNA 내용 삭제 페이지 [delete]
				case("/aqna_del.cnd"): 
					command = new AQnADeleteCommand();
					command.execute(request, response, session);
					viewPage = "aqna.cnd";
					break;
					
				//관리자 상품 페이징 [delete]
				case("/aqnaPaging.cnd"): 
					command = new AQnAPagingCommand();
					command.execute(request, response, session);	
					viewPage = "aqna.jsp";
					break;	
					// -------------------------------//
					//      주문내역 관리					  //
					// -------------------------------//
						
					
						 
						// 관리자 주문(리스트)페이지 [select]
					case ("/aorder.cnd") : 
						command = new AOrderCommand();
						command.execute(request, response, session);
						viewPage = "aorder.jsp";
						break;
						
					// 관리자 주문 정보 보기 페이지 [select]
					case("/aorder_view.cnd"): 
						command = new AOrderViewCommand();
						command.execute(request, response, session);
						viewPage = "aorder_view.jsp";
						break;	
					
					// 관리자 주문 정보 수정 페이지 [update]
					case("/aorder_modi.cnd"): 
						command = new AOrderModifyCommand();
						command.execute(request, response, session);
						viewPage = "aorder.cnd";
						break;	
						
					// 관리자 주문 정보 탈퇴 페이지 [update]
					case("/aorder_del.cnd"): 
						command = new AOrderDeleteCommand();
						command.execute(request, response, session);
						viewPage = "aorder.cnd";
						break;	
						
						// 관리자 상품 페이징 [delete]
					case("/aorderPaging.cnd"): 
						command = new AOrderPagingCommand();
						command.execute(request, response, session);
						viewPage = "aorder.jsp";
						break;		
//navbarmenu---------------------------------------------//	
			
				
			// -------------------------------//
			//       공지사항	(db select)		  //	
			// -------------------------------//
			
					
				// 회원 공지사항(list) 페이지 [select]
			case ("/notice.cnd") : 
				command = new NoticeCommand();
				command.execute(request, response, session);
				viewPage = "notice.jsp";
				break;	
			
				// 회원 공지사항 읽기 페이지 [select]
			case ("/notice_view.cnd") : 					
				command = new NoticeViewCommand();
				command.execute(request, response, session);
				viewPage = "notice_view.jsp";
				break;	
				
			case("/noticePaging.cnd"): // 공지 페이징
				command = new NoticePagingCommand();
				command.execute(request, response, session);
				viewPage = "notice.jsp";
				break;

				//공지사항 댓글
			case ("/comment_write.cnd") :
				command = new CommentWriteCommand();
				command.execute(request, response, session);
				viewPage = "notice_view.cnd";
				break;
				
			// -------------------------------//
			//                쇼핑			  //  		@@ 장바구니 , 조회수   
			// -------------------------------//
	
				
				// 쇼핑 버튼을 눌렀을 때 고양이 전체 페이지로 이동.
				// 고양이-전체 버튼에 form action을 /shopcat_tot.cnd로 줌
				
				//------------강아지---------------//
			case ("/shopping.cnd") : 
				command = new ShoppingCommand();
				command.execute(request, response, session);
				viewPage = "shopping.jsp";
				break;	

				
					// 관리자 상품 페이징 [delete]
			case("/shoppingPaging.cnd"): 
				command = new ShoppingPagingCommand();
				command.execute(request, response, session);
				viewPage = "shopping.jsp";
				break;		
				
				
				
				
				//------------고양이---------------//	
			case ("/shoppingcat.cnd") : 
				command = new ShoppingCatCommand();
				command.execute(request, response, session);
				viewPage = "shoppingcat.jsp";
				break;	

				
					// 관리자 상품 페이징 [delete]
			case("/shoppingcatPaging.cnd"): 
				command = new ShoppingCatPagingCommand();
				command.execute(request, response, session);
				viewPage = "shoppingcat.jsp";
				break;		
				
				
	
				
				
				
				// 관리자 상품 정보 보기 페이지 [select]
			case("/shopping_view.cnd"): 
				command = new ShoppingViewCommand();
			command.execute(request, response, session);
			viewPage = "shopping_view.jsp";
			break;	
				

				// -------------------------------//
				//                주문작성			  //
				// -------------------------------//
				
				
				
				// 주문No 넘기기 [Select] 
				case ("/order_insert.cnd") : 
					command = new OrderInsertCommand();
					command.execute(request, response, session);
					viewPage = "order.jsp";
					break;
				
				// 주문서 넣기 [Select] 
				case ("/order_fin.cnd") : 
					command = new OrderConfirmCommand();
					command.execute(request, response, session);
					viewPage = "shopping.cnd";
					break;
				
					//주문취소 하기 
				case ("/order_cancel.cnd") : 
					command = new OrderCancelCommand();
					command.execute(request, response, session);
					viewPage = "shopping.cnd";
					break;
				
				
			
			
		
				
			

		
				
			// -------------------------------//
			//                상세정보		      //
			// -------------------------------//	
				
				
				// 주문하기 버튼을 눌렀을때 로그인 안되어있으면 로그인하라는 alert띄우고 로그인 창으로 이동
				
				// 상품상세정보 [Select]
			case ("/shop_detail.cnd") : 
				command = new ShopDetailCommand();
				command.execute(request, response, session);
				viewPage = "shop_detail.jsp";
				break;
				
	
			
			
			// -------------------------------//
			//                주문작성			  //
			// -------------------------------//
			
				
			//
				
//				// 주문서 출력 [Select] 
//			case ("/order_sheet.cnd") : 
//				command = new OrderSheetCommand();
//				command.execute(request, response, session);
//				viewPage = "order_sheet.jsp";
//				break;
				
			
			
			// -------------------------------//
			//                게시판			  //    @@@ 좋아요, 댓글
			// -------------------------------//
			
				// 게시판 리스트 보기	[Select] (조회수,하트)
			case ("/post_list.cnd") :
				command = new PostListCommand();
				command.execute(request, response, session);
				viewPage = "post_list.jsp";
				break;
			
				// 게시판 내용  보기(사진 클릭) , 댓글도 같이 select [Select]	(조회수 insert)
			case ("/post_view.cnd") :
				command = new PostViewCommand();
				command.execute(request, response, session);
				viewPage = "post_view.jsp";
				break;	
				
				// 게시판리스트에서 등록버튼을 누르면 post_write.cnd가 실행
				// 게시판 내용  등록 [insert]
			case ("/post_write.cnd") :
				command = new PostWriteCommand();
				command.execute(request, response, session);
				viewPage = "post_list.cnd";
				break;		
				
				// 게시판 내용  수정 [update]
			case ("/post_modi.cnd") :
				command = new PostModifyCommand();
				command.execute(request, response, session);
				viewPage = "post_list.cnd";
				break;		
				
				
				// 게시판 내용  삭제 [delete] @ 내글리스트 페이지에서만 뜸, 삭제 하이퍼링크 생성
			case ("/post_del.cnd") :
				command = new PostDeleteCommand();
				command.execute(request, response, session);
				viewPage = "post_list.cnd";
				break;	
				
			
			
			case("/postPaging.cnd"): // 공지 페이징
				command = new PostPagingCommand();
				command.execute(request, response, session);
				viewPage = "post_list.jsp";
				break;

			case ("/pcomment_write.cnd") :
				command = new pCommentWriteCommand();
				command.execute(request, response, session);
				viewPage = "post_view.cnd";
				break;	
		
				// 게시판  댓글  작성 [insert]
		
			
//				// 게시판  댓글  보기 [select]
//			case ("/post_commentview.cnd") :
//				command = new PostCViewCommand();
//				command.execute(request, response, session);
//				viewPage = "post_view.jsp";
//				break;	
//		
				
			
			// -------------------------------//
			//               질의응답			  //
			// -------------------------------//
			
				// 질의응답 리스트 보기 [select]
			case ("/qna.cnd") : 
				command = new QnACommand();
				command.execute(request, response, session);
				viewPage = "qna.jsp";
				break;
			
				// 질의응답 내용 보기 (제목클릭) , 댓글도 같이 select [select]
			case ("/qna_view.cnd") : 
				command = new QnAViewCommand();
				command.execute(request, response, session);
				viewPage = "qna_view.jsp";
				break;
			
				// 질의응답 작성 (리스트 페이지에서 작성버튼[하이퍼링크를타고] 클릭했을때) [insert]
			case ("/qna_write.cnd") : 
				command = new QnAWriteCommand();
				command.execute(request, response, session);
				viewPage = "qna.cnd";
				break;
				
				// 질의응답 내가 쓴글 리스트 보기 (제목클릭) [select]
//			case ("/qna_mylist.cnd") : 
//				command = new QnAMyListCommand();
//				command.execute(request, response, session);
//				viewPage = "qna_mylist.jsp";
//				break;	
//			
//			case ("/qna_myview.cnd") : 
//				command = new QnAMyViewCommand();
//				command.execute(request, response, session);
//				viewPage = "qna_myview.jsp";
//				break;	
//			
				
				// 질의응답 삭제 (리스트 페이지에서 내글을 눌렀을때만) [delete]
			case ("/qna_del.cnd") : 
				command = new QnADelCommand();
				command.execute(request, response, session);
				viewPage = "qna.cnd";
				break;
			//	질의응답 수정
			case ("/qna_modi.cnd") : 
				command = new QnAModiCommand();
			command.execute(request, response, session);
			viewPage = "qna.cnd";
			break;
				
				// 질의응답  댓글  작성 [insert]
			case ("/qna_commentwrite.cnd") :
				command = new QnACActCommand();
				command.execute(request, response, session);
				viewPage = "qna_view.jsp";
				break;	
				
			case("/qnaPaging.cnd"): // 공지 페이징
				command = new QnAPagingCommand();
				command.execute(request, response, session);
				viewPage = "qna.jsp";
				break;
			
			//-------------------------------------------
			
			
				// -------------------------------//
				//               회원가입		      //
				// -------------------------------//
				
					// 회원가입 페이지 
								case ("/join.cnd") : 
									viewPage = "join.jsp";
								break;	
									
								
								// 회원가입 페이지 [insert]
								case ("/joinAction.cnd") : 
									command = new JoinActionCommand();
									command.execute(request, response, session);
									viewPage = "joinComplete.cnd";
								break;
								
								
								case("/join_idcheck.cnd") :
									viewPage = "join_idcheck.jsp";
								break;	
								
								
								case("/join_idcheckbtn.cnd") :
									command = new Join_idcheckCommand();
									command.execute(request, response, session);
									viewPage = "join_idcheckbtn.jsp";
									break;
									
								case("/join_idcheckCom.cnd") :
								command = new Join_idcheckComCommand();
								command.execute(request, response, session);
								viewPage = "join.cnd";
								break;
									
									
								case ("/joinfin.cnd") :
									viewPage = "joinfin.jsp";
								break;
								
								case ("/joinComplete.cnd") :
								viewPage = "joinComplete.jsp";
								break;
								
								
								
				
			
			// -------------------------------//
			//                로그인페이지		  //
			// -------------------------------//
			
			 //로그인 하기 [select]
			
			case ("/login.cnd") : 
				viewPage = "login.jsp";
			break;
			
			
			case ("/loginAction.cnd") : 
				command = new LoginActionCommand();
				command.execute(request, response, session);
				viewPage = "loginAction.jsp";
				break;
			
			
				
				
				
				
				
				// ID/PW 찾기 [select]
							case ("/id_find.cnd") : 
								command = new LoginFindCommand();
								command.execute(request, response, session);
								viewPage = "/resultId.cnd";
								break;
								
							case ("/resultId.cnd") : 
								viewPage = "/resultId.jsp";
							break;
							
								
							case ("/pw_find.cnd") : 
								command = new PwFindCommand();
								command.execute(request, response, session);
								viewPage = "/resultPw.cnd";
							break;
							
							case ("/resultPw.cnd") : 
								viewPage = "/resultPw.jsp";
							break;
			
			
//login상태--------------------------------------------------------//			
			
			
			
			// -------------------------------//
			//             마이페이지 			  //
			// -------------------------------//
			
							// 마이페이지 5개의 버튼만 있는 창
							
							case ("/mypage.cnd") : 
								viewPage = "mypage.jsp";
								break;	
								
								// 내 정보 수정 [update, select]
							case ("/user_info.cnd") : // 게시판 전부 보이기
								command = new UserInfoCommand();
								command.execute(request, response, session);
								viewPage = "user_info.jsp";
								break;
						
							// 내가 쓴 post [select] 
							case ("/user_list.cnd") : // 게시판 전부 보이기
								command = new UserListCommand();
								command.execute(request, response, session);
								viewPage = "user_list.jsp";
								break;
								// 내가 쓴 comment [select] 
							case ("/user_comment.cnd") : // 게시판 전부 보이기
								command = new UserCommentCommand();
							command.execute(request, response, session);
							viewPage = "user_comment.jsp";
								break;
								
							// 내가 쓴 댓글 삭제 [select] 
							case ("/comment_del.cnd") : // 게시판 전부 보이기
								command = new CommentDelCommand();
							command.execute(request, response, session);
							viewPage = "user_comment.cnd";
							break;
							
							// 관리자 상품 페이징 [delete]
							case("/user_commentPaging.cnd"): 
								command = new UserCommentPagingCommand();
								command.execute(request, response, session);
								viewPage = "user_comment.jsp";
								break;			
							
								
							// 내 정보 수정 [update, select]
							case ("/user_modify.cnd") : // 게시판 전부 보이기
								command = new UserModifyCommand();
								command.execute(request, response, session);
								viewPage = "mypage.jsp";
								break;
								// 내 정보 탈퇴 [update, select]
							case ("/user_out.cnd") : // 게시판 전부 보이기
								command = new UserOutCommand();
								command.execute(request, response, session);	
								viewPage = "logout.cnd";
								break;
								
							// 주문내역 리스트 [select]
							case ("/user_orderlist.cnd") : //
								command = new OrderListCommand();
								command.execute(request, response, session);
								viewPage = "user_orderlist.jsp";
								break;
							
								// 관리자 상품 페이징 [delete]
							case("/user_listPaging.cnd"): 
								command = new UserListPagingCommand();
								command.execute(request, response, session);
								viewPage = "user_list.jsp";
								break;		
							
							// 내가 쓴 댓글 삭제 [select] 
							case ("/user_list_del.cnd") : // 게시판 전부 보이기
								command = new UserListDelCommand();
								command.execute(request, response, session);
								viewPage = "user_list.cnd";
								break;
								
								// 관리자 상품 페이징 [delete]
							case("/user_orderlistPaging.cnd"): 
								command = new UserOrderListPagingCommand();
								command.execute(request, response, session);
								viewPage = "user_orderlist.jsp";
								break;		
			
			
			
			// -------------------------------//
			//             장바구니 			  //
			// -------------------------------//
			
			// 주문하기 버튼 누르면 iNumber타고 주문서페이지 하이퍼링크
			// 장바구니 리스트 보이기 [select] 
			
			
			case ("/cart.cnd") :
			command = new CartCommand();
			command.execute(request, response, session);
			viewPage = "cart.jsp";
			break;
			
			
			
			// -------------------------------//
			//             로그아웃 			  //
			// -------------------------------//
			
			// alert 삽입
			case ("/logout.cnd") : 
			viewPage = "logout.jsp";
			break;
			
			
			//-----------------------------------------
			default:
				viewPage = "main.cnd";
				break;
			}
						
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
			}
			
		
		
		}
		
		
		
		

