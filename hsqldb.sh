#!/bin/sh

# shell scripts directory
DIR="$(cd "$( dirname "$0" )" && pwd)"

# include env configuration
. $DIR/environment.cfg

java -cp $hsqldb_dir/lib/hsqldb.jar org.hsqldb.Server \
    -database.0 file:database/db \
    -dbname.0 mirrorapp