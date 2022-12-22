package net.radonfhir.connector.basic.mapper;

import net.radonfhir.connector.base.hl7.HL7Configuration;
import net.radonfhir.connector.base.hl7.mapper.PatientAdt231Mapper;
import net.radonfhir.connector.base.organization.OrganizationService;
import net.radonfhir.connector.base.patient.loader.FhirClientLoader;
import org.springframework.stereotype.Service;

@Service
public class BasicADTPatientMapper extends PatientAdt231Mapper {

    public BasicADTPatientMapper(OrganizationService organizationService, HL7Configuration configuration, FhirClientLoader clientLoader) {
        super(organizationService, configuration, clientLoader, clientLoader);
    }
}
