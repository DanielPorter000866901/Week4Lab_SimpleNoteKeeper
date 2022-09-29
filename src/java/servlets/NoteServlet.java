/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import models.Note;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author porte
 */
@WebServlet(name = "NoteServlet", urlPatterns = {"/NoteServlet"})
public class NoteServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, FileNotFoundException {
        
        String e = request.getParameter("edit");
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        Scanner readNotes = new Scanner(new File(path));
        
        Note note = new Note();
        note.setTitle(readNotes.nextLine());
        note.setContents(readNotes.nextLine());
        
        request.setAttribute("note", note);
        
        if (e == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String title = (String)request.getAttribute("title");
        String contents = (String)request.getAttribute("contents");
        
        Note note = new Note();
        note.setTitle(title);
        note.setContents(contents);
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        FileWriter writeNotes = new FileWriter(path);
        
        writeNotes.write(title + "\n" + contents + "\n");
        
        writeNotes.close();
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        
    }

}
