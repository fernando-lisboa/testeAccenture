# Testes Automatizados Portal PME


## Pré Requisitos

 - Java JDK 8+
 - Maven
 - Git
 - Docker
 

## Baixando o codigo

1. gerar o SSH Key e adicionar a sua conta

```bash
https://docs.microsoft.com/en-us/azure/devops/repos/git/use-ssh-keys-to-authenticate?view=azure-devops
```

2. Baixar o codigo

```bash
git clone alelo@vs-ssh.visualstudio.com:v3/alelo/Framework%20de%20Automa%C3%A7%C3%A3o/PortalPME
```

## Baixando e configurando o Zalenium / Selenium Hub
```bash
 # Pull docker-selenium
  docker pull elgalu/selenium

  # Pull Zalenium
  docker pull dosel/zalenium
        
  docker run --rm -ti --name zalenium -p 4444:4444 \
    -v /var/run/docker.sock:/var/run/docker.sock \
    -v /tmp/videos:/home/seluser/videos \
    --privileged dosel/zalenium start
    
 ```

## Executando os Testes

- Com relatorio de execução em HTML

```bash
mvn clean verify
```
## Links

- Dashboard Zalenium - http://localhost:4444/dashboard/
- Live Preview - http://localhost:4444/grid/admin/live
- Grid Console - http://localhost:4444/grid/console


