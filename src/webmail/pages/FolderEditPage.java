package webmail.pages;

import org.stringtemplate.v4.ST;
import webmail.entities.Contacts;
import webmail.entities.Folder;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JOKER on 12/2/14.
 */
public class FolderEditPage extends MailPage {
    public FolderEditPage(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    public void verify() { }

    @Override
    public ST body() {
        int folderID = Integer.parseInt(request.getParameter("folderID"));
        Folder folder = SQLManager.getFolderInfoSQL(folderID);
        ST st = templates.getInstanceOf("folderEdit");
        st.add("username", getUsername());
        st.add("ea_address", getAccount());
        st.add("folder", folder);
        return st;
    }

    @Override
    public ST getTitle() {
        return new ST("Edit your folder");
    }

}
