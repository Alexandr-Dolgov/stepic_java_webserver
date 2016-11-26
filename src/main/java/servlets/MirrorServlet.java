package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MirrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> requestParameters = req.getParameterMap();

        StringBuilder stringBuilder = new StringBuilder();
        for (String[] strings : requestParameters.values()) {
            for (String string : strings) {
                stringBuilder.append(string).append('\n');
            }
        }

        resp.getWriter().println(stringBuilder.toString());
        resp.setContentType("text/html;charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
