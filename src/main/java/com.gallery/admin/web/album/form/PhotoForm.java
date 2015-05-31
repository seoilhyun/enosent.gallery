package com.gallery.admin.web.album.form;

import com.gallery.admin.core.domain.common.ImageFile;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 5. 13.
 * Time: 오후 11:13
 * To change this template use File | Settings | File Templates.
 */

@Data
@NoArgsConstructor
public class PhotoForm {

    private String caption;

    private MultipartFile file;

    public ImageFile bindFile(String path) {
        return new ImageFile(file, path);
    }
}
