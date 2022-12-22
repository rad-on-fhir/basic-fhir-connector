package net.radonfhir.connector.basic;

import ca.uhn.fhir.rest.client.api.IGenericClient;
import net.radonfhir.connector.base.hl7.HL7Configuration;
import net.radonfhir.connector.base.hl7.mapper.AppointmentSIUMapper;
import net.radonfhir.connector.base.hl7.mapper.PatientAdt231Mapper;
import net.radonfhir.connector.base.hl7.mapper.PatientAdt25Mapper;
import net.radonfhir.connector.base.organization.OrganizationService;
import net.radonfhir.connector.base.patient.loader.FhirClientLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {


    @Bean
    @Autowired
    @ConditionalOnProperty(
            value = "hl7.mapper.siu",
            havingValue = "true"
    )
    public AppointmentSIUMapper appointmentSIUMapper(OrganizationService orga, HL7Configuration config, IGenericClient client, FhirClientLoader fhirClient) {
        return new AppointmentSIUMapper(orga, config, client, fhirClient);
    }

    @Bean
    @Autowired
    @ConditionalOnProperty(
            value ="mllp.version",
            havingValue = "2.3.1"
    )
    public PatientAdt231Mapper patientAdt231Mapper(OrganizationService organizationService, HL7Configuration configuration, FhirClientLoader fhirClient) {
        return new PatientAdt231Mapper(organizationService, configuration, fhirClient, fhirClient);
    }

    @Bean
    @Autowired
    @ConditionalOnProperty(
            value ="mllp.version",
            havingValue = "2.5",
            matchIfMissing = true
    )
    public PatientAdt25Mapper patientAdt25Mapper(OrganizationService organizationService, HL7Configuration configuration, FhirClientLoader fhirClient) {
        return new PatientAdt25Mapper(organizationService, configuration, fhirClient, fhirClient);
    }


}
