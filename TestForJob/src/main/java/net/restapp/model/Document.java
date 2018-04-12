package net.restapp.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.boot.autoconfigure.web.ResourceProperties;


@Entity
@Table(name = "document")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "hash",
        "format",
        "url",
        "title",
        "documentOf",
        "datePublished",
        "dateModified",
        "id"
})
public class Document {

    @Column(name = "hash")
    @JsonProperty("hash")
    private String hash;
    @Column(name = "format")
    @JsonProperty("format")
    private String format;
    @Column(name = "url")
    @JsonProperty("url")
    private String url;
    @Column(name = "title")
    @JsonProperty("title")
    private String title;
    @Column(name = "documentOf")
    @JsonProperty("documentOf")
    private String documentOf;
    @Column(name = "datePublished")
    @JsonProperty("datePublished")
    private String datePublished;
    @Column(name = "dateModified")
    @JsonProperty("dateModified")
    private String dateModified;

    @Id
    @JsonProperty("id")
    @Column(name = "id")
    private String id;

    @ManyToOne
    private Contract contract;

    @JsonProperty("hash")
    public String getHash() {
        return hash;
    }

    @JsonProperty("hash")
    public void setHash(String hash) {
        this.hash = hash;
    }

    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("documentOf")
    public String getDocumentOf() {
        return documentOf;
    }

    @JsonProperty("documentOf")
    public void setDocumentOf(String documentOf) {
        this.documentOf = documentOf;
    }

    @JsonProperty("datePublished")
    public String getDatePublished() {
        return datePublished;
    }

    @JsonProperty("datePublished")
    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    @JsonProperty("dateModified")
    public String getDateModified() {
        return dateModified;
    }

    @JsonProperty("dateModified")
    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}


