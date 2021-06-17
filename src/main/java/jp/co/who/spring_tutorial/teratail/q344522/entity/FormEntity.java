package jp.co.who.spring_tutorial.teratail.q344522.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormEntity {
    public FormEntity() {
    }

    @JsonProperty
    private Integer id;
    @JsonProperty
    private String startTime;
    @JsonProperty
    private String endTime;

    public FormEntity(Integer id, String startTime, String endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
