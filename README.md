# Framework de  Automação Alelo 2.0 - API

Projeto Base com exemplo da versão 2.0 do framework de automação de testes de WEB

## Pré Requisitos

 - Java JDK 8+
 - Maven
 - Git
 - Docker
 

## Baixando o codigo

1. gerar o SSH Key e adicionar a sua conta
1.1. Gerando o SSHKey
  ```bash
  https://docs.microsoft.com/en-us/azure/devops/repos/git/use-ssh-keys-to-authenticate?view=azure-devops
  ```
1.2. Adicionando no VSTS
 ```bash
  https://alelo.visualstudio.com/_usersSettings/keys
  ```

2. Baixar o codigo

```bash
git clone  alelo@vs-ssh.visualstudio.com:v3/alelo/Time%20de%20Automa%C3%A7%C3%A3o/Framework2.0%20-%20API
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


