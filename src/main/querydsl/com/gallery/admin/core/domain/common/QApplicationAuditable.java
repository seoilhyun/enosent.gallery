package com.gallery.admin.core.domain.common;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QApplicationAuditable is a Querydsl query type for ApplicationAuditable
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QApplicationAuditable extends EntityPathBase<ApplicationAuditable> {

    private static final long serialVersionUID = 1080585509L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QApplicationAuditable applicationAuditable = new QApplicationAuditable("applicationAuditable");

    public final com.gallery.admin.core.domain.system.QUser createdBy;

    public final DateTimePath<java.util.Date> createdDate = createDateTime("createdDate", java.util.Date.class);

    public final com.gallery.admin.core.domain.system.QUser lastModifiedBy;

    public final DateTimePath<java.util.Date> lastModifiedDate = createDateTime("lastModifiedDate", java.util.Date.class);

    public QApplicationAuditable(String variable) {
        this(ApplicationAuditable.class, forVariable(variable), INITS);
    }

    public QApplicationAuditable(Path<? extends ApplicationAuditable> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QApplicationAuditable(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QApplicationAuditable(PathMetadata<?> metadata, PathInits inits) {
        this(ApplicationAuditable.class, metadata, inits);
    }

    public QApplicationAuditable(Class<? extends ApplicationAuditable> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new com.gallery.admin.core.domain.system.QUser(forProperty("createdBy")) : null;
        this.lastModifiedBy = inits.isInitialized("lastModifiedBy") ? new com.gallery.admin.core.domain.system.QUser(forProperty("lastModifiedBy")) : null;
    }

}

