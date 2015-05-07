package usm

class User {

    String firstName
    String lastName
    String email
    Account account
    //static belongsTo = [account: Account]

    static constraints = {
      firstName size: 1..50, blank: false
      lastName size: 1..50, blank: false
      email email: true, blank: false
    }
}
