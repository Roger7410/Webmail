package webmail.managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JOKER on 11/23/14.
 */
public abstract class Manager {

    public static HttpServletRequest request;
    public static HttpServletResponse response;

    public Manager(HttpServletRequest request,
                       HttpServletResponse response)
    {
        this.request = request;
        this.response = response;
    }

    //default running fun()
    public abstract void run();

}
