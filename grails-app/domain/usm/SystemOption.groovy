package usm

class SystemOption {

    String name
	String description
    static belongsTo = [system: System]
    static hasMany = [accessTypes: AccessType]

    static constraints = {
		name size: 3..35, blank: false
		description size: 3..75, blank: false
    }
	
	/*static mapping = {
		table 'system_option'
	}*/
}
