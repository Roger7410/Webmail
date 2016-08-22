package webmail.pages;

import org.stringtemplate.v4.ST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JOKER on 11/26/14.
 */
public class SendEmailWithToPage extends Page {
    public SendEmailWithToPage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }


    @Override
    public ST body() {
        String account = (String)request.getSession().getAttribute("account");
        ST st = templates.getInstanceOf("sendEmailWithTo");
        String to = request.getParameter("to");
        st.add("ea_address", account);
        st.add("to", to);
        return st;
    }

    @Override
    public ST getTitle() {
        return new ST("Send Email");
    }
}
