package pl.two.EatingPlanner.models.modelApi;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "food_name",
        "serving_unit",
        "tag_name",
        "serving_qty",
        "common_type",
        "tag_id",
        "photo",
        "locale"
})
public class Common {

    @JsonProperty("food_name")
    private String foodName;
    @JsonProperty("serving_unit")
    private String servingUnit;
    @JsonProperty("tag_name")
    private String tagName;
    @JsonProperty("serving_qty")
    private Integer servingQty;
    @JsonProperty("common_type")
    private Integer commonType;
    @JsonProperty("tag_id")
    private String tagId;
    @JsonProperty("photo")
    private Photo photo;
    @JsonProperty("locale")
    private String locale;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("food_name")
    public String getFoodName() {
        return foodName;
    }

    @JsonProperty("food_name")
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @JsonProperty("serving_unit")
    public String getServingUnit() {
        return servingUnit;
    }

    @JsonProperty("serving_unit")
    public void setServingUnit(String servingUnit) {
        this.servingUnit = servingUnit;
    }

    @JsonProperty("tag_name")
    public String getTagName() {
        return tagName;
    }

    @JsonProperty("tag_name")
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @JsonProperty("serving_qty")
    public Integer getServingQty() {
        return servingQty;
    }

    @JsonProperty("serving_qty")
    public void setServingQty(Integer servingQty) {
        this.servingQty = servingQty;
    }

    @JsonProperty("common_type")
    public Integer getCommonType() {
        return commonType;
    }

    @JsonProperty("common_type")
    public void setCommonType(Integer commonType) {
        this.commonType = commonType;
    }

    @JsonProperty("tag_id")
    public String getTagId() {
        return tagId;
    }

    @JsonProperty("tag_id")
    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    @JsonProperty("photo")
    public Photo getPhoto() {
        return photo;
    }

    @JsonProperty("photo")
    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    @JsonProperty("locale")
    public String getLocale() {
        return locale;
    }

    @JsonProperty("locale")
    public void setLocale(String locale) {
        this.locale = locale;
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
