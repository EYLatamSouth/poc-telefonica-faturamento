# poc-telefonica-faturamento
POC microserviço de faturamento para a Telefonica


## Build artifact

```
mvn clean compile package
```


## Build docker

```
docker build --build-arg JAR_FILE=./target/ms-faturamento-*.jar . -t crpoctelefonica.azurecr.io/ms-faturamento:latest
```

## Execute docker

### OBS: PORT 8081

```
docker run -e "APPLICATIONINSIGHTS_CONNECTION_STRING=InstrumentationKey=a0326010-d8b6-4a60-a429-8c185a8d3b89;IngestionEndpoint=https://eastus-8.in.applicationinsights.azure.com/;LiveEndpoint=https://eastus.livediagnostics.monitor.azure.com/" -it -p 8081:8080 crpoctelefonica.azurecr.io/ms-faturamento:latest

```

## Push docker

```
docker image push crpoctelefonica.azurecr.io/ms-cobranca:latest
```

`To push to ACR, login on your Docker Registry <crpoctelefonica>`

