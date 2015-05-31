package com.gallery.admin.core.repository.album;

import com.gallery.admin.core.domain.album.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 5. 13.
 * Time: 오후 11:11
 * To change this template use File | Settings | File Templates.
 */
public interface AlbumRepository extends JpaRepository<Album, Long>, QueryDslPredicateExecutor<Album> {
}
