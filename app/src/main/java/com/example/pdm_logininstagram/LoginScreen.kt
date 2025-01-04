package com.example.pdm_logininstagram

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun LoginScreen()
{
    Box(
        Modifier
            .fillMaxSize()
            .padding(8.dp)
    )
    {
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
        Footer(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun Header(modifier: Modifier) 
{
    val activity = LocalContext.current as? Activity

    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "Cerrar App",
        modifier = modifier.clickable { activity?.finish() }
    )
}

@Composable
fun Body(modifier: Modifier)
{
    var email by rememberSaveable{ mutableStateOf("") }
    var password by rememberSaveable{ mutableStateOf("") }

    Column(
        modifier = modifier
    )
    {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Email(email) { email = it }
        Password(password) { password = it }
        //ForgotPassword()
        //LoginButton()
        //LoginDivisor()
        //LoginSocial()
    }
}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.insta),
        contentDescription = "Logo Instagram",
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(email: String, function: (String) -> Unit)
{
    TextField(
        value = email,
        onValueChange = { function(it) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            focusedTextColor = Color(0xFF020202),
            containerColor = Color(0xFFF0F0F0),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        ),
        placeholder = { Text(text = "Email") }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Password(password: String, function: (String) -> Unit)
{
    var passwordVisibility by rememberSaveable { mutableStateOf(false) }

    TextField(
        value = password,
        onValueChange = { function(it) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            focusedTextColor = Color(0xFF020202),
            containerColor = Color(0xFFF0F0F0),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        placeholder = { Text(text = "Password") },
        trailingIcon = {
            val image =
                if(passwordVisibility)
                    Icons.Filled.VisibilityOff
                else
                    Icons.Filled.Visibility

            IconButton(
                onClick = { passwordVisibility = !passwordVisibility }
            ){
                Icon(
                    imageVector = image,
                    contentDescription = "Show Password"
                )
            }
        },
        visualTransformation =
            if(passwordVisibility)
                VisualTransformation.None
            else
                PasswordVisualTransformation()
    )
}

@Composable
fun Footer(modifier: Modifier)
{

}