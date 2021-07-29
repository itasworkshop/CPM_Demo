package gui

import entity.Task
import entity.TaskDAO
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.TextField
import javafx.scene.control.cell.PropertyValueFactory
import models.TaskModel

class TaskCPMController() {
    val dao: TaskDAO = TaskDAO()
    @FXML var cpmTable: TableView<Any>? = null
    @FXML var cpmtaskCol: TableColumn<Any, String>? = null
    @FXML var esCol: TableColumn<Any, String>? = null
    @FXML var efCol: TableColumn<Any, String>? = null
    @FXML var lsCol: TableColumn<Any, String>? = null
    @FXML var lfCol: TableColumn<Any, String>? = null
    @FXML var slackCol: TableColumn<Any, String>? = null
    @FXML var criticalCol: TableColumn<Any, String>? = null


    @FXML fun initialize(): Unit {
        println("from task CPM init")

        val Tasks = FXCollections.observableList(dao.findAllTask())

        val end = TaskModel("End", 0)
        val F = TaskModel("F", 2, end)
        val A = TaskModel("A", 3, end)
        val X = TaskModel("X", 4, F, A)
        val Q = TaskModel("Q", 2, A, X)
        val start = TaskModel("Start", 0, Q)

        val allTaskModels1 = hashSetOf(end, F, A, X, Q, start)
        allTaskModels1.forEach { menu -> println(menu?.name) }

        val hashSet = HashSet<TaskModel>()

       /* for (i in Tasks){
            val model:TaskModel()
            hashSet.add(i)
        }
        allTaskModels2.forEach { menu -> println(menu?.name) }
*/

        app.calculateCriticalPath(allTaskModels1)
        app.prettyPrintResult(allTaskModels1)
    }

    fun calculateCriticalPath(TaskModels: Collection<TaskModel>) {
        val completed = hashSetOf<TaskModel>()
        val remaining = TaskModels.toHashSet()

        while (remaining.isNotEmpty()) {
            var progress = false

            val it = remaining.iterator()
            while (it.hasNext()) {
                val TaskModel = it.next()
                if (completed.containsAll(TaskModel.dependencies)) {
                    val critical = TaskModel.dependencies.map { it.criticalCost }.maxOrNull() ?: 0
                    TaskModel.criticalCost = critical + TaskModel.cost
                    completed.add(TaskModel)
                    it.remove()
                    progress = true
                }
            }
            if (!progress) throw RuntimeException("Cyclic dependency, algorithm stopped!")
        }

        val maxCost = TaskModels.map { it.criticalCost }.maxOrNull() ?: -1
        println("Critical path length (cost): $maxCost")

        calculateLatest(TaskModels, maxCost)
        calculateEarly(TaskModels)
    }

    fun calculateLatest(TaskModels: Collection<TaskModel>, maxCost: Int) = TaskModels.forEach { it.setLatest(maxCost) }

    fun calculateEarly(TaskModels: Collection<TaskModel>) = initials(TaskModels).forEach {
        it.earlyStart = 0
        it.earlyFinish = it.cost
        it.setEarlyForDependencies()
    }

    fun initials(TaskModels: Collection<TaskModel>): Collection<TaskModel> {
        val dependencies = TaskModels.flatMap { it.dependencies }.toSet()
        return TaskModels.filter { it !in dependencies }.also {
            println("Initial nodes: ${it.joinToString { node -> node.name }}\n")
        }
    }

    fun prettyPrintResult(TaskModels: Collection<TaskModel>) {
        val format = "%1$-10s %2$-5s %3$-5s %4$-5s %5$-5s %6$-5s %7$-10s\n"
        System.out.format(format, "TaskModel", "ES", "EF", "LS", "LF", "Slack", "Critical?")
        TaskModels.sortedWith { o1, o2 -> o1.name.compareTo(o2.name) }.forEach {
            System.out.format(
                format, it.name, it.earlyStart, it.earlyFinish, it.latestStart, it.latestFinish,
                it.latestStart - it.earlyStart, if (it.isCritical()) "Yes" else "No"
            )
        }
    }

    fun <T, S> TableColumn<S, T>.setProperty(property: String) {
        setCellValueFactory(PropertyValueFactory<S, T>(property))
    }
}


