package webmail.managers.ajaxManagers.addEmailPageManagers;

import webmail.managers.Manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JOKER on 11/25/14.
 */
public class AddEmailManager extends Manager {

    public AddEmailManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void run(){
        //pop
        String email = request.getParameter("email");

    }

}
