package webmail.entities;

import java.io.*;

/**
 * Created by JOKER on 5/7/15.
 */
public class FileUtil {
    public static byte[] getBytesFromFile(File file){

        byte[] buffer = null;
        BufferedInputStream bis = null;

        InputStream fis = null;
        try {

            if(file.exists()) {
                fis = new FileInputStream(file.getAbsolutePath());
                bis = new BufferedInputStream(fis);

                int len = (int)file.length();
                int bytesRead = 0;
                buffer = new byte[len];
                if ((bytesRead = bis.read(buffer, 0, len)) == -1) {
                    System.err.println("wrong");
                }
//                bis.read(buffer);


            }

        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(bis != null)
                    bis.close();
                if(fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buffer;
    }
}
