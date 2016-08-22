package webmail.pages;

import org.stringtemplate.v4.ST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JOKER on 11/27/14.
 */
public class DraftPage extends MailPage {
    public DraftPage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    public void verify() { }

    @Override
    public ST body() {
        ST st = templates.getInstanceOf("draft");
        st.add("username", getUsername());
        st.add("ea_address", getAccount());
        return st;
    }

    @Override
    public ST getTitle() {
        return new ST("Draft: "+getStrAccount());
    }

}
