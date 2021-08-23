# Exec clean install on each folder containg pom.xml (should work for gradle and so on)
find . -name "pom.xml" -exec mvn clean -f '{}' \;