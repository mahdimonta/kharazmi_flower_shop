package com.example.composeapp.authentication

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.R
import com.example.composeapp.mainPage.MainScreen

class SendCode : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

                SentCone()

        }
    }

    @Composable
    fun SentCone() {


        val focusManager = LocalFocusManager.current

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
                                .makeText(this@SendCode, "done", Toast.LENGTH_SHORT)
                                .show()
                        }
                ) {


                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "back",
                        tint = Color.White,
                    )
                    Text(
                        "back",
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
                        text = "verification",
                        style = TextStyle(
                            fontSize = 25.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = "sent code to your number pleas write it in this TextField",
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = Color.Black,
                        )
                    )
                    Spacer(modifier = Modifier.height(80.dp))
                    val code = TextFieldCustom()

                    Button(
                        shape = RoundedCornerShape(0.dp),
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        contentPadding = PaddingValues(0.dp),
                        onClick = {


                        }
                    ) {
                        Text(
                            text = "Resent Code",
                            color = Color(0xFF3F51B5),
                            fontSize = 16.sp
                        )
                    }



                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 100.dp),
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF18AF7C)),
                        onClick = {
                            Toast.makeText(this@SendCode, code.toString(), Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@SendCode, MainScreen::class.java))

                        }
                    ) {
                        Text(
                            "verify",
                            modifier = Modifier
                                .padding(6.dp),
                            fontSize = 20.sp

                        )
                    }
                }
            }


        }


    }

    @SuppressLint("ComposableNaming")
    @Composable
    fun TextFieldCustom(): List<String> {

        var code by remember { mutableStateOf(List(6) { "" }) }

        val focusRequesters = List(6) { FocusRequester() }

        Row(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(),

            horizontalArrangement = Arrangement.Center

                ,
        ) {
            code.forEachIndexed { index, value ->
                OutlinedTextField(
                    value = value,
                    onValueChange = { newValue ->
                        if (newValue.length <= 1) {
                            if (value.isNotEmpty() && newValue.isEmpty() && index > 0) {
                                focusRequesters[index - 1].requestFocus()
                            }
                            code = code.toMutableList().apply { this[index] = newValue }
                            if (newValue.isNotEmpty() && index < code.size - 1) {
                                focusRequesters[index + 1].requestFocus()
                            }
                        }
                    },
                    modifier = Modifier
                        .size(50.dp)
                        .focusRequester(focusRequesters[index]),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                )
            }
        }
        return code
    }


    @Preview(
        showBackground = true,
        showSystemUi = true,
        device = Devices.PIXEL_7
    )
    @Composable
    fun GreetingPreview() {
            SentCone()

    }
}




