package usm

class Role {

    String code;
    String name;
    static belongsTo = [system: System]
    static hasMany = [permissions:Permission] // Relationship one-to-many (unidirectional)

    static constraints = {
    }
}
