package com.example.demoapp.presentation.allTasks

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.demoapp.data.TodoDatabase
import com.example.demoapp.data.entity.Tasks
import com.example.demoapp.domain.DeleteTasksUseCase
import com.example.demoapp.domain.GetAllTasksUseCase

class AllTasksViewModel(
    application: Application
    // private val getAllTasksUseCase: GetAllTasksUseCase,
    // private val deleteTasksUseCase: DeleteTasksUseCase
) : ViewModel() {

    private val tasksDao = TodoDatabase.build(application.applicationContext).tasksDao

    fun getAllTask(): LiveData<List<Tasks>> = tasksDao.getAllTasks()
    //suspend fun getAllTask(): List<Tasks> = getAllTasksUseCase.execute()

    /*class AllTasksViewModelFactory @Inject constructor(
        private val application: Application,
        private val staffGeneratedRFRepo: StaffGeneratedRFRepo,
        private val thirdPartyTransporterRepo: ThirdPartyTransporterRepo,
        private val memberGeneratedRFRepo: MemberGeneratedRFRepo,
        private val trustGroupGeneratedRfRepo: TrustGroupGeneratedRfRepo,
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ViewDailyScheduleViewModel(
                application, staffGeneratedRFRepo,
                thirdPartyTransporterRepo,
                memberGeneratedRFRepo,
                trustGroupGeneratedRfRepo
            ) as T
        }
    }*/

    class AllTasksViewModelFactory(
        private val application: Application
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return AllTasksViewModel(
                application) as T
        }
    }
}