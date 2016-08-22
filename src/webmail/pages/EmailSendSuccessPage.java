package webmail.pages;

import org.stringtemplate.v4.ST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JOKER on 11/26/14.
 */
public class EmailSendSuccessPage extends Page {
    public EmailSendSuccessPage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public ST body() {
        return templates.getInstanceOf("emailSendSuccess");
    }

    @Override
    public ST getTitle() {
        return new ST("Success");
    }
}