package com.georgimirchev.domain.models

inline class BrandIdModel(val value: String)

inline class ChannelIdModel(val value: Int) {
    companion object {
        val NULL = ChannelIdModel(-1)
    }
}
