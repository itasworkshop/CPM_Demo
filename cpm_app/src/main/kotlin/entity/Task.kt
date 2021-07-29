package entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.NamedQuery
import javax.persistence.Table

@Entity
@Table(name = "TASK")
@NamedQuery(name = "Task.findAll", query = "SELECT task FROM Task task")
public class Task() {
    @Id
    public var id : Int = 0
    public var name : String = ""
    public var cost : Int = 0
    public var dependencies : String = ""
}
