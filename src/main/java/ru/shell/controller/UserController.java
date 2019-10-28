package ru.shell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.shell.model.User;
import ru.shell.service.UserService;
import ru.shell.service.UserServiceImpl;

import java.util.List;

//сообщает Spring MVC, что данный класс является контроллером
@Controller
public class UserController {

//    DispatcherServlet - главный контроллер, все входящие запросы проходят через него и он уже
//    дальше передает их конкретному контроллеру. диспетчер будет проверять аннотации
//    @RequestMapping чтобы вызвать подходящий метод.

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    //позволяет задать адреса методам контроллера, по которым они будут доступны в клиенте (браузер)
    //Eе можно применять также и к классу контроллера, чтобы задать корневой адрес для всех методов.
    @RequestMapping(value = "/", method = RequestMethod.GET)
//    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allUsers() {
        List<User> list = userService.allUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mainPage");
        modelAndView.addObject("userList", list);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) { //@PathVariable указывает на то, что данный параметр (int id) получается из адресной строки
        User user = userService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/"); //означает, что после выполнения данного метода мы будем перенаправлены на адрес "/"
        userService.edit(user);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("User") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        userService.add(user);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        User user = userService.getById(id);
        userService.delete(user);
        return modelAndView;
    }
}
