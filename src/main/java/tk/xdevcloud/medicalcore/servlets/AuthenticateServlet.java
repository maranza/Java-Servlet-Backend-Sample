package tk.xdevcloud.medicalcore.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import com.google.gson.*;
import org.apache.log4j.Logger;

public class AuthenticateServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(AuthenticateServlet.class.getName());

    public void init() {


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");


        try {

            Gson json = new Gson();
            JsonObject jsonObject = json.fromJson(request.getReader(), JsonObject.class);
            String username = jsonObject.get("username").getAsString();
            String password = jsonObject.get("password").getAsString();
            if (username.equals("admina") && password.equals("abc123")) {

                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.getWriter().println("{\"success\":true}");

            } else {

                response.getWriter().println("{\"success\":false}");

                logger.info("Failed to authenticate ");
            }


        } catch (JsonSyntaxException e) {

            response.getWriter().println("{\"error\" : \"Failed to Parse Json\"}");
        } catch (Exception e) {


            response.getWriter().println("{\"error\" : \"System Error\"}");
            logger.info(e.getMessage());


        }


    }

}
