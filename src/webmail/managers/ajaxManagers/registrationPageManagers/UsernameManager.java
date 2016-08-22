package webmail.managers.ajaxManagers.registrationPageManagers;

import webmail.managers.Manager;
import webmail.managers.otherManagers.SQLManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JOKER on 11/23/14.
 */
public class UsernameManager extends Manager {

    public UsernameManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public void run(){
        String username = request.getParameter("username");
        boolean exist = SQLManager.usernameExistSQL(username);
        boolean containsWrongChar = !checkChar(username);
        try {
            if (username.equals("")||username == null) {
                response.getWriter().write("Username can't be empty.");
            }
            else if (containsWrongChar) {
                response.getWriter().write("Plz use letters, numbers and '- _ .'.");
            }
            else if (username.length() > 20) {
                response.getWriter().write("Length can't over 20.");
            }
            else if (exist == true) {
                response.getWriter().write("Exist username, plz change.");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean IsDigit(char cCheck)
    {
        return (('0'<=cCheck) && (cCheck<='9'));
    }
    public boolean IsAlpha(char cCheck)
    {
        return ((('a'<=cCheck) && (cCheck<='z')) || (('A'<=cCheck) && (cCheck<='Z')));
    }
//    public boolean IsaNull(char cCheck)
//    {
//        return(cCheck !=' ');
//    }

    public boolean checkChar(String username){
        for (int nIndex=0; nIndex<username.length(); nIndex++) {
            char cCheck = username.charAt(nIndex);
            if (!(IsDigit(cCheck) || IsAlpha(cCheck) ||  cCheck == '-' || cCheck == '_' || cCheck == '.')) {
                return false;
            }
        }
        return true;
    }

}

