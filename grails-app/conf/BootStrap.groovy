import usm.*

class BootStrap {

    def init = { servletContext ->
		System systemUSM = new System(code:"usm", name: "User Security Manager")
		systemUSM.save()

		AccessType accessTypeView = new AccessType(name: "VIEW")
		AccessType accessTypeCreate = new AccessType(name: "CREATE")
		accessTypeView.save()
		accessTypeCreate.save()
		
		SystemOption optionAccountsView = new SystemOption(name: "accounts", description: "Accounts Manager", accessTypeEnableds: [accessTypeView, accessTypeCreate], system: systemUSM)
		optionAccountsView.save()
		
		SystemOption optionSystemsView = new SystemOption(name: "systems", description: "Systems Manager", accessTypeEnableds: [accessTypeView, accessTypeCreate], system: systemUSM)
		optionSystemsView.save()

		Permission permissionAccountsView = new Permission(systemOption: optionAccountsView, accessType: accessTypeView, system: systemUSM)
		permissionAccountsView.save()
		
		Role roleAdmin = new Role(code: "ADM", name: "Administrator", system: systemUSM, permissions: [permissionAccountsView])
		roleAdmin.save()

		//Account accountAdmin = new Account(name: "test", password: "abc123")
		//accountAdmin.save()

		User userTest = new User(firstName: "User", lastName: "Tester", email: "usertester@gmail.com")
		userTest.save()

		Account accountAdmin = new Account(name: "test", password: "abc123", user: userTest, permissions: [permissionAccountsView], roles: [roleAdmin])
		accountAdmin.save()

		println "User: $userTest.firstName $userTest.lastName $userTest.email"
		println "User -> Account: $userTest.account.name"
		//println "User -> Account -> Permissions -> System: $userTest.account.permissions[0].system.name"
		
		//User userTest = new User(firstName: "User", lastName: "Tester", email: "usertester@gmail.com", account: accountAdmin)
		//userTest.save(flush: true)
    }
    def destroy = {
    }
}
