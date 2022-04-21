package com.meli.challenge.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meli.challenge.R
import com.meli.challenge.data.models.ResponseSearchModel
import com.meli.challenge.data.models.Result
import com.meli.challenge.ui.theme.MeliChallengeTheme
import com.meli.challenge.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()

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

                    Box {
                        Column() {
                            SearchView(state = textSearchState) {
                                viewModel.search(it)
                            }
                            ListItems(viewModel.searchResponse)
                        }
                        if (viewModel.isLoading.value) {
                            ProgressView()
                        }
                    }
                }
            }
        }
    }


}
@Composable
private fun ListItems(searchResponse: State<ResponseSearchModel?>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        items(searchResponse.value!!.results){ model->
            ItemView(model)
        }
    }
}

@Composable
private fun ItemView(model: Result){

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
            .background(colorResource(id = R.color.background_alpha))

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