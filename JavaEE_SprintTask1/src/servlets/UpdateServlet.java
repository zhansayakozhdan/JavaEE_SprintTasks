package servlets;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Task;

import java.io.IOException;

@WebServlet("/updateTask")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long taskId = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String deadlineDate = req.getParameter("deadlineDate");
        boolean status = Boolean.parseBoolean(req.getParameter("status"));

        Task task = DBManager.getTaskById(taskId);

        task.setName(name);
        task.setDescription(description);
        task.setDeadlineDate(deadlineDate);
        task.setStatus(status);
        DBManager.updateTask(task);
        //resp.sendRedirect("/details?id=" + taskId);
        resp.sendRedirect("/main");
    }
}
