package usm

class SystemOption {

    String name
    static belongsTo = [system: System]
    static hasMany = [accessTypes: AccessType]

    static constraints = {
		name size: 3..50, blank: false
    }
	
	/*static mapping = {
		table 'system_option'
	}*/
}
