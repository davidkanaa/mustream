package com.mustream.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;


/**
 * Mustream streaming service object : contains information about an Streaming Service integrated in the Mustream Platform.
 **/

@ApiModel(description = "Mustream streaming service object : contains information about an Streaming Service integrated in the Mustream Platform.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-10T04:15:39.662Z")
public class StreamingService {

    private String id = null;
    private String name = null;

    /**
     * The MuStream ID for the streaming service.
     **/
    public StreamingService id(String id) {
        this.id = id;
        return this;
    }


    @ApiModelProperty(value = "The MuStream ID for the streaming service.")
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * The name of the streaming service.
     **/
    public StreamingService name(String name) {
        this.name = name;
        return this;
    }


    @ApiModelProperty(value = "The name of the streaming service.")
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StreamingService streamingService = (StreamingService) o;
        return Objects.equals(id, streamingService.id) &&
                Objects.equals(name, streamingService.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class StreamingService {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

