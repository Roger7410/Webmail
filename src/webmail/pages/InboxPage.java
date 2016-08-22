package webmail.pages;

import org.stringtemplate.v4.ST;
import webmail.entities.Email;
import webmail.entities.Folder;
import webmail.entities.User;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by JOKER on 11/25/14.
 */
public class InboxPage extends MailPage {
    public InboxPage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    private static int inbox_pageNum = 1;

    public static int getInbox_pageNum() {
        return inbox_pageNum;
    }

    public static void increseInbox_pageNum(){
        inbox_pageNum++;
    }
    public static void decreseInbox_pageNum(){
        inbox_pageNum--;
    }


    @Override
    public ST body() {
        String orderby = request.getParameter("order");
        if (orderby == null){
            orderby = "date";
        }
        Email emails[] = SQLManager.getEmailsInfoSQL(getStrAccount(),"INBOX", inbox_pageNum, orderby);
        //tmp add here
        if (emails[0]==null){
            inbox_pageNum--;
            emails = SQLManager.getEmailsInfoSQL(getStrAccount(),"INBOX", inbox_pageNum, orderby);
        }

        ST st = templates.getInstanceOf("inbox");
        st.add("username", getUsername());
        st.add("ea_address", getAccount());
        st.add("emails", emails);
        Folder folders[] = SQLManager.getFoldersInfoSQL(getStrAccount());
        st.add("folders", folders);
        st.add("page", inbox_pageNum);
        return st;
    }

    @Override
    public ST getTitle() {
        return new ST("Inbox: "+getStrAccount());
    }

}
