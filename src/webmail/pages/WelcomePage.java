package webmail.pages;


import org.stringtemplate.v4.ST;
import webmail.entities.EmailAccount;
import webmail.entities.User;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class WelcomePage extends Page {
    public WelcomePage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }


    public void verify() { }


    @Override
    public ST body() {
        //EmailAccount[] emailAccounts;
        EmailAccount[] emailAccounts;
        emailAccounts = SQLManager.getEmailAccountListSQL(getStringUsername());
        ST welcomeST = templates.getInstanceOf("welcome");
        welcomeST.add("username", getUsername());
        welcomeST.add("emailAccounts",emailAccounts);
        return welcomeST;
    }

    @Override
    public ST getTitle() {
        return new ST("Welcome to Amail");
    }

    public String getStringUsername(){
        String s_username = null;
        HttpSession session = request.getSession();
        User su = (User)session.getAttribute("user");
        s_username = su.getUsername();
        return s_username;
    }

    public ST getUsername(){
        HttpSession session = request.getSession();
        User su = (User)session.getAttribute("user");
        String username = su.getUsername();
        return new ST(username);
    }

}
