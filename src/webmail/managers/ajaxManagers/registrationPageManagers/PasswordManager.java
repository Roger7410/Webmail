package webmail.managers.ajaxManagers.registrationPageManagers;

import webmail.managers.Manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JOKER on 11/23/14.
 */
public class PasswordManager extends Manager{

    public PasswordManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void run() {
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");
        String onStatu = request.getParameter("onStatu");
//        System.out.println(onStatu);
//        System.out.println(confirm);
        if(onStatu.equals("onfocus")){
            onFocus();
        }
        else if(onStatu.equals("onblur")){
            onBlur(password,confirm);
        }
        else if(onStatu.equals("onchange")){
            System.out.println("lalala in in in");
            onChange();
        }
    }
    public void onFocus(){

    }
    public void onBlur(String password,String confirm){
        try{
            if(password.equals("")){
                response.getWriter().write("Password can't be empty.");
            }
            else if ( password.length()<6 || password.length() > 18) {
                response.getWriter().write("Length should be 6-18.");
            }
            else if ( !password.equals(confirm) && confirm!=null && !confirm.equals("") ){
                //empty the confirm   ---------------  dont know how to do it    pring something now.
                response.getWriter().write("Are you kidding me, you change your password after you confirmed it. Need fix here.");
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void onChange(){
        //empty the confirm password
        //request.setAttribute("confirm",null);
        Object c = request.getAttribute("confirm");
        String s = c.toString();
        System.out.println("lalalal"+s);
    }
}
