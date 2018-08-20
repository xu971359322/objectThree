package org.java.mapper;

import org.java.entity.OaTeamEmail;

import java.util.List;
import java.util.Map;

public interface OaTeamEmailMapperCustom {
    public List<Map<String ,Object>> groupEmail(String wid);
}