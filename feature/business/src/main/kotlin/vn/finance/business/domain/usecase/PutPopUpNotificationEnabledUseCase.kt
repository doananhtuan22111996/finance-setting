package vn.finance.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import vn.core.domain.ResultModel
import vn.core.usecase.BaseUseCase
import vn.finance.business.domain.repository.PopUpNotificationRepository
import javax.inject.Inject

class PutPopUpNotificationEnabledUseCase @Inject constructor(private val repository: PopUpNotificationRepository) : BaseUseCase<Boolean, ResultModel<Nothing>>() {
    override fun execute(vararg params: Boolean?): Flow<ResultModel<Nothing>> = repository.putPopUpNotificationEnabled(value = params[0] ?: false)
}
