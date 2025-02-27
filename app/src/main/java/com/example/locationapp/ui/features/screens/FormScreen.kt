package com.example.locationapp.ui.features.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.locationapp.ui.components.CardComponents
import com.example.locationapp.ui.components.DefaultTextField
import com.example.locationapp.ui.components.ImgMapComponents
import com.example.locationapp.ui.components.NavTopComponent
import com.example.locationapp.ui.features.actions.FormAction
import com.example.locationapp.ui.features.format.formatCep
import com.example.locationapp.ui.features.states.FormState
import com.example.locationapp.ui.features.viewModels.FormViewModel

@Composable
fun FormScreen(){
    val viewModel: FormViewModel = viewModel()
    val state = viewModel.state.collectAsState().value
    FormContent(
        action = viewModel::action,
        state = state
    )
}

@Composable
fun FormContent(
    state: FormState,
    action: (FormAction) ->Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            NavTopComponent(
                titulo = "Localizar",
            )
            DefaultTextField(
                value = state.search    ,
                onValueChange = {
                    val cleanedInput = it.filter { char -> char.isDigit() }
                    if (cleanedInput.length <= 8) {
                        action(FormAction.UpdateSearch(cleanedInput))
                    }
                },
                label = "Digite seu CEP",
                placeholder = "00000-000",
                singleLine = true,
                charLimit = 9,
                iconLeft = Icons.Default.LocationOn,
                iconRight = Icons.Default.Clear,
                keyboardType = KeyboardType.Number,
                shape = RoundedCornerShape(16.dp),
                isError = false,
            )
        }

        ImgMapComponents(
            estado = state.estado ?: "Não informado",
            cidade = state.cidade ?: "Não informado",
        )
        CardComponents(
            cep = formatCep(state.cep ?: "Não informado"),
            rua = state.rua ?: "Não informado",
            bairro = state.bairro ?: "Não informado",
            regiao = state.regiao ?: "Não informado",
            ddd = state.ddd ?: "Não informado"
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun FormPreview(){
    FormContent(
        state = FormState(

        ),
        action = {}
    )
}