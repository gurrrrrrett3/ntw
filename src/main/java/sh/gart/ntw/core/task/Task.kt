package sh.gart.ntw.core.task

open class Task(name: String) {

    fun execute() {
        throw Error("Task not implemented.")
    }
}
