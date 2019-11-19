package com.j7arsen.data.model.mapper;

import java.util.List;

public interface IModelMapper<CACHE, ENTITY, DOMAIN> {

    DOMAIN mapEntityToDomain(ENTITY photo);

    List<DOMAIN> mapEntityToDomainList(List<ENTITY> photos);

    CACHE mapEntityToCache(ENTITY photo);

    List<CACHE> mapEntityToCacheList(List<ENTITY> photos);

    DOMAIN mapCacheToDomain(CACHE photo);

    List<DOMAIN> mapCacheToDomainList(List<CACHE> photos);

    CACHE mapDomainToCache(DOMAIN photo);

    List<CACHE> mapDomainToCacheList(List<DOMAIN> photos);

}
