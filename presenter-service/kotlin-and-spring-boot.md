# Kotlin and Spring Boot

Considerations to achieve the best of two technologies

---


## Topics

- Tools to be used: Kotlin, Spring Boot(SB), Gradle, Intellij
- Kotlin basic features
    - Intro(for those who are not familiar)
    - Concepts to be used
        - Classes are final by default
        - Inmutable values
        - Null-safety
        - Data classes
        - Extensions
- SB Configuration
    - Brief intro(for those who are not familiar).
    - How it uses reflection.
        - Reflection for Dependency Injection.
        - Reflection for ORM.
- Question: How to leverage Kotlin's features in Spring Boot without falling into the verbosity that the language
  naturally aims to eliminate?

- Create a project: Kotlin, SB, Gradle(Kotlin), H2, JPA, Web
    - Explain basic Gradle configuration
        - Dependencies
        - Plugins
    - Create a Basic Rest
    - Using Data Classes to define API Types
        - Declare Controllers
    - Using Classes for JPA Definition
        - Declare classes and extend Abstract
    - Use null-safety to protect data
        - Declare explicit nullable fields(Using wildcard `?`)
    - Use immutability to declare fields
        - Use of `val` and `var`
    - Use extensions for adapters(mappers)
        - Declaring extension functions
    - Use name params for readability
        - Show and example how parameter orders can be changed putting explicitly the names of params in a
          function/constructor
    - Use scope functions
    - Use sealed interfaces
- Conclusions



