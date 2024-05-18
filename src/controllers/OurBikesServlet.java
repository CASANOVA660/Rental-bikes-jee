package controllers;

import java.io.IOException;
import dao.BikeDAO;
import Beans.Bike;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class OurBikesServlet
 */
@WebServlet("/OurBikesServlet")
public class OurBikesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BikeDAO dao = new BikeDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OurBikesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Bike> bikes = dao.getAllBikes();
        request.setAttribute("bikes", bikes);
        request.getRequestDispatcher("/WEB-INF/ourBikes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
