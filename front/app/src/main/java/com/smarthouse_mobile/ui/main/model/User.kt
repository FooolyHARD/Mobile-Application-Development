package com.smarthouse_mobile.ui.main.model

import com.smarthouse_mobile.ui.main.model.devices.Color
import com.smarthouse_mobile.ui.main.model.devices.Conditioner
import com.smarthouse_mobile.ui.main.model.devices.ConditioningMode
import com.smarthouse_mobile.ui.main.model.devices.Device
import com.smarthouse_mobile.ui.main.model.devices.Lamp

val simpleDevice = Lamp(1, "Lamp 1", true, true, Color.WHITE, 1)

lateinit var user: Pair<Int, MutableMap<Int, Pair<House, MutableMap<Int, Pair<Room, MutableMap<Int, Device>>>>>>


val testUser: Pair<Int, MutableMap<Int, Pair<House, MutableMap<Int, Pair<Room, MutableMap<Int, Device>>>>>> = Pair(0,
    mutableMapOf(
        Pair(1,
            Pair(
                House(1, "Дача на море"),
                mutableMapOf(
                    Pair(1,
                        Pair(
                            Room(1, "Cпальня", "Спальня Саши"),
                            mutableMapOf(
                                Pair(1, Lamp(1, "Lamp 1", true, true, Color.WHITE, 1)),
                                Pair(2, Conditioner(2, "cond 1", false, 20, ConditioningMode.FUN))

                            )
                        )
                    ),
                    Pair(2,
                        Pair(
                            Room(2, "Зал", "Зал на первом этаже"),
                            mutableMapOf(
                                Pair(1, Lamp(1, "Lamp 1", true, true, Color.WHITE, 1)),
                                Pair(2, Lamp(2, "Lamp 1", true, true, Color.WHITE, 1))
                            )
                        )
                    ),
                    Pair(3,
                        Pair(
                            Room(3, "Кухня", "Обычная кухня"),
                            mutableMapOf(
                                Pair(1, Lamp(1, "Lamp 1", true, true, Color.WHITE, 1)),
                                Pair(2, Conditioner(2, "cond 1", false, 20, ConditioningMode.FUN)),
                            )
                        )
                    )
                )
            )
        ),
        Pair(2,
            Pair(
                House(2, "Белорусская, 6"),
                mutableMapOf(
                    Pair(1,
                        Pair(
                            Room(1, "805Б", "ВОТ ЭТО ПРИКОЛ"),
                            mutableMapOf(
                                Pair(1, Lamp(1, "Lamp 1", true, true, Color.WHITE, 1)),
                                Pair(2, Conditioner(2, "cond 1", false, 20, ConditioningMode.FUN))

                            )
                        )
                    ),
                    Pair(2,
                        Pair(
                            Room(2, "Ванная", "Мокренько"),
                            mutableMapOf(
                                Pair(1, Lamp(1, "Lamp 1", true, true, Color.WHITE, 1)),
                                Pair(2, Lamp(2, "Lamp 1", true, true, Color.WHITE, 1))
                            )
                        )
                    ),
                    Pair(3,
                        Pair(
                            Room(3, "Кухня", "Обычная кухня"),
                            mutableMapOf(
                                Pair(1, Lamp(1, "Lamp 1", true, true, Color.WHITE, 1)),
                                Pair(2, Conditioner(2, "cond 1", false, 20, ConditioningMode.FUN)),
                            )
                        )
                    )
                )
            )
        )
    )
)
