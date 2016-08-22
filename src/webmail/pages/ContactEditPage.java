package webmail.pages;

import org.stringtemplate.v4.ST;
import webmail.entities.Contacts;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JOKER on 12/2/14.
 */
public class ContactEditPage extends MailPage {
    public ContactEditPage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    public void verify() { }

    @Override
    public ST body() {
        String contactID = request.getParameter("contactID");
        int int_contactID = Integer.parseInt(contactID);
        Contacts contact = SQLManager.getContactInfoSQL(int_contactID);
        ST st = templates.getInstanceOf("contactEdit");
        st.add("username", getUsername());
        st.add("ea_address", getAccount());
        st.add("contact", contact);
        return st;
    }

    @Override
    public ST getTitle() {
        return new ST("Edit your contact");
    }

}
