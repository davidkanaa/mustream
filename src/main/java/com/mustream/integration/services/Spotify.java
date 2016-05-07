package com.mustream.integration.services;

import com.google.common.base.Joiner;
import com.mustream.integration.StreamingService;
import com.mustream.models.Track;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by davidkanaa on 16-04-28.
 */
public class Spotify extends StreamingService{


    public Spotify() {
        this.name = "spotify";
        this.baseURL = "https://api.spotify.com/v1";
        this.clientID = "ea319403675f4db29fcce916fff2679f";
    }


    /**
     * Runs a search over Spotify's database.
     * @param terms Terms of the search.
     * @return The results of the search as a list of Items.
     */
    @Override
    public List<Track> search(String terms) {

        List<Track> results = new ArrayList<>();

        try {

            String query = URLEncoder.encode(terms, "UTF-8");
            URL url = new URL(baseURL + "/search?q=" + query + "&type=" + "track");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStream in = new BufferedInputStream(connection.getInputStream());
            JsonReader reader = Json.createReader(in);
            JsonObject jsonResults = reader.readObject();

            JsonArray tracks = (JsonArray) jsonResults.getJsonObject("tracks").get("items");


            // retrieves the tracks within the results.
            retrieveTracksFromJson(results, tracks);

        }catch(IOException e){
            e.printStackTrace();
        }
        return results;
    }

    private void retrieveTracksFromJson(List<Track> results, JsonArray tracks) {
        for (JsonObject jsonTrack : tracks.getValuesAs(JsonObject.class)) {

            Track track = buildTrack(jsonTrack);

            // Adding to the results.
            results.add(track);
        }
    }

    private Track buildTrack(JsonObject jsonTrack) {
        Track track = new Track();

        // Sets the album name.
        String albumName = ((JsonObject) jsonTrack.get("album")).getString("name");
        track.setAlbum(albumName);

        // Sets the list of artists.
        JsonArray jsonArtists = (JsonArray) jsonTrack.get("artists");
        List<String> artists = jsonArtists.getValuesAs(JsonObject.class).stream().map(jsonArtist -> jsonArtist.get("name").toString()).collect(Collectors.toList());
        track.setArtists(artists);

        // Sets duration.
        long duration = jsonTrack.getJsonNumber("duration_ms").longValue();
        track.setDuration(duration);

        // Sets title.
        String name = jsonTrack.getString("name");
        track.setName(name);

        // Sets stream url.
        if (jsonTrack.get("preview_url") != null)
            track.setStreamUrl(jsonTrack.getString("preview_url"));

        // Sets id.
        String id = jsonTrack.getString("id");
        track.setId(id);

        // Sets mustream unique resource identifier
        String uri = this.name + ":track:" +  id;
        track.setUri(uri);
        return track;
    }

    @Override
    public List<Track> getTracks(List<String> ids) {

        List<Track> results = new ArrayList<>();

        //
        String identifiers = Joiner.on(",").join(ids);

        try {
            URL url = new URL(baseURL + "/tracks?ids="+identifiers);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStream in = new BufferedInputStream(connection.getInputStream());
            JsonReader reader = Json.createReader(in);
            JsonObject jsonResults = reader.readObject();

            JsonArray tracks = (JsonArray) jsonResults.get("tracks");

            // retrieves the tracks within the results.
            retrieveTracksFromJson(results, tracks);

        }catch (Exception e){
            e.printStackTrace();
        }
        return results;
    }
}
