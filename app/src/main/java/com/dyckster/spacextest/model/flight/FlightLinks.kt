package com.dyckster.spacextest.model.flight

import com.google.gson.annotations.SerializedName

data class FlightLinks(
        @SerializedName("mission_patch")
        val missionPatch: String?,
        @SerializedName("reddit_campaign")
        val redditCampaign: String?,
        @SerializedName("reddit_launch")
        val redditLaunch: String?,
        @SerializedName("reddit_recovery")
        val redditRecovery: String?,
        @SerializedName("reddit_media")
        val redditMedia: String?,
        @SerializedName("press_kit")
        val pressKit: String?,
        @SerializedName("article_link")
        val articleLink: String?,
        @SerializedName("video_link")
        val videoLink: String?
)