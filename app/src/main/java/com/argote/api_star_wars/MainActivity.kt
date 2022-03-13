package com.argote.api_star_wars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.argote.api_star_wars.navigation.AppNavigation
import com.argote.api_star_wars.ui.screens.people.PeopleScreen
import com.argote.api_star_wars.ui.theme.ApistarwarsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApistarwarsTheme {
                BackdropScaffold(
                    appBar = {
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = getString(R.string.app_name),
                                style = MaterialTheme.typography.h1,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(start = 10.dp)
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_close_24),
                                contentDescription = null,
                                modifier = Modifier.padding(end = 10.dp).clickable {
                                    finish()
                                }
                            )
                        }
                    },
                    backLayerContent = {},
                    frontLayerContent = {
                        AppNavigation()
                    },
                    peekHeight = 40.dp,
                    headerHeight = 60.dp,
                    gesturesEnabled = false
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ApistarwarsTheme {}
}