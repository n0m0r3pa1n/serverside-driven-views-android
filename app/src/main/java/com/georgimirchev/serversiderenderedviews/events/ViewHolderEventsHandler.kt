package com.georgimirchev.serversiderenderedviews.events

import com.georgimirchev.domain.uievents.UiEvent

interface ViewHolderEventsHandler {
    fun submitEvent(uiEvent: UiEvent)
}
