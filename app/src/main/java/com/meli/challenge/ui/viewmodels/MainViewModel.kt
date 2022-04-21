package com.meli.challenge.ui.viewmodels

import androidx.annotation.StringRes
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meli.challenge.data.models.ResponseSearchModel
import com.meli.challenge.data.repositories.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {

    private val _searchResponse: MutableState<ResponseSearchModel?> = mutableStateOf(null)
    val searchResponse: State<ResponseSearchModel?> get() = _searchResponse

    private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: State<Boolean> get() = _isLoading


    fun search(){
        viewModelScope.launch {
            searchRepository.searchItems(
                onStart = { _isLoading.value = true },
                onCompletion = { _isLoading.value = false },
                onError = {

                }
            ).collect {
                it
            }
        }

    }

}