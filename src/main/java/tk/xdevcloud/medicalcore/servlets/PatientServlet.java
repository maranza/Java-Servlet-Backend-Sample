package tk.xdevcloud.medicalcore.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

import tk.xdevcloud.medicalcore.models.Patient;
import tk.xdevcloud.medicalcore.services.PatientService;
import org.apache.log4j.Logger;
import com.google.gson.*;

@WebServlet(urlPatterns = {"/patient/*"})
public class PatientServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(PatientServlet.class.getName());

    public void init() {


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Gson json;
        response.setContentType("application/json");

        try {

            Gson json = new Gson();
            JsonObject jsonObject = json.fromJson(request.getReader(), JsonObject.class);

            String firstName = jsonObject.get("firstName").getAsString();
            String lastName = jsonObject.get("lastName").getAsString();
            String IdNumber = jsonObject.get("IdNumber").getAsString();
            Patient patient = new Patient();
            patient.setFirstName(firstName);
            patient.setLastName(lastName);
            patient.setIdNumber(IdNumber);

            if (PatientService.add(patient)) {
                response.getWriter().println("{\"success\":\"Captured\"}");

            } else {
                response.getWriter().println("{\"error\":\"Failed to Capture Record\"}");
            }


        } catch (JsonSyntaxException e) {

            response.getWriter().println("{\"error\" : \"Failed to Parse Json\"}");
        } catch (Exception e) {

            response.getWriter().println("{\"error\" : \"System Error Try Again\"}");
            logger.warn(e.getMessage());

        }


    }


}
