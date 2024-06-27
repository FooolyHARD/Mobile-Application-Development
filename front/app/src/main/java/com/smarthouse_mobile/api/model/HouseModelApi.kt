package com.smarthouse_mobile.api.model

import java.util.UUID

data class HouseModelApi(
    val id: UUID = UUID.randomUUID(),
    val name: String = "",
    val description: String? = null,
    val userLogin: String? = null,
)
