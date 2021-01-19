package com.smems.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

interface ICoroutines {

    val jobs: MutableSet<Job>

    fun execute(block: suspend CoroutineScope.() -> Unit) {
        jobs += GlobalScope.launch(block = block)
    }

    fun cancelJobs() {
        jobs.filter { !it.isCompleted }.forEach { it.cancel() }
    }
}