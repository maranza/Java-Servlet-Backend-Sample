package org.coresystems.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.coresystems.model.Employee;
import org.coresystems.service.EmployeeService;

/**
 *
 * @author master
 */
@WebServlet(urlPatterns = {"/employee/*"})
public class EmployeeServlet extends HttpServlet{
    
    private static final long serialVersionUID = 1L;
    
    public static Logger logger = Logger.getLogger(EmployeeServlet.class.getName());
    
    public void init(){}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("application/json");
        
        try {
            
            Gson json = new Gson();
            JsonObject jsonObject = json.fromJson(req.getReader(), JsonObject.class);
            
            String name = jsonObject.get("name").getAsString();
            String position = jsonObject.get("position").getAsString();
            
            Employee emp = new Employee(name, position);
            
            if (EmployeeService.addRecord(emp)) {
                resp.getWriter().println("{\"success\" : \"Record Added\"}");
            } else {
                resp.getWriter().println("{\"error\" : \"Failed to add Record\"}");
            }
            
        } catch(JsonSyntaxException e){
            resp.getWriter().println("{\"error\" : \"Failed to Capture Json\"}");
            logger.warning(e.getMessage());
            
        } catch (Exception e) {
            resp.getWriter().println("{\"error\" : \"Failed to add Record\"}");
            logger.warning(e.getMessage());
        }
        
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        
        try {
            
            Gson json = new Gson();
            JsonObject jsonObject = json.fromJson(req.getReader(), JsonObject.class);
            
            Integer id = jsonObject.get("id").getAsInt();
            
            if (EmployeeService.deleteRecord(id)) {
                resp.getWriter().println("{\"success\" : \"Record Deleted\"}");
            } else {
                resp.getWriter().println("{\"error\" : \"Failed to Delete Record\"}");
            }
            
        } catch(JsonSyntaxException e){
            resp.getWriter().println("{\"error\" : \"Failed to Capture Json\"}");
            logger.warning(e.getMessage());
            
        } catch (Exception e) {
            resp.getWriter().println("{\"error\" : \"Failed to Delete Record\"}");
            logger.warning(e.getMessage());
        }
    }
    
    
    
    
    
}
