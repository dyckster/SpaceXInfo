package com.dyckster.spacextest.data.entity.info

import com.dyckster.spacextest.domain.model.info.Headquarters

data class CompanyInfoEntity(
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