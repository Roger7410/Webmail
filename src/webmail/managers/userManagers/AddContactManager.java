package webmail.managers.userManagers;

import webmail.entities.Contacts;
import webmail.managers.Manager;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by JOKER on 12/2/14.
 */
public class AddContactManager extends Manager {

    public AddContactManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void run(){
        //create user
        try {
            HttpSession session = request.getSession();
            String account = (String)session.getAttribute("account");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            Contacts contact = new Contacts(0,account,name,email,phone);
            SQLManager.addContactSQL(contact);
            response.sendRedirect("/contacts?infolder=inbox");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
