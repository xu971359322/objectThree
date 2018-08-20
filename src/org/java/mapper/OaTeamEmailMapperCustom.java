package org.java.mapper;

import org.apache.ibatis.annotations.Param;
import org.java.entity.OaTeamEmail;

import java.util.List;
import java.util.Map;

public interface OaTeamEmailMapperCustom {

    //查询所有的的邮件分组
    public List<Map<String ,Object>> groupEmail(String wid);

    //收件箱数量
    public int shouCount(String wid);

    //查询新收到新邮件
    public List<Map<String ,Object>> newEmail(String wid);

    //查看邮件
    public OaTeamEmail lookEmail(String emId);

    //查看收件箱
    public List<Map<String ,Object>> shouEmail(String wid);

    //查看草稿、发件箱、垃圾箱
    public List<OaTeamEmail> myEmail(@Param("wid") String wid,@Param("status") Integer status);
}