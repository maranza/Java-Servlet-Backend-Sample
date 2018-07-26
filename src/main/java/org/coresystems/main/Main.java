package org.coresystems.main;

import java.util.List;
import java.util.logging.Logger;
import org.coresystems.model.Employee;
import org.coresystems.service.EmployeeService;
import org.coresystems.servlet.EmployeeServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 *
 * @author master
 */
public class Main {
    
    private static Logger logger = Logger.getLogger(Main.class.getName());
    
    public static void main(String[] args) throws Exception {
        
//        String serverMessage = "Starting Up Java Server";
//        
//        logger.info(() -> {return serverMessage;});
//        
//        Server server = new Server(8080);
//        ServletHandler servletHandler = new ServletHandler();
//        
//        server.setHandler(servletHandler);
//        servletHandler.addServletWithMapping(EmployeeServlet.class, "/employees/*");
//        
//        server.start();
//        server.join();
        
        Employee em = new Employee();
        
//        em.setId(6);
//        System.out.println(em.getId());
        
//        em.setName("Oratile");
//        System.out.println(em.getName());
        
//        em.setPosition("Data Scientist");
//        System.out.println(em.getPosition());
        
        
        
        List<Employee> emp = EmployeeService.getRecords();
        
        
        System.out.println(emp.get(0).getName());
        
//        for (Employee obj : emp) {
//            System.out.println(obj.getName());
//        }
        
//        if (EmployeeService.deleteRecord(6)) {
//            System.out.println("Deleted");
//        }else{
//            System.out.println("Error Record Not Deleted");
//        }
        
    }
    
}
