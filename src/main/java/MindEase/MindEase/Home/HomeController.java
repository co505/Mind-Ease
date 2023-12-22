package MindEase.MindEase.Home;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
    private ModelAndView modelAndView;

    @GetMapping("/")
    public ModelAndView home(){
        modelAndView = new ModelAndView("index");
        return modelAndView;
    }



}
