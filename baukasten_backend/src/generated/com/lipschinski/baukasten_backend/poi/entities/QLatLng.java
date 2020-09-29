package com.lipschinski.moor.poi.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLatLng is a Querydsl query type for LatLng
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QLatLng extends BeanPath<LatLng> {

    private static final long serialVersionUID = -1739402246L;

    public static final QLatLng latLng = new QLatLng("latLng");

    public final StringPath lat = createString("lat");

    public final StringPath lng = createString("lng");

    public QLatLng(String variable) {
        super(LatLng.class, forVariable(variable));
    }

    public QLatLng(Path<? extends LatLng> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLatLng(PathMetadata metadata) {
        super(LatLng.class, metadata);
    }

}

