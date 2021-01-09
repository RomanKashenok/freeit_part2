package com.freeit.cloudupload.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cloud_images")
public class Picture {

    @Id
    @GeneratedValue
    private Long id;

    private String publicUri;

    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublicUri() {
        return publicUri;
    }

    public void setPublicUri(String publicUri) {
        this.publicUri = publicUri;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @PrePersist
    public void prePersist() {
        this.created = new Date();
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", publicUri='" + publicUri + '\'' +
                ", created=" + created +
                '}';
    }
}
