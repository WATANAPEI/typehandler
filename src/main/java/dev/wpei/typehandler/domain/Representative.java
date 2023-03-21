package dev.wpei.typehandler.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Alias("Representative")
@Getter
@Setter
public class Representative {
    private final String lastName;
    private final String firstName;

    @JsonCreator
    public Representative(
            @JsonProperty("lastName") String lastName,
            @JsonProperty("firstName") String firstName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String result = mapper.writeValueAsString(this);
            System.out.println("serialized representative object.");
            System.out.println(result);
            return result;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Representative of(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Representative result = mapper.readValue(json, Representative.class);
            System.out.println("deserialized from string.");
            return result;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
