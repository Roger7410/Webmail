package webmail.managers.userManagers;

import webmail.entities.Contacts;
import webmail.entities.Folder;
import webmail.managers.Manager;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by JOKER on 12/2/14.
 */
public class AddFolderManager extends Manager {

    public AddFolderManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void run(){
        //create user
        try {
            HttpSession session = request.getSession();
            String account = (String)session.getAttribute("account");
            String name = request.getParameter("name");
            Folder folder = new Folder(0,account,name);
            SQLManager.addFolderSQL(folder);
            response.sendRedirect("/folder?infolder=inbox");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
