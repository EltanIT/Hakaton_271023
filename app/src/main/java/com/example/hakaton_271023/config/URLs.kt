package com.example.hakaton_271023.config

import java.net.URL

class URLs {
    private val mainURL = "http://xn----7sbpbfclakh1al9a7fxc.xn--p1ai:8000/"

    val loginUserURL = URL(mainURL+"users/sign_in")
    val getProfileURL = URL(mainURL+"users/profile")

    val createPortalsURL = URL(mainURL+"portals/create")
    val invitePortalsURL = URL(mainURL+"portals/invite")
    val upgradeEmployeePortalsURL = URL(mainURL+"portals/upgrade_employee")
    val downgradeEmployeePortalsURL = URL(mainURL+"portals/downgrade_employee")
    val deletePortalsURL = URL(mainURL+"portals/delete")
    val getMyPortalsURL = URL(mainURL+"portals/my_portals")
    val getAllPortalsURL = URL(mainURL+"portals/all_portals")
    val getAllPortalByIdURL = mainURL+"portals/get_portal_by_portal_id?portal_id="
    val getAllPortalsByOwnerIdURL = URL(mainURL+"portals/get_portal_by_owner_id")
    val portalInfoURL = URL(mainURL+"portals/info")
    val portalDepartmentCreateURL = URL(mainURL+"portals/departments/create_department")
    val portalDepartmentDeleteURL = URL(mainURL+"portals/departments/delete_department")
    val portalDepartmentTreeURL = URL(mainURL+"portals/departments/tree_department")

    val createTestURL = URL(mainURL+"tests/create")
    val sendTestURL = URL(mainURL+"tests/send")
    val getAllTestsURL = URL(mainURL+"tests/model/get_all")
}