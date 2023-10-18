# Usage:
```
mvn install
```
This:
- builds the subprojects
- executes the tests (including integration tests)
- installs artefacts in the local maven repository

A web-server can be started in `simple-webapp` folder:

```
mvn jetty:run
```

The weather form is then available at <http://localhost:8088/>.
