package dev.wpei.typehandler.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.List;

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

    public static List<Representative> of(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            TypeFactory typeFactory = mapper.getTypeFactory();
            CollectionType collectionType = typeFactory.constructCollectionType(List.class, Representative.class);
            List<Representative> result = mapper.readValue(json, collectionType);
            return result;
        }catch (MismatchedInputException e) {
            try {
                Representative representative = mapper.readValue(json, Representative.class);
                return List.of(representative);
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
