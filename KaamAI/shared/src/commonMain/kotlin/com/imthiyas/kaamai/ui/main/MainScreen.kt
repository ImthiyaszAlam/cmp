package com.imthiyas.kaamai.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
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

@Composable
fun MainScreen() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }
    val homeViewModel = remember { HomeViewModel() }

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Text(
                    text = "KaamAI",
                    modifier = Modifier.padding(16.dp),
                    fontWeight = FontWeight.Bold,

                    )

                HorizontalDivider()

                NavigationDrawerItem(
                    label = { Text("Home") },
                    selected = true,
                    onClick = { },
                    icon = { Icon(Icons.Default.Home, contentDescription = null) }
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
                        icon = { Text("🏠", style = MaterialTheme.typography.titleLarge) },
                        label = { Text("Home") }
                    )
                    NavigationBarItem(
                        selected = currentScreen is Screen.Report,
                        onClick = { currentScreen = Screen.Report },
                        icon = { Text("📊", style = MaterialTheme.typography.titleLarge) },
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
