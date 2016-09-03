
package com.android.saturday.restclient.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "asset_family",
        "caption",
        "collection_code",
        "collection_id",
        "collection_name",
        "display_sizes",
        "license_model",
        "max_dimensions",
        "title"
})
public class Image {

    @JsonProperty("id")
    private String id;
    @JsonProperty("asset_family")
    private String assetFamily;
    @JsonProperty("caption")
    private String caption;
    @JsonProperty("collection_code")
    private String collectionCode;
    @JsonProperty("collection_id")
    private Integer collectionId;
    @JsonProperty("collection_name")
    private String collectionName;
    @JsonProperty("display_sizes")
    private List<DisplaySize> displaySizes = new ArrayList<DisplaySize>();
    @JsonProperty("license_model")
    private String licenseModel;
    @JsonProperty("max_dimensions")
    private MaxDimensions maxDimensions;
    @JsonProperty("title")
    private String title;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The assetFamily
     */
    @JsonProperty("asset_family")
    public String getAssetFamily() {
        return assetFamily;
    }

    /**
     * @param assetFamily The asset_family
     */
    @JsonProperty("asset_family")
    public void setAssetFamily(String assetFamily) {
        this.assetFamily = assetFamily;
    }

    /**
     * @return The caption
     */
    @JsonProperty("caption")
    public String getCaption() {
        return caption;
    }

    /**
     * @param caption The caption
     */
    @JsonProperty("caption")
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * @return The collectionCode
     */
    @JsonProperty("collection_code")
    public String getCollectionCode() {
        return collectionCode;
    }

    /**
     * @param collectionCode The collection_code
     */
    @JsonProperty("collection_code")
    public void setCollectionCode(String collectionCode) {
        this.collectionCode = collectionCode;
    }

    /**
     * @return The collectionId
     */
    @JsonProperty("collection_id")
    public Integer getCollectionId() {
        return collectionId;
    }

    /**
     * @param collectionId The collection_id
     */
    @JsonProperty("collection_id")
    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    /**
     * @return The collectionName
     */
    @JsonProperty("collection_name")
    public String getCollectionName() {
        return collectionName;
    }

    /**
     * @param collectionName The collection_name
     */
    @JsonProperty("collection_name")
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    /**
     * @return The displaySizes
     */
    @JsonProperty("display_sizes")
    public List<DisplaySize> getDisplaySizes() {
        return displaySizes;
    }

    /**
     * @param displaySizes The display_sizes
     */
    @JsonProperty("display_sizes")
    public void setDisplaySizes(List<DisplaySize> displaySizes) {
        this.displaySizes = displaySizes;
    }

    /**
     * @return The licenseModel
     */
    @JsonProperty("license_model")
    public String getLicenseModel() {
        return licenseModel;
    }

    /**
     * @param licenseModel The license_model
     */
    @JsonProperty("license_model")
    public void setLicenseModel(String licenseModel) {
        this.licenseModel = licenseModel;
    }

    /**
     * @return The maxDimensions
     */
    @JsonProperty("max_dimensions")
    public MaxDimensions getMaxDimensions() {
        return maxDimensions;
    }

    /**
     * @param maxDimensions The max_dimensions
     */
    @JsonProperty("max_dimensions")
    public void setMaxDimensions(MaxDimensions maxDimensions) {
        this.maxDimensions = maxDimensions;
    }

    /**
     * @return The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
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
