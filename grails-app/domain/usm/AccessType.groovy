package usm

class AccessType {
  //VIEW, CREATE, UPDATE, DELETE, EXECUTE;
  //READ_ONLY, EXECUTE
  String name
  
  static constraints = {
	  name blank: false
  }
}
