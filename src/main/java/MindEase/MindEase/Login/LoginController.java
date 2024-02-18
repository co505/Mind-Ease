package MindEase.MindEase.Login;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    private ModelAndView modelAndView;
    @RequestMapping("/login")
    public ModelAndView getLogin(){
         modelAndView = new ModelAndView("login");
         return modelAndView;
    }



}
