package com.gallery.admin.core.common.exception;

import org.springframework.dao.DataAccessException;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 5. 16.
 * Time: 오후 2:32
 * To change this template use File | Settings | File Templates.
 */
public class EntityConverterException extends DataAccessException {

    private static final long serialVersionUID = 2229231488116158088L;

    private Class<?> entityType;

    public EntityConverterException(Class<?> entityType, String msg, Throwable cause) {
        super(msg, cause);
    }

    public Class<?> getEntityType() {
        return entityType;
    }
}
