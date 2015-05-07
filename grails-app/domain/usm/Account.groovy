package usm

class Account {

    String name
    String password
    static hasOne = [user:User]                              // Relationship one-to-one (hasOne works only bidirectional)
    static hasMany = [permissions:Permission, roles:Role]    // Relationship one-to-many (unidirectional)

    static constraints = {
        name size: 3..24, blank: false
        password size: 6..24, blank: false
        //user unique: true
    }
}
