package webmail;


/**
 * Created by JOKER on 10/28/14.
 */

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import webmail.entities.Folder;
import webmail.managers.ajaxManagers.TestManager;
import webmail.managers.ajaxManagers.addEmailPageManagers.AddEmailManager;
import webmail.managers.ajaxManagers.addEmailPageManagers.AddEmailPasswordManager;
import webmail.managers.ajaxManagers.registrationPageManagers.ConfirmManager;
import webmail.managers.ajaxManagers.registrationPageManagers.PasswordManager;
import webmail.managers.ajaxManagers.registrationPageManagers.SubmitButtonManager;
import webmail.managers.ajaxManagers.registrationPageManagers.UsernameManager;
import webmail.managers.emailManagers.*;
import webmail.managers.userManagers.*;
import webmail.misc.STListener;
import webmail.pages.*;
import org.eclipse.jetty.server.handler.RequestLogHandler;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class WebmailServer {
    public static final String WEBMAIL_TEMPLATES_ROOT = "resources/templates";

    public static final STListener stListener = new STListener();  //listen error not used now

    public static Map<String,Class> mapping = new HashMap<String, Class>();  //store <url,page>
    static {
        //mapping.put("", HomePage.class);   //change to login maybe
        mapping.put("/", LoginPage.class);
        mapping.put("/amail", AmailPage.class);
        mapping.put("/login", LoginPage.class);
        mapping.put("/registration", RegistrationPage.class);
        mapping.put("/addAccount", AddEmailPage.class);
        mapping.put("/users", UserListPage.class);
        mapping.put("/welcome", WelcomePage.class);

        mapping.put("/help", HelpPage.class);
        mapping.put("/service", ServicePage.class);
        mapping.put("/aboutAmail", AboutAmailPage.class);

//      user Managers
        mapping.put("/userCreationManager", UserCreationManager.class);
        mapping.put("/userLoginManager", UserLoginManager.class);
        mapping.put("/userLogoutManager", UserLogoutManager.class);
        mapping.put("/userAddEmailManager", UserAddEmailManager.class);
        mapping.put("/edit", EditPage.class);
        mapping.put("/changePwdManager", ChangePwdManager.class);
        mapping.put("/testManager", TestManager.class);

//      registrationPage Managers
        mapping.put("/usernameManager", UsernameManager.class);
        mapping.put("/passwordManager", PasswordManager.class);
        mapping.put("/confirmManager", ConfirmManager.class);
        mapping.put("/submitButtonManager", SubmitButtonManager.class);

//      addEmailPage Managers
        mapping.put("/addEmailManager", AddEmailManager.class);
        mapping.put("/addEmailPassword", AddEmailPasswordManager.class);

//      email pages
        mapping.put("/afterWelcomeBeforeInboxManager", AfterWelcomeBeforeInboxManager.class);
        mapping.put("/inbox", InboxPage.class);
        mapping.put("/sent", SentPage.class);
        mapping.put("/draft", DraftPage.class);
        mapping.put("/trash", TrashPage.class);
        mapping.put("/sendEmail", SendEmailPage.class);
        mapping.put("/sendEmailManager", SendEmailManager.class);
        mapping.put("/emailSendSuccess", EmailSendSuccessPage.class);
        mapping.put("/checkEmailManager", CheckEmailManager.class);
        mapping.put("/viewEmail", ViewEmailPage.class);
        mapping.put("/reply", ReplyPage.class);
        mapping.put("/forward", ForwardPage.class);
        mapping.put("/replyManager", ReplyManager.class);
        mapping.put("/forwardManager", ForwardManager.class);
        mapping.put("/deleteManager", DeleteManager.class);
        mapping.put("/emptyManager", EmptyManager.class);
        mapping.put("/leftManager", LeftManager.class);
        mapping.put("/rightManager", RightManager.class);
        mapping.put("/orderbyManager", OrderbyManager.class);
        mapping.put("/searchPage", SearchPage.class);
        mapping.put("/contacts", ContactsPage.class);
        mapping.put("/addContact", AddContactPage.class);
        mapping.put("/addContactManager", AddContactManager.class);
        mapping.put("/contactEdit", ContactEditPage.class);
        mapping.put("/editContactManager", EditContactManager.class);
        mapping.put("/contactDeleteManager", ContactDeleteManager.class);
        mapping.put("/sendEmailWithTo", SendEmailWithToPage.class);
        //mapping.put("/page",Page.class);
        mapping.put("/unreadManager", UnreadManager.class);
        mapping.put("/folder", FolderPage.class);
        mapping.put("/addFolder", AddFolderPage.class);
        mapping.put("/addFolderManager", AddFolderManager.class);
        mapping.put("/folderEdit", FolderEditPage.class);
        mapping.put("/editFolderManager", EditFolderManager.class);
        mapping.put("/folderDeleteManager", FolderDeleteManager.class);
        mapping.put("/moveFolderManager", MoveFolderManager.class);
        mapping.put("/userFolder", UserFolderPage.class);
        mapping.put("/returnManager", ReturnManager.class);
        mapping.put("/uploadManager", UploadManager.class);
    }

    public static void main(String[] args) throws Exception {
        if ( args.length<2 ) {
            System.err.println("java webmail.Server static-files-dir log-dir");
            System.exit(1);
        }
        String staticFilesDir = args[0];    //mark
        String logDir = args[1];            //mark
        //Server server = new Server(8080);

        ServletContextHandler context = new
                ServletContextHandler(ServletContextHandler.SESSIONS);  //option = 1
        context.setContextPath("/");
//        server.setHandler(context);




        String jettyDistKeystore = "resources/keystore";
          String keystorePath = System.getProperty(
                          "example.keystore", jettyDistKeystore);
          File keystoreFile = new File(keystorePath);
          if (!keystoreFile.exists())
              {
                  throw new FileNotFoundException(keystoreFile.getAbsolutePath());
              }

          // Create a basic jetty server object without declaring the port. Since
          // we are configuring connectors directly we'll be setting ports on
          // those connectors.
          Server server = new Server();

          // HTTP Configuration
          // HttpConfiguration is a collection of configuration information
          // appropriate for http and https. The default scheme for http is
          // <code>http</code> of course, as the default for secured http is
          // <code>https</code> but we show setting the scheme to show it can be
          // done. The port for secured communication is also set here.
          HttpConfiguration http_config = new HttpConfiguration();
          http_config.setSecureScheme("https");
          http_config.setSecurePort(8443);
          http_config.setOutputBufferSize(32768);

          // HTTP connector
          // The first server connector we create is the one for http, passing in
          // the http configuration we configured above so it can get things like
          // the output buffer size, etc. We also set the port (8080) and
          // configure an idle timeout.
          ServerConnector http = new ServerConnector(server,
                          new HttpConnectionFactory(http_config));
          http.setPort(8080);
          http.setIdleTimeout(30000);

          // SSL Context Factory for HTTPS and SPDY
          // SSL requires a certificate so we configure a factory for ssl contents
          // with information pointing to what keystore the ssl connection needs
          // to know about. Much more configuration is available the ssl context,
          // including things like choosing the particular certificate out of a
          // keystore to be used.
          SslContextFactory sslContextFactory = new SslContextFactory();
          sslContextFactory.setKeyStorePath(keystoreFile.getAbsolutePath());
          sslContextFactory.setKeyStorePassword("OBF:1vny1zlo1x8e1vnw1vn61x8g1zlu1vn4");
          sslContextFactory.setKeyManagerPassword("OBF:1u2u1wml1z7s1z7a1wnl1u2g");

          // HTTPS Configuration
          // A new HttpConfiguration object is needed for the next connector and
          // you can pass the old one as an argument to effectively clone the
          // contents. On this HttpConfiguration object we add a
          // SecureRequestCustomizer which is how a new connector is able to
          // resolve the https connection before handing control over to the Jetty
          // Server.
          HttpConfiguration https_config = new HttpConfiguration(http_config);
          https_config.addCustomizer(new SecureRequestCustomizer());

          // HTTPS connector
          // We create a second ServerConnector, passing in the http configuration
          // we just made along with the previously created ssl context factory.
          // Next we set the port and a longer idle timeout.
          ServerConnector https = new ServerConnector(server,
                         new SslConnectionFactory(sslContextFactory, "http/1.1"),
                         new HttpConnectionFactory(https_config));
          https.setPort(8443);
          https.setIdleTimeout(500000);

          // Here you see the server having multiple connectors registered with
          // it, now requests can flow into the server from both http and https
          // urls to their respective ports and be processed accordingly by jetty.
          // A simple handler is also registered with the server so the example
          // has something to pass requests off to.

          // Set the connectors
          server.setConnectors(new Connector[] { http, https });



        // add a simple Servlet at "/dynamic/*"
        ServletHolder holderDynamic = new ServletHolder("dynamic", DispatchServlet.class);
        context.addServlet(holderDynamic, "/*");

        // add special pathspec of "/home/" content mapped to the homePath
        ServletHolder holderHome = new ServletHolder("static-home", DefaultServlet.class);
        holderHome.setInitParameter("resourceBase",staticFilesDir);
        holderHome.setInitParameter("dirAllowed","true");
        holderHome.setInitParameter("pathInfoOnly","true");
        context.addServlet(holderHome, "/files/*");

        // Lastly, the default servlet for root content (always needed, to satisfy servlet spec)
        // It is important that this is last.
        ServletHolder holderPwd = new ServletHolder("default", DefaultServlet.class);
        holderPwd.setInitParameter("resourceBase","/tmp/foo");
        holderPwd.setInitParameter("dirAllowed","true");
        context.addServlet(holderPwd, "/");

        // log using NCSA (common log format)
        // http://en.wikipedia.org/wiki/Common_Log_Format
        NCSARequestLog requestLog = new NCSARequestLog();
        requestLog.setFilename(logDir + "/yyyy_mm_dd.request.log");
        requestLog.setFilenameDateFormat("yyyy_MM_dd");
        requestLog.setRetainDays(90);
        requestLog.setAppend(true);
        requestLog.setExtended(true);
        requestLog.setLogCookies(false);
        requestLog.setLogTimeZone("GMT");
        RequestLogHandler requestLogHandler = new RequestLogHandler();
        requestLogHandler.setRequestLog(requestLog);
        requestLogHandler.setServer(server);

        HandlerCollection handlerCollection=new HandlerCollection();
        handlerCollection.addHandler(requestLogHandler);
        handlerCollection.addHandler(context);
        server.setHandler(handlerCollection);



        server.start();

        server.join();
    }
}
