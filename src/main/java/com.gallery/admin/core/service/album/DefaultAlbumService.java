package com.gallery.admin.core.service.album;

import com.gallery.admin.core.domain.album.Album;
import com.gallery.admin.core.repository.album.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 5. 13.
 * Time: 오후 11:12
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class DefaultAlbumService implements AlbumService {

    @Autowired private AlbumRepository albumRepository;

    @Override
    public Album save(Album album) {

        if(album == null){
            // throw exception ..
        }

        return albumRepository.save(album);
    }

}
