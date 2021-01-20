package com.raeandres.cartrackapp.common.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/** Rae-An Andres created on 2020-06-02*/

interface NetworkService {


    /**To get the current user's playlist
    1.  Get User Channel

        GET https://www.googleapis.com/youtube/v3/channels?part=snippet%2CcontentDetails%2CbrandingSettings&maxResults=20&mine=true&key=[YOUR_API_KEY] HTTP/1.1

        Authorization: Bearer [YOUR_ACCESS_TOKEN]
        Accept: application/json

    2.   Get Channel ID
        *  GET https://www.googleapis.com/youtube/v3/channels?part=id&forUsername=GoogleDevelopers&key=[YOUR_API_KEY] HTTP/1.1

            Authorization: Bearer [YOUR_ACCESS_TOKEN]
            Accept: application/json

     3.  Get Channel's Playlist
        *   GET https://www.googleapis.com/youtube/v3/playlists?part=snippet%2CcontentDetails&channelId=UC_x5XG1OV2P6uZZ5FSM9Ttw&key=[YOUR_API_KEY] HTTP/1.1

            Authorization: Bearer [YOUR_ACCESS_TOKEN]
            Accept: application/json
     */

//    @GET("youtube/v3/channels")
//    fun getPersonalChannel(@Query("key") apiKey: String, @Query("part")part: String, @Query("mine") mine: Boolean) : Call<UserChannelResponse>
//
//    @GET("youtube/v3/search")
//    fun getChannel(@Query("key") apiKey: String,
//                   @Query("channelId") channelId: String,
//                   @Query("part") part: String,
//                   @Query("order") order: String,
//                   @Query("maxResults") maxResults: Int) : Call<YoutubeSearchResponse>



    //part=snippet&order=date&channelId={YOUR_CHANNEL_ID}&maxResults=20&key={YOUR_API_KEY}

//    // get Channel ID
//    @GET("youtube/v3/channels")
//    fun getChannelID(@Query("key") apiKey: String,
//                     @Query("forUsername") forUsername: String,
//                     @Query("part") part: String) : Call<CurrentUserPlaylistResponse>


    //GET https://www.googleapis.com/youtube/v3/playlists

    //GeT channel ID
//    GET https://www.googleapis.com/youtube/v3/channels?part=id&forUsername=GoogleDevelopers&key=[YOUR_API_KEY] HTTP/1.1
//
//    Authorization: Bearer [YOUR_ACCESS_TOKEN]
//    Accept: application/json



//    GET the Channel's playlist
//    GET https://www.googleapis.com/youtube/v3/playlists?part=snippet%2CcontentDetails&channelId=UC_x5XG1OV2P6uZZ5FSM9Ttw&key=[YOUR_API_KEY] HTTP/1.1
////
////    Authorization: Bearer [YOUR_ACCESS_TOKEN]
////    Accept: application/json



//    GET Current User's Playlist
//    GET https://www.googleapis.com/youtube/v3/playlists?part=snippet%2CcontentDetails&mine=true&key=[YOUR_API_KEY] HTTP/1.1
//
//    Authorization: Bearer [YOUR_ACCESS_TOKEN]
//    Accept: application/json

//    GET https://www.googleapis.com/youtube/v3/playlists?part=snippet%2CcontentDetails&channelId=UCEXZ8k4eot6RvPy1_MIob7A&maxResults=25&key=[YOUR_API_KEY] HTTP/1.1
//
//    Authorization: Bearer [YOUR_ACCESS_TOKEN]
//    Accept: application/json



//    @GET("youtube/v3/playlists")
//    fun getCurrentUserPlaylist(@Query("key")apiKey: String, @Query("part")part: String, @Query("channelId") channelId: String, @Query("maxResults") maxResults: Int) : Call<CurrentUserPlaylistResponse>





    //    GET Playlist Item
//    GET https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=20&playlistId=UU7V6hW6xqPAiUfataAZZtWA&key=[YOUR_API_KEY] HTTP/1.1
//
//    Authorization: Bearer [YOUR_ACCESS_TOKEN]
//    Accept: application/json

//    @GET("youtube/v3/playlistItems")
//    fun getPlaylistItems(@Query("key")apiKey: String, @Query("part")part: String, @Query("playlistId")playlistId: String, @Query("maxResults") maxResults: Int): Call<ItemPlaylistsResponse>


//    GET https://www.googleapis.com/youtube/v3/playlistItems?part=snippet%2C%20contentDetails%2C%20status%2C%20id&maxResults=25&playlistId=PLBCF2DAC6FFB574DE&key=[YOUR_API_KEY] HTTP/1.1
//
//    Authorization: Bearer [YOUR_ACCESS_TOKEN]
//    Accept: application/json



//    GET Video duration
//    GET https://www.googleapis.com/youtube/v3/videos?part=snippet%2CcontentDetails%2Cstatistics&id=Ks-_Mh1QhMc&key=[YOUR_API_KEY] HTTP/1.1
//
//    Authorization: Bearer [YOUR_ACCESS_TOKEN]
//    Accept: application/json



//    @GET("youtube/v3/videos")
//    fun getVideoDetails(@Query("key") apiKey: String,@Query("part") part: String,@Query("id") videoId: String) : Call<VideoDetailsResponse>



    // Get Channel Author
//    GET https://www.googleapis.com/youtube/v3/channels?part=snippet%2CcontentDetails%2Cstatistics&id=UC_x5XG1OV2P6uZZ5FSM9Ttw&key=[YOUR_API_KEY] HTTP/1.1
//
//    Authorization: Bearer [YOUR_ACCESS_TOKEN]
//    Accept: application/json

//    @GET("youtube/v3/channels")
//    fun getAuthorFromChannel(@Query("key") apiKey: String, @Query("part") part: String, @Query("id")channelId: String) : Call<UserChannelResponse>


}