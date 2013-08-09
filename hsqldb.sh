#!/bin/sh

echo "Reading config...." >&2
. "$(cd "$( dirname "$0" )" && pwd)"/environment.cfg

java -cp $hsqldb_dir/lib/hsqldb.jar org.hsqldb.Server --props database/db.properties