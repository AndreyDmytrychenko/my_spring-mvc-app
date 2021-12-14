package ua.andrey.springcource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {
    @GetMapping("/calculate")
    public String calculate(@RequestParam(value = "a") int a,
                            @RequestParam(value = "b") int b,
                            @RequestParam(value = "operation") String operation,
                            Model model) {
        double res;
        switch (operation) {
            case "multiplication" :
                res = a * b;
                addModel(model, a, b, res, operation);
                break;
            case "addition" :
                res = a + b;
                addModel(model, a, b, res, operation);
                break;
            case "subtraction" :
                res = a - b;
                addModel(model, a, b, res, operation);
                break;
            case "division" :
                res = a / (double)b;
                addModel(model, a, b, res, operation);
                break;
        }
        return "first/calculator";
    }

    public void addModel(Model model, int a, int b, double res, String operation) {

        String str = String.format("Operation: % between values: %s and %s result: %s", operation, a, b, res);

        model.addAttribute("message", str);

    }
}
