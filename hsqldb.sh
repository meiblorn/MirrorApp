#!/bin/sh

# shell scripts directory
DIR="$(cd "$( dirname "$0" )" && pwd)"

# include env configuration
. $DIR/environment.cfg

java -cp $hsqldb_dir/lib/hsqldb.jar org.hsqldb.Server --props $DIR/database/db.properties