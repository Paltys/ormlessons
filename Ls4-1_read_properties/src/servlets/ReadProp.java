package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;


public class ReadProp extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");

            //wrong style used getRealPath
            //String relativePath = getServletContext().getRealPath("")+"resources\\config.properties";

            InputStream ins = getServletContext().getResourceAsStream("resources\\config.properties");

            //System.out.println(relativePath);
            //FileInputStream in = new FileInputStream(relativePath);

            Properties prop = new Properties();
            prop.load(ins);
            for (String key: prop.stringPropertyNames()){
                out.println(key+":"+prop.get(key));
            }
    }

}
