# Training-Smile-restaurant

DEMO PLUGIN

At first create and configure one Liferay profile from your settings.xml.
Then :

<pre>
mvn liferay:build-service
mvn all
</pre>

Example :

```xml
  <profiles>
  <profile>
  	<id>Liferay-v6.2-EE-(Tomcat-7)</id>
  	<properties>
  		<liferay.version>6.2.10.8</liferay.version>
  		<liferay.maven.plugin.version>7.0.0-m2</liferay.maven.plugin.version>
  		<liferay.auto.deploy.dir>/Volumes/Guillaume Lenoir/Liferay/Liferay 6.2 EE/liferay-portal-6.2-ee-sp7/deploy</liferay.auto.deploy.dir>
  		<liferay.app.server.deploy.dir>/Volumes/Guillaume Lenoir/Liferay/Liferay 6.2 EE/liferay-portal-6.2-ee-sp7/tomcat-7.0.42/webapps</liferay.app.server.deploy.dir>
  		<liferay.app.server.lib.global.dir>/Volumes/Guillaume Lenoir/Liferay/Liferay 6.2 EE/liferay-portal-6.2-ee-sp7/tomcat-7.0.42/lib/ext</liferay.app.server.lib.global.dir>
  		<liferay.app.server.portal.dir>/Volumes/Guillaume Lenoir/Liferay/Liferay 6.2 EE/liferay-portal-6.2-ee-sp7/tomcat-7.0.42/webapps/ROOT</liferay.app.server.portal.dir>
  	</properties>
  	</profile>
  </profiles>
```
