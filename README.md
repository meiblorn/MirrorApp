<h3>MirrorApp</h3>

Deployment:<br>

1. Edit environment.cfg to setup Gigaspaces XAP and HSQLDB directories.
2. Run hsqldb.sh script to run Database server. 
3. Run agent.sh script to startup Gigaspace agent with GSM, GSC and LUS. 
4. Run in other terminal deploy.sh script to deploy MirrorApp project.

Usage:<br>

To access all features we recommend to use CURL or same REST client with JSON support.

- <tt>GET http://127.0.1.1:8080/mirror/rest/status</tt>  - shows mirror-service data source operations count and their status.
- <tt>GET http://127.0.1.1:8081/service/rest/operation/event/</tt>  - shows all <tt>Event</tt> objects currently contains in space.
- <tt>GET http://127.0.1.1:8081/service/rest/operation/event/{id}</tt> - if exists, returns <tt>Event</tt> object with specified <tt>id</tt> number.
- <tt>POST http://127.0.1.1:8081/service/rest/operation/event/</tt>  - puts <tt>Event</tt> object in the space. Supports only JSON requests like <tt>{ "id": yourIdNumber, "message": "yourMessage" }</tt>
- <tt>DELETE http://127.0.1.1:8081/service/rest/operation/event/{id}</tt> - if exists, delete from the space <tt>Event</tt> object with specified <tt>id</tt> number.
