package pers.dwl.lighting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pers.dwl.lighting.domain.User;
import pers.dwl.lighting.service.UserService;

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
    public String login(@Valid User user, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("result",result.getFieldErrors().get(0).getDefaultMessage());
            return "login_index";
        }
        if(userService.userLogin(user.getUserName(),user.getUserPwd()))
            return "redirect:/user/home";
        model.addAttribute("result","用户名或密码错误");
        return "login_index";
    }

    @RequestMapping(value = "/{userName}",method = RequestMethod.GET)
    public User getUser(@PathVariable("userName")String userName){
        return userService.findUserByName(userName);
    }
}
