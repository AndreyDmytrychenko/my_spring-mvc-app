package ua.andrey.spring_rest_mvs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false, defaultValue = "Jan") String name,
                            @RequestParam(value = "surname", required = false, defaultValue = "Batist") String surname,
                            Model model) {
        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }
                                          //----OR----
//    @GetMapping("/hello")
//    public String helloPage(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        System.out.println("Hello, " + name + " " + surname);
//        return "first/hello";
//    }

    @GetMapping("/goodbye")
    public String goodByPage() {
        return "first/goodbye";
    }

    @GetMapping("/exit")
    public String exit() {
        return "first/exit";
    }
    @GetMapping("/calculate")
    public String calculate(@RequestParam(value = "a") int a,
                            @RequestParam(value = "b") int b,
                            @RequestParam(value = "operation") String operation,
                            Model model) {
        String res;
        switch (operation) {
            case "multiplication" :
                res = (a * b) + "";
                addModel(model, a, b, res, operation);
                break;
            case "addition" :
                res = (a + b) + "";
                addModel(model, a, b, res, operation);
                break;
            case "subtraction" :
                res = (a - b) + "";
                addModel(model, a, b, res, operation);
                break;
            case "division" :
                res = (a / (double)b) + "";
                addModel(model, a, b, res, operation);
                break;
            default:
                res = "operation isn't valid";
                addModel(model, a, b, res, operation);
                break;

        }
        return "first/calculator";
    }

    public void addModel(Model model, int a, int b, String res, String operation) {

        model.addAttribute("message", String.format("Operation: %s, between values %s and %s, result: %s", operation, a, b, res));

    }
}
