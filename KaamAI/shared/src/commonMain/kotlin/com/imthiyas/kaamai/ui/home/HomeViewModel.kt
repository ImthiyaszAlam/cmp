package com.imthiyas.kaamai.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.imthiyas.kaamai.domain.model.Task

class HomeViewModel {
    var tasks by mutableStateOf(
        listOf(
            Task("1", "Morning Standup", "Review daily goals with team", true, "Meeting"),
            Task("2", "Develop CMP Feature", "Implement bottom navigation and separation of concerns", false, "Development"),
            Task("3", "Code Review", "Review pull requests for KaamAI", false, "Review")
        )
    )
        private set

    fun toggleTask(taskId: String) {
        tasks = tasks.map { task ->
            if (task.id == taskId) task.copy(isCompleted = !task.isCompleted) else task
        }
    }

    fun addTask(title: String, description: String, category: String) {
        val newTask = Task(
            id = (tasks.size + 1).toString(),
            title = title,
            description = description,
            isCompleted = false,
            category = category
        )
        tasks = tasks + newTask
    }
}
