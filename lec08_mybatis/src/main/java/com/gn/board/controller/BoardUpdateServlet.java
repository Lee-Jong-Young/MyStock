package com.gn.board.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gn.board.service.BoardService;
import com.gn.board.vo.Board;
@WebServlet("/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardUpdateServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("board_no"));
		String boardTitle = request.getParameter("board_title");
		String boardContent = request.getParameter("board_content");
//		1. Board 객체에 no title content 정보 담기
//		2. Service >> Dao >> board-mapper.xml 통해 데이터 update
//		3. board_title board_content 를 수정하면 되는데 , 기준은 board_no
//		4. update 쿼리는 resultType이 무조건 int 이니 적지 않는다
//		System.out.println(boardNo+":"+boardTitle+":"+boardContent); 넘어오는지 확인
		Board b = new Board();
		b.setBoard_no(boardNo);
		b.setBoard_title(boardTitle);
		b.setBoard_content(boardContent);
		int result = new BoardService().updateBoard(b);
		
		String resp_code = "500";
		if(result>0) {
			resp_code = "200";
		}
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append(resp_code);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}