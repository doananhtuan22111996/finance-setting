# Android Repository Template

This repository provides a starting point for creating modular Android applications. It includes predefined project configurations, structured modules, and best practices to streamline development.

## Features

- **Modular Design**: Separation of concerns into `demo`, `feature`, `business`, `presentation`, and `featureApi` modules.
- **Kotlin DSL**: Gradle build scripts use Kotlin DSL for better readability and maintainability.
- **Scalable Architecture**: Suitable for large-scale apps with clear modularization.
- **CI/CD Ready**: Includes GitHub Actions workflows.
- **Jetpack Compose Support**: Ready to integrate Jetpack Compose for modern UI development.

---

## Project Structure
```
    android-repo-template/
├── .chglog             # Change log configuration
├── .github             # GitHub workflows
├── .gradle             # Gradle cache files
├── .idea               # IntelliJ IDEA settings
├── .kotlin             # Kotlin-specific configuration
├── buildSrc            # Custom Gradle plugins and shared configurations
├── demo                # Main application module
├── feature             # Features implementation
│   ├── business        # Business logic layer
│   ├── presentation    # UI layer (e.g., Jetpack Compose, Views)
├── featureApi          # Interfaces and APIs for the feature module
├── gradle              # Gradle wrapper files
├── gradlew             # Gradle wrapper script
├── gradlew.bat         # Gradle wrapper script for Windows
├── local.properties    # Local environment-specific properties
├── README.md           # Project documentation
├── build.gradle.kts    # Root Gradle build script
├── gradle.properties   # Gradle properties file
└── settings.gradle.kts # Gradle settings file
```

## Module Overview

### `demo` Module
This is the main application module, primarily used to run and integrate the other modules.

### `feature` Module
A modularized directory containing:

- **`business`**: Handles business logic and domain-specific operations.
- **`presentation`**: Manages the UI layer, which includes Jetpack Compose or View-based layouts.
- **`featureApi`**: Defines interfaces and contracts to decouple the `business` and `presentation` layers from the main app.

### `buildSrc`
Contains custom Gradle plugins and reusable configurations to standardize settings across all modules.

