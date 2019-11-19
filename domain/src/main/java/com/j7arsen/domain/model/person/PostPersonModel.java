package com.j7arsen.domain.model.person;

import java.io.Serializable;
import java.util.List;

public class PostPersonModel implements Serializable {

    private List<PostPersonDataModel> data;
    private PostPersonLinksModel links;
    private PostPersonMetaModel meta;

    public List<PostPersonDataModel> getData() {
        return data;
    }

    public void setData(List<PostPersonDataModel> data) {
        this.data = data;
    }

    public PostPersonLinksModel getLinks() {
        return links;
    }

    public void setLinks(PostPersonLinksModel links) {
        this.links = links;
    }

    public PostPersonMetaModel getMeta() {
        return meta;
    }

    public void setMeta(PostPersonMetaModel meta) {
        this.meta = meta;
    }
}
