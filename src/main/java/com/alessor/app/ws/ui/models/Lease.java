package com.alessor.app.ws.ui.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Blob;

@Entity(name="Lease")
public class Lease implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable=false, name="Description")
    private String description;

    @Column(nullable=false, name="Contents")
    @Lob
    private byte[] contents;

    @Column(nullable=false, name="Active")
    private Boolean active;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getContents() {
        return this.contents;
    }

    public void setContents(byte[] contents) {
        this.contents = contents;
    }
}
