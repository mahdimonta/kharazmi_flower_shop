package com.example.composeapp.authentication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.R

class SingUp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            SignUpCode()


        }
    }

    private val userName = mutableStateOf(TextFieldValue())
    private val phoneOrEmail = mutableStateOf(TextFieldValue())
    private val password = mutableStateOf(TextFieldValue())

    @Composable
    fun SignUpCode() {
        val focusManager = LocalFocusManager.current

        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) { // تشخیص کلیک خارج از TextField
                    detectTapGestures(onTap = {
                        focusManager.clearFocus() // برداشتن فوکوس
                    })
                },
            contentAlignment = Alignment.BottomCenter
        )
        {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
            ) {


                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(R.drawable.gradient),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null
                )

                Row(
                    modifier = Modifier
                        .padding(top = 100.dp, start = 25.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) {
                            Toast
                                .makeText(this@SingUp, "done", Toast.LENGTH_SHORT)
                                .show()
                        }
                ) {


                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "back",
                        tint = Color.White,
                    )
                    Text(
                        text = stringResource(id = R.string.back),
                        color = Color.White,
                        fontSize = 20.sp
                    )


                }

            }

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f),
                shape = RoundedCornerShape(topEnd = 45.dp, topStart = 45.dp),
                shadowElevation = 20.dp,
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(40.dp)
                ) {

                    Text(
                        modifier = Modifier.padding(top = 10.dp),
                        text = stringResource(id = R.string.sign_up),
                        style = TextStyle(
                            fontSize = 25.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = stringResource(id = R.string.sign_up_explain),
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = Color.Black,
                        )
                    )
                    var isPasswordVisible by remember { mutableStateOf(false) }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 30.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        CustomTextField(
                            32,
                            label = stringResource(id = R.string.user_name),
                            userName,
                            KeyboardOptions(keyboardType = KeyboardType.Text)
                        )
                        CustomTextField(
                            11,
                            label = stringResource(id = R.string.phone_num),
                            phoneOrEmail,
                            KeyboardOptions(keyboardType = KeyboardType.Number)
                        )
                        CustomTextField(
                            28,
                            label = stringResource(id = R.string.Password),
                            password,
                            KeyboardOptions(keyboardType = KeyboardType.Password),
                            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            trailingIcon = {
                                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                                    Icon(
                                        imageVector = if (isPasswordVisible) Icons.Default.Check else Icons.Default.CheckCircle,
                                        contentDescription = null
                                    )
                                }
                            })


                        Button(

                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 40.dp),
                            shape = RoundedCornerShape(5.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF18AF7C)),
                            onClick = {
                                startActivity(Intent(this@SingUp, SendCode::class.java))

                            }
                        ) {
                            Text(
                                text = stringResource(id= R.string.sign_up),
                                modifier = Modifier
                                    .padding(6.dp),
                                fontSize = 20.sp

                            )
                        }


                    }


                }
            }


        }
    }

    @Composable
    fun CustomTextField(
        length: Int,
        label: String,
        value: MutableState<TextFieldValue>,
        type: KeyboardOptions,
        trailingIcon: @Composable (() -> Unit)? = null,
        visualTransformation: VisualTransformation = VisualTransformation.None
    ) {
        var text by remember { value }
        OutlinedTextField(
            value = text,
            onValueChange = {
                if (it.text.length <= length)
                    text = it
            },
            keyboardOptions = type,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .clip(RoundedCornerShape(5.dp)),
            label = {
                Text(
                    text = label,
                    fontSize = 13.sp
                )
            },
            trailingIcon = trailingIcon,
            visualTransformation = visualTransformation,
            singleLine = true

        )
    }

    @Preview(
        showBackground = true,
        showSystemUi = true,
        device = Devices.PIXEL_7
    )
    @Composable
    fun GreetingPreview() {
        SignUpCode()

    }
}
