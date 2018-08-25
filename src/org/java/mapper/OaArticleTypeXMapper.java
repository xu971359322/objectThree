package org.java.mapper;

import org.java.entity.OaArticleType;

import java.util.List;

public interface OaArticleTypeXMapper {
    public List<OaArticleType> articleShowAll();
    public List<OaArticleType> articleShowAllCount(Integer tid);
}
