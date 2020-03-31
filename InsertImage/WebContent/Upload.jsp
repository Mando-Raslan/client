<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload</title>
</head>
 <body>
        <h1>File Upload to Database</h1>
        <form  method="post" action="./FileUploadDbServlet" enctype="multipart/form-data">
            <label for="first_name">First Name:</label>
            <input type="text" name="first_name" size="50" placeholder="Enter Your FirstName" required/><br><br>
            <label for="last_name">Last Name: </label>
            <input type="text" name="last_name" size="50" placeholder="Enter Your LastName" required/><br><br>
            <label for="photo"> Portrait Photo:  </label>
            <input type="file" name="photo" size="50" placeholder="Upload Your Image" required/><br><br>
            <button type="submit" value="Save">Save</button>
        </form>
        
        <br><br>
        
        <a href="viewImage.jsp"> ViewImage </a>
        
        
    </body>
</html>