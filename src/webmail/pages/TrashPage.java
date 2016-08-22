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
public class TrashPage extends MailPage {
    public TrashPage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }
    private static int trash_pageNum = 1;

    public static int getTrash_pageNum() {
        return trash_pageNum;
    }
    public static void increseTrash_pageNum(){
        trash_pageNum++;
    }
    public static void decreseTrash_pageNum(){
        trash_pageNum--;
    }
    public void verify() { }

    @Override
    public ST body() {
        String orderby = request.getParameter("order");
        if (orderby == null){
            orderby = "date";
        }
        Email emails[] = SQLManager.getEmailsInfoSQL(getStrAccount(), "TRASH", trash_pageNum, orderby);
        if (emails[0]==null){
            trash_pageNum--;
            emails = SQLManager.getEmailsInfoSQL(getStrAccount(),"TRASH", trash_pageNum, orderby);
        }
        ST st = templates.getInstanceOf("trash");
        st.add("username", getUsername());
        st.add("ea_address", getAccount());
        st.add("emails", emails);
        Folder folders[] = SQLManager.getFoldersInfoSQL(getStrAccount());
        st.add("folders", folders);
        st.add("page", trash_pageNum);
        return st;
    }

    @Override
    public ST getTitle() {
        return new ST("Trash: "+getStrAccount());
    }

}
