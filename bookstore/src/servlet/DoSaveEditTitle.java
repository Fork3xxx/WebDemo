package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Title;
import bean.TitleDao;
import bean.TitleDaoImpl;

/**
 * Servlet implementation class DoSaveEditTitle
 */
@WebServlet("/DoSaveEditTitle")
public class DoSaveEditTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoSaveEditTitle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String isbn=request.getParameter("isbn");
		String title=request.getParameter( "title");
		String copyright= request.getParameter( "copyright");
		String imageFile = request.getParameter( "imageFile");
		int editionNumber = Integer.parseInt(request.getParameter("editionNumber"));
		int publisherId = Integer.parseInt(request.getParameter( "publisherId"));
		float price= Float.parseFloat(request.getParameter( "price"));
		Title titlebean = new Title();
		titlebean.setIsbn(isbn);
		titlebean.setCopyright(copyright);
		titlebean.setEditionNumber(editionNumber);
		titlebean.setImageFile(imageFile);
		titlebean.setPrice(price);
		titlebean.setPublisherId(publisherId);
		titlebean.setTitle(title);
		TitleDao titleDao = new TitleDaoImpl();
		int n = titleDao.update(titlebean);
		if(n > 0)
			response.sendRedirect( "listBook.jsp");
		esle
			r
		
		doGet(request, response);
	}

}
