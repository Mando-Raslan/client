package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import classes.Contact_Api;
import classes.Contacts;

/**
 * Servlet implementation class FileUploadDbServlet
 */
@WebServlet("/FileUploadDbServlet") 

@MultipartConfig

public class FileUploadDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadDbServlet() {
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
		
		
		PrintWriter writer= response.getWriter();
		String first_name = request.getParameter("first_name");
        String last_name  = request.getParameter("last_name");
        
        Part   photo      =  request.getPart("photo");
       
       
       
        
        if(photo != null) {
        	 InputStream image = photo.getInputStream();
//        	 image             = Contact_Api.resizeImage(image, 500, 500);
             byte [] photoafter= Contact_Api.readFully(image);
        	 Contacts contact  = new Contacts();
             contact.setFirst_name(first_name);
             contact.setLast_name(last_name);
             contact.setPhoto(photoafter);
             int status    = Contact_Api.saveUser(contact);
             
             
             if(status > 0) {
             	
             	writer.print("Done added");
             	
             }else {
             	
             	writer.print("errors");
             	
             }
        	
        }        
        
        
       
	}
	
	
}
