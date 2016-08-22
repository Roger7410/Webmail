package webmail.managers.emailManagers;



import webmail.entities.User;
import webmail.managers.Manager;
import webmail.managers.otherManagers.SQLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import webmail.pages.Page;

/**
 * Created by JOKER on 11/26/14.
 */
public class UploadManager extends Manager {

    String UPLOAD_TEMP_DIR = "staticFiles/uploadTmp";

    public UploadManager(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }
    // not using this manager for now
    @Override
    public void run() {
        String from = "";
        String to = "";
        String subject = "";
        String content = "";

        try {
//            String to = request.getParameter("to");
//            String subject = request.getParameter("subject");
//            String content = request.getParameter("content");
//            System.out.println(to+" "+subject+" "+content);

            // Check that we have a file upload request
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (isMultipart) {
                // Create a new file upload handler
//                ServletFileUpload upload = new ServletFileUpload();
                // Create a factory for disk-based file items
                DiskFileItemFactory factory = new DiskFileItemFactory();

                // Set factory constraints
                factory.setSizeThreshold(1024*1024*5);
                File dirFile = new File(UPLOAD_TEMP_DIR);
                if (!dirFile.exists()) {
                    if (!dirFile.mkdirs())
                        System.err.println("no file");
                }
                factory.setRepository(new File("/tmp"));

                // Create a new file upload handler
                ServletFileUpload upload = new ServletFileUpload(factory);

                // Set overall request size constraint
                upload.setHeaderEncoding("UTF-8");
                upload.setSizeMax(1024*1024*5);
                upload.setFileSizeMax(1024*1024*5);


                // Parse the request
                List<FileItem> items = upload.parseRequest(request);
                // Process the uploaded items
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    String name = item.getFieldName();
                    if (item.isFormField()) {
                        if(item.getFieldName().equals("to")){
                            to = item.getString();
                        }else if(item.getFieldName().equals("from")){
                            from = item.getString();
                        }else if(item.getFieldName().equals("subject")){
                            subject = item.getString();
                        }else if(item.getFieldName().equals("content")){
                            content = item.getString();
                        }
                    } else {
                        String filename = item.getName();
                        //create file
                        File file = new File(dirFile, filename);
                        if (!file.exists())
                            if (!file.createNewFile())
                                System.err.println("can not create file");
                        item.write(file);
                        long len = file.length();
                        //not using now
//                        String size = null;
//                        if(len >= 1024*1024){
//                            size = (double)(Math.round((double)len/(1024 * 1024)*10)/10.0) + " MB";
//                        }else if(len > 1024){
//                            size = len/1024 + " KB";
//                        }else{
//                            size = len + " bytes";
//                        }
                        //out.println(item.getName()+ " (" + size + ")");
                    }
                }
                //System.out.println(from+to+subject+content);

            }
        }catch (FileUploadException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }


        try {
            response.sendRedirect("/sendEmail?to="+to+"&subject="+subject+"&content="+content);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
