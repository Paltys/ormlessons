package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;


public class downloadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> key = req.getParameterNames();
        String tempKey;
        //while (key.hasMoreElements()) {
            tempKey = key.nextElement();
            System.out.println(tempKey);
        //    System.out.println(tempKey + ": " + req.getParameter(tempKey));
        //}
        if (tempKey.equals("download_pdf")){

            String relativePath = getServletContext().getRealPath("")+"files\\Java1.pdf";
            System.out.println("relativePath = " + relativePath);
            File downloadfile = new File(relativePath);
            FileInputStream in = new FileInputStream(downloadfile);
            ServletContext context = getServletContext();
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("application/pdf");
            resp.setHeader("Content-Disposition","attachment; filename="+downloadfile.getName());
            OutputStream os= resp.getOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = in.read(buffer)) != -1){
                os.write(buffer, 0, bytesRead);
            }
            in.close();
            os.close();
            System.out.println("на pdf");

        } else if (tempKey.equals("download_zip")){
            String relativePath = getServletContext().getRealPath("")+"files\\Java1.rar";
            System.out.println("relativePath = " + relativePath);
            File downloadfile = new File(relativePath);
            FileInputStream in = new FileInputStream(downloadfile);
            ServletContext context = getServletContext();
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("application/x-rar-compressed");
            resp.setHeader("Content-Disposition","attachment; filename="+downloadfile.getName());
            OutputStream os= resp.getOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = in.read(buffer)) != -1){
                os.write(buffer, 0, bytesRead);
            }
            in.close();
            os.close();
            System.out.println("на zip");
        } else {
           req.getRequestDispatcher("errorPage").forward(req,resp);

            System.out.println("нет файла такого");
        }
    }
}
