@file:OptIn(ExperimentalResourceApi::class)

package kmp.project.demo

import androidx.compose.runtime.Composable
import coil3.ImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.request.crossfade
import coil3.svg.SvgDecoder
import coil3.util.DebugLogger
import kmp.project.ui_kit.design.NNTheme
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext


@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {

    setSingletonImageLoaderFactory {
        ImageLoader.Builder(it).crossfade(true).logger(DebugLogger()).components {
            add(SvgDecoder.Factory())
        }.build()
    }


    KoinContext {
//        val appDatabase = koinInject<AppDatabase>()
//        val carDao = appDatabase.getDao()
//        LaunchedEffect(true) {
//            carDao.insert(Car(name = "大众", number = "鄂ADD1587"))
//            carDao.insert(Car(name = "几何", number = "鄂ADD7879"))
//        }
        val appState = rememberAppState()
        NNTheme {
            NNApp(appState)
        }

//            val cars by carDao.getAllAsFlow().collectAsStateWithLifecycle(initialValue = emptyList())
//            val scope = rememberCoroutineScope()
//            var showContent by remember { mutableStateOf(false) }
//            var bodyText by remember { mutableStateOf("Loading") }
//            val scrollState = rememberScrollState()
//
//            Column(
//                Modifier.fillMaxWidth().verticalScroll(scrollState),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                cars.forEach {
//                    Text(text = "${it.name}${it.number}", modifier = Modifier.clickable {
//                        scope.launch {
//                            carDao.delete(it)
//                        }
//                    })
//                }

//                LaunchedEffect(true) {
//                    scope.launch {
//                        bodyText = Greeting().ktorDoc()
//                    }
//                }
//                Text(text = bodyText)
//                Button(onClick = { showContent = !showContent }) {
//                    Text("Click me!")
//                }
//                AnimatedVisibility(showContent) {
//                    val greeting = remember { Greeting().greet() }
//                    val uuid = remember { Greeting().uuid() }
//                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                        AsyncImage(
//                            model = Res.getUri("drawable/adventure.svg"),
//                            contentDescription = null
//                        )
//                        Image(painter = painterResource(Res.drawable.compose_logo), null)
//                        AsyncImage(
//                            model = "https://lh6.googleusercontent.com/proxy/FwQO2GGVBmWEUuUZc3LfXT9n5xV9dboHNqxEDM5d3erCMRUD-M0BHxsmFRlP3VcF0Jgum3r2dDhEHYoqzAhhEEsJh7LlCCN-t41rT-ZIWAVMVoE3diE5xaxrJeIxVHvaJg",
//                            null
//                        )
//                        Text("Compose: $greeting")
//                        Text("UUID:$uuid")
//                    }
//                }

//            }


    }
}