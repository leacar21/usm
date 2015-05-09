class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
		
		// For Exceptions
		"500"(controller: "error", action: "handleObjectNotFound", exception: ObjectNotFoundException)
		
		// REST Mapping
		
		// USERS
		// Se creará, actualizará y eliminará un User a travez del Account asociado
		"/users"(resources:"user", includes:['index', 'show'])

		// ACCOUNTS 
		// Se permite obtener el User de un Account
		// Se permite objener, agregar y quitar los Permission y los Role de un account
		"/accounts"(resources:"account")
		"/accounts/$idAccount/user" {
			controller = 'account'
			action = 'showUser'
			method = GET
		}
		"/accounts/$idAccount/permissions" {
			controller = 'account'
			action = 'showPermissions'
			method = GET
		}
		"/accounts/$idAccount/permissions" {
			controller = 'account'
			action = 'addPermission'
			method = POST
		}
		"/accounts/$idAccount/permissions/$idPermission" {
			controller = 'account'
			action = 'quitPermission'
			method = DELETE
		}
		"/accounts/$idAccount/roles" {
			controller = 'account'
			action = 'showRoles'
			method = GET
		}
		"/accounts/$idAccount/roles" {
			controller = 'account'
			action = 'addRole'
			method = POST
		}
		"/accounts/$idAccount/roles/$idRole" {
			controller = 'account'
			action = 'quitRole'
			method = DELETE
		}

		// AccessTypes
		// ACCESS_TYPES
		// En principio se creará, actualizará y eliminará un AccessType desde la base (habiendo uno de solo lectura y otro de ejecución)
		//"/accessTypes"(resources:"accessTypes", includes:['index', 'show'])
		
		// ROLES
		// Los roles se navegan a travez de los accounts
		//"/roles"(resources:"roles", includes:[])
		"/roles/$idRole/permissions" {
			controller = 'role'
			action = 'showPermissions'
			method = GET
		}

		// PERMISSIONS
		// Los permisos se navegan a travez de los accounts
		"/permissions"(resources:"permissions", includes:['show'])
		"/permissions/$idPermission/accessType" {
			controller = 'permission'
			action = 'showAccessType'
			method = GET
		}

		// SYSTEM_OPTIONS
		// Las opciones de istema se navegan a travez de los sistemas
		"/systemOptions"(resources:"systemOptions", includes:['show'])
		"/systemOptions/$idSystemOption/accessTypes" {
			controller = 'systemOption'
			action = 'showAccessTypes'
			method = GET
		}

		// SYSTEM
		"/systems"(resources:"systems")
		"/systems/$idSystem/systemOptions" {
			controller = 'system'
			action = 'showSystemOptions'
			method = GET
		}
		"/systems/$idSystem/systemOptions" {
			controller = 'system'
			action = 'addSystemOption'
			method = POST
		}
		"/systems/$idSystem/systemOptions/$idSystemOption" {
			controller = 'system'
			action = 'quitSystemOption'
			method = DELETE
		}
		"/systems/$idSystem/accessTypes" {
			controller = 'system'
			action = 'showAccessTypes'
			method = GET
		}
		"/systems/$idSystem/accessTypes" {
			controller = 'system'
			action = 'addAccessTypes'
			method = POST
		}
		"/systems/$idSystem/accessTypes" {
			controller = 'system'
			action = 'quitAccessTypes'
			method = DELETE
		}
	}
}
