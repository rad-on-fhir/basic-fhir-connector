package net.radonfhir.connector.basic.mapper;

import net.radonfhir.connector.base.hl7.HL7Configuration;
import net.radonfhir.connector.base.hl7.mapper.patient.PatientAdt231Mapper;
import net.radonfhir.connector.base.organization.OrganizationService;
import net.radonfhir.connector.base.patient.loader.FhirClientLoader;
import net.radonfhir.connector.base.sync.SyncPackageProvider;
import org.springframework.stereotype.Service;

@Service
public class BasicADTPatientMapper extends PatientAdt231Mapper {

    public BasicADTPatientMapper(OrganizationService organizationService, HL7Configuration configuration, FhirClientLoader clientLoader, SyncPackageProvider syncPackageProvider) {
        super(organizationService, configuration, clientLoader, clientLoader, syncPackageProvider);
    }
}
