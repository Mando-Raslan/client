package classes;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;



public class Contact_Api {
	
	
public static Connection getcon() {
		
		Connection mySql = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url   = "jdbc:mysql://localhost:3306/mysqll";
			String key   = "root";
			String pKey  = "";
			mySql        = DriverManager.getConnection(url,key,pKey);
			
		} catch (ClassNotFoundException  | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mySql;
		
		
		
		
	}

public static int saveUser(Contacts contact) {
	
	int status            = 0;
	Connection mySql      = getcon();
	

		String sql            = "insert into contact (first_name,last_name,photo) values (?,?,?)";
		
		try {
			PreparedStatement ps = mySql.prepareStatement(sql);
			ps.setString(1, contact.getFirst_name());
			ps.setString(2, contact.getLast_name());
			ps.setBytes (3, contact.getPhoto());					
			status                = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	return status;
	
}
//
//public static InputStream getInputStream(Part photo) {
//	InputStream inputStream = null;
//	
//	try {
//		 inputStream = photo.getInputStream();
//		
//		
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	return inputStream;
//}


public static byte[] readFully(InputStream input) throws IOException
{
    byte[] buffer = new byte[8192];
    int bytesRead;
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    while ((bytesRead = input.read(buffer)) != -1)
    {
        output.write(buffer, 0, bytesRead);
    }
    return output.toByteArray();
}


public static InputStream resizeImage(InputStream inputStream, int width, int height) throws IOException {
    BufferedImage sourceImage = ImageIO.read(inputStream);
    Image thumbnail = sourceImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    BufferedImage bufferedThumbnail = new BufferedImage(thumbnail.getWidth(null),
            thumbnail.getHeight(null),
            BufferedImage.TYPE_INT_RGB);
    bufferedThumbnail.getGraphics().drawImage(thumbnail, 10, 10, null);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(bufferedThumbnail, "jpeg", baos);
    return new ByteArrayInputStream(baos.toByteArray());
}



public static List<Contacts> Data(){
	
	
	List<Contacts> myData = new ArrayList<Contacts>();
	
	Connection mySql        =    getcon();
	String sql            = "select * from contact";
	try {
		
		PreparedStatement ps   = mySql.prepareStatement(sql);
		ResultSet pointer      = ps.executeQuery();
		
		while(pointer.next()) {
			String base64Image = Base64.getEncoder().encodeToString(pointer.getBytes("photo"));
			Contacts contacts = new Contacts();
			contacts.setFirst_name(pointer.getString("first_name"));
			contacts.setLast_name(pointer.getString("last_name"));
			contacts.setPhoto(pointer.getBytes("photo"));
		    contacts.setBass64(base64Image);
		    
			myData.add(contacts);
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
		
   return myData;
	
}






}
