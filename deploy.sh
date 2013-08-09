#!/bin/sh

DIR="$(cd "$( dirname "$0" )" && pwd)"

# include env configuration
. $DIR/environment.cfg

# maven package
cd $DIR
mvn package

# Lookup group
export LOOKUPGROUPS="MirrorApp"

# deploy mirror
$gs_dir/bin/gs.sh deploy \
    -max-instances-per-vm 4 \
    -max-instances-per-machine 4 \
    -deploy-timeout 1500 \
    -override-name mirror $DIR/mirror/target/MirrorApp-mirror.war

# deploy service
#$gs_dir/bin/gs.sh deploy \
#    -cluster schema=partitioned-sync2backup total_members=1,1 \
#    -max-instances-per-vm 4 \
#    -max-instances-per-machine 4 \
#    -deploy-timeout 1500 \
#    -override-name service $DIR/service/target/MirrorApp-service.war