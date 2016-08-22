package webmail.pages;

import org.stringtemplate.v4.ST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JOKER on 10/28/14.
 */


public class LoginPage extends Page {
    public LoginPage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

//        try {
//            response.getWriter().write("xxxxxxxxxxxxxxxx");
//        }catch(IOException e){
//
//        }
        //if loggedin goto welcome page
//        if(UserLoginManager.SESSION_LOGGEDIN == "true"){
//            try{
//                response.sendRedirect("/welcome");
//            }
//            catch (IOException e){
//                System.out.println(e.getMessage());
//            }
//        }       dont need .

    @Override
    public ST body() {
        return templates.getInstanceOf("login");
    }

    @Override
    public ST getTitle() {
        return new ST("Login");
    }
}