package guest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private GuestDao guestDao;

    @Autowired
    private TaskDao taskDao;

    private int getUserIdFromCookie(HttpServletRequest request) {
        int userId = 0;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userId")) {
                    userId = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
        }
        return userId;
    }

    @RequestMapping(value = "/define")
    public ModelAndView define() {
        guestDao.persist(new Guest("test", "test"));
        guestDao.persist(new Guest("alex", "alex"));

        taskDao.persist(new Task(1, "test", "Hello World form TEST!"));
        taskDao.persist(new Task(1, "test", "PANDA!!"));
        taskDao.persist(new Task(1, "test", "IMPORTANT!"));

        taskDao.persist(new Task(2, "alex", "Hello World form ALEX!"));
        taskDao.persist(new Task(2, "alex", "KOALA!!"));
        taskDao.persist(new Task(2, "alex", "ALERT!"));

        return new ModelAndView("redirect:main.html");
    }

    @RequestMapping(value = "/main")
    public ModelAndView main() {
        return new ModelAndView("main.jsp");
    }

    @RequestMapping(value = "/auth")
    public ModelAndView auth(HttpServletRequest request,
                             HttpServletResponse response) {
        // Handle a new guest (if any):
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Guest guest = guestDao.findByNameAndPassword(name, password);
        if (guest != null) {
            Cookie cookie = new Cookie("userId", Integer.toString(guest.id));
            cookie.setMaxAge(30 * 60);
            response.addCookie(cookie);
            return new ModelAndView("redirect:allTasks.html");
        } else {
            return new ModelAndView("redirect:main.html");
        }

        // Prepare the result view (list.jsp):

    }

    @RequestMapping(value = "/registrationPage")
    public ModelAndView registrationPage(HttpServletRequest request) {
        return new ModelAndView("registration.jsp");
    }

    @RequestMapping(value = "/registration")
    public ModelAndView registration(HttpServletRequest request) {
        // Handle a new guest (if any):
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        guestDao.persist(new Guest(name, password));

        // Prepare the result view (list.jsp):
        return new ModelAndView("redirect:main.html");
    }

    @RequestMapping(value = "/allTasks")
    public ModelAndView list(HttpServletRequest request) {
        int userId = getUserIdFromCookie(request);

        Guest guest = guestDao.findById(userId);
        ModelAndView model = new ModelAndView("list.jsp");
        model.addObject("guestDao", guestDao);
        model.addObject("tasks", taskDao.getAllTasks(userId));
        model.addObject("addTask", true);
        return model;
    }

    @RequestMapping(value = "/addTask")
    public ModelAndView addTask(HttpServletRequest request) {
        int userId = getUserIdFromCookie(request);

        String text = request.getParameter("text");
        Task task = new Task(userId, guestDao.findById(userId).getName(), text);
        taskDao.persist(task);
        return new ModelAndView("redirect:allTasks.html");
    }

    @RequestMapping(value = "/changeStatus")
    public ModelAndView changeStatus(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        int status = Integer.parseInt(request.getParameter("status"));
        taskDao.changeStatus(id, status);
        return new ModelAndView("redirect:allTasks.html");
    }

    @RequestMapping(value = "/sharing")
    public ModelAndView sharing(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));

        taskDao.shareTask(id);
        return new ModelAndView("redirect:allTasks.html");
    }

    @RequestMapping(value = "/deleteTask")
    public ModelAndView deleteTask(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));

        taskDao.deleteTask(id);
        return new ModelAndView("redirect:allTasks.html");
    }

    @RequestMapping(value = "/notExecutedTasks")
    public ModelAndView notExecutedTasks(HttpServletRequest request) {
        int userId = getUserIdFromCookie(request);

        Guest guest = guestDao.findById(userId);
        ModelAndView model = new ModelAndView("list.jsp");
        model.addObject("guestDao", guestDao);
        model.addObject("tasks", taskDao.getNotExecutedTasks(userId));
        model.addObject("addTask", false);
        return model;
    }

    @RequestMapping(value = "/executedTasks")
    public ModelAndView executedTasks(HttpServletRequest request) {
        int userId = getUserIdFromCookie(request);

        Guest guest = guestDao.findById(userId);
        ModelAndView model = new ModelAndView("list.jsp");
        model.addObject("guestDao", guestDao);
        model.addObject("tasks", taskDao.getExecutedTasks(userId));
        model.addObject("addTask", false);
        return model;
    }

    @RequestMapping(value = "/importantTasks")
    public ModelAndView importantTasks(HttpServletRequest request) {
        int userId = getUserIdFromCookie(request);

        Guest guest = guestDao.findById(userId);
        ModelAndView model = new ModelAndView("list.jsp");
        model.addObject("guestDao", guestDao);
        model.addObject("tasks", taskDao.getImportantTasks(userId));
        model.addObject("addTask", false);
        return model;
    }

    @RequestMapping(value = "/rssfeed")
    public ModelAndView getFeedInRss() {

        List<Task> items = taskDao.getAllTasksToRss();
        System.out.println(items);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("rssViewer");
        mav.addObject("feedContent", items);

        return mav;

    }
}