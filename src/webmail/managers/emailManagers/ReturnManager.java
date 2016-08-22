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
public class ReturnManager extends Manager {

    public ReturnManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void run() {
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
