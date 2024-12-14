package com.feature.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import vn.finance.api.SettingApi
import vn.finance.theme.AppTheme
import javax.inject.Inject

@AndroidEntryPoint
class DemoActivity : ComponentActivity() {

    @Inject
    lateinit var settingApi: SettingApi

    private val viewModel: DemoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            val isDarkModel by viewModel.isDarkMode.collectAsStateWithLifecycle()
            AppTheme(darkTheme = isDarkModel) {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = settingApi.path) {
                    composable(settingApi.path) {
                        settingApi.SettingPage(goBack = {
                            navController.navigateUp()
                        }, onDarkModeChanged = { isDarkModel ->
                            viewModel.onDarkModeChanged(isDarkModel)
                        })
                    }
                }
            }
        }
    }
}