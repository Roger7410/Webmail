package webmail.managers.emailManagers;

import webmail.managers.Manager;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JOKER on 12/1/14.
 */
public class UnreadManager extends Manager {

    public UnreadManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void run() {
        int int_emailID = Integer.parseInt(request.getParameter("emailID"));
        SQLManager.changeToUnreadedSQL(int_emailID);
        String folder = request.getParameter("infolder");

        try {
            response.sendRedirect("/"+folder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
