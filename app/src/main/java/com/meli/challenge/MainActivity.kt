package com.meli.challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meli.challenge.ui.theme.MeliChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeliChallengeTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        TopBar()
                    },

                    ) {
                    val textSearchState = rememberSaveable { mutableStateOf("") }
                    val isSearching = rememberSaveable { mutableStateOf(false) }

                    Box {
                        Column() {
                            SearchView(state = textSearchState) {
                                isSearching.value = true
                                it.length
                            }
                        }
                        if (isSearching.value) {
                            ProgressView()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(stringResource(id = R.string.title_appbar))
        },
        backgroundColor = MaterialTheme.colors.primary
    )
}

@Composable
fun ProgressView() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .blur(30.dp).background(Color.Red)

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CircularProgressIndicator()
            Text(text = "Buscando")
        }
    }
}

@Composable
fun SearchView(state: MutableState<String>, onClickSearch: ((String) -> Unit)?) {
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = Modifier.fillMaxWidth(),
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp)
            )
        },
        trailingIcon = {
            if (state.value != "") {
                Button(
                    onClick = { onClickSearch?.invoke(state.value) },
                ) {
                    Text("Buscar")
                }
            }
        },
        singleLine = true,
        shape = RectangleShape, // The TextFiled has rounded corners top left and right by default
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            leadingIconColor = Color.White,
            trailingIconColor = Color.White,
            backgroundColor = MaterialTheme.colors.primary,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.White,
            disabledIndicatorColor = Color.White
        )
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MeliChallengeTheme {
        TopBar()
    }
}

@Preview(showBackground = true)
@Composable
fun SearchViewPreview() {
    MeliChallengeTheme {

        val textState = remember { mutableStateOf("Hola") }
        SearchView(textState, null)
    }
}