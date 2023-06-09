package com.jetpackcompose.suspendfunctions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jetpackcompose.suspendfunctions.screens.LaunchedEffectTestScreen
import com.jetpackcompose.suspendfunctions.screens.LoadingScreen
import com.jetpackcompose.suspendfunctions.ui.theme.JetpackComposeSuspendFunctionsTheme
import com.jetpackcompose.suspendfunctions.viewModels.launched.effect.LaunchedEffectTestViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeSuspendFunctionsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //RememberCoroutineScopeTestScreen()
                    //LaunchedEffectNetworkState(snackbarHostState = SnackbarHostState() , LaunchedEffectNetworkStateViewModel())

                    // Loading Screen Test
                    var showLoading by remember {
                        mutableStateOf(true)
                    }

                    if (showLoading) {
                        LoadingScreen { showLoading = false }
                    } else {
                        val snackbarHostState = SnackbarHostState()
                        LaunchedEffectTestScreen(snackbarHostState, LaunchedEffectTestViewModel())
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeSuspendFunctionsTheme {
        Greeting("Android")
    }
}