package MindEase.MindEase.Registration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class RegistrationController {
    private ModelAndView modelAndView;
    @GetMapping("/registration")
    public ModelAndView getRegistration(){
        modelAndView = new ModelAndView("registration");
        return modelAndView;
    }
}
