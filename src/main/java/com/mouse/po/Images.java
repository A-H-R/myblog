package com.mouse.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 *created by mouse on 2020/2/24
 */
@Entity
@Table(name = "m_images")
public class Images {

    @Id
    @GeneratedValue
    private Long id;
    private String path;
    private String createTime;

    public Images() {
    }

    @Override
    public String toString() {
        return "images{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
