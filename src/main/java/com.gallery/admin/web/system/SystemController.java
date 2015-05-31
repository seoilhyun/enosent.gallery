package com.gallery.admin.web.system;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 5. 23.
 * Time: 오전 11:51
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Controller
@RequestMapping(value = "/admin/system")
public class SystemController {

    // get
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Model model){

        model.addAttribute("form", new SystemM());

        return "/admin/system/form";
    }

    // post
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String save(@ModelAttribute("form") SystemM system) {

        log.debug("post - " + system.toString());

        System.out.println("post - " + system.toString());

        return "/admin/system/form";
    }

    // put
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public String update(@ModelAttribute("form") SystemM system) {

        log.debug("put - " + system.toString());

        System.out.println("put - " + system.toString());

        return "/admin/system/form";
    }

    @Data
    @ToString
    public static class SystemM {

        private String name;

        private String email;

        public SystemM() { }

        public SystemM(String name, String email) {
            setName(name);
            setEmail(email);
        }

    }
}
