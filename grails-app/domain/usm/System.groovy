package usm

class System {

    String code
    String name 
    static hasMany = [systemOptions: SystemOption, roles: Role, accessTypes: AccessType] 
    //static hasMany = [roles: Role]

    static constraints = {
		code size: 3..6, blank: false
		name blank: false
    }
}
