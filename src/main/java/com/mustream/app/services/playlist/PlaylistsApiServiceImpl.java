package com.mustream.app.services.playlist;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mustream.api.ApiResponseMessage;
import com.mustream.app.entities.PlaylistEntity;
import com.mustream.app.services.playlist.PlaylistsApiService;

import java.util.ArrayList;
import java.util.List;

import com.mustream.integration.ServiceLoader;
import com.mustream.models.Error;
import com.mustream.models.Playlist;
import com.mustream.models.PlaylistInfo;

import com.mustream.api.NotFoundException;
import com.mustream.models.Track;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-04-28T15:50:48.909Z")
public class PlaylistsApiServiceImpl extends PlaylistsApiService {

    EntityManager em = Persistence.createEntityManagerFactory("playlists_local").createEntityManager();

    @Override
    public Response addTrackstoPlaylist(String playlistId, List<String> uris, SecurityContext securityContext)
            throws NotFoundException {
        // do services magic!

        try {
            PlaylistEntity playlist = new PlaylistEntity();
            em.getTransaction().begin();
            playlist = em.find(PlaylistEntity.class, Long.parseLong(playlistId));

            List<String> tracksURIs = playlist.getTracksUris();
            if (uris != null)
                // Add a track uri only if it is not already in the playlist.
                for (String uri :
                        uris) {
                    if (!tracksURIs.contains(uri))
                        playlist.getTracksUris().add(uri);
                }

            em.getTransaction().commit();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "No such Playlist")).build();
        }
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successful operation!")).build();
    }

    @Override
    public Response createPlaylist(PlaylistInfo playlistInfo, SecurityContext securityContext)
            throws NotFoundException {
        // do services magic!
        PlaylistEntity playlist = new PlaylistEntity();
        playlist.setOwner(playlistInfo.getGroup());
        playlist.setName(playlistInfo.getName());
        playlist.setTracksUris(new ArrayList<>());

        em.getTransaction().begin();
        em.persist(playlist);
        em.getTransaction().commit();

        // Just for pretty printing ... will be deleted
        try {
            ObjectMapper mapper = new ObjectMapper();
            return Response.ok().entity(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(playlist)).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //System.out.println(v);

        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response deletePlaylist(String playlistId, SecurityContext securityContext)
            throws NotFoundException {
        // do services magic!
        try {

            em.getTransaction().begin();
            PlaylistEntity playlist = em.find(PlaylistEntity.class, Long.parseLong(playlistId));

            em.remove(playlist);
            em.getTransaction().commit();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "No such Playlist")).build();
        }

        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response getAllPlaylists(String group, SecurityContext securityContext)
            throws NotFoundException {
        // do services magic!

        List<PlaylistEntity> playlists = new ArrayList<>();

        em.getTransaction().begin();
        TypedQuery query = em.createQuery("select p from PlaylistEntity p where p.owner = :group", PlaylistEntity.class);
        playlists = query.setParameter("group", group).getResultList();
        em.getTransaction().commit();

        List<Playlist> p_s = new ArrayList<>();

        if (!playlists.isEmpty()) {

            for (PlaylistEntity playlist :
                    playlists) {
                Playlist p = new Playlist();
                p.setTracks(new ArrayList<>());

                getPlaylistTracks(playlist, p);

                p.setName(playlist.getName());
                p.setId(playlist.getId().toString());
                p.setGroup(playlist.getOwner());
                p.setUri("mustream:playlist:" + playlist.getId());

                p_s.add(p);
            }
        }

        // Just for pretty printing ... will be deleted
        try {
            ObjectMapper mapper = new ObjectMapper();
            return Response.ok().entity(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(p_s)).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response getPlaylist(String playlistId, SecurityContext securityContext)
            throws NotFoundException {
        // do services magic!
        PlaylistEntity playlist = new PlaylistEntity();

        try {
            em.getTransaction().begin();
            playlist = em.find(PlaylistEntity.class, Long.parseLong(playlistId));
            em.getTransaction().commit();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "No such Playlist")).build();
        }


        Playlist p = new Playlist();
        p.setTracks(new ArrayList<>());

        if (!playlist.getTracksUris().isEmpty())
            getPlaylistTracks(playlist, p);

        p.setName(playlist.getName());
        p.setId(playlist.getId().toString());
        p.setGroup(playlist.getOwner());
        p.setUri("mustream:playlist:" + playlist.getId());


        // Just for pretty printing ... will be deleted
        try {
            ObjectMapper mapper = new ObjectMapper();
            return Response.ok().entity(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(p)).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    private void getPlaylistTracks(PlaylistEntity playlist, Playlist p) {
        List<String> idsFromSpotify = new ArrayList<>();
        List<String> idsFromSoundcloud = new ArrayList<>();


        for (String uri :
                playlist.getTracksUris()) {

            String[] parts = uri.split(":");

            switch (parts[0]) {
                case "spotify":
                    idsFromSpotify.add(parts[2]);
                    break;
                case "soundcloud":
                    idsFromSoundcloud.add(parts[2]);
                    break;
                default:
                    break;
            }

        }


        if (!idsFromSpotify.isEmpty()) {
            List<Track> tracksFromSpotify = ServiceLoader.getInstance().getService("spotify").getTracks(idsFromSpotify);
            p.getTracks().addAll(tracksFromSpotify);
        }

        if (!idsFromSoundcloud.isEmpty()) {
            List<Track> tracksFromSoundcloud = ServiceLoader.getInstance().getService("soundcloud").getTracks(idsFromSoundcloud);
            p.getTracks().addAll(tracksFromSoundcloud);
        }
    }

    @Override
    public Response removeTracksfromPlaylist(String playlistId, List<String> uris, SecurityContext securityContext)
            throws NotFoundException {
        // do services magic!
        try {
            PlaylistEntity playlist = new PlaylistEntity();

            em.getTransaction().begin();
            playlist = em.find(PlaylistEntity.class, Long.parseLong(playlistId));

            List<String> tracksURIs = playlist.getTracksUris();
            if (uris != null)
                playlist.getTracksUris().removeAll(uris);
            em.getTransaction().commit();

        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "No such Playlist")).build();
        }

        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response updatePlaylist(String playlistId, String name, SecurityContext securityContext)
            throws NotFoundException {
        // do services magic!

        try {
            PlaylistEntity playlist = new PlaylistEntity();
            em.getTransaction().begin();
            playlist = em.find(PlaylistEntity.class, Long.parseLong(playlistId));

            playlist.setName(name);
            em.persist(playlist);
            em.getTransaction().commit();

        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "No such Playlist")).build();

        }
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

}
