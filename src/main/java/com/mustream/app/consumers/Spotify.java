package com.mustream.app.consumers;

import com.mustream.api.models.StreamingService;
import com.mustream.api.models.Track;

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
 * Created by davidkanaa on 16-04-11.
 */
public class Spotify extends ServiceConsumer {

    public Spotify() {
        this.id = "spotify";
        this.name = "spotify";
        this.baseURL = "https://api.spotify.com";
        this.clientID = "ea319403675f4db29fcce916fff2679f";
    }

    /**
     * Runs a search over Spotify's database.
     * @param terms Terms of the search.
     * @return The results of the search as a list of Items.
     */
    @Override
    public List<Track> search(String terms) {

        String query;
        URL url;
        List<Track> results = new ArrayList<>();

        try {

            query = URLEncoder.encode(terms, "UTF-8");
            url = new URL(baseURL + "/v1/search?q=" + query + "&type=" + "track");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStream in = new BufferedInputStream(connection.getInputStream());
            JsonReader reader = Json.createReader(in);
            JsonObject jsonResults = reader.readObject();

            // retrieves the tracks within the results.
            JsonArray tracks = (JsonArray) jsonResults.getJsonObject("tracks").get("items");
            for (JsonObject jsonTrack : tracks.getValuesAs(JsonObject.class)) {

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
                /*String streamUrl;
                if (jsonTrack.get("preview_url") == null) {
                    streamUrl = "n/a";
                } else {
                    streamUrl = jsonTrack.getString("preview_url");
                }
                track.setStreamUrl(streamUrl);*/

                if (jsonTrack.get("preview_url") != null)
                    track.setStreamUrl(jsonTrack.getString("preview_url"));

                // Sets id.
                String id = jsonTrack.getString("id");
                track.setId(id);

                // Sets streaming service provider.
                StreamingService service = new StreamingService();
                service.setName(this.name);
                service.setId(this.id);
                track.setSource(service);

                // Sets mustream unique resource identifier
                String uri = this.id + ":track:" +  id;
                track.setUri(uri);


                // Adding to the results.
                results.add(track);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return results;
    }
}
