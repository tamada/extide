# extide-api

## read from some location.

## output format

```json
{
  name: "NameContainer.java",
  type: "file-name",
  children: [
    {
      name: "NameContainer",
      type: "class-name",
      children: [
        {
          type: "field-name",
          name: "type"
        }, {
          type: "field-name",
          name: "name",
        }, {
          type: "method-name",
          name: "of",
          children: [
            {
              type: "return-type",
              name: "NameComponent"
            }, {
              type: "argument-name",
              name: "name"
              children: {
                type: "argument-type",
                name: "Name"
              }
            }, {
              type: "argument-name",
              name: "type"
              children: {
                type: "argument-type",
                name: "Type"
              }
            }
          ]
        }, {
          type: "method-name",
          name: "<init>",
          children: [
            {
              type: "argument-name",
              name: "name"
              children: {
                type: "argument-type",
                name: "Name"
              }
            }, {
              type: "argument-name",
              name: "type"
              children: {
                type: "argument-type",
                name: "Type"
              }
            }
          ]
        }, {
          type: "method-name",
          name: "type",
          children: [
            {
              type: "return-type",
              name: "Type"
            }
          ]
        }, {
          type: "method-name",
          name: "name",
          children: [
            {
              type: "return-type",
              name: "Name"
            }
          ]
        }
      ]
    }
  ]
}
```
