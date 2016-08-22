package webmail.managers.userManagers;

import webmail.managers.Manager;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JOKER on 12/2/14.
 */
public class EditFolderManager extends Manager {

    public EditFolderManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void run(){
        String id= request.getParameter("fid");
        int fid = Integer.parseInt(id);
        String name = request.getParameter("name");
        SQLManager.updateFolderSQL(fid, name);
        try {
            response.sendRedirect("/folder?infolder=inbox");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
