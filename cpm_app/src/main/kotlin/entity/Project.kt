package entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.NamedQuery
import javax.persistence.Table

@Entity
@Table(name = "PROJECT")
@NamedQuery(name = "Project.findAll", query = "SELECT project FROM Project project")
public class Project() {
    @Id
    public var id : Int = 0
    public var pid : Int = 0
    public var name : String = ""
    public var task: String = ""
}
