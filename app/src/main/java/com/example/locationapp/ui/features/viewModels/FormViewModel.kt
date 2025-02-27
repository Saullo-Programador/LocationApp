package com.example.locationapp.ui.features.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.locationapp.domain.usecase.GetAddressUseCase
import com.example.locationapp.ui.features.actions.FormAction
import com.example.locationapp.ui.features.states.FormState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FormViewModel @Inject constructor(
    private val getAddressUseCase: GetAddressUseCase
): ViewModel() {

    private val _state = MutableStateFlow(FormState())
    var state: StateFlow<FormState> = _state

    init {

    }


    fun action(action: FormAction){
        when(action){
            FormAction.SearchAddress -> {
                searchAddress()
            }
            is FormAction.UpdateSearch -> {
                _state.update { currentState ->
                    currentState.copy(search = action.search)
                }
                searchAddress()
            }
        }
    }

    private fun searchAddress(){
        viewModelScope.launch {
            if (_state.value.search.length == 8) {
                val addressResponse = getAddressUseCase(_state.value.search)
                _state.update { addressResponse.toFormState(_state.value.search) }
            }
        }
    }
}