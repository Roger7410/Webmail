package webmail.managers.userManagers;

import webmail.managers.Manager;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JOKER on 12/2/14.
 */
public class FolderDeleteManager extends Manager {

    public FolderDeleteManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }


    @Override
    public void run() {
        String id = request.getParameter("folderID");
        int fid = Integer.parseInt(id);
        SQLManager.deleteFolderSQL(fid);
        try {
            response.sendRedirect("/folder?infolder=inbox");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
