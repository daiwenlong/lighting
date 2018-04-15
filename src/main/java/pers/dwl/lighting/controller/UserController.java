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
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/login")
    public String index(Model model){
        model.addAttribute("result","");
        return "login_index";
    }

    @PostMapping("/user")
    public String login(@Valid User user, BindingResult result, Model model,HttpSession session){
        if(result.hasErrors()){
            model.addAttribute("result",result.getFieldErrors().get(0).getDefaultMessage());
            return "login_index";
        }
        if(userService.userLogin(user.getUserName(),user.getUserPwd())){
            User my = userService.findUserByName(user.getUserName());
            session.setAttribute(Constants.USER,my);
            return "redirect:/record/"+my.getUserId();
        }
        model.addAttribute("result","用户名或密码错误");
        return "login_index";
    }


}
