package com.example.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.R
import com.example.ui.screens.AboutScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.LibraryScreen
import com.example.ui.screens.MaterialDetailScreen
import com.example.ui.screens.QuizScreen
import com.example.ui.screens.TimetableScreen
import com.example.ui.theme.SytbayGold
import com.example.ui.theme.SytbayGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SytbayApp(
    viewModel: SytbayViewModel = viewModel()
) {
    val currentTab by viewModel.currentTab.collectAsState()
    val selectedMaterial by viewModel.selectedMaterial.collectAsState()
    val quizState by viewModel.quizState.collectAsState()

    // Handle system back navigation
    BackHandler(enabled = selectedMaterial != null || quizState.isActive || currentTab != ScreenTab.HOME) {
        when {
            selectedMaterial != null -> viewModel.closeMaterial()
            quizState.isActive -> viewModel.exitQuiz()
            currentTab != ScreenTab.HOME -> viewModel.selectTab(ScreenTab.HOME)
        }
    }

    if (selectedMaterial != null) {
        MaterialDetailScreen(
            material = selectedMaterial!!,
            viewModel = viewModel,
            onBack = { viewModel.closeMaterial() },
            onNavigateToQuiz = {
                viewModel.closeMaterial()
                viewModel.selectTab(ScreenTab.QUIZ)
            }
        )
    } else {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(CircleShape)
                                    .background(SytbayGreen),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_sytbay_logo_1790244415271),
                                    contentDescription = "Sytbay Logo",
                                    modifier = Modifier.size(28.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                Text(
                                    text = "Sytbay Academy",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "sytbay.co.zw • Exam Prep",
                                    fontSize = 11.sp,
                                    color = SytbayGreen,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }
                    },
                    actions = {
                        Surface(
                            color = SytbayGreen.copy(alpha = 0.12f),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.padding(end = 12.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(7.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFF16A34A))
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(
                                    text = "Offline Ready",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = SytbayGreen
                                )
                            }
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                )
            },
            bottomBar = {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = SytbayGreen
                ) {
                    NavigationBarItem(
                        selected = currentTab == ScreenTab.HOME,
                        onClick = { viewModel.selectTab(ScreenTab.HOME) },
                        icon = {
                            Icon(
                                imageVector = if (currentTab == ScreenTab.HOME) Icons.Filled.Home else Icons.Outlined.Home,
                                contentDescription = "Home"
                            )
                        },
                        label = { Text("Home", fontSize = 11.sp) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = SytbayGreen,
                            selectedTextColor = SytbayGreen,
                            indicatorColor = SytbayGreen.copy(alpha = 0.15f)
                        ),
                        modifier = Modifier.testTag("home_tab")
                    )

                    NavigationBarItem(
                        selected = currentTab == ScreenTab.LIBRARY,
                        onClick = { viewModel.selectTab(ScreenTab.LIBRARY) },
                        icon = {
                            Icon(
                                imageVector = if (currentTab == ScreenTab.LIBRARY) Icons.Filled.MenuBook else Icons.Outlined.MenuBook,
                                contentDescription = "Library"
                            )
                        },
                        label = { Text("Library", fontSize = 11.sp) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = SytbayGreen,
                            selectedTextColor = SytbayGreen,
                            indicatorColor = SytbayGreen.copy(alpha = 0.15f)
                        ),
                        modifier = Modifier.testTag("library_tab")
                    )

                    NavigationBarItem(
                        selected = currentTab == ScreenTab.QUIZ,
                        onClick = { viewModel.selectTab(ScreenTab.QUIZ) },
                        icon = {
                            Icon(
                                imageVector = if (currentTab == ScreenTab.QUIZ) Icons.Filled.Quiz else Icons.Outlined.Quiz,
                                contentDescription = "Quiz"
                            )
                        },
                        label = { Text("Quiz", fontSize = 11.sp) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = SytbayGreen,
                            selectedTextColor = SytbayGreen,
                            indicatorColor = SytbayGreen.copy(alpha = 0.15f)
                        ),
                        modifier = Modifier.testTag("quiz_tab")
                    )

                    NavigationBarItem(
                        selected = currentTab == ScreenTab.TIMETABLE,
                        onClick = { viewModel.selectTab(ScreenTab.TIMETABLE) },
                        icon = {
                            Icon(
                                imageVector = if (currentTab == ScreenTab.TIMETABLE) Icons.Filled.CalendarMonth else Icons.Outlined.CalendarMonth,
                                contentDescription = "Timetable"
                            )
                        },
                        label = { Text("Timetable", fontSize = 11.sp) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = SytbayGreen,
                            selectedTextColor = SytbayGreen,
                            indicatorColor = SytbayGreen.copy(alpha = 0.15f)
                        ),
                        modifier = Modifier.testTag("timetable_tab")
                    )

                    NavigationBarItem(
                        selected = currentTab == ScreenTab.ABOUT,
                        onClick = { viewModel.selectTab(ScreenTab.ABOUT) },
                        icon = {
                            Icon(
                                imageVector = if (currentTab == ScreenTab.ABOUT) Icons.Filled.Info else Icons.Outlined.Info,
                                contentDescription = "About"
                            )
                        },
                        label = { Text("About", fontSize = 11.sp) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = SytbayGreen,
                            selectedTextColor = SytbayGreen,
                            indicatorColor = SytbayGreen.copy(alpha = 0.15f)
                        ),
                        modifier = Modifier.testTag("about_tab")
                    )
                }
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                when (currentTab) {
                    ScreenTab.HOME -> HomeScreen(
                        viewModel = viewModel,
                        onNavigateTab = { viewModel.selectTab(it) },
                        onOpenMaterial = { viewModel.openMaterial(it) }
                    )
                    ScreenTab.LIBRARY -> LibraryScreen(
                        viewModel = viewModel,
                        onOpenMaterial = { viewModel.openMaterial(it) }
                    )
                    ScreenTab.QUIZ -> QuizScreen(
                        viewModel = viewModel
                    )
                    ScreenTab.TIMETABLE -> TimetableScreen(
                        viewModel = viewModel
                    )
                    ScreenTab.ABOUT -> AboutScreen()
                }
            }
        }
    }
}
