package net.radonfhir.connector.basic;

import net.radonfhir.connector.base.hl7.PatientHL7Sender;
import net.radonfhir.connector.base.organization.OrganizationService;
import net.radonfhir.connector.base.patient.PatientHandlerService;
import org.springframework.stereotype.Service;

@Service
public class BasicPatientHandler extends PatientHandlerService {

    public BasicPatientHandler(OrganizationService organizationService, PatientHL7Sender hl7Sender) {
        super(organizationService, hl7Sender);
    }



}
