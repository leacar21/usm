package usm

class System {

    String code
    String name 
    static hasMany = [systemOptions: SystemOption, roles: Role, accessType: AccessType] 
    //static hasMany = [roles: Role]

    static constraints = {
    }
}
