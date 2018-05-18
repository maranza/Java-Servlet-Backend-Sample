package tk.xdevcloud.medicalcore;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import tk.xdevcloud.medicalcore.servlets.PatientServlet;
import tk.xdevcloud.medicalcore.servlets.AuthenticateServlet;
import tk.xdevcloud.medicalcore.filters.AuthenticationFilter;
import org.eclipse.jetty.server.handler.ContextHandler;

import java.util.EnumSet;
import javax.servlet.DispatcherType;

import org.apache.log4j.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        logger.info("Starting up Java Server");
        Server server = new Server(8080);
        //ContextHandler contextHandler = new ContextHandler();
        //contextHandler.setContextPath("/MedicalService");
        ServletHandler serverHandler = new ServletHandler();
        //contextHandler.setHandler(serverHandler);
        server.setHandler(serverHandler);
        //serverHandler.addFilterWithMapping(AuthenticationFilter.class,"/Patient/*",  EnumSet.of(DispatcherType.REQUEST));
        //serverHandler.addServletWithMapping(AuthenticateServlet.class,"/Authenticate/*");
        serverHandler.addServletWithMapping(PatientServlet.class, "/Patient/*");

        server.start();
        server.join();

    }
}
