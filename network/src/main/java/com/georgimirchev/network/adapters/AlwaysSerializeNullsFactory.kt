package com.georgimirchev.network.adapters

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.Type

/**
 * Checks for classes annotated with [AlwaysSerializeNulls] and ensures nulls are serialized
 * rather than being left out of the generated JSON.
 *
 * See https://github.com/square/moshi/blob/9c17bb823fac16a00dd5af64bea0f0497678799e/README.md#composing-adapters
 */
object AlwaysSerializeNullsFactory : JsonAdapter.Factory {
    override fun create(
        type: Type,
        annotations: Set<Annotation?>,
        moshi: Moshi
    ): JsonAdapter<*>? {
        val rawType = Types.getRawType(type)
        if (!rawType.isAnnotationPresent(AlwaysSerializeNulls::class.java)) {
            return null
        }
        return moshi.nextAdapter<Any>(this, type, annotations).serializeNulls()
    }
}

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class AlwaysSerializeNulls
