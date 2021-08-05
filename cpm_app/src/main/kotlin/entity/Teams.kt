package entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.NamedQuery
import javax.persistence.Table

@Entity
@Table(name = "TEAM")
@NamedQuery(name = "Team.findAll", query = "SELECT team FROM Team team")
public class Teams() {
    @Id
    public var id : Int = 0
    public var name : String = ""
    public var pid : Int = 0
}
