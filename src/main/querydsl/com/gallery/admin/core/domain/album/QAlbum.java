package com.gallery.admin.core.domain.album;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QAlbum is a Querydsl query type for Album
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAlbum extends EntityPathBase<Album> {

    private static final long serialVersionUID = -2103412563L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAlbum album = new QAlbum("album");

    public final com.gallery.admin.core.domain.common.QApplicationAuditable _super;

    public final StringPath content = createString("content");

    // inherited
    public final com.gallery.admin.core.domain.system.QUser createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    // inherited
    public final com.gallery.admin.core.domain.system.QUser lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedDate;

    public final ListPath<Photo, QPhoto> photo = this.<Photo, QPhoto>createList("photo", Photo.class, QPhoto.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public QAlbum(String variable) {
        this(Album.class, forVariable(variable), INITS);
    }

    public QAlbum(Path<? extends Album> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAlbum(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAlbum(PathMetadata<?> metadata, PathInits inits) {
        this(Album.class, metadata, inits);
    }

    public QAlbum(Class<? extends Album> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.gallery.admin.core.domain.common.QApplicationAuditable(type, metadata, inits);
        this.createdBy = _super.createdBy;
        this.createdDate = _super.createdDate;
        this.lastModifiedBy = _super.lastModifiedBy;
        this.lastModifiedDate = _super.lastModifiedDate;
    }

}

