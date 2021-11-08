package com.georgimirchev.domain.componentdata

import com.georgimirchev.domain.componentdata.types.UiComponentDataTypes

interface UiComponentData {
    @UiComponentDataTypes
    val type: String get() = ""
}
