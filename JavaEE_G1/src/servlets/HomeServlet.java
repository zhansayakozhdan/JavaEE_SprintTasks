package servlets;

import db.DbManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Developer;
import models.Item;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> items = DbManager.getItems();
        req.setAttribute("tovary", items);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
    //вытаскивали данные из эррейлиста это типа была наша база отирик
    //@Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Developer> developers = DbManager.getDevelopers();
//        req.setAttribute("razraby", developers);
//        req.getRequestDispatcher("home.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String surname = req.getParameter("surname");
//        String department = req.getParameter("department");
//        Integer salary = Integer.parseInt(req.getParameter("salary"));
//
//        Developer developer = new Developer(name, surname, department, salary);
//        DbManager.addDeveloper(developer);
//        resp.sendRedirect("/home");                         //перезапустить метод doGet(), указывая ссылку на сервлет
//    }

    //отдельно

    //    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        List<Developer> developers = new ArrayList<>();
//            developers.add(new Developer("Daulet", "D", "IT", 500000));
//            developers.add(new Developer("Tili", "T", "IT", 500000));
//            developers.add(new Developer("Amir", "A", "IT", 500000));
//            developers.add(new Developer("Abylai", "A", "IT", 500000));
//            developers.add(new Developer("Daryn", "D", "IT", 500000));
//            developers.add(new Developer("Zhansaya", "Z", "IT", 500000));
//            developers.add(new Developer("Dina", "D", "IT", 500000));
//            developers.add(new Developer("Baglan", "B", "IT", 500000));
//            developers.add(new Developer("Gulshat", "D", "IT", 500000));
//
//        req.setAttribute("razraby", developers); //для отправки данных в jsp
//        req.getRequestDispatcher("home.jsp").forward(req, resp); //для открытия jsp файла
//    }


    //бул отдельно болек устингиден
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Post post = new Post();
//        post.setTitle("ASKJDHGSADSAHDG");
//        post.setCategory(Post.CategoryType.SPORT);
//        request.getRequestDispatcher("home.jsp").forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    }


    //Ex7
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter pw = resp.getWriter();
//        pw.print("<form action=\"home\" method=\"post\">");
//        pw.print("<label>NAME:</label>");
//        pw.print("<input type=\"text\" name=\"name\" >");
//        pw.print("<br>");
//        pw.print("<label>SURNAME:</label>");
//        pw.print("<input type=\"text\" name=\"name\" >");
//        pw.print("<br>");
//        pw.print("<label>SALARY:</label>");
//        pw.print("<input type=\"number\" name=\"name\" >");
//        pw.print("<br>");
//        pw.print("</form>");
//    }


    //Ex6
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter pw = response.getWriter();
//
//        pw.print("<form action=\"/home\" method=\"post\">");
//        pw.print("<label>FULL NAME:</label>");
//        pw.print("<input name=\"name\" type=\"text\" style=\"margin-left:30px;\">");
//        pw.print("<br>");
//        pw.print("<label>EXAM POINTS:</label>");
//        pw.print("<input name=\"points\" type=\"number\" style=\"margin-left:30px;\">");
//        pw.print("<br>");
//        pw.print("<button>SUBMIT EXAM</button>");
//        pw.print("</form>");
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        int points = Integer.parseInt(req.getParameter("points"));
//        String mark;
//
//        if (points >= 90) {
//            mark = "A";
//        } else if (points >= 75) {
//            mark = "B";
//        } else if (points >= 60) {
//            mark = "C";
//        } else if (points >= 50) {
//            mark = "D";
//        } else {
//            mark = "F";
//        }
//
//        resp.setContentType("text/html");
//        PrintWriter pw = resp.getWriter();
//        pw.print(name + " got \"" + mark + "\" for exam!");
//    }



    //Ex4
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter pw = resp.getWriter();
//        pw.print("<form action=\"/home\" method=\"post\">");
//            pw.print("<label>NAME:</label>");
//            pw.print("<input type=\"text\" name=\"name\" style=\"margin-bottom: 5px;\">");
//            pw.print("<br>");
//            pw.print("<label>SURNAME:</label>");
//            pw.print("<input type=\"text\" name=\"surname\" style=\"margin-bottom: 5px;\">");
//            pw.print("<br>");
//            pw.print("<label>FOOD:</label>");
//            pw.print("<select name=\"food\" style=\"margin-bottom: 5px;\">");
//                pw.print("<option value=\"food1\">Manty - 900 KZT</option>");
//                pw.print("<option value=\"food2\">Plov - 900 KZT</option>");
//                pw.print("<option value=\"food3\">Lagman - 1000 KZT</option>");
//                pw.print("<option value=\"food4\">Rassolnik - 900 KZT</option>");
//                pw.print("<option value=\"food5\">Ramen - 800 KZT</option>");
//            pw.print("</select>");
//            pw.print("<br>");
//            pw.print("<button>ORDER</button>");
//
//        pw.print("</form>");
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String surname = req.getParameter("surname");
//        String food = req.getParameter("food");
//
//        PrintWriter pw = resp.getWriter();
//        pw.print(name + " " + surname + " ordered " + food);
//    }

    //Ex3
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter pw = response.getWriter();
//        pw.print("<form action=\"/home\" method=\"post\" style=\"max-width: 290px;\">");
//        pw.print("<label>NAME:</label>");
//        pw.print("<input type=\"text\" name=\"name\" style=\"margin-left:60px; margin-bottom: 5px;\">");
//        pw.print("<br>");
//        pw.print("<label>SURNAME:</label>");
//        pw.print("<input type=\"text\" name=\"surname\" style=\"margin-left:30px; margin-bottom: 5px\">");
//        pw.print("<br>");
//        pw.print("<button style=\"float: right; \">SEND</button>");
//        pw.print("</form>");
//    }
//
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String surname = req.getParameter("surname");
//
//        resp.setContentType("text/html");
//        PrintWriter pw = resp.getWriter();
//        pw.print(name + " " + surname + " отправил(а) свои данные!");
//    }

        //Ex2
