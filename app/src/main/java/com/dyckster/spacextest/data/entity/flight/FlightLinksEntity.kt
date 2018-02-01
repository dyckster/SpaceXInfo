package com.dyckster.spacextest.data.entity.flight

import com.google.gson.annotations.SerializedName

data class FlightLinksEntity(
        @SerializedName("mission_patch")
        var missionPatch: String?,
        @SerializedName("reddit_campaign")
        var redditCampaign: String?,
        @SerializedName("reddit_launch")
        var redditLaunch: String?,
        @SerializedName("reddit_recovery")
        var redditRecovery: String?,
        @SerializedName("reddit_media")
        var redditMedia: String?,
        @SerializedName("press_kit")
        var pressKit: String?,
        @SerializedName("article_link")
        var articleLink: String?,
        @SerializedName("video_link")
        var videoLink: String?
)
