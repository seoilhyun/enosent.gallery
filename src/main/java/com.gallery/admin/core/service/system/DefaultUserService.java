package com.gallery.admin.core.service.system;

import com.gallery.admin.core.domain.system.QUser;
import com.gallery.admin.core.domain.system.User;
import com.gallery.admin.core.repository.system.UserRepository;
import com.mysema.query.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 5. 26.
 * Time: 오후 1:48
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class DefaultUserService implements UserService, UserDetailsService {

    @Autowired private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QUser qUser = QUser.user;

        BooleanBuilder predicate = new BooleanBuilder();

        User user = userRepository.findOne(predicate.and(qUser.username.eq(username)));

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }
}
