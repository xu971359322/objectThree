package org.java.mapper;

import org.java.entity.OaArticleType;

import java.util.List;
import java.util.Map;

public interface OaArticleTypeXMapper {

    public List<OaArticleType> articleShowAll();

    public List<Map<String,Object>> postType(String tid);

}
