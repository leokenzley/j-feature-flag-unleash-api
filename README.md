# Java API UNLEASH FEATURE FLAG
### Executando a aplicação

1. É necessário executar as configurações que está na pasta .infraestrutura/unleash/README-UNLEASH.md
2. Este projeto segue o seguinte tutorial, não completamente:
```
https://docs.getunleash.io/reference/sdks/java
```
2. Para testar o endpoint, uma vez que seguiu as configurações do unleash, execute o seguinte curl para receber true:

true
```
curl --location 'http://localhost:8080/api/verify-feature-flag/verify' \
   --header 'X-client-identifyer: 150'
```
false
```
curl --location 'http://localhost:8080/api/verify-feature-flag/verify' \
   --header 'X-client-identifyer: 138'
```