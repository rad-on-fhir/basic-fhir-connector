package net.radonfhir.connector.basic.mapper;

import ca.uhn.fhir.rest.client.api.IGenericClient;
import net.radonfhir.connector.base.hl7.HL7Configuration;
import net.radonfhir.connector.base.hl7.mapper.PatientAdt231Mapper;
import net.radonfhir.connector.base.organization.OrganizationService;
import org.springframework.stereotype.Service;

@Service
public class BasicADTPatientMapper extends PatientAdt231Mapper {

    public BasicADTPatientMapper(OrganizationService organizationService, HL7Configuration configuration, IGenericClient fhirClient) {
        super(organizationService, configuration, fhirClient);
    }
}
