package webmail.pages;

import org.stringtemplate.v4.ST;
import webmail.misc.VerifyException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JOKER on 10/28/14.
 */


public class AmailPage extends Page {
    public AmailPage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

// -----------------------------sample
    @Override
    public void handleDefaultArgs() {
        // handle default args like page number, etc...
        String pageStr = request.getParameter("welcome");
        if ( pageStr!=null ) {
            pageNum = Integer.valueOf(pageStr);            //?
        }
    }

    @Override
    public void generate() {
        handleDefaultArgs();
        try {
            verify(); // check args before generation
            ST pageST = templates.getInstanceOf("welcome");
            //ST bodyST = body();
            //pageST.add("body", bodyST);
            //pageST.add("title", getTitle());

            String page = pageST.render();  //change to String
            out.print(page);
        }
        catch (VerifyException ve) {
            // redirect to error page
        }
        finally {
            out.close();
        }
    }
    @Override
    public ST body() {
        return templates.getInstanceOf("amail");
    }

    @Override
    public ST getTitle() {
        return new ST("Amail");
    }
}