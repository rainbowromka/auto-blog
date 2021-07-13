#!/usr/bin/env bash
if [ ! -d /home/perminovrp/projects/sandbox/auto-blog/dataBase/db ]; then
  mkdir -p /home/perminovrp/projects/sandbox/auto-blog/dataBase/db;
fi
/usr/lib/postgresql/9.5/bin/initdb --encoding UTF8 -D /home/perminovrp/projects/sandbox/auto-blog/dataBase/db
