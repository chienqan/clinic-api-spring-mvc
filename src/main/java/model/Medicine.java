package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Medicine {

    @Id
    private String name;

    @OneToMany(mappedBy = "medicine", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Drug> drugs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }
}
