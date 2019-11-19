package com.j7arsen.data.repository.mapper;

import com.j7arsen.data.model.mapper.IObjectModelMapper;
import com.j7arsen.data.model.net.person.PostPersonAvatarImage;
import com.j7arsen.data.model.net.person.PostPersonDataEntity;
import com.j7arsen.data.model.net.person.PostPersonEntity;
import com.j7arsen.data.model.net.person.PostPersonLinks;
import com.j7arsen.data.model.net.person.PostPersonMeta;
import com.j7arsen.domain.model.person.PostPersonAvatarImageModel;
import com.j7arsen.domain.model.person.PostPersonDataModel;
import com.j7arsen.domain.model.person.PostPersonLinksModel;
import com.j7arsen.domain.model.person.PostPersonMetaModel;
import com.j7arsen.domain.model.person.PostPersonModel;

import java.util.ArrayList;
import java.util.List;

public class PostPersonMapper implements IObjectModelMapper<PostPersonEntity, PostPersonModel> {

    @Override
    public PostPersonModel mapEntityToDomain(PostPersonEntity postPersonEntity) {
        PostPersonModel postPersonModel = new PostPersonModel();
        postPersonModel.setLinks(mapLinksEntityToDomain(postPersonEntity.getLinks()));
        postPersonModel.setMeta(mapMetaEntityToDomain(postPersonEntity.getMeta()));
        if (postPersonEntity.getData() != null && postPersonEntity.getData().size() != 0) {
            List<PostPersonDataModel> postPersonDataModelList = new ArrayList<>();
            for (PostPersonDataEntity postPersonDataEntity : postPersonEntity.getData()) {
                postPersonDataModelList.add(mapDataEntityToDomain(postPersonDataEntity));
            }
            postPersonModel.setData(postPersonDataModelList);
        } else {
            postPersonModel.setData(null);
        }
        return postPersonModel;
    }

    private PostPersonMetaModel mapMetaEntityToDomain(PostPersonMeta postPersonMeta) {
        PostPersonMetaModel postPersonMetaModel = new PostPersonMetaModel();
        postPersonMetaModel.setCurrentPage(postPersonMeta.getCurrentPage());
        postPersonMetaModel.setFrom(postPersonMeta.getFrom());
        postPersonMetaModel.setLastPage(postPersonMeta.getLastPage());
        postPersonMetaModel.setPath(postPersonMeta.getPath());
        postPersonMetaModel.setPerPage(postPersonMeta.getPerPage());
        postPersonMetaModel.setTo(postPersonMeta.getTo());
        postPersonMetaModel.setTotal(postPersonMeta.getTotal());
        return postPersonMetaModel;
    }

    private PostPersonLinksModel mapLinksEntityToDomain(PostPersonLinks postPersonLinks) {
        PostPersonLinksModel postPersonLinksModel = new PostPersonLinksModel();
        postPersonLinksModel.setFirst(postPersonLinks.getFirst());
        postPersonLinksModel.setLast(postPersonLinks.getLast());
        postPersonLinksModel.setNext(postPersonLinks.getNext());
        postPersonLinksModel.setPrev(postPersonLinks.getPrev());
        return postPersonLinksModel;
    }

    private PostPersonAvatarImageModel mapAvatarImageEntityToDomain(PostPersonAvatarImage postPersonAvatarImage) {
        PostPersonAvatarImageModel postPersonAvatarImageModel = new PostPersonAvatarImageModel();
        postPersonAvatarImageModel.setId(postPersonAvatarImage.getId());
        postPersonAvatarImageModel.setMentionedUsersCount(postPersonAvatarImage.getMentionedUsersCount());
        postPersonAvatarImageModel.setUrl(postPersonAvatarImage.getUrl());
        postPersonAvatarImageModel.setUrlLarge(postPersonAvatarImage.getUrlLarge());
        postPersonAvatarImageModel.setUrlLargeOrigin(postPersonAvatarImage.getUrlLargeOrigin());
        postPersonAvatarImageModel.setUrlMedium(postPersonAvatarImage.getUrlMedium());
        postPersonAvatarImageModel.setUrlMediumOrigin(postPersonAvatarImage.getUrlMediumOrigin());
        postPersonAvatarImageModel.setUrlOrigin(postPersonAvatarImage.getUrlOrigin());
        postPersonAvatarImageModel.setUrlSmall(postPersonAvatarImage.getUrlSmall());
        postPersonAvatarImageModel.setUrlSmallOrigin(postPersonAvatarImage.getUrlSmallOrigin());
        return postPersonAvatarImageModel;
    }

    private PostPersonDataModel mapDataEntityToDomain(PostPersonDataEntity postPersonDataEntity) {
        PostPersonDataModel postPersonDataModel = new PostPersonDataModel();
        postPersonDataModel.setId(postPersonDataEntity.getId());
        postPersonDataModel.setActiveGift(postPersonDataEntity.getActiveGift());
        postPersonDataModel.setGender(postPersonDataEntity.getGender());
        postPersonDataModel.setHasMeInBlacklist(postPersonDataEntity.isHasMeInBlacklist());
        postPersonDataModel.setInMyBlacklist(postPersonDataEntity.isInMyBlacklist());
        postPersonDataModel.setLastname(postPersonDataEntity.getLastname());
        postPersonDataModel.setLastOnlineTimestamp(postPersonDataEntity.getLastOnlineTimestamp());
        postPersonDataModel.setMultiplier(postPersonDataEntity.getMultiplier());
        postPersonDataModel.setName(postPersonDataEntity.getName());
        postPersonDataModel.setNickname(postPersonDataEntity.getNickname());
        postPersonDataModel.setOffPage(postPersonDataEntity.isOffPage());
        postPersonDataModel.setOnline(postPersonDataEntity.isOnline());
        postPersonDataModel.setStatus(postPersonDataEntity.getStatus());
        postPersonDataModel.setSubscribed(postPersonDataEntity.isSubscribed());
        postPersonDataModel.setAvatarImage(mapAvatarImageEntityToDomain(postPersonDataEntity.getAvatarImage()));
        return postPersonDataModel;
    }

