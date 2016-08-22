package webmail.managers.ajaxManagers.registrationPageManagers;

import webmail.managers.Manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JOKER on 11/23/14.
 */
public class ConfirmManager extends Manager {

    public ConfirmManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void run() {
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");
        String onStatu = request.getParameter("onStatu");
        if(onStatu.equals("onfocus")){
            onFocus();
        }
        else if(onStatu.equals("onblur")){
            onBlur(password, confirm);
        }
    }
    public void onFocus(){

    }
    public void onBlur(String password, String confirm){
        try{
            if(confirm.equals("")){
                response.getWriter().write("Confirm can't be empty.");
            }
            else if ( !password.equals(confirm) ) {
                response.getWriter().write("Not the same password.");
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}