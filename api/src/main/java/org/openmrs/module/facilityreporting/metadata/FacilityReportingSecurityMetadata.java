package org.openmrs.module.facilityreporting.metadata;

import org.openmrs.api.UserService;
import org.openmrs.module.kenyaemr.metadata.SecurityMetadata;
import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.openmrs.module.metadatadeploy.bundle.Requires;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.*;

/**
 * Implementation of access control to the app.
 */
@Component
@Requires(SecurityMetadata.class)
public class FacilityReportingSecurityMetadata extends AbstractMetadataBundle {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	public static final class _Privilege {
		
		public static final String FACILITY_REPORTING_APP = "App: facilityreporting";
		
		public static final String FACILITY_REPORTING_AIR_APP = "App: facilityReporting.air";
		
	}
	
	public static final class _Role {
		
		public static final String FACILITY_REPORTING_AIR = "Facility reporting";

		
	}
	
	/**
	 * @see AbstractMetadataBundle#install()
	 */
	@Override
	public void install() {
		
		install(privilege(_Privilege.FACILITY_REPORTING_APP, "Able to access Facility Reporting features"));
		install(privilege(_Privilege.FACILITY_REPORTING_AIR_APP, "Able to access Facility Air Reporting features"));
		
		install(role(_Role.FACILITY_REPORTING_AIR, "Can access the facility reporting",
		    idSet(SecurityMetadata._Role.API_PRIVILEGES_VIEW_AND_EDIT),
		    idSet(_Privilege.FACILITY_REPORTING_APP, _Privilege.FACILITY_REPORTING_AIR_APP)));

	}
}
