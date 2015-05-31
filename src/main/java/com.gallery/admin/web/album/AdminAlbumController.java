package com.gallery.admin.web.album;

import com.gallery.admin.core.domain.album.Album;
import com.gallery.admin.core.domain.system.User;
import com.gallery.admin.core.repository.album.AlbumRepository;
import com.gallery.admin.core.service.album.AlbumService;
import com.gallery.admin.web.album.condition.AlbumCondition;
import com.gallery.admin.web.album.form.AlbumForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 5. 13.
 * Time: 오후 11:12
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Controller
@RequestMapping(value = "/admin/album")
public class AdminAlbumController {

    @Autowired private AlbumService albumService;
    @Autowired private AlbumRepository albumRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@ModelAttribute("condition") AlbumCondition condition, Model model) {

        model.addAttribute("list", albumRepository.findAll());
        return "/admin/album/list";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("form", new AlbumForm());
        return "/admin/album/form";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean save(@ModelAttribute("form") AlbumForm form) {

        try{

            albumService.save(new Album(form.getTitle(), form.getContent()));

        }catch (Exception e){
            log.debug("[AdminAlbumController :: save] fail " + e.getMessage());
            return false;
        }

        return true;
    }

    @RequestMapping(value = "/edit/{album}", method = RequestMethod.GET)
    public String edit(@PathVariable Album album, Model model, User user){

        log.debug("user - " + user.getUsername());

        model.addAttribute("form", album);
        return "/admin/album/form";
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean update(@ModelAttribute("form") AlbumForm form) {
        try{

            Album origin = albumRepository.findOne(form.getId());

            if(origin == null) {
                //exception
            }

            albumService.save(origin.bind(form.getTitle(), form.getContent()));

        }catch(Exception e){
            e.printStackTrace();
            log.debug("[AdminAlbumController :: update - target is "+ form.getId() +"] fail " + e.getMessage());
            return false;
        }

        return true;
    }
}
