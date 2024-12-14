package vn.finance.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import vn.core.composex.uikit.Container
import vn.core.composex.uikit.alert.AlertExceptionDialogComponent
import vn.core.composex.uikit.button.IconBackButton
import vn.core.composex.uikit.loading.FullScreenLoadingDialogComponent
import vn.finance.presentation.EMPTY_STRING
import vn.finance.presentation.components.SettingComponent
import vn.finance.setting.presentation.R

@Composable
fun SettingPage(goBack: () -> Unit, onDarkModeChanged: (Boolean) -> Unit) {
    val viewModel: SettingViewModel = hiltViewModel()
    val isLocked by viewModel.isLocked.collectAsStateWithLifecycle()
    val isDeactivated by viewModel.isDeactivated.collectAsStateWithLifecycle()
    val isNotifications by viewModel.isNotifications.collectAsStateWithLifecycle()
    val isDarkMode by viewModel.isDarkMode.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val appException by viewModel.appException.collectAsStateWithLifecycle()

    LaunchedEffect(isDarkMode) {
        onDarkModeChanged.invoke(isDarkMode)
    }

    Container(appBarTitle = stringResource(R.string.setting), navigationIcon = {
        IconBackButton(onClick = goBack)
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                stringResource(R.string.card_settings),
                style = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.onSurface
                )
            )
            Box(modifier = Modifier.height(16.dp))
            SettingComponent(icon = Icons.Filled.Lock,
                label = stringResource(R.string.lock_card),
                isChecked = isLocked,
                onSwitchAction = { value ->
                    viewModel.onLockChanged(value)
                })
            Box(modifier = Modifier.padding(vertical = 16.dp)) {
                SettingComponent(icon = Icons.Filled.CreditCard,
                    label = stringResource(R.string.deactivate_card),
                    isChecked = isDeactivated,
                    onSwitchAction = { value ->
                        viewModel.onDeactivateChanged(value)
                    })
            }
            Box(modifier = Modifier.height(16.dp))
            Text(
                stringResource(R.string.notification),
                style = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.onSurface
                )
            )
            Box(modifier = Modifier.padding(vertical = 16.dp)) {
                SettingComponent(icon = Icons.Filled.Notifications,
                    label = stringResource(R.string.pop_up_notifications),
                    isChecked = isNotifications,
                    onSwitchAction = { value ->
                        viewModel.onNotificationsChanged(value)
                    })
            }
            Box(modifier = Modifier.height(16.dp))
            Text(
                stringResource(R.string.theme), style = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.onSurface
                )
            )
            Box(modifier = Modifier.padding(vertical = 16.dp)) {
                SettingComponent(icon = Icons.Filled.DarkMode,
                    label = stringResource(R.string.dark_mode),
                    isChecked = isDarkMode,
                    onSwitchAction = { value ->
                        viewModel.onDarkModeChanged(value)
                    })
            }
        }

        if (isLoading) {
            FullScreenLoadingDialogComponent()
        }

        if (appException != null) {
            AlertExceptionDialogComponent(
                message = appException?.message ?: EMPTY_STRING,
                onDismissRequest = {
                    viewModel.onDismissAppException()
                })
        }
    }
}