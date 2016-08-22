package webmail.pages;

import org.stringtemplate.v4.ST;
import webmail.entities.Email;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JOKER on 12/1/14.
 */
public class SearchPage extends MailPage {
    public SearchPage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public ST body() {
        String search_type = request.getParameter("search-select");
        String search_input = request.getParameter("search-input");

        Email emails[] = SQLManager.getSearchEmailsInfoSQL(getStrAccount(), search_type, search_input);
        ST st = templates.getInstanceOf("search");
        st.add("username", getUsername());
        st.add("ea_address", getAccount());
        st.add("emails", emails);
        return st;
    }

    @Override
    public ST getTitle() {
        return new ST("Inbox: "+getStrAccount());
    }

}
