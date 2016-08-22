package webmail.pages;

import org.stringtemplate.v4.ST;
import webmail.entities.Contacts;
import webmail.entities.Folder;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by JOKER on 12/2/14.
 */
public class ContactsPage extends MailPage {
    public ContactsPage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public ST body() {
        String infolder = request.getParameter("infolder");
        ST st = templates.getInstanceOf("contacts");
        HttpSession session = request.getSession();
        String account = (String)session.getAttribute("account");
        Contacts contacts[] = SQLManager.getContactsInfoSQL(account);
        st.add("username", getUsername());
        st.add("ea_address", getAccount());
        st.add("infolder", infolder);
        st.add("contacts", contacts);
        Folder folders[] = SQLManager.getFoldersInfoSQL(getStrAccount());
        st.add("folders", folders);
        return st;
    }

    @Override
    public ST getTitle() {
        return new ST("Contacts");
    }

}
