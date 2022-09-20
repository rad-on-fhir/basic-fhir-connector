# basic-fhir-connector
Spring Boot based Connector for HL7 to FHIR-Repository with Basic Patient Sync

## Configuration

Sample Configuration for an application.properties, more Details will folow:

```
# The Connector needs Events from the FHIR Repository. You can use the 
# build in Subscriptions - or the MQTT-Connector. Whatever your Repository is configured to.
#
# !! ONLY USE MQTT OR SUBSCRIPTION !!
#
# if you prefer the Build in Subscriptions:
fhir.subscription.enabled=false
# Where can the FHIR Server reach THIS instance for Events:
fhir.subscription.baseUrl=http://192.168.0.2:8080
# If you want to use MQTT-Event transfer, add your Server and Host:
mqtt.enabled=true
mqtt.host=192.168.0.1


# Remtote FHIR Server URL:
fhir.serverBaseUrl=http://192.168.0.1:8080/fhir

# Configure the Organisation Struckture:
# The ID of the CENTRAL Patient Organisation:
fhir.organisation.centralID=2
# The ID of the Organisation, THIS Connector will manage:
fhir.organisation.myID=4

# Enable Outgoing HL7 Messages, defaults to false
hl7.enabled=true
hl7.version=2.3.1
hl7.senderFac=FHIR
hl7.senderAuth=SYSTEM
hl7.receiverFac=EXTERNAL
hl7.receiverAuth=AIS
hl7.remoteHost=192.168.0.4
hl7.remotePort=38000
hl7.delay=5100
hl7.maxAllowedErrors=21
hl7.assigningAuth=AIS
# whether you want to use a Position Based Auth rather than Key Based, defaults to false
hl7.mapper.usePositionBasedAuthority=true
# HL7 Events to use for outgoing Patient Info:
hl7.adt.event=ADT
hl7.adt.type=A08

# Incoming HL7 Messages via MLLP
# Charset
mllp.charsetName=Windows-1252
# Pool/Capacity Settings
mllp.poolSize=10
mllp.maximumPoolSize=100
mllp.capacity=100
# Abuse Config:
mllp.abuse.limit=200
mllp.abuse.interval=2000
#Enable Spring Logging if needed: 
#logging.level.org.springframework.web=DEBUG
#spring.mvc.log-request-details=true
```

## Run inside a Docker

```console
docker run -d \
    --restart unless-stopped
    --name fhir-basic-connector
    -p 58080:8080 \
    -p 33000:33000 \
    -v /your/path/to/folder/with/config/:/rof/config \
     srcblk/rad-on-fhir-basic-connector
```

Let's unpack this:
 - -d: start as deamon
 - restart: autostart on startup and auto-restart container on fail
 - name this container - if you run multiple...
 - -p: expose REST-Api at Port 58080 on host and
 - -p: expose MLLP Socket on 33000 on host
 - -v: the Service need an additional config as "application.properties". create a 
   File and Link the folder into the Image as /rof/config (so that it will be /rof/config/application.properties)