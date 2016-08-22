package webmail.pages;

import org.stringtemplate.v4.ST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JOKER on 11/30/14.
 */
public class EditPage extends MailPage {
    public EditPage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    public void verify() { }

    @Override
    public ST body() {
        ST st = templates.getInstanceOf("edit");
        st.add("username", getUsername());
        st.add("ea_address", getAccount());
        return st;
    }

    @Override
    public ST getTitle() {
        return new ST("Edit your password");
    }

}
