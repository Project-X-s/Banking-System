#!/bin/bash

# Inicie o SQL Server em segundo plano
/opt/mssql/bin/sqlservr &

# Espere até que o SQL Server esteja pronto para aceitar conexões
echo "Esperando o SQL Server iniciar..."
while ! /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P 'Senha123' -Q "SELECT 1" &> /dev/null
do
  echo "Aguardando o SQL Server estar pronto..."
  sleep 5
done

# Execute o script SQL para inicializar o banco de dados
echo "Executando o script de inicialização..."
/opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P 'Senha123' -i /usr/src/app/init-database.sql

# Aguarde indefinidamente para manter o contêiner em execução
wait
