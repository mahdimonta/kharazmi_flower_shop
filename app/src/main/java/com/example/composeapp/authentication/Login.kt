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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.composeapp.R

class Login : ComponentActivity() {

    private val phoneOrEmail = mutableStateOf(TextFieldValue())
    private val password = mutableStateOf(TextFieldValue())
    private val code = mutableStateOf(TextFieldValue())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            LoginCode()

        }
    }


    @Composable
    fun LoginCode() {
        val focusManager = LocalFocusManager.current
        var showDialog by remember { mutableStateOf(false) }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        focusManager.clearFocus()
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
                                .makeText(this@Login, "done", Toast.LENGTH_SHORT)
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
                CustomDialog(
                    showDialog = showDialog,
                    onDismiss = { showDialog = false }
                )

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
                        text = stringResource(id = R.string.sign_in),
                        style = TextStyle(
                            fontSize = 25.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = stringResource(id = R.string.sign_in_explain),
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = Color.Black,
                        )
                    )
                    var isPasswordVisible by remember { mutableStateOf(false) }

                    Spacer(modifier = Modifier.height(50.dp))

                    CustomTextField(
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                            .clip(RoundedCornerShape(5.dp)),
                        32,
                        label = stringResource(id = R.string.phone_num),
                        phoneOrEmail,
                        KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                    CustomTextField(
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                            .clip(RoundedCornerShape(5.dp)),
                        28,
                        label = stringResource(id = R.string.Password),
                        password,
                        KeyboardOptions(keyboardType = KeyboardType.Password),
                        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                                Icon(
                                    imageVector = if (isPasswordVisible) Icons.Default.Check else Icons.Default.CheckCircle,
                                    contentDescription = if (isPasswordVisible) "مخفی کردن رمز" else "نمایش رمز"
                                )
                            }
                        })

                    Button(
                        {
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        shape = RoundedCornerShape(0.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {

                        Text(
                            text = stringResource(id = R.string.forget),
                            fontSize = 14.sp,
                            color = Color(0xFF273893),
                            modifier = Modifier.padding(top = 10.dp)
                        )
                    }
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 40.dp),
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF18AF7C)),
                        onClick = {
                            showDialog = true
                        }
                    ) {
                        Text(
                            text = stringResource(id = R.string.sign_in),
                            modifier = Modifier
                                .padding(6.dp),
                            fontSize = 20.sp

                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp, bottom = 20.dp, top = 15.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(id = R.string.have_not_account),
                            fontSize = 12.sp
                        )
                        ClickableText(
                            AnnotatedString(stringResource(id = R.string.sign_up)),
                            modifier = Modifier.padding(top = 3.dp, start = 3.dp),
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF3F51B5),
                                fontSize = 12.sp
                            )
                        ) { }
                    }


                }


            }


        }

    }

    @Composable
    private fun CustomDialog(
        showDialog: Boolean,
        onDismiss: () -> Unit
    ) {
        if (showDialog) {
            Dialog(onDismissRequest = { onDismiss() }) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .padding(10.dp),
                    shape = RoundedCornerShape(10.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "verify code",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "sent code to your number pleas write it in this TextField",
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(5.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Absolute.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Button(
                                modifier = Modifier.padding(end = 8.dp, top = 23.dp),
                                shape = RoundedCornerShape(0.dp),
                                colors = ButtonDefaults.buttonColors(Color.Transparent),
                                contentPadding = PaddingValues(0.dp),
                                onClick = {


                                }
                            ) {
                                Text(
                                    text = "Resent Code",
                                    color = Color(0xFF3F51B5),
                                    fontSize = 13.sp
                                )
                            }
                            CustomTextField(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(top = 20.dp)
                                    .clip(RoundedCornerShape(5.dp)),
                                6,
                                "code",
                                code,
                                KeyboardOptions(keyboardType = KeyboardType.Number)
                            )

                        }
                        Spacer(modifier = Modifier.height(30.dp))

                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(5.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFF18AF7C)),
                            contentPadding = PaddingValues(0.dp),
                            onClick = {
                                startActivity(Intent(this@Login, SingUp::class.java))
                            }
                        ) {
                            Text(
                                text = "verify",
                                fontSize = 15.sp
                            )
                        }
                    }
                }
            }
        }
    }


    @Composable
    fun CustomTextField(
        modifier: Modifier,
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
            modifier = modifier,
            label = {
                Text(
                    text = label,
                    fontSize = 17.sp
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
        LoginCode()


    }

}

