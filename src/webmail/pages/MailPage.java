package webmail.pages;

import org.stringtemplate.v4.ST;
import webmail.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by JOKER on 11/27/14.
 */
public abstract class MailPage extends Page {
    public MailPage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    public ST getAccount(){
        HttpSession session = request.getSession();
        String ea_address = (String)session.getAttribute("account");
        return new ST(ea_address);
    }

    public String getStrUsername(){
        HttpSession session = request.getSession();
        User su = (User)session.getAttribute("user");
        String username = su.getUsername();
        return username;
    }

    public String getStrAccount(){
        HttpSession session = request.getSession();
        String ea_address = (String)session.getAttribute("account");
        return ea_address;
    }

    public ST getUsername(){
        HttpSession session = request.getSession();
        User su = (User)session.getAttribute("user");
        String username = su.getUsername();
        return new ST(username);
    }

}

