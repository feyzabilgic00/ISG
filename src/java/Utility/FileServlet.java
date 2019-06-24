/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import Controller.DocumentController;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "FileServlet", urlPatterns = {"/file/*"})
public class FileServlet extends HttpServlet {

    
    private DocumentController dc;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String file = request.getPathInfo();//yıldız yerine hangi url request edildiyse
        File f = new File(getDc().getUploadTo()+file);//dosyamızın nerede olduğu
        
        Files.copy(f.toPath(), response.getOutputStream());
    }

    public DocumentController getDc() {
        if(this.dc == null)
            this.dc = new DocumentController();
        return dc;
    }

    public void setDc(DocumentController dc) {
        this.dc = dc;
    }
    
    

}
