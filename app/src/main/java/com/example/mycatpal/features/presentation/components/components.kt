package com.example.mycatpal.features.presentation.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun CatTextField(
    modifier: Modifier = Modifier,
    text:String,
    onTextChange: (String) -> Unit,
    enabled: Boolean = true,
    maxLines: Int = 2,
    label: String,
    imeAction: () -> Unit = {},
    color: Color,
    textColor: Color,
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        modifier = modifier,
        value = text,
        onValueChange = onTextChange,
        enabled = enabled,
        maxLines = maxLines,
        label = {
            Text(text = label,
                style = MaterialTheme.typography.bodyLarge
            )
        },

        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done),

        keyboardActions = KeyboardActions(onDone={
            imeAction()
            keyboardController?.hide()
        }
        ),

        colors = TextFieldDefaults.colors(
            focusedContainerColor = color,
            unfocusedContainerColor = color,
            disabledContainerColor = color,
            errorContainerColor = color,
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            disabledTextColor = textColor,
            errorTextColor = Color.Red
        ),
    )
}

@Composable
fun CatButton(
    modifier: Modifier = Modifier,
    text: String,
    onButClick: () -> Unit,
    enabled: Boolean = true,
    color: Color,
    textColor: Color,
){
    Button(onClick = onButClick,
        modifier=modifier,
        enabled=enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        )) {
        Text(text = text,
            color = textColor,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun CatPasswordTextField(
    modifier: Modifier = Modifier,
    text:String,
    onTextChange: (String) -> Unit,
    enabled: Boolean = true,
    maxLines: Int = 2,
    label: String,
    imeAction: () -> Unit = {},
    color: Color,
    textColor: Color,
    visualState: Boolean,
    icon: @Composable () -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        modifier = modifier,
        value = text,
        onValueChange = onTextChange,
        enabled = enabled,
        maxLines = maxLines,
        label = {
            Text(text = label,
                style = MaterialTheme.typography.bodyLarge
            )
        },

        visualTransformation = if(visualState) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done),

        keyboardActions = KeyboardActions(onDone={
            imeAction()
            keyboardController?.hide()
        }
        ),

        colors = TextFieldDefaults.colors(
            focusedContainerColor = color,
            unfocusedContainerColor = color,
            disabledContainerColor = color,
            errorContainerColor = color,
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            disabledTextColor = textColor,
            errorTextColor = Color.Red
        ),

        trailingIcon = {
            icon()
        }
    )
}