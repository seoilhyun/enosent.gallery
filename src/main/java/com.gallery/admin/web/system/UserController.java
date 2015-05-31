package com.gallery.admin.web.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 5. 26.
 * Time: 오후 2:59
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UserController {

    @RequestMapping("/login")
    public String login(){

        return "/admin/index";
    }
}
