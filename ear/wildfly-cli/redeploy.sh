SCRIPTDIR=$(dirname "$0")

if [ ! -e $SCRIPTDIR/jboss-cli-client.jar ]; then
  docker cp hotadv-wildfly:/hotadv/wildfly/bin/client/jboss-cli-client.jar $SCRIPTDIR/
fi

java -jar $SCRIPTDIR/jboss-cli-client.jar --connect -u=mruser -p=mruser_1234 "deploy --force $SCRIPTDIR/../build/libs/hotel-advisors.ear"
