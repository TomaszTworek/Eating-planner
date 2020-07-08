package pl.two.EatingPlanner.models.modelApi;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "food_name",
        "serving_unit",
        "nix_brand_id",
        "brand_name_item_name",
        "serving_qty",
        "nf_calories",
        "photo",
        "brand_name",
        "region",
        "brand_type",
        "nix_item_id",
        "locale"
})
public class Branded {

    @JsonProperty("food_name")
    private String foodName;
    @JsonProperty("serving_unit")
    private String servingUnit;
    @JsonProperty("nix_brand_id")
    private String nixBrandId;
    @JsonProperty("brand_name_item_name")
    private String brandNameItemName;
    @JsonProperty("serving_qty")
    private Double servingQty;
    @JsonProperty("nf_calories")
    private Integer nfCalories;
    @JsonProperty("photo")
    private PhotoBranded photo;
    @JsonProperty("brand_name")
    private String brandName;
    @JsonProperty("region")
    private Integer region;
    @JsonProperty("brand_type")
    private Integer brandType;
    @JsonProperty("nix_item_id")
    private String nixItemId;
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

    @JsonProperty("nix_brand_id")
    public String getNixBrandId() {
        return nixBrandId;
    }

    @JsonProperty("nix_brand_id")
    public void setNixBrandId(String nixBrandId) {
        this.nixBrandId = nixBrandId;
    }

    @JsonProperty("brand_name_item_name")
    public String getBrandNameItemName() {
        return brandNameItemName;
    }

    @JsonProperty("brand_name_item_name")
    public void setBrandNameItemName(String brandNameItemName) {
        this.brandNameItemName = brandNameItemName;
    }

    @JsonProperty("serving_qty")
    public Double getServingQty() {
        return servingQty;
    }

    @JsonProperty("serving_qty")
    public void setServingQty(Double servingQty) {
        this.servingQty = servingQty;
    }

    @JsonProperty("nf_calories")
    public Integer getNfCalories() {
        return nfCalories;
    }

    @JsonProperty("nf_calories")
    public void setNfCalories(Integer nfCalories) {
        this.nfCalories = nfCalories;
    }

    @JsonProperty("photo")
    public PhotoBranded getPhoto() {
        return photo;
    }

    @JsonProperty("photo")
    public void setPhoto(PhotoBranded photo) {
        this.photo = photo;
    }

    @JsonProperty("brand_name")
    public String getBrandName() {
        return brandName;
    }

    @JsonProperty("brand_name")
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @JsonProperty("region")
    public Integer getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(Integer region) {
        this.region = region;
    }

    @JsonProperty("brand_type")
    public Integer getBrandType() {
        return brandType;
    }

    @JsonProperty("brand_type")
    public void setBrandType(Integer brandType) {
        this.brandType = brandType;
    }

    @JsonProperty("nix_item_id")
    public String getNixItemId() {
        return nixItemId;
    }

    @JsonProperty("nix_item_id")
    public void setNixItemId(String nixItemId) {
        this.nixItemId = nixItemId;
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
