package webmail.managers.emailManagers;

import webmail.managers.Manager;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JOKER on 12/1/14.
 */
public class MoveFolderManager extends Manager {

    public MoveFolderManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void run() {
        String folder = request.getParameter("folder");
        String moveto = request.getParameter("moveto");
        int eid = Integer.parseInt(request.getParameter("emailID"));

        //deal with moving folder
        SQLManager.moveToFolderSQL(eid, moveto);

        if (folder.contains("inbox")||folder.contains("sent")||folder.contains("trash")){
            try {
                response.sendRedirect("/"+folder);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                response.sendRedirect("/userFolder?folder="+folder);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
