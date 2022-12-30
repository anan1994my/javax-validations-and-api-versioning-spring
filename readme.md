dto contract validation depends on api version
in latest version field should be mandatory but on old version can be empty
how to handle such scenario with javax validation

- custom validations, anotation with fromVersion/targetVersions list
- groups: version defined throw group and field marked with group

