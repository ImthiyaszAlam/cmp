package com.imthiyas.kaamai.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Report
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.imthiyas.kaamai.ui.home.HomeScreen
import com.imthiyas.kaamai.ui.home.HomeViewModel
import com.imthiyas.kaamai.ui.navigation.Screen
import com.imthiyas.kaamai.ui.report.ReportScreen
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }

    val homeViewModel = remember { HomeViewModel() }

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(300.dp)
            ) {

                Column {
                    Text(
                        text = "KaamAI",
                        modifier = Modifier.padding(16.dp),
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "Your personal AI Assistant",
                        modifier = Modifier.padding(11.dp)
                    )
                }



                HorizontalDivider()

                Spacer(modifier = Modifier.height(16.dp))

                NavigationDrawerItem(
                    label = { Text("Home") },
                    selected = currentScreen == Screen.Home,
                    onClick = {
                        currentScreen = Screen.Home
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    icon = { Icon(Icons.Default.Home, contentDescription = null) }
                )

                NavigationDrawerItem(
                    label = { Text("Report") },
                    selected = currentScreen == Screen.Report,
                    onClick = {
                        currentScreen = Screen.Report
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    icon = { Icon(Icons.Default.Report, contentDescription = null) }
                )

            }
        }
    ) {

        Scaffold(


            topBar = {
                TopAppBar(
                    title = {
                        Text("KaamAI")
                    },

                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Open drawer",
                                tint = Color.White
                            )
                        }
                    },


                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Blue,
                        titleContentColor = Color.White
                    )
                )
            },
            modifier = Modifier.fillMaxSize(),

            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        selected = currentScreen is Screen.Home,
                        onClick = { currentScreen = Screen.Home },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = null
                            )
                        },
                        label = { Text("Home") }
                    )
                    NavigationBarItem(
                        selected = currentScreen is Screen.Report,
                        onClick = { currentScreen = Screen.Report },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Report,
                                contentDescription = null
                            )
                        },
                        label = { Text("Report") }
                    )
                }
            }
        )

        { innerPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                color = MaterialTheme.colorScheme.background
            ) {
                when (currentScreen) {
                    is Screen.Home -> HomeScreen(viewModel = homeViewModel)
                    is Screen.Report -> ReportScreen(homeViewModel = homeViewModel)
                }
            }
        }

    }
}
