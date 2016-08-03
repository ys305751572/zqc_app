package com.leoman.system.entity;

import com.leoman.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 系统文本内容
 * Created by Daisy on 2016/8/3.
 */
@Entity
@Table(name = "t_system")
public class System extends BaseEntity{

    @Column(name = "type")
    private Integer type;//类型：0:注册协议 1:益米成长规则 2：益米消费渠道 3:关于软件 4：帮助

    @Column(name = "content")
    private String content;//内容

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}