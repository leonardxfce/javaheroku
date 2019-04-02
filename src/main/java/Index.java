import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;

public class Index extends HttpServlet {
    private static final long serialVersionUID = -4751096228274971485L;

    @Override
    protected void doGet(HttpServletRequest reqest, HttpServletResponse response)
            throws ServletException, IOException {
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache m = mf.compile("index.mustache");
        StringWriter writer = new StringWriter();
        Human h = new Human("leonardo","araoz");
        m.execute(writer, h).flush();
        String html = writer.toString();
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(html);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");
    }
}

class Human{
    String nombre;
    String apellido;

    public Human(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}