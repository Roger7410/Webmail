package webmail.managers.emailManagers;

import webmail.managers.Manager;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by JOKER on 11/30/14.
 */
public class EmptyManager extends Manager {

    public EmptyManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    public String getAccount(){
        HttpSession session = request.getSession();
        String str_account = (String)session.getAttribute("account");
        return str_account;
    }

    @Override
    public void run() {
        String str_account = getAccount();
        SQLManager.emptyTrashSQL(str_account);
        try {
            response.sendRedirect("/trash");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
