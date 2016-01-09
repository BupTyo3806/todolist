package guest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private GuestDao guestDao;

    @Autowired
    private TaskDao taskDao;

    private int userId;

    @RequestMapping(value = "/main")
    public ModelAndView main() {
            return new ModelAndView("main.jsp");
    }

    @RequestMapping(value = "/auth")
    public ModelAndView auth(HttpServletRequest request) {
        // Handle a new guest (if any):
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Guest guest = guestDao.findByNameAndPassword(name, password);
        if (guest != null) {
            userId = guest.id;
            return new ModelAndView("redirect:list.html");
        } else {
            return new ModelAndView("redirect:main.html");
        }

        // Prepare the result view (list.jsp):

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

    @RequestMapping(value = "/list")
    public ModelAndView list() {
        Guest guest = guestDao.findById(userId);
        Task task = new Task(guest.getId(), "HelloWorld!");
        taskDao.persist(task);
        ModelAndView model = new ModelAndView("list.jsp");
        model.addObject("guest", guest);
        model.addObject("taskDao", taskDao);
        return model;
    }

    @RequestMapping(value = "/addTask")
    public ModelAndView addTask(HttpServletRequest request) {
        String text = request.getParameter("text");
        Task task = new Task(userId, text);
        taskDao.persist(task);
        return new ModelAndView("redirect:list.html");
    }
}