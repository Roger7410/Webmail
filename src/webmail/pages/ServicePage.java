package webmail.pages;

import org.stringtemplate.v4.ST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JOKER on 10/28/14.
 */


public class ServicePage extends Page {
    public ServicePage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }


    @Override
    public ST body() {
        return templates.getInstanceOf("service");
    }

    @Override
    public ST getTitle() {
        return new ST("Service here");
    }
}
