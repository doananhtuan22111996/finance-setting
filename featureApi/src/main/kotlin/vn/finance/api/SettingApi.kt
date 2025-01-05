package vn.finance.api

import androidx.compose.runtime.Composable

interface SettingApi {
    val path: String

    @Composable
    fun SettingPage(goBack: () -> Unit, onDarkModeChanged: (Boolean) -> Unit)
}
