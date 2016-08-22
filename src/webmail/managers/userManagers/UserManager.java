package webmail.managers.userManagers;

import webmail.entities.User;
import webmail.managers.Manager;
import webmail.managers.otherManagers.MD5Manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by JOKER on 11/9/14.
 */
public class UserManager extends Manager{


    public static final String SESSION_MEMBER = "user";
    public static final String SESSION_ACCOUNT = "account";
    public static final String SESSION_LOGGEDIN = "loggedin";

    public UserManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    public User getUserInformation(){
        String username = request.getParameter("username");
        String password = MD5Manager.MD5(request.getParameter("password"));
        User u = new User(username, password);
        //Page p = new HomePage(request, response);
        //p.generate();
        return u;
    }

    public HttpSession sessionCreation(){
        User u = getUserInformation();
        HttpSession session = request.getSession();  //verify   change!!!
        User su = (User)session.getAttribute("user");
        if ( su==null ) {
            //su = new User(u.getUsername(),u.getPassword());
            session.setAttribute("user", u);  //use u here    su is fine
        }
        return session;
    }

    //default running fun()
    public void run(){};





}
