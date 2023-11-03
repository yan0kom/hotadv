FROM openjdk:11

WORKDIR /hotadv

# download and unpack wildfly
RUN wget https://download.jboss.org/wildfly/24.0.1.Final/wildfly-24.0.1.Final.tar.gz
RUN mkdir wildfly
RUN tar --file=wildfly-24.0.1.Final.tar.gz --extract --strip-components=1 --directory=wildfly

# add admin user
RUN wildfly/bin/add-user.sh -r ManagementRealm -u mruser -p mruser_1234

# add mysql driver
RUN wget https://repo1.maven.org/maven2/com/mysql/mysql-connector-j/8.2.0/mysql-connector-j-8.2.0.jar
RUN touch setup-wildfy.cli
RUN echo 'embed-server --admin-only=true --std-out=echo' >> setup-wildfly.cli
RUN echo 'module add --name=com.mysql --resources=/hotadv/mysql-connector-j-8.2.0.jar --dependencies=javax.api,javax.transaction.api' >> setup-wildfly.cli
RUN echo '/subsystem=datasources/jdbc-driver=mysql:add(driver-name="mysql",driver-module-name="com.mysql",driver-class-name=com.mysql.jdbc.Driver)' >> setup-wildfly.cli
RUN echo 'stop-embedded-server' >> setup-wildfly.cli
RUN cat setup-wildfly.cli
RUN wildfly/bin/jboss-cli.sh --file=setup-wildfly.cli

# ports
EXPOSE 8080
EXPOSE 8443
EXPOSE 9990

CMD [ "wildfly/bin/standalone.sh", "-Djboss.bind.address.management=0.0.0.0", "-Djboss.bind.address=0.0.0.0" ]
