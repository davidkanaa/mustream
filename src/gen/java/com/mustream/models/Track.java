package com.mustream.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * Mustream track object.
 **/

@ApiModel(description = "Mustream track object.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-28T15:50:48.909Z")
public class Track   {
  
  private String id = null;
  private String name = null;
  private Long duration = null;
  private String streamUrl = null;
  private String uri = null;
  private List<String> artists = new ArrayList<String>();
  private String album = null;

  
  /**
   * The (MuStream) ID for the track.
   **/
  public Track id(String id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(value = "The (MuStream) ID for the track.")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   * The name of the track.
   **/
  public Track name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(value = "The name of the track.")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * The track length (duration) in milliseconds.
   **/
  public Track duration(Long duration) {
    this.duration = duration;
    return this;
  }

  
  @ApiModelProperty(value = "The track length (duration) in milliseconds.")
  @JsonProperty("duration")
  public Long getDuration() {
    return duration;
  }
  public void setDuration(Long duration) {
    this.duration = duration;
  }

  
  /**
   * A URL to stream the track.
   **/
  public Track streamUrl(String streamUrl) {
    this.streamUrl = streamUrl;
    return this;
  }

  
  @ApiModelProperty(value = "A URL to stream the track.")
  @JsonProperty("stream_url")
  public String getStreamUrl() {
    return streamUrl;
  }
  public void setStreamUrl(String streamUrl) {
    this.streamUrl = streamUrl;
  }

  
  /**
   * The Mustream Resource Identifier or URI for the track.
   **/
  public Track uri(String uri) {
    this.uri = uri;
    return this;
  }

  
  @ApiModelProperty(value = "The Mustream Resource Identifier or URI for the track.")
  @JsonProperty("uri")
  public String getUri() {
    return uri;
  }
  public void setUri(String uri) {
    this.uri = uri;
  }

  
  /**
   * The artists who performed the track.
   **/
  public Track artists(List<String> artists) {
    this.artists = artists;
    return this;
  }

  
  @ApiModelProperty(value = "The artists who performed the track.")
  @JsonProperty("artists")
  public List<String> getArtists() {
    return artists;
  }
  public void setArtists(List<String> artists) {
    this.artists = artists;
  }

  
  /**
   * The album of the track.
   **/
  public Track album(String album) {
    this.album = album;
    return this;
  }

  
  @ApiModelProperty(value = "The album of the track.")
  @JsonProperty("album")
  public String getAlbum() {
    return album;
  }
  public void setAlbum(String album) {
    this.album = album;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Track track = (Track) o;
    return Objects.equals(id, track.id) &&
        Objects.equals(name, track.name) &&
        Objects.equals(duration, track.duration) &&
        Objects.equals(streamUrl, track.streamUrl) &&
        Objects.equals(uri, track.uri) &&
        Objects.equals(artists, track.artists) &&
        Objects.equals(album, track.album);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, duration, streamUrl, uri, artists, album);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Track {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    streamUrl: ").append(toIndentedString(streamUrl)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("    artists: ").append(toIndentedString(artists)).append("\n");
    sb.append("    album: ").append(toIndentedString(album)).append("\n");
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

