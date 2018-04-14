package pers.dwl.lighting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pers.dwl.lighting.Constants;
import pers.dwl.lighting.domain.User;
import pers.dwl.lighting.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * 用户控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("result","");
        return "login_index";
    }

    @PostMapping("/login")
    public String login(@Valid User user, BindingResult result, Model model,HttpSession session){
        if(result.hasErrors()){
            model.addAttribute("result",result.getFieldErrors().get(0).getDefaultMessage());
            return "login_index";
        }
        if(userService.userLogin(user.getUserName(),user.getUserPwd())){
            session.setAttribute(Constants.USER,userService.findUserByName(user.getUserName()));
            return "redirect:/user/home";
        }
        model.addAttribute("result","用户名或密码错误");
        return "login_index";
    }

    @RequestMapping("/home")
    public String toHome(Model model,HttpSession session){
        model.addAttribute("user",session.getAttribute(Constants.USER));
        return "user_index";
    }

    @PostMapping("/addWeight")
    @ResponseBody
    public String toAdd(String weight){
         System.out.print(weight);
         return weight;
    }

    @RequestMapping(value = "/{userName}",method = RequestMethod.GET)
    public User getUser(@PathVariable("userName")String userName){
        return userService.findUserByName(userName);
    }
}
