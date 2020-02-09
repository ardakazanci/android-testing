package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TasksViewModelTest{

    fun addNewTask_setsNewTaskEvent(){

        // Given a fresh TasksViewModel - Giriş - FAB a tıklandı
        val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())

        // When adding a new task - Gelişme - Tıklandıktan sonra işlenecek mantık eklendi - işlendi.
        tasksViewModel.addNewTask()

        // Then the new task event is triggered - Sonuç - Screen değişimi sağlandı

    }


}