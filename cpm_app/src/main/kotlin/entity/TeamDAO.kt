package entity

import javax.persistence.EntityManager
import javax.persistence.Persistence

class TeamDAO() {
    val em :EntityManager? = Persistence.createEntityManagerFactory("unit3")!!.createEntityManager()

    fun findAllTeams(): List<Teams> {
        return em?.createNamedQuery("Team.findAll", Teams().javaClass)?.getResultList() as List<Teams>
    }

    fun create(Teams: Teams): Unit {
        em?.getTransaction()?.begin()
        em?.persist(Teams)
        em?.getTransaction()?.commit()
    }

    fun delete(Teams: Teams?): Unit {
        em?.getTransaction()?.begin()
        em?.remove(Teams)
        em?.getTransaction()?.commit()
    }
}