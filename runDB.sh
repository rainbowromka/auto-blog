#!/usr/bin/env bash
if [ ! -d /home/perminovrp/projects/sandbox/auto-blog/dataBase/tmp ]; then
  mkdir -p /home/perminovrp/projects/sandbox/auto-blog/dataBase/tmp;
fi
/usr/lib/postgresql/9.5/bin/postgres -D /home/perminovrp/projects/sandbox/auto-blog/dataBase/db -p 5443 -i
# Перед тем как запустить базу данных, убедитесь что в postgresql.conf прописан
# путь к unix_socket_directories