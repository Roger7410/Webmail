package webmail.pages;

import org.stringtemplate.v4.ST;
import webmail.entities.Email;
import webmail.entities.Folder;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JOKER on 11/27/14.
 */
public class SentPage extends MailPage {
    public SentPage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }
    private static int sent_pageNum = 1;

    public static int getSent_pageNum() {
        return sent_pageNum;
    }
    public static void increseSent_pageNum(){
        sent_pageNum++;
    }
    public static void decreseSent_pageNum(){
        sent_pageNum--;
    }
    public void verify() { }

    @Override
    public ST body() {
        String orderby = request.getParameter("order");
        if (orderby == null){
            orderby = "date";
        }
        Email emails[] = SQLManager.getEmailsInfoSQL(getStrAccount(), "SENT",sent_pageNum, orderby);
        if (emails[0]==null){
            sent_pageNum--;
            emails = SQLManager.getEmailsInfoSQL(getStrAccount(),"SENT", sent_pageNum, orderby);
        }
        ST st = templates.getInstanceOf("sent");
        st.add("username", getUsername());
        st.add("ea_address", getAccount());
        st.add("emails", emails);
        Folder folders[] = SQLManager.getFoldersInfoSQL(getStrAccount());
        st.add("folders", folders);
        st.add("page", sent_pageNum);
        return st;
    }

    @Override
    public ST getTitle() {
        return new ST("Sent Mail: "+getStrAccount());
    }

}
