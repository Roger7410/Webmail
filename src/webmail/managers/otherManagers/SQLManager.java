package webmail.managers.otherManagers;

import webmail.entities.*;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by JOKER on 11/9/14.
 */

public class SQLManager{
//    private static int count = 1;

    public static Connection createDB(){
        Connection db = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbFile = "webmailDB/amail";
            db = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return db;
    }

    public static void closeDB(Connection db){
        try{
            if(db!=null){
                db.close();
            }
        }
        catch (SQLException e){
            System.err.println(e);
        }
    }

    public static boolean usernameExistSQL(String username){
        Connection db = createDB();
        boolean exist = false;
        try {
            PreparedStatement search = db.prepareStatement("select * from Users where username=?");
            search.setQueryTimeout(30);  //set timeout to 30 sec.
            search.setString(1, username);
            ResultSet rs = search.executeQuery();
            if( rs.next() ){
                exist = true;
            }
            search.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeDB(db);
        return exist;
    }

    public static void registrationSQL(User u){
        Connection db = createDB();
        try{
            //prepared insert
            PreparedStatement insert = db.prepareStatement("insert into Users values (?,?,?)");
            insert.setQueryTimeout(30);  // set timeout to 30 sec.
            insert.setString(2, u.getUsername());
            insert.setString(3, u.getPassword());
            int n = insert.executeUpdate();
            if ( n!=1 ) {
                System.err.println("Bad update");
            }
            insert.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
    }

    public static boolean loginSQL(User u){
        boolean flag = false;
        Connection db = createDB();
        try{
            //prepared insert
            PreparedStatement login = db.prepareStatement("select * from Users where username=? and password=?");
            login.setQueryTimeout(30);  // set timeout to 30 sec.
            login.setString(1, u.getUsername());
            login.setString(2, u.getPassword());
            ResultSet rs = login.executeQuery();
            if ( rs.next() ) {
                flag = true;
            }
            login.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
        return flag;
    }

    public static void addEmailAccountSQL(EmailAccount ea){
        Connection db = createDB();
        try{
            //prepared insert
            PreparedStatement insert = db.prepareStatement("insert into EmailAccounts values (?,?,?,?)");
            insert.setQueryTimeout(30);  // set timeout to 30 sec.
            insert.setString(2,ea.getEA_username());
            insert.setString(3,ea.getEA_address());
            insert.setString(4,ea.getEA_password());
            int n = insert.executeUpdate();
            if ( n!=1 ) {
                System.err.println("Bad update");
            }
            insert.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
    }

    public static EmailAccount[] getEmailAccountListSQL(String eaUsername){
        Connection db = createDB();
        EmailAccount[] emailAccounts = new EmailAccount[10];
        int i = 0;
        try{
            PreparedStatement select = db.prepareStatement("select eaAddress from EmailAccounts where eaUsername=?");
            select.setQueryTimeout(30);  // set timeout to 30 sec.
            select.setString(1, eaUsername);
            ResultSet rs = select.executeQuery();
//            ResultSetMetaData metaData = rs.getMetaData();
//            int numberOfColumns = metaData.getColumnCount();
            while ( rs.next() ) {
                String columnValue = rs.getString(1);
                emailAccounts[i] = new EmailAccount(null, columnValue, null);
                i++;
            }
            select.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
        return emailAccounts;
    }

    public static String getEmailAccountPwdSQL(String eaUsername,String eaAddress){
        Connection db = createDB();
        String pwd = null;
        try{
            PreparedStatement select = db.prepareStatement("select eaPassword from EmailAccounts where eaUsername=? and eaAddress=?");
            select.setQueryTimeout(30);  // set timeout to 30 sec.
            select.setString(1, eaUsername);
            select.setString(2, eaAddress);
            ResultSet rs = select.executeQuery();
//            ResultSetMetaData metaData = rs.getMetaData();
//            int numberOfColumns = metaData.getColumnCount();
            if( rs.next() ) {
                String columnValue = rs.getString(1);
                pwd = columnValue;
            }
            select.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
        return pwd;
    }

    public static void addSentEmailInfoSQL(String account,String from,String to,String subject,String contentTEXT){
        boolean alreadyRead=false;
        String folder = "SENT";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String date = dateFormat.format(new Date());
        Connection db = createDB();
        try{
            PreparedStatement insert = db.prepareStatement("insert into Emails values (?,?,?,?,?,?,?,?,?,?,?)");
            insert.setQueryTimeout(30);  // set timeout to 30 sec.
            insert.setString(2, account);
            insert.setString(3, from);
            insert.setString(4, to);
            insert.setString(5, subject);
            insert.setString(6, contentTEXT);
            insert.setBoolean(8, alreadyRead);
            insert.setString(10, folder);
            insert.setString(11, date);
            int n = insert.executeUpdate();
            if ( n!=1 ) {
                System.err.println("Bad update");
            }
            insert.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
    }

    public static void addPOPInfoSQL(Email email){
        Connection db = createDB();
        try{
            PreparedStatement insert = db.prepareStatement("insert into Emails values (?,?,?,?,?,?,?,?,?,?,?)");
            insert.setQueryTimeout(30);  // set timeout to 30 sec.
            insert.setString(2, email.getAccount());
            insert.setString(3, email.getFrom());
            insert.setString(4, email.getTo());
            insert.setString(5, email.getSubject());
            insert.setString(6, email.getContentTEXT());
            insert.setString(7, email.getContentHTML());
            insert.setBoolean(8, email.isAlreadyRead());
            insert.setString(9, email.getUniqueID());
            insert.setString(10, email.getFolder());
            insert.setString(11, email.getDate());
            int n = insert.executeUpdate();
            if ( n!=1 ) {
                System.err.println("Bad update");
            }
            insert.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
    }

    public static Email[] getEmailsInfoSQL(String in_account, String in_folder, int pageNum, String order){
        Connection db = createDB();
        Email[] emails = new Email[15];
        int i = 0;
        try{
            String sort ="desc";
            if(order.equals("from")||order.equals("to")||order.equals("subject")){
                sort = "";
            }
            if(order.equals("from")){
                order = "[from]";
            }
            if(order.equals("to")){
                order = "[to]";
            }
            String s = "select * from ( select * from Emails where account=? and folder=? order by "+order+" "+sort+") limit ?,?";
//            PreparedStatement select = db.prepareStatement("select * from ( select * from Emails where account=? and folder=? order by ? desc) limit ?,?");
            PreparedStatement select = db.prepareStatement(s);
            select.setQueryTimeout(30);  // set timeout to 30 sec.
            select.setString(1, in_account);
            select.setString(2, in_folder);
//            select.setObject(3, order);
//            int s_pageNum = (pageNum-1)*10+1;
//            int e_pageNum = (pageNum)*10;
//            select.setInt(4,s_pageNum);
//            select.setInt(5,e_pageNum);
            int s_pageNum = (pageNum-1)*15;
            int e_pageNum = 15;
            select.setInt(3,s_pageNum);
            select.setInt(4,e_pageNum);
            ResultSet rs = select.executeQuery();
            while (rs.next()) {
//                count++;
//                if(count >= (pageNum-1)*10+1 && count <= (pageNum)*10 ){
                    int emailID        = rs.getInt(1);
                    String account     = rs.getString(2);
                    String from        = rs.getString(3);
                    String to          = rs.getString(4);
                    String subject     = rs.getString(5);
                    String contentTEXT = rs.getString(6);
                    String contentHTML = rs.getString(7);
                    boolean alreadyRead= rs.getBoolean(8);
                    String uniqueID    = rs.getString(9);
                    String folder      = rs.getString(10);
                    String date        = rs.getString(11);
                    Email email = new Email(emailID,account,from,to,subject,contentTEXT,contentHTML,alreadyRead,uniqueID,folder,date);
                    emails[i] = email;
                    i++;
//                }
            }
            select.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
        return emails;
    }

    public static Email[] getSearchEmailsInfoSQL(String in_account, String type, String input){
        Connection db = createDB();
        Email[] emails = new Email[100];
        int i = 0;
        try{
            if(type.equals("from")){
                type = "[from]";
            }
            if(type.equals("to")){
                type = "[to]";
            }
            String s = "select * from Emails where account=? and "+type+" like '%"+input+"%'";
//            PreparedStatement select = db.prepareStatement("select * from ( select * from Emails where account=? and folder=? order by ? desc) limit ?,?");
            PreparedStatement select = db.prepareStatement(s);
            select.setQueryTimeout(30);  // set timeout to 30 sec.
            select.setString(1, in_account);

            ResultSet rs = select.executeQuery();
            while (rs.next()) {
//                count++;
//                if(count >= (pageNum-1)*10+1 && count <= (pageNum)*10 ){
                int emailID        = rs.getInt(1);
                String account     = rs.getString(2);
                String from        = rs.getString(3);
                String to          = rs.getString(4);
                String subject     = rs.getString(5);
                String contentTEXT = rs.getString(6);
                String contentHTML = rs.getString(7);
                boolean alreadyRead= rs.getBoolean(8);
                String uniqueID    = rs.getString(9);
                String folder      = rs.getString(10);
                String date        = rs.getString(11);
                Email email = new Email(emailID,account,from,to,subject,contentTEXT,contentHTML,alreadyRead,uniqueID,folder,date);
                emails[i] = email;
                i++;
//                }
            }
            select.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
        return emails;
    }

    public static Email getEmailInfoSQL(int eID){
        Connection db = createDB();
        Email email = new Email(eID,null,null,null,null,null,null,false,null,null,null);
        try{
            PreparedStatement select = db.prepareStatement("select * from Emails where emailID=?");
            select.setQueryTimeout(30);  // set timeout to 30 sec.
            select.setInt(1, eID);
            ResultSet rs = select.executeQuery();
            while ( rs.next() ) {
                int emailID        = rs.getInt(1);
                String account     = rs.getString(2);
                String from        = rs.getString(3);
                String to          = rs.getString(4);
                String subject     = rs.getString(5);
                String contentTEXT = rs.getString(6);
                String contentHTML = rs.getString(7);
                boolean alreadyRead= rs.getBoolean(8);
                String uniqueID    = rs.getString(9);
                String folder      = rs.getString(10);
                String date        = rs.getString(11);
                email = new Email(emailID,account,from,to,subject,contentTEXT,contentHTML,alreadyRead,uniqueID,folder,date);
            }
            select.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
        return email;
    }

    public static void moveToTrashSQL(int eID){
        Connection db = createDB();
        try{
//            PreparedStatement select = db.prepareStatement("select * from Emails where emailID=?");
            PreparedStatement select = db.prepareStatement("update Emails set folder='TRASH' where emailID=?");
            select.setQueryTimeout(30);  // set timeout to 30 sec.
            select.setInt(1, eID);
            int n = select.executeUpdate();
            if ( n!=1 ) {
                System.err.println("Bad update");
            }
            select.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
    }

    public static void emptyTrashSQL(String str_account){
        Connection db = createDB();
        try{
            PreparedStatement select = db.prepareStatement("delete from Emails where folder='TRASH' and account=?");
            select.setQueryTimeout(30);  // set timeout to 30 sec.
            select.setString(1, str_account);
            int n = select.executeUpdate();
//            if ( n!=1 ) {
//                System.err.println("Bad update");
//            }
            select.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
    }

    public static void changePwdSQL(String c_username, String new_pwd){
        Connection db = createDB();
        try{
//            PreparedStatement select = db.prepareStatement("select * from Emails where emailID=?");
            PreparedStatement change = db.prepareStatement("update Users set password = ? where username = ?");
            change.setQueryTimeout(30);  // set timeout to 30 sec.
            change.setString(1, new_pwd);
            change.setString(2, c_username);
            int n = change.executeUpdate();
            if ( n!=1 ) {
                System.err.println("Bad update");
            }
            change.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
    }

    public static void changeToReadedSQL(int eID){
        Connection db = createDB();
        try{
//            PreparedStatement select = db.prepareStatement("select * from Emails where emailID=?");
            PreparedStatement select = db.prepareStatement("update Emails set alreadyRead=1 where emailID=?");
            select.setQueryTimeout(30);  // set timeout to 30 sec.
            select.setInt(1, eID);
            int n = select.executeUpdate();
            if ( n!=1 ) {
                System.err.println("Bad update");
            }
            select.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
    }

    public static void changeToUnreadedSQL(int eID){
        Connection db = createDB();
        try{
//            PreparedStatement select = db.prepareStatement("select * from Emails where emailID=?");
            PreparedStatement select = db.prepareStatement("update Emails set alreadyRead=0 where emailID=?");
            select.setQueryTimeout(30);  // set timeout to 30 sec.
            select.setInt(1, eID);
            int n = select.executeUpdate();
            if ( n!=1 ) {
                System.err.println("Bad update");
            }
            select.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
    }

    public static void addContactSQL(Contacts c){
        Connection db = createDB();
        try{
            //prepared insert
            PreparedStatement insert = db.prepareStatement("insert into Contacts values (?,?,?,?,?)");
            insert.setQueryTimeout(30);  // set timeout to 30 sec.
            insert.setString(2, c.getcAccount());
            insert.setString(3, c.getcName());
            insert.setString(4, c.getcEmail());
            insert.setString(5, c.getcPhone());
            int n = insert.executeUpdate();
            if ( n!=1 ) {
                System.err.println("Bad update");
            }
            insert.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
    }

    public static Contacts[] getContactsInfoSQL(String account){
        Connection db = createDB();
        Contacts[] contacts = new Contacts[50];
        int i = 0;
        try {
            PreparedStatement select = db.prepareStatement("select * from Contacts where cAccount=?");
            select.setQueryTimeout(30);  // set timeout to 30 sec.
            select.setString(1, account);

            ResultSet rs = select.executeQuery();
            while (rs.next()) {
    //                count++;
    //                if(count >= (pageNum-1)*10+1 && count <= (pageNum)*10 ){
                int contactID        = rs.getInt(1);
                String cAccount     = rs.getString(2);
                String cName        = rs.getString(3);
                String cEmail          = rs.getString(4);
                String cPhone     = rs.getString(5);
                Contacts contact = new Contacts(contactID, cAccount, cName, cEmail, cPhone);
                contacts[i] = contact;
                i++;
            }
        }
        catch (SQLException e) {
                e.printStackTrace();
        }
        closeDB(db);
        return contacts;
    }

    public static Contacts getContactInfoSQL(int id){
        Connection db = createDB();
        Contacts contact = new Contacts(0,null,null,null,null);
        try {

            PreparedStatement select = db.prepareStatement("select * from Contacts where contactID=?");
            select.setQueryTimeout(30);  // set timeout to 30 sec.
            select.setInt(1, id);
            ResultSet rs = select.executeQuery();
            while (rs.next()) {
                int contactID        = rs.getInt(1);
                String cAccount     = rs.getString(2);
                String cName        = rs.getString(3);
                String cEmail          = rs.getString(4);
                String cPhone     = rs.getString(5);
                contact = new Contacts(contactID, cAccount, cName, cEmail, cPhone);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        closeDB(db);
        return contact;
    }

    public static void updateContactSQL(int id, String name, String email, String phone){
        Connection db = createDB();
        try{
//            PreparedStatement select = db.prepareStatement("select * from Emails where emailID=?");
            PreparedStatement change = db.prepareStatement("update Contacts set cName = ? , cEmail = ? , cPhone = ? where contactID = ?");
            change.setQueryTimeout(30);  // set timeout to 30 sec.
            change.setString(1, name);
            change.setString(2, email);
            change.setString(3, phone);
            change.setInt(4, id);
            int n = change.executeUpdate();
            if ( n!=1 ) {
                System.err.println("Bad update");
            }
            change.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
    }

    public static void deleteContactSQL(int id){
        Connection db = createDB();
        try{
//            PreparedStatement select = db.prepareStatement("select * from Emails where emailID=?");
            PreparedStatement select = db.prepareStatement("delete from Contacts where contactID = ?");
            select.setQueryTimeout(30);  // set timeout to 30 sec.
            select.setInt(1, id);
            int n = select.executeUpdate();
            if ( n!=1 ) {
                System.err.println("Bad update");
            }
            select.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
    }

    public static Folder[] getFoldersInfoSQL(String account){
        Connection db = createDB();
        Folder[] folders = new Folder[50];
        int i = 0;
        try {
            PreparedStatement select = db.prepareStatement("select * from Folders where emailAccount=?");
            select.setQueryTimeout(30);  // set timeout to 30 sec.
            select.setString(1, account);

            ResultSet rs = select.executeQuery();
            while (rs.next()) {
                //                count++;
                //                if(count >= (pageNum-1)*10+1 && count <= (pageNum)*10 ){
                int folderID        = rs.getInt(1);
                String emailAccount     = rs.getString(2);
                String folderName        = rs.getString(3);
                Folder folder = new Folder(folderID, emailAccount, folderName);
                folders[i] = folder;
                i++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        closeDB(db);
        return folders;
    }

    public static void addFolderSQL(Folder f){
        Connection db = createDB();
        try{
            //prepared insert
            PreparedStatement insert = db.prepareStatement("insert into Folders values (?,?,?)");
            insert.setQueryTimeout(30);  // set timeout to 30 sec.
            insert.setString(2, f.getEmailAccount());
            insert.setString(3, f.getFolderName());
            int n = insert.executeUpdate();
            if ( n!=1 ) {
                System.err.println("Bad update");
            }
            insert.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
    }

    public static Folder getFolderInfoSQL(int id){
        Connection db = createDB();
        Folder folder = new Folder(0,null,null);
        try {

            PreparedStatement select = db.prepareStatement("select * from Folders where folderID=?");
            select.setQueryTimeout(30);  // set timeout to 30 sec.
            select.setInt(1, id);
            ResultSet rs = select.executeQuery();
            while (rs.next()) {
                int folderID        = rs.getInt(1);
                String emailAccount     = rs.getString(2);
                String folderName        = rs.getString(3);
                folder = new Folder(folderID, emailAccount, folderName);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        closeDB(db);
        return folder;
    }

    public static void updateFolderSQL(int id, String name){
        Connection db = createDB();
        try{
//            PreparedStatement select = db.prepareStatement("select * from Emails where emailID=?");
            PreparedStatement change = db.prepareStatement("update Folders set folderName = ? where folderID = ?");
            change.setQueryTimeout(30);  // set timeout to 30 sec.
            change.setString(1, name);
            change.setInt(2, id);
            int n = change.executeUpdate();
            if ( n!=1 ) {
                System.err.println("Bad update");
            }
            change.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
    }

    public static void deleteFolderSQL(int id){
        Connection db = createDB();
        try{
//            PreparedStatement select = db.prepareStatement("select * from Emails where emailID=?");
            PreparedStatement select = db.prepareStatement("delete from Folders where folderID = ?");
            select.setQueryTimeout(30);  // set timeout to 30 sec.
            select.setInt(1, id);
            int n = select.executeUpdate();
            if ( n!=1 ) {
                System.err.println("Bad update");
            }
            select.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
    }

    public static void moveToFolderSQL(int eID,String folder){
        Connection db = createDB();
        try{
            PreparedStatement select = db.prepareStatement("update Emails set folder=? where emailID=?");
            select.setQueryTimeout(30);  // set timeout to 30 sec.
            select.setString(1, folder);
            select.setInt(2, eID);
            int n = select.executeUpdate();
            if ( n!=1 ) {
                System.err.println("Bad update");
            }
            select.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
    }

    //att
    public static void addAttInfoSQL(String account, String uniqueID, String attName){
        Connection db = createDB();
        try{
            PreparedStatement insert = db.prepareStatement("insert into Attachments values (?,?,?,?)");
            insert.setQueryTimeout(30);  // set timeout to 30 sec.
            insert.setString(2, account);
            insert.setString(3, uniqueID);
            insert.setString(4, attName);
            int n = insert.executeUpdate();
            if ( n!=1 ) {
                System.err.println("Bad update");
            }
            insert.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
    }

    public static String getUIDSQL(int eid){
        Connection db = createDB();
        String uid = "";
        try{
            PreparedStatement select = db.prepareStatement("select uniqueID from Emails where emailID=?");
            select.setQueryTimeout(30);  // set timeout to 30 sec.
            select.setInt(1, eid);
            ResultSet rs = select.executeQuery();
//            ResultSetMetaData metaData = rs.getMetaData();
//            int numberOfColumns = metaData.getColumnCount();
            while ( rs.next() ) {
                uid = rs.getString(1);
            }
            select.close();
        }
        catch(SQLException e){
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        closeDB(db);
        return uid;
    }

    public static Attachment[] getAttachmentsInfoSQL(String uid){
        Connection db = createDB();
        Attachment[] attachments = new Attachment[10]; //only allow 10 atts now
        int i = 0;
        try {
            PreparedStatement select = db.prepareStatement("select * from Attachments where uID=?");
            select.setQueryTimeout(30);  // set timeout to 30 sec.
            select.setString(1, uid);

            ResultSet rs = select.executeQuery();
            while (rs.next()) {

                int attID        = rs.getInt(1);
                String account     = rs.getString(2);
                //String uID        = rs.getString(3);
                String attName    = rs.getString(4);
                Attachment attachment = new Attachment(attID, account, uid, attName);
                attachments[i] = attachment;
                i++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        closeDB(db);
        return attachments;
    }


}
