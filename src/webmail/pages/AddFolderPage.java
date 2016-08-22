package webmail.pages;

import org.stringtemplate.v4.ST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JOKER on 12/2/14.
 */
public class AddFolderPage extends MailPage {
    public AddFolderPage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public ST body() {

        ST st = templates.getInstanceOf("addFolder");
        st.add("username", getUsername());
        st.add("ea_address", getAccount());
        return st;
    }

    @Override
    public ST getTitle() {
        return new ST("plz add your folder");
    }

}
