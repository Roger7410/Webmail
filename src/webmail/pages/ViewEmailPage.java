package webmail.pages;

import org.stringtemplate.v4.ST;
import webmail.entities.Attachment;
import webmail.entities.Email;
import webmail.entities.Folder;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JOKER on 11/29/14.
 */
public class ViewEmailPage extends MailPage {
    public ViewEmailPage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    public void verify() { }

    @Override
    public ST body() {
        String tmp_emailID = request.getParameter("emailID");
        int int_emailID = Integer.parseInt(tmp_emailID);
        Email email = SQLManager.getEmailInfoSQL(int_emailID);
        SQLManager.changeToReadedSQL(int_emailID);
        String infolder = request.getParameter("infolder");

        //move folder part
        Folder folders[] = SQLManager.getFoldersInfoSQL(getStrAccount());

        //attachment part
        //need a attachments here    use eID to find uID and use uID find account uID attName in Attachments
        //use eID find uID
        String uID = SQLManager.getUIDSQL(int_emailID);
        Attachment attachments[] = SQLManager.getAttachmentsInfoSQL(uID);
        boolean att = false;  // is there att or not
        if (attachments[0] != null ){
            att = true;
        }

        ST st = templates.getInstanceOf("viewEmail");
        st.add("username", getUsername());
        st.add("ea_address", getAccount());
        st.add("email", email);
        st.add("infolder", infolder);
        st.add("folders", folders);
        st.add("attachments", attachments);
        st.add("containsatt", att);
        return st;
    }

    @Override
    public ST getTitle() {
        return new ST("View: "+getStrAccount());
    }

}