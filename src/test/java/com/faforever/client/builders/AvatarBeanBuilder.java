package com.faforever.client.builders;

import com.faforever.client.domain.AvatarBean;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.OffsetDateTime;


public class AvatarBeanBuilder {
  public static AvatarBeanBuilder create() {
    return new AvatarBeanBuilder();
  }

  private final AvatarBean avatarBean = new AvatarBean();

  public AvatarBeanBuilder defaultValues() {
    id(0);
    try {
      url(new URL("https:google.com"));
    } catch (MalformedURLException ignored) {}
    description("test");
    return this;
  }

  public AvatarBeanBuilder url(URL url) {
    avatarBean.setUrl(url);
    return this;
  }

  public AvatarBeanBuilder description(String description) {
    avatarBean.setDescription(description);
    return this;
  }

  public AvatarBeanBuilder id(Integer id) {
    avatarBean.setId(id);
    return this;
  }

  public AvatarBeanBuilder createTime(OffsetDateTime createTime) {
    avatarBean.setCreateTime(createTime);
    return this;
  }

  public AvatarBeanBuilder updateTime(OffsetDateTime updateTime) {
    avatarBean.setUpdateTime(updateTime);
    return this;
  }

  public AvatarBean get() {
    return avatarBean;
  }

}

