package com.gallery.admin.core.domain.album;

import com.gallery.admin.core.domain.common.ApplicationAuditable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 5. 13.
 * Time: 오후 11:08
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Data
@NoArgsConstructor
public class Album extends ApplicationAuditable {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String content;

    @OneToMany
    private List<Photo> photo = new ArrayList<Photo>();


    public Album(String title, String content) {
        setTitle(title);
        setContent(content);
    }

    public Album bind(String title, String content) {
        setTitle(title);
        setContent(content);

        return this;
    }
}
