package webmail.managers.emailManagers;

import webmail.managers.Manager;
import webmail.pages.InboxPage;
import webmail.pages.SentPage;
import webmail.pages.TrashPage;
import webmail.pages.UserFolderPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JOKER on 12/1/14.
 */
public class RightManager extends Manager {

    public RightManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void run() { // no right bound now
        String folder = request.getParameter("folder");
        if (folder.equals("inbox")){
            InboxPage.increseInbox_pageNum();
            try {
                response.sendRedirect("/"+folder+"?order="+OrderbyManager.order);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (folder.equals("sent")){
            SentPage.increseSent_pageNum();
            try {
                response.sendRedirect("/"+folder+"?order="+OrderbyManager.order);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (folder.equals("trash")){
            TrashPage.increseTrash_pageNum();
            try {
                response.sendRedirect("/"+folder+"?order="+OrderbyManager.order);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!folder.equals("inbox") && !folder.equals("sent") && !folder.equals("trash")){
            UserFolderPage.increseUserFolder_pageNum();
            try {
                response.sendRedirect("/userFolder?folder="+folder+"&order="+OrderbyManager.order);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