//        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            response.setContentType("text/html");
//            PrintWriter pw = response.getWriter();
//            List<Developer> developers = new ArrayList<>();
//            developers.add(new Developer("Daulet", "D", "IT", 500000));
//            developers.add(new Developer("Tili", "T", "IT", 500000));
//            developers.add(new Developer("Amir", "A", "IT", 500000));
//            developers.add(new Developer("Abylai", "A", "IT", 500000));
//            developers.add(new Developer("Daryn", "D", "IT", 500000));
//            developers.add(new Developer("Zhansaya", "Z", "IT", 500000));
//            developers.add(new Developer("Dina", "D", "IT", 500000));
//            developers.add(new Developer("Baglan", "B", "IT", 500000));
//            developers.add(new Developer("Gulshat", "D", "IT", 500000));
//            pw.print("<table cellpadding=8px; style=\"border: 1px solid;\">");
//            pw.print("<thead style=\"background: #ccc;\">");
//              pw.print("<th>NAME</th>");
//              pw.print("<th>SURNAME</th>");
//              pw.print("<th>DEPARTMENT</th>");
//              pw.print("<th>SALARY</th>");
//            pw.print("</thead>");
//              pw.print("<tbody>");
//                  for (Developer developer : developers){
//                      pw.print("<tr>");
//                      pw.print("<td>"+developer.getName()+"</td>");
//                      pw.print("<td>"+developer.getSurname()+"</td>");
//                      pw.print("<td>"+developer.getDepartment()+"</td>");
//                      pw.print("<td>"+developer.getSalary()+"</td>");
//                      pw.print("</tr>");
//                  }
//           pw.print("</tbody>");
//           pw.print("</table>");
//    }


      //Ex1
//        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            response.setContentType("text/html");
//            PrintWriter pw = response.getWriter();
//            for (int i = 0; i < 10; i++) {
//            pw.print("<h1>HELLO BITLAB!</h1>");
//            }
//    }

}
