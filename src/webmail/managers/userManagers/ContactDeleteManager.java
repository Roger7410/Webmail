package webmail.managers.userManagers;

import webmail.managers.Manager;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JOKER on 12/2/14.
 */
public class ContactDeleteManager extends Manager {

    public ContactDeleteManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }


    @Override
    public void run() {
        String id = request.getParameter("contactID");
        int cid = Integer.parseInt(id);
        SQLManager.deleteContactSQL(cid);
        try {
            response.sendRedirect("/contacts?infolder=inbox");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
