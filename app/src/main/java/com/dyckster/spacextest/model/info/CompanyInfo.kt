package com.dyckster.spacextest.model.info

data class CompanyInfo(
        val name: String,
        val found: String,
        val founded: Int,
        val employees: Int,
        val vehicles: Int,
        val launchSites: Int,
        val testSites: Int,
        val ceo: String,
        val cto: String,
        val coo: String,
        val ctoPropulsion: String,
        val valuation: Long,
        val headquarters: Headquarters,
        val summary: String
)