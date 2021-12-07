# Aufgabe
Diese Projekt kann mit Maven nicht erfolgreich gebaut werden.

- Warum?
- Wie muss dieses Projekt umgestellt werden?

## Verwendung mit Ant

Kompilierung, Unit tests & Packaging:

```
ant dist
```

Aufruf 

```
java -classpath 'MyProject.jar:lib/*' com.sonatype.maven.weather.yahoo.Main

```
