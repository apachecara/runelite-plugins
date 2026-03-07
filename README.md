# RuneLite Plugins

Custom RuneLite plugins monorepo.

## Structure

Each plugin lives in its own directory under the root:

```
runelite-plugins/
├── plugin-one/
│   ├── build.gradle
│   └── src/main/java/com/runelite/plugins/...
├── plugin-two/
│   └── ...
├── settings.gradle
├── build.gradle
└── README.md
```

## Setup

1. Clone this repo
2. Open in IntelliJ (or your IDE of choice)
3. Each plugin is a Gradle subproject — build individually or all at once

## Building

```bash
./gradlew build          # build all plugins
./gradlew :plugin-name:build  # build a specific plugin
```
