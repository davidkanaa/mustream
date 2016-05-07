package com.mustream.app.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by davidkanaa on 16-04-12.
 */
@Entity
public class PlaylistEntity {
    @GeneratedValue
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Version
    private Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @ElementCollection
    private List<String> tracksUris;

    public List<String> getTracksUris() {
        return tracksUris;
    }

    public void setTracksUris(List<String> tracksURIS) {
        this.tracksUris = tracksURIS;
    }

    @Basic
    private String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String ownerID) {
        this.owner = ownerID;
    }
}
