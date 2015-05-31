package com.gallery.support.mapper;

import com.gallery.admin.core.domain.system.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 5. 27.
 * Time: 오후 1:32
 * To change this template use File | Settings | File Templates.
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<User> {

    @Override
    public User getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.getPrincipal() instanceof User)
            return ((User) authentication.getPrincipal());

        return null;
    }
}
