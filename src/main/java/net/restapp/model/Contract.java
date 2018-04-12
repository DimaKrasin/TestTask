package net.restapp.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "contract")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data"
})
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @OneToMany(mappedBy = "contract")
    @JsonProperty("data")
    private List<Document> data = null;

    @JsonProperty("data")
    public List<Document> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Document> data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contract)) return false;
        Contract contract = (Contract) o;
        return id == contract.id &&
                Objects.equals(data, contract.data);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, data);
    }
}

