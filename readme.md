# javax-validations-and-api-versioning-spring
Two examples how to handle javax validation backcompatibility in versioned REST API. Annotations group and custom javax validators.

DTO contract validation depends on api version
For example in latest version field/property should be mandatory but in old version can be empty.

How to handle such scenario with javax validation?
- custom validations, anotation with fromVersion/targetVersions list
- groups: version defined throw group and field marked with group

