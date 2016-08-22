package webmail.managers.ajaxManagers;

import webmail.managers.userManagers.UserManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JOKER on 11/22/14.
 */
public class TestManager extends UserManager {
    public TestManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }


    @Override
    public void run(){
        String result = request.getParameter("username");

        System.out.println(result);
        if( result.equals("")){
            System.out.println(1);
        }
        if( result.length()==0){
            System.out.println(2);
        }
        if( result==null){
            System.out.println(3);
        }

        if( result.equals("")||result.equals(null) ){
            try {
                response.getWriter().write("cant be empty");
            }
            catch(IOException e){

            }
        }
        if( result.equals("aaa") ){
            try {
                System.out.println("lalalala");
                response.getWriter().write("cant be aaa");
                System.out.println("lalalala");
            }
            catch(IOException e){

            }
        }






    }

}
