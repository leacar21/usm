package usm

class Permission {

    SystemOption systemOption          // Relationship Many-to-one unidirectional
    AccessType accessType  // Relationship Many-to-one unidirectional
    System system          // Relationship Many-to-one unidirectional

    static constraints = {
    }
}
