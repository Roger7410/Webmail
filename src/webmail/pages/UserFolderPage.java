package webmail.pages;

import org.stringtemplate.v4.ST;
import webmail.entities.Email;
import webmail.entities.Folder;
import webmail.entities.User;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Iterator;

/**
 * Created by JOKER on 11/25/14.
 */
public class UserFolderPage extends MailPage {
    public UserFolderPage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    private static int user_pageNum = 1;

    public static int getUserFolder_pageNum() {
        return user_pageNum;
    }

    public static void increseUserFolder_pageNum(){
        user_pageNum++;
    }
    public static void decreseUserFolder_pageNum(){
        user_pageNum--;
    }

    String title = request.getParameter("folder");
    @Override
    public ST body() {
        String orderby = request.getParameter("order");
        if (orderby == null){
            orderby = "date";
        }
        String folder = request.getParameter("folder");
        Email emails[] = SQLManager.getEmailsInfoSQL(getStrAccount(), folder, user_pageNum, orderby);
        if (emails[0]==null){
            user_pageNum--;
            emails = SQLManager.getEmailsInfoSQL(getStrAccount(), folder, user_pageNum, orderby);
        }
        Folder folders[] = SQLManager.getFoldersInfoSQL(getStrAccount());
        if (folders.length != 0) {
            int i = 0;
            while (folders[i]!=null){
                if(folders[i].getFolderName().equals(title)){
                    folders[i].setFolderIn();
                }
                i++;
            }
//            for (Folder f : folders) {
//                if(f.getFolderName().equals(title)){
//                    f.setFolderIn();
//                }
//            }
        }
        ST st = templates.getInstanceOf("userFolder");
        st.add("username", getUsername());
        st.add("ea_address", getAccount());
        st.add("emails", emails);
        st.add("folders", folders);
        st.add("folder", folder);
        st.add("page", user_pageNum);
        return st;
    }

    @Override
    public ST getTitle() {
        return new ST(title+": "+getStrAccount());
    }

}
