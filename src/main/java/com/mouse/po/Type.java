package com.mouse.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
 *created by mouse on 2020/2/4
 */
@Entity
@Table(name = "m_type")
public class Type {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean status;

    @OneToMany(mappedBy = "type")
    private List<Article> articles = new ArrayList<>();

    public Type() {
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
