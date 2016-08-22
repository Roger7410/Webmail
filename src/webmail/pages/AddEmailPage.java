package webmail.pages;

import org.stringtemplate.v4.ST;
import webmail.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by JOKER on 11/24/14.
 */
public class AddEmailPage extends Page {
    public AddEmailPage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }


    @Override
    public ST body() {
        ST addAccountST = templates.getInstanceOf("addEmail");
        addAccountST.add("username", getUsername());
        return addAccountST;
    }

    @Override
    public ST getTitle() {
        return new ST("ADD Email");
    }

    public ST getUsername(){
        HttpSession session = request.getSession();
        User su = (User)session.getAttribute("user");
        String username = su.getUsername();
        return new ST(username);
    }
}
