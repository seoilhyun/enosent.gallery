package com.gallery.support.method;

import com.gallery.admin.core.domain.system.QUser;
import com.gallery.admin.core.domain.system.User;
import com.gallery.admin.core.repository.system.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 5. 27.
 * Time: 오전 10:37
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
public class UserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired private UserRepository userRepository;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return User.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && User.class.isAssignableFrom(authentication.getPrincipal().getClass())) {

            User user = (User) authentication.getPrincipal();
            user = userRepository.findOne(QUser.user.username.eq(user.getUsername()));

            log.debug("found securityContextHolder-bound authentication: {}", user);

            return  user;
        }

        log.debug("no authentication. returns null object.");

        return null;
    }
}
