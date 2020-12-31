---
layout: default
title: Syntax
parent: Language
grand_parent: Reference
has_children: false
---

# Hypercode Language Syntax

## Code blocks

A code block is a series of statements encapsulated with curly brackets (`{` and `}`).

These may be denoted in documentation as `{ <code> }`.

## Keywords

A keyword is a case-sensitive string of characters that denote a functionality.

### `on`

Declares an event handler for an event.
There may only be one event handler for each event.

Usage:
```hypercode 
on <identifier>(<event parameters>) {
    <code>
}
```

### `if`, `else`

Runs a code block if a condition is true.
If the condition is false, the code block will not be run. Can be strung together with `else`, in which case the `else` code block will be evaluated instead.

Usage:
```hypercode
if <expression> {
    <code>
} [else {
    <code>
}]
```

### `var`

Declares a variable.

Usage: 
```hypercode
var <identifier> = <expression>
```

### `process`

Declares a process.

Usage:
```hypercode
process <identifier> {

}
```

### `function`, `return`

Declares a function.
Functions can take parameters through the use of identifiers.
They can also return values through the use of the `return` keyword.

Usage:
```hypercode
function <identifier>([identifier...]) {
    <code>
}
```

### `macro`

Declares a macro.
A macro is an identifier which gets replaced with something; either a block or a variable.

This may, in some cases, when applied correctly, save runtime memory as it does not need to keep track of a variable.

Note that `return` cannot be used for a macro function.

Usages:
1. Variable
```hypercode 
macro <identifier> = <expression>
```
2. Function
```hypercode
macro <identifier>([identifier...]) {
}
```

## Identifiers

An identifier is a sequence of ASCII characters.

They cannot start with numbers, and can not contain operators, dots, or spaces.

They can also not be equal to a keyword.