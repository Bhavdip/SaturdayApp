
package com.android.saturday.restclient.pojo;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "is_watermarked",
        "name",
        "uri"
})
public class DisplaySize {

    @JsonProperty("is_watermarked")
    private Boolean isWatermarked;
    @JsonProperty("name")
    private String name;
    @JsonProperty("uri")
    private String uri;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The isWatermarked
     */
    @JsonProperty("is_watermarked")
    public Boolean getIsWatermarked() {
        return isWatermarked;
    }

    /**
     * @param isWatermarked The is_watermarked
     */
    @JsonProperty("is_watermarked")
    public void setIsWatermarked(Boolean isWatermarked) {
        this.isWatermarked = isWatermarked;
    }

    /**
     * @return The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The uri
     */
    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    /**
     * @param uri The uri
     */
    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
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
