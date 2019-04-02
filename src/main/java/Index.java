import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest reqest, HttpServletResponse response) throws IOException {
        Human h = new Human("leonardo", "araoz");
        Gson gson = new Gson();
        String json = gson.toJson(h);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET");
        response.getWriter().println(json);
    }
}

class Human {
    private String nombre;
    private String apellido;

    Human(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}