package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.getOrAwaitValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TasksViewModelTest{

    // Subject under test
    private lateinit var tasksViewModel: TasksViewModel

    @Before
    fun setupViewModel() {
        tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())
    }



    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()




    @Test
    fun addNewTask_setsNewTaskEvent(){

        // Given a fresh TasksViewModel - Giriş - FAB a tıklandı
        // val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())

        // When adding a new task - Gelişme - Tıklandıktan sonra işlenecek mantık eklendi - işlendi.
        tasksViewModel.addNewTask()

        // Then the new task event is triggered - Sonuç - Screen değişimi sağlandı
        val value = tasksViewModel.newTaskEvent.getOrAwaitValue()

        assertThat(value.getContentIfNotHandled(), not(nullValue()))

    }



    @Test
    fun setFilterAllTasks_tasksAddViewVisible() {

        // Given a fresh ViewModel

        // Filtre Modu ALL_TASKS olduğunda
        tasksViewModel.setFiltering(TasksFilterType.ALL_TASKS)
        // tasksAddViewVisible liveData değerinin true olması gerekmektedir.
        assertThat(tasksViewModel.tasksAddViewVisible.getOrAwaitValue(), `is`(true))
    }


}