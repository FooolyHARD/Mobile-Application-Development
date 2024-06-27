package com.smarthouse_mobile.api.model

import java.util.UUID

data class RoomModelApi(
    val id: UUID = UUID.randomUUID(),
    val name: String = "",
    val description: String? = null,
    val houseId: UUID? = null,
)
