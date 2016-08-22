package webmail.pages;

import webmail.WebmailServer;
import webmail.managers.Manager;
import webmail.managers.otherManagers.ErrorManager;
import webmail.managers.userManagers.UserManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Constructor;

public class DispatchServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        String uri = request.getRequestURI();
        if(uri.contains("Manager")){//run Manager
            Manager u = createManager(uri, request, response);
            if( u == null){
                response.sendRedirect("files/error.html");
                return;
            }
            response.setContentType("text/html");
            u.run();
        }
        else {//run Page
            Page p = createPage(uri, request, response);
            if (p == null) {
                response.sendRedirect("/files/error.html");
                return;
            }
            response.setContentType("text/html");
            p.generate();
        }
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws  ServletException, IOException
    {
        String uri = request.getRequestURI();
        if(uri.contains("Manager")){
            Manager u = createManager(uri, request, response);
            if( u == null){
                response.sendRedirect("files/error.html");
                return;
            }
            response.setContentType("text/html");
            u.run();
        }
        else {
            Page p = createPage(uri, request, response);
            if (p == null) {
                response.sendRedirect("/files/error.html");
                return;
            }
            response.setContentType("text/html");
            p.generate();
        }
    }

    public Manager createManager(String uri,
                                         HttpServletRequest request,
                                         HttpServletResponse response)
    {
        Class managerClass = WebmailServer.mapping.get(uri);
        try{
            Constructor<Manager> ctor =managerClass.getConstructor(HttpServletRequest.class,
                    HttpServletResponse.class);
            return ctor.newInstance(request, response);
        }
        catch (Exception e){
            ErrorManager.instance().error(e);
        }
        return null;
    }

    public Page createPage(String uri,
                           HttpServletRequest request,
                           HttpServletResponse response)
    {
        Class pageClass = WebmailServer.mapping.get(uri);
        try {
            Constructor<Page> ctor = pageClass.getConstructor(HttpServletRequest.class,
                    HttpServletResponse.class);
            return ctor.newInstance(request, response);
        }
        catch (Exception e) {
            ErrorManager.instance().error(e);
        }
        return null;
    }

}
