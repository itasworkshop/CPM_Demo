package entity

import javax.persistence.EntityManager
import javax.persistence.Persistence

class TaskDAO() {
    val em :EntityManager? = Persistence.createEntityManagerFactory("unit1")!!.createEntityManager()

    fun findAllTask(): List<Task> {
        return em?.createNamedQuery("Task.findAll", Task().javaClass)?.getResultList() as List<Task>
    }

    fun create(Task: Task): Unit {
        em?.getTransaction()?.begin()
        em?.persist(Task)
        em?.getTransaction()?.commit()
    }

    fun delete(Task: Task?): Unit {
        em?.getTransaction()?.begin()
        em?.remove(Task)
        em?.getTransaction()?.commit()
    }
}