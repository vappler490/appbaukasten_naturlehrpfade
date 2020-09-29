package com.lipschinski.moor.poi.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPoiEntity is a Querydsl query type for PoiEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPoiEntity extends EntityPathBase<PoiEntity> {

    private static final long serialVersionUID = -1134744743L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPoiEntity poiEntity = new QPoiEntity("poiEntity");

    public final StringPath _id = createString("_id");

    public final StringPath author = createString("author");

    public final StringPath htmlData = createString("htmlData");

    public final DateTimePath<java.time.LocalDateTime> lastModified = createDateTime("lastModified", java.time.LocalDateTime.class);

    public final QLatLng latLng;

    public final StringPath name = createString("name");

    public final BooleanPath poiIsStored = createBoolean("poiIsStored");

    public final StringPath project = createString("project");

    public QPoiEntity(String variable) {
        this(PoiEntity.class, forVariable(variable), INITS);
    }

    public QPoiEntity(Path<? extends PoiEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPoiEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPoiEntity(PathMetadata metadata, PathInits inits) {
        this(PoiEntity.class, metadata, inits);
    }

    public QPoiEntity(Class<? extends PoiEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.latLng = inits.isInitialized("latLng") ? new QLatLng(forProperty("latLng")) : null;
    }

}

