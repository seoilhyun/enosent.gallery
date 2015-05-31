package com.gallery.admin.core.domain.common;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 5. 13.
 * Time: 오전 9:26
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Data
@NoArgsConstructor
public class ImageFile {

    @Setter(AccessLevel.NONE)
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String contentType;

    private String path;

    private long size;

    public ImageFile(MultipartFile file, String path) {
        setName(file.getOriginalFilename());
        setContentType(file.getContentType());
        setPath(path);
        setSize(file.getSize());
    }

}
