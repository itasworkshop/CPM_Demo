package models

class TaskModel (
    var name: String, // a name for the task for printing
    var cost: Int, // the actual cost of the task
    vararg dependencies: TaskModel
) {
    // the cost of the task along the critical path
    var criticalCost = 0

    // the earliest start
    var earlyStart = 0

    // the earliest finish
    var earlyFinish = -1

    // the latest start
    var latestStart = 0

    // the latest finish
    var latestFinish = 0

    // the tasks on which this task is dependant
    var dependencies = hashSetOf(*dependencies)

    fun setLatest(maxCost: Int) {
        latestStart = maxCost - criticalCost
        latestFinish = latestStart + cost
    }

    fun setEarlyForDependencies() {
        val completionTime = earlyFinish
        dependencies.forEach {
            if (completionTime >= it.earlyStart) {
                it.earlyStart = completionTime
                it.earlyFinish = completionTime + it.cost
            }
            it.setEarlyForDependencies()
        }
    }

    fun isCritical() = earlyStart == latestStart

    fun isDependent(t: TaskModel): Boolean = dependencies.contains(t) || dependencies.any { it.isDependent(t) }
}