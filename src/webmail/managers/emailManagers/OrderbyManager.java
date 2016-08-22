package webmail.managers.emailManagers;

import webmail.managers.Manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JOKER on 12/1/14.
 */
public class OrderbyManager extends Manager {

    public OrderbyManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    public static String order = "date";
    @Override
    public void run() {
        String folder = request.getParameter("folder");
        order = request.getParameter("orderselect");
        if (folder.contains("inbox")||folder.contains("sent")||folder.contains("trash")) {
            try {
                response.sendRedirect("/" + folder + "?order=" + order);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            //redirect to a userfolder
            try {
                response.sendRedirect("/userFolder?folder="+folder+"&order=" + order);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
