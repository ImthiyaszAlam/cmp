package com.imthiyas.kaamai.ui.report

import com.imthiyas.kaamai.ui.home.HomeViewModel

class ReportViewModel(private val homeViewModel: HomeViewModel) {
    val totalTasks: Int
        get() = homeViewModel.tasks.size

    val completedTasks: Int
        get() = homeViewModel.tasks.count { it.isCompleted }

    val pendingTasks: Int
        get() = totalTasks - completedTasks

    val completionRate: Float
        get() = if (totalTasks == 0) 0f else completedTasks.toFloat() / totalTasks.toFloat()
}
