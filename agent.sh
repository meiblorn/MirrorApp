#!/bin/sh

DIR="$(cd "$( dirname "$0" )" && pwd)"

# include env configuration
. $DIR/environment.cfg

#export IDE_REMOTE_DEBUG="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8088"
#export GSC_JAVA_OPTIONS="-Duser.region=us -Duser.language=en $IDE_REMOTE_DEBUG"

# Lookup group
export LOOKUPGROUPS="MirrorApp"

$gs_dir/bin/gs-agent.sh gsa.gsc 1 gsa.global.gsm 1 gsa.global.lus 1

