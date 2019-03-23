package servlets;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import javax.servlet.annotation.WebServlet;

/*@WebServlet("/loadServlet")
@MultipartConfig*/

public class loadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file");
        String fileName = Paths.get(filePart.getSubmittedFileName()).toString();
        System.out.println(fileName);
        InputStream fileContent = filePart.getInputStream();
        byte[] data = new byte[fileContent.available()];
        DataInputStream dis = new DataInputStream(fileContent);
        dis.readFully(data);
        String relativePath = getServletContext().getRealPath("")+"files\\"+fileName;
        System.out.println(relativePath);
        FileOutputStream uploaded = new FileOutputStream(relativePath);
        uploaded.write(data);
        uploaded.close();
        fileContent.close();
        response.getWriter().print("OK "+fileName+" uploaded");

        }
    }