    @Override
    public PostPersonEntity mapDomainToEntity(PostPersonModel postPersonModel) {
        PostPersonEntity postPersonEntity = new PostPersonEntity();
        postPersonEntity.setLinks(mapLinksDomainToEntity(postPersonModel.getLinks()));
        postPersonEntity.setMeta(mapMetaDomainToEntity(postPersonModel.getMeta()));
        if (postPersonModel.getData() != null && postPersonModel.getData().size() != 0) {
            List<PostPersonDataEntity> postPersonDataEntityList = new ArrayList<>();
            for (PostPersonDataModel postPersonDataModel : postPersonModel.getData()) {
                postPersonDataEntityList.add(mapDataDomainToEntity(postPersonDataModel));
            }
            postPersonEntity.setData(postPersonDataEntityList);
        } else {
            postPersonModel.setData(null);
        }
        return postPersonEntity;
    }

    private PostPersonMeta mapMetaDomainToEntity(PostPersonMetaModel postPersonMetaModel) {
        PostPersonMeta postPersonMeta = new PostPersonMeta();
        postPersonMeta.setCurrentPage(postPersonMetaModel.getCurrentPage());
        postPersonMeta.setFrom(postPersonMetaModel.getFrom());
        postPersonMeta.setLastPage(postPersonMetaModel.getLastPage());
        postPersonMeta.setPath(postPersonMetaModel.getPath());
        postPersonMeta.setPerPage(postPersonMetaModel.getPerPage());
        postPersonMeta.setTo(postPersonMetaModel.getTo());
        postPersonMeta.setTotal(postPersonMetaModel.getTotal());
        return postPersonMeta;
    }

    private PostPersonLinks mapLinksDomainToEntity(PostPersonLinksModel postPersonLinksModel) {
        PostPersonLinks postPersonLinks = new PostPersonLinks();
        postPersonLinks.setFirst(postPersonLinksModel.getFirst());
        postPersonLinks.setLast(postPersonLinksModel.getLast());
        postPersonLinks.setNext(postPersonLinksModel.getNext());
        postPersonLinks.setPrev(postPersonLinksModel.getPrev());
        return postPersonLinks;
    }

    private PostPersonAvatarImage mapAvatarImageDomainToEntity(PostPersonAvatarImageModel postPersonAvatarImageModel) {
        PostPersonAvatarImage postPersonAvatarImage = new PostPersonAvatarImage();
        postPersonAvatarImage.setId(postPersonAvatarImageModel.getId());
        postPersonAvatarImage.setMentionedUsersCount(postPersonAvatarImageModel.getMentionedUsersCount());
        postPersonAvatarImage.setUrl(postPersonAvatarImageModel.getUrl());
        postPersonAvatarImage.setUrlLarge(postPersonAvatarImageModel.getUrlLarge());
        postPersonAvatarImage.setUrlLargeOrigin(postPersonAvatarImageModel.getUrlLargeOrigin());
        postPersonAvatarImage.setUrlMedium(postPersonAvatarImageModel.getUrlMedium());
        postPersonAvatarImage.setUrlMediumOrigin(postPersonAvatarImageModel.getUrlMediumOrigin());
        postPersonAvatarImage.setUrlOrigin(postPersonAvatarImageModel.getUrlOrigin());
        postPersonAvatarImage.setUrlSmall(postPersonAvatarImageModel.getUrlSmall());
        postPersonAvatarImage.setUrlSmallOrigin(postPersonAvatarImageModel.getUrlSmallOrigin());
        return postPersonAvatarImage;
    }

    private PostPersonDataEntity mapDataDomainToEntity(PostPersonDataModel postPersonDataModel) {
        PostPersonDataEntity postPersonDataEntity = new PostPersonDataEntity();
        postPersonDataEntity.setId(postPersonDataModel.getId());
        postPersonDataEntity.setActiveGift(postPersonDataModel.getActiveGift());
        postPersonDataEntity.setGender(postPersonDataModel.getGender());
        postPersonDataEntity.setHasMeInBlacklist(postPersonDataModel.isHasMeInBlacklist());
        postPersonDataEntity.setInMyBlacklist(postPersonDataModel.isInMyBlacklist());
        postPersonDataEntity.setLastname(postPersonDataModel.getLastname());
        postPersonDataEntity.setLastOnlineTimestamp(postPersonDataModel.getLastOnlineTimestamp());
        postPersonDataEntity.setMultiplier(postPersonDataModel.getMultiplier());
        postPersonDataEntity.setName(postPersonDataModel.getName());
        postPersonDataEntity.setNickname(postPersonDataModel.getNickname());
        postPersonDataEntity.setOffPage(postPersonDataModel.isOffPage());
        postPersonDataEntity.setOnline(postPersonDataModel.isOnline());
        postPersonDataEntity.setStatus(postPersonDataModel.getStatus());
        postPersonDataEntity.setSubscribed(postPersonDataModel.isSubscribed());
        postPersonDataEntity.setAvatarImage(mapAvatarImageDomainToEntity(postPersonDataModel.getAvatarImage()));
        return postPersonDataEntity;
    }

}
