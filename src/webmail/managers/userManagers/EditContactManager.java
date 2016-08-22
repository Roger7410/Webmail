package webmail.managers.userManagers;

import webmail.managers.Manager;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JOKER on 12/2/14.
 */
public class EditContactManager extends Manager {

    public EditContactManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void run(){
        String id= request.getParameter("cid");
        int cid = Integer.parseInt(id);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        SQLManager.updateContactSQL(cid, name, email, phone);
        try {
            response.sendRedirect("/contacts?infolder=inbox");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
