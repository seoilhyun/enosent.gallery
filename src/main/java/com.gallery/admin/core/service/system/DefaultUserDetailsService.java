package com.gallery.admin.core.service.system;

import com.gallery.admin.core.domain.system.QUser;
import com.gallery.admin.core.domain.system.User;
import com.gallery.admin.core.repository.system.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 5. 27.
 * Time: 오전 9:53
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
public class DefaultUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public DefaultUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findOne(QUser.user.username.eq(username));

        if (user == null)
            throw new UsernameNotFoundException("Could not found user : username=" + username);

        //Hibernate.initialize(user.getEmployee().getCompany());
        //Hibernate.initialize(user.getEmployee().getDepartment());

        log.trace("Load UserDetail for {}({})", user.getUsername(), user.getPassword());

        return user;
    }
}
