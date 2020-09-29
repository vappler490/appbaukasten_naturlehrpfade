package com.lipschinski.moor.animal.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAnimal is a Querydsl query type for Animal
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAnimal extends EntityPathBase<Animal> {

    private static final long serialVersionUID = 674329964L;

    public static final QAnimal animal = new QAnimal("animal");

    public final StringPath htmlData = createString("htmlData");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final StringPath pictureUrl = createString("pictureUrl");

    public final StringPath scientificName = createString("scientificName");

    public QAnimal(String variable) {
        super(Animal.class, forVariable(variable));
    }

    public QAnimal(Path<? extends Animal> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAnimal(PathMetadata metadata) {
        super(Animal.class, metadata);
    }

}

