package webmail.pages;

import org.stringtemplate.v4.ST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JOKER on 10/28/14.
 */


public class RegistrationPage extends Page {
    public RegistrationPage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }


    @Override
    public ST body() {
        return templates.getInstanceOf("registration");
    }

    @Override
    public ST getTitle() {
        return new ST("Create your Amail account");
    }
}
