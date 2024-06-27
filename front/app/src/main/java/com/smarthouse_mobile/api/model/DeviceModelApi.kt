package com.smarthouse_mobile.api.model

import java.util.UUID

data class DeviceModelApi(
    val id: UUID = UUID.randomUUID(),
    val name: String = "",
    val type: String? = null,
    val description: String? = null,
    val roomId: UUID? = null,
)
