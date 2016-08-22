package webmail.managers.emailManagers;

import webmail.entities.Email;
import webmail.entities.User;
import webmail.managers.Manager;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by JOKER on 11/30/14.
 */
public class DeleteManager extends Manager {

    public DeleteManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    public String getUsername(){
        HttpSession session = request.getSession();
        User su = (User)session.getAttribute("user");
        String username = su.getUsername();
        return username;
    }
    public int getEmailID(){
        String tmp_emailID = request.getParameter("emailID");
        int int_emailID = Integer.parseInt(tmp_emailID);
        return int_emailID;
    }
    @Override
    public void run() {
        String username = getUsername();
        int int_emailID = getEmailID();
        SQLManager.moveToTrashSQL(int_emailID);
        try {
            String folder = request.getParameter("folder");
            if (folder.contains("inbox")||folder.contains("sent")||folder.contains("trash")) {
                response.sendRedirect("/" + folder);
            }
            else{
                response.sendRedirect("/userFolder?folder="+folder);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
