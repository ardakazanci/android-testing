package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.core.Is.`is`
import org.junit.Assert.*
import org.junit.Test

/**
 * Örnek test senaryosu
 *
 * Aktif bir görev ve tamamlanmış bir görev yoksa
 * Aktif görevlerin yüzdesinin %100 olduğu
 * Tamamlanan görevlerin yüzdesi% 0'dır.
 */

class StatisticsUtilsTest {
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {

        // Create an active task
        val tasks = listOf<Task>(
                // Örnek bir Task nesnesi eklendi. Tamamlanma durumu False
                Task(
                        title = "Title",
                        description = "Desc",
                        isCompleted = false

                )
        )

        // Call your function
        // Test etmek istediğimiz metodu çağırıyoruz (Internal)
        val result = getActiveAndCompletedStats(tasks)
        // Check the result
        // Sonuçların eşitliğinin aşağıda ki gibi olmasını bekliyoruz. Çünkü statusResult döndürüyor.
        /**
         * Testleriniz kodunuzun ne yaptığına dair belge görevi gördüğünden,
         * insanlar tarafından okunabilir olduğunda hoş olur.
         * `is` eklendi. -> '-dır,-dir'
         */

        // assertEquals(result.completedTasksPercent, `is`(0F))
        // assertEquals(result.activeTasksPercent, 100F)

        assertThat(result.activeTasksPercent, `is`(100F))
        assertThat(result.completedTasksPercent, `is`(0F))


    }

    /**
     * Aktif görev yoksa Completed durumu 100f active durumu 0 olmalı.
     */
    @Test
    fun getActiveAndCompletedStats_noActive_returnsZeroHundred() {
        val tasks = listOf(
                Task("title", "desc", isCompleted = true)
        )
        // When the list of tasks is computed with a completed task
        val result = getActiveAndCompletedStats(tasks)

        // Then the percentages are 0 and 100
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(100f))
    }

    /**
     * 3 tamamlanmış 2 active görev varsa sonuç active : 40f completed : 60f olmalı
     */
    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {
        // Given 3 completed tasks and 2 active tasks
        val tasks = listOf(
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false)
        )
        // When the list of tasks is computed
        val result = getActiveAndCompletedStats(tasks)

        // Then the result is 40-60
        assertThat(result.activeTasksPercent, `is`(40f))
        assertThat(result.completedTasksPercent, `is`(60f))
    }

    /**
     * List olarak null gelirse active ve completed 0f olmalı
     */
    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {
        // When there's an error loading stats
        val result = getActiveAndCompletedStats(null)

        // Both active and completed tasks are 0
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    /**
     * List boş gelirse iki durumda 0f olmalı
     */
    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros() {
        // When there are no tasks
        val result = getActiveAndCompletedStats(emptyList())

        // Both active and completed tasks are 0
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    // Test durumlarının hatalı bir şekilde görünmesi ileride yaşanacak problemleri proaktif bir şekilde sezzecektir.

}