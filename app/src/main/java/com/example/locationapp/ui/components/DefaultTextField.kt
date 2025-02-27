package com.example.locationapp.ui.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DefaultTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String? = null,
    placeholder: String? = null,
    singleLine: Boolean,
    charLimit: Int = Int.MAX_VALUE,
    iconLeft: ImageVector,
    iconRight: ImageVector,
    keyboardType: KeyboardType,
    shape: Shape,
    isError: Boolean
){
    TextField(
        modifier = modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = {
            if (it.length <= charLimit){
                onValueChange(it)
            }
        },
        label = {
            label?.let { Text(
                text = it,
            ) }
        },
        placeholder = {
            placeholder?.let { Text(
                text = it,
                color = Color.Gray,
            ) }
        },
        singleLine = singleLine,
        leadingIcon = {
            Icon(
                imageVector = iconLeft,
                contentDescription = "Search",
                tint = Color.Gray,
            )
        },
        trailingIcon = {
            if (value.isNotEmpty()) {
                IconButton(
                    onClick = {onValueChange("")},
                    content = {
                        Icon(
                            imageVector = iconRight,
                            contentDescription = "Clear",
                            tint = Color.Gray,
                        )
                    }
                )
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType
        ),
        shape = shape,
        isError = isError,
        textStyle = TextStyle(
            fontSize = 18.sp
        ),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )

}

@Preview(showBackground = true)
@Composable
fun DefaultTextFieldPreview(){
    var textValue by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        DefaultTextField(
            value = textValue,
            onValueChange = { textValue = it },
            label = "Digite seu CEP",
            placeholder = "00000-000",
            singleLine = true,
            charLimit = 8,
            iconLeft = Icons.Default.LocationOn,
            iconRight = Icons.Default.Clear,
            keyboardType = KeyboardType.Number,
            shape = RoundedCornerShape(16.dp),
            isError = false,
        )
    }
}