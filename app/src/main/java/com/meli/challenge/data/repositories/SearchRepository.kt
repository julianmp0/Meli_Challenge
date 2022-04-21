package com.meli.challenge.data.repositories

import com.meli.challenge.data.network.Service
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val service: Service
) {

    fun searchItems(
        search: String,
        onStart: () -> Unit,
        onCompletion: () -> Unit,
        onError: (String) -> Unit
    ) = flow {

        service.searchItemsByQuery("MLA", search = search)
            .suspendOnSuccess {
                emit(data)
            }
            .onError {
                onError(message())
            }
            .onException {
                onError(message())
            }
    }.onStart { onStart() }.onCompletion { onCompletion() }.flowOn(Dispatchers.IO)

}