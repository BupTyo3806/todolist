package guest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GuestController {

    @Autowired
    private GuestDao guestDao;

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
            return new ModelAndView("redirect:guest.html");
        } else {
            return new ModelAndView("redirect:main.html");
        }

        // Prepare the result view (guest.jsp):

    }

    @RequestMapping(value = "/registration")
    public ModelAndView registration(HttpServletRequest request) {
        // Handle a new guest (if any):
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        guestDao.persist(new Guest(name, password));

        // Prepare the result view (guest.jsp):
        return new ModelAndView("redirect:main.html");
    }

    @RequestMapping(value = "/guest")
    public ModelAndView guestbook() {
        Guest guest = guestDao.findById(userId);
        // Prepare the result view (guest.jsp):
//        return new ModelAndView("guest.jsp", "guestDao", guestDao);
        return new ModelAndView("guest.jsp", "guest", guest);
    }
}