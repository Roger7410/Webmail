package webmail.pages;

import org.stringtemplate.v4.ST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JOKER on 11/26/14.
 */
public class SendEmailPage extends Page {
    public SendEmailPage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }


    @Override
    public ST body() {
        String account = (String)request.getSession().getAttribute("account");
        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");

        //store all file.toString in a list
        List<String> atts = new ArrayList<String>();

        File uploadDir = new File("staticFiles/uploadTmp");
        File []tmpatts = uploadDir.listFiles();
        if (tmpatts != null) {
            for (File att : tmpatts) {
                if(!att.isFile())
                    continue;
                if(att.getName().substring(0,1).equals("."))
                    continue;
                atts.add(att.getName());
            }
        }
        ST st = templates.getInstanceOf("sendEmail");
        st.add("ea_address", account);
        st.add("atts", atts);
        st.add("to", to);
        st.add("subject", subject);
        st.add("content", content);
        return st;
    }

    @Override
    public ST getTitle() {
        return new ST("Send Email");
    }
}
