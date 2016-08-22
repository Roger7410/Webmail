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
public class LeftManager extends Manager {

    public LeftManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void run() {
        boolean flag = false;
        String folder = request.getParameter("folder");
        if (folder.equals("inbox")){
            InboxPage.decreseInbox_pageNum();
            if(InboxPage.getInbox_pageNum() == 0){
                InboxPage.increseInbox_pageNum();
            }
            flag=true;
        }
        if (folder.equals("sent")){
            SentPage.decreseSent_pageNum();
            if(SentPage.getSent_pageNum() == 0){
                SentPage.increseSent_pageNum();
            }
            flag=true;
        }
        if (folder.equals("trash")){
            TrashPage.decreseTrash_pageNum();
            if(TrashPage.getTrash_pageNum() == 0){
                TrashPage.increseTrash_pageNum();
            }
            flag=true;
        }
        if(flag) {
            try {
                response.sendRedirect("/" + folder + "?order=" + OrderbyManager.order);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!folder.equals("inbox") && !folder.equals("sent") && !folder.equals("trash")){
            UserFolderPage.decreseUserFolder_pageNum();
            if(UserFolderPage.getUserFolder_pageNum() == 0){
                UserFolderPage.increseUserFolder_pageNum();
            }
            try {
                response.sendRedirect("/userFolder?folder="+folder+"&order=" + OrderbyManager.order);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
