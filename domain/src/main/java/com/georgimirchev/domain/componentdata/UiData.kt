package com.georgimirchev.domain.componentdata

import com.georgimirchev.domain.componentdata.types.UiDataTypes

interface UiData {
    @UiDataTypes
    val type: String get() = ""
}
