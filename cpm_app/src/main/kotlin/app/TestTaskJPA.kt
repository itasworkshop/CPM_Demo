package app

import entity.TaskDAO

fun main(args:Array<String>) {
    TaskDAO().findAllTask().forEach {
            task -> println("${task.name} ---\\${task.cost}---\\${task.dependencies}")
    }
}