package vn.finance.presentation.api

import androidx.compose.runtime.Composable
import vn.finance.api.SettingApi
import vn.finance.presentation.PATH
import javax.inject.Inject
import vn.finance.presentation.ui.SettingPage as Page

class SettingApiImpl @Inject constructor() : SettingApi {
    override val path: String
        get() = PATH

    @Composable
    override fun SettingPage(goBack: () -> Unit, onDarkModeChanged: (Boolean) -> Unit) {
        Page(goBack, onDarkModeChanged)
    }
}