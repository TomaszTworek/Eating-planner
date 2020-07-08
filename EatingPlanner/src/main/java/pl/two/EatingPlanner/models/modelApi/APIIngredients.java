package pl.two.EatingPlanner.models.modelApi;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "common",
        "branded"
})
public class APIIngredients {

    @JsonProperty("common")
    private List<Common> common = null;
    @JsonProperty("branded")
    private List<Branded> branded = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("common")
    public List<Common> getCommon() {
        return common;
    }

    @JsonProperty("common")
    public void setCommon(List<Common> common) {
        this.common = common;
    }

    @JsonProperty("branded")
    public List<Branded> getBranded() {
        return branded;
    }

    @JsonProperty("branded")
    public void setBranded(List<Branded> branded) {
        this.branded = branded;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
