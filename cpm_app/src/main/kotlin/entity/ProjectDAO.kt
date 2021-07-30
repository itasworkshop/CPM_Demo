package entity

import javax.persistence.EntityManager
import javax.persistence.Persistence

class ProjectDAO() {
    val em :EntityManager? = Persistence.createEntityManagerFactory("unit2")!!.createEntityManager()

    fun findAllProject(): List<Project> {
        return em?.createNamedQuery("Project.findAll", Project().javaClass)?.getResultList() as List<Project>
    }

    fun create(Project: Project): Unit {
        em?.getTransaction()?.begin()
        em?.persist(Project)
        em?.getTransaction()?.commit()
    }

    fun delete(Project: Project?): Unit {
        em?.getTransaction()?.begin()
        em?.remove(Project)
        em?.getTransaction()?.commit()
    }
}