package com.mustream.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;



/**
 * Mustream playlist object.
 **/

@ApiModel(description = "Mustream playlist object.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-28T15:50:48.909Z")
public class Playlist   {
  
  private String id = null;
  private String name = null;
  private String uri = null;
  private String group = null;
  private List<Track> tracks = new ArrayList<Track>();

  
  /**
   * The MuStream ID for the playlist.
   **/
  public Playlist id(String id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(value = "The MuStream ID for the playlist.")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   * The name of the playlist.
   **/
  public Playlist name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(value = "The name of the playlist.")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * The Mustream Resource Identifier or URI for the track.
   **/
  public Playlist uri(String uri) {
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
   **/
  public Playlist group(String group) {
    this.group = group;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("group")
  public String getGroup() {
    return group;
  }
  public void setGroup(String group) {
    this.group = group;
  }

  
  /**
   * The tracks of the playlist.
   **/
  public Playlist tracks(List<Track> tracks) {
    this.tracks = tracks;
    return this;
  }

  
  @ApiModelProperty(value = "The tracks of the playlist.")
  @JsonProperty("tracks")
  public List<Track> getTracks() {
    return tracks;
  }
  public void setTracks(List<Track> tracks) {
    this.tracks = tracks;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Playlist playlist = (Playlist) o;
    return Objects.equals(id, playlist.id) &&
        Objects.equals(name, playlist.name) &&
        Objects.equals(uri, playlist.uri) &&
        Objects.equals(group, playlist.group) &&
        Objects.equals(tracks, playlist.tracks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, uri, group, tracks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Playlist {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
    sb.append("    tracks: ").append(toIndentedString(tracks)).append("\n");
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

