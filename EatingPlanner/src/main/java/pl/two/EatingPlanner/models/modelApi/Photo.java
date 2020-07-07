package pl.two.EatingPlanner.models.modelApi;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "thumb",
        "highres",
        "is_user_uploaded"
})
public class Photo {

    @JsonProperty("thumb")
    private String thumb;
    @JsonProperty("highres")
    private Object highres;
    @JsonProperty("is_user_uploaded")
    private Boolean isUserUploaded;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("thumb")
    public String getThumb() {
        return thumb;
    }

    @JsonProperty("thumb")
    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    @JsonProperty("highres")
    public Object getHighres() {
        return highres;
    }

    @JsonProperty("highres")
    public void setHighres(Object highres) {
        this.highres = highres;
    }

    @JsonProperty("is_user_uploaded")
    public Boolean getIsUserUploaded() {
        return isUserUploaded;
    }

    @JsonProperty("is_user_uploaded")
    public void setIsUserUploaded(Boolean isUserUploaded) {
        this.isUserUploaded = isUserUploaded;
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
