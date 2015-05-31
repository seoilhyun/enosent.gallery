package com.gallery.front.web.album;

import com.gallery.admin.core.domain.album.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 5. 13.
 * Time: 오후 11:14
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/album")
public class AlbumController {

    @RequestMapping(value = "/list")
    public String index(Model model){
        return "/front/album/index";
    }

    @RequestMapping(value = "/{album}")
    public String index(@PathVariable Album album){
        System.out.println("album");
        return "/front/album/index";
    }
}
