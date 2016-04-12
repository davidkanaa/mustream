package com.mustream.app.services.consumers;

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

/**
 * Created by davidkanaa on 16-04-11.
 */
public class SoundCloud extends ServiceConsumer {

    public SoundCloud() {
        this.id = "soundcloud";
        this.name = "soudcloud";
        this.clientID = "39c4a333359cc62c40b9795ad9bb5203";
        this.baseURL = "http://api.soundcloud.com";
    }

    /**
     * Runs a search over SoundCloud's database.
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
            url = new URL(baseURL+"/tracks?client_id="+clientID+"&q="+query);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStream in = new BufferedInputStream(connection.getInputStream());
            JsonReader reader = Json.createReader(in);
            JsonArray jsonResults = reader.readArray();

            // retrieves the tracks within the results.
            for (JsonObject result:
                    jsonResults.getValuesAs(JsonObject.class)) {

                Track track = new Track();

                // Sets the album name.
                String albumName = "n/a";
                track.setAlbum(albumName);

                // Sets the user as the sole artist of the track.
                String user = result.getJsonObject("user").getString("username");
                List<String> artists = new ArrayList<>();
                artists.add(user);
                track.setArtists(artists);

                // Sets the duration.
                long duration = result.getJsonNumber("duration").longValue();
                track.setDuration(duration);

                // Sets title.
                String title = result.getString("title");
                track.setName(title);

                // Sets stream url.
                String streamUrl = result.getString("stream_url");
                track.setStreamUrl(streamUrl);

                // Sets id.
                String id = result.getJsonNumber("id").toString();
                track.setId(id);

                // Sets streaming service provider.
                StreamingService service = new StreamingService();
                service.setName(this.name);
                service.setId(this.id);
                track.setSource(service);

                // Sets mustream unique resource identifier
                String uri = this.id + ":track:" +  id;
                track.setUri(uri);

                // Sets provider.
                //track.setProvider(this);

                // Adding to the results.
                results.add(track);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return results;
    }
}
