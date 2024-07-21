# Use a imagem base do Microsoft SQL Server
FROM mcr.microsoft.com/mssql/server:2022-latest

# Defina as variáveis de ambiente
ENV ACCEPT_EULA=Y
ENV SA_PASSWORD=Senha123

# Defina o usuário raiz para evitar problemas de permissão
USER root

# Crie o diretório para os scripts de inicialização
RUN mkdir -p /usr/src/app

# Copie os scripts de inicialização para o diretório
COPY init-database.sql /usr/src/app/init-database.sql
COPY entrypoint.sh /usr/src/app/entrypoint.sh

# Defina permissões executáveis para o script de entrada
RUN chmod +x /usr/src/app/entrypoint.sh

# Defina o comando de entrada
CMD ["/usr/src/app/entrypoint.sh"]
