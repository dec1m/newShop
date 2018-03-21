package ru.trach.controller;

import org.apache.log4j.Logger;
import ru.trach.ejb.BookManagerBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;


public class ImageController extends HttpServlet{
    @EJB
   private BookManagerBean bookManagerBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputStream outputStream = resp.getOutputStream();
        long id = Long.parseLong(req.getParameter("id"));
        byte[] img = bookManagerBean.getImgById(id);
        outputStream.write(img);
        outputStream.flush();
        outputStream.close();


    }
}
