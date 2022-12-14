package com.human.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.DAO.boardDAO;
import com.human.VO.boardVO;

/**
 * Servlet implementation class boderView
 */
@WebServlet("/boderView")
public class boderView extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private boardDAO bdao=new boardDAO()   ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boderView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String wno=request.getParameter("wno");
		System.out.println(wno);
		ArrayList<boardVO> clist=new ArrayList<>();
		
		clist=bdao.selectC(wno);
		boardVO data=bdao.selectOne(wno);
		
		String url="bbs/view.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		request.setAttribute("board", data);
		request.setAttribute("comment", clist);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
