package webmail.pages;

import org.stringtemplate.v4.ST;
import webmail.entities.Email;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JOKER on 11/29/14.
 */
public class ReplyPage extends MailPage {
    public ReplyPage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    public void verify() { }

    @Override
    public ST body() {
        String tmp_emailID = request.getParameter("emailID");
        int int_emailID = Integer.parseInt(tmp_emailID);
        Email email = SQLManager.getEmailInfoSQL(int_emailID);

        String infolder = request.getParameter("infolder");

        ST st = templates.getInstanceOf("reply");
        st.add("username", getUsername());
        st.add("ea_address", getAccount());
        st.add("email", email);
        st.add("infolder", infolder);
        return st;
    }

    @Override
    public ST getTitle() {
        return new ST("Reply: "+getStrAccount());
    }

}
