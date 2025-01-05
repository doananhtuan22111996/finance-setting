package vn.finance.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import vn.core.domain.ResultModel
import vn.core.usecase.BaseUseCase
import vn.finance.business.domain.repository.PopUpNotificationRepository
import javax.inject.Inject

class GetPopUpNotificationEnabledUseCase @Inject constructor(private val repository: PopUpNotificationRepository) : BaseUseCase<Unit, ResultModel<Boolean>>() {
    override fun execute(vararg params: Unit?): Flow<ResultModel<Boolean>> = repository.getPopUpNotificationEnabled()
}
