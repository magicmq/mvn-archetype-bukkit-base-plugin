[![Generic badge](https://img.shields.io/badge/version-1.5.3-C.svg)](https://repo.magicmq.dev/repository/archetypes/)
[![Apache license](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

# BasePluginArchetype

The aim of this project is to create a Maven Archetype that resembles a Bukkit plugin. Simply put, an Archetype is a template that defines a general structure of a project. This archetype will generate much of the basic code that goes into every Bukkit plugin (such as a main clas, listener, command, and plugin.yml). For more information on Maven Arcetypes, see [this](https://maven.apache.org/guides/introduction/introduction-to-archetypes.html) link.

This project is a fork of a maven archetype originally created by Rayzr522, with several changes/updates made in order to make the archetype more useable. The upstream repository is located [here](https://github.com/Rayzr522/mvn-archetype-bukkit-base-plugin).

## Features
At present, the Archetype will do the following for you (when the project is created):

- Creates a package structure according to the GroupID property when the project is created
- Creates a pom.xml according to the `artifactId`, `groupId`, and `version` properties.
  - Also imports Spigot as a dependency. The version of spigot to use is defined through the `mc-version` property when creating the project (see below).
  - Contains a build profile configured to compile using language level 8. A shade goal is also included in case an uber-jar is needed.
- Creates four classes:
  - A main class for your plugin, named according to the `name` property. Code is already written to save the config.yml in the `onEnable()` method, as well as to register the listener class and the command class.
  - A PluginListener class for listening to events.
  - A command class, named according to the `name` property, that serves as a main command for your plugin.
- Creates a plugin.yml, with project name, version, author, main class location, and main command defined for you.

## Usage

This archetype can be used in two ways. The preferred (and more convenient) method is to use your IDE to "import" a remote `archetype-catalog.xml`, and allow the IDE to handle generating the project using the archetype and properties you define. As an alternative method, Maven can be used to manually install the archetype and generate the project files. 

There are six properties of note when using this archetype. These will be defned when the project is created:

- `artifactId`: The artifact ID of the project, default is someplugin
- `name`: The name of the plugin that will be used in the plugin.yml as well as for naming the main plugin class, default is SomePlugin
- `groupId`: The group ID of the project, used to define the package structure of the project, default is com.github.someauthor
- `author`: The author of the project/plugin, used in the plugin.yml, default is someauthor
- `version`: The initial version of the plugin, used in the plugin.yml, default is 1.0.0
- `mc-version`: The version of Spigot that will be imported as a dependecy in the `pom.xml`. Options can be `1.7.10` through `1.15.2`. Only enter the MC version, **do not** enter the full Spigot version, default is 1.8.8.

### Eclipse

Eclipse allows you to import remote archetype catalogs out of the box. To do so, follow [this](https://howtodoinjava.com/eclipse/how-to-import-maven-remote-archetype-catalogs-in-eclipse/) guide to import the remote archetype catalog as well as create a project using the archetype.

The remote catalog for this archetype that you will use can be found at `https://repo.magicmq.dev/repository/archetypes/archetype-catalog.xml`.

If done correctly, you should see the archetype, labeled as `dev.magicmq:bukkit-plugin-archetype` in the list of available archetypes when you create a new Maven project. There will be several versions available; use the latest version, which can be found at the top of this page.

&#9888;&nbsp;Note: When you create a new Maven project in Eclipse using the archetype, you **should** define the `author`, `version`, and `mc-version` properties when you create the project, or else unwanted default values will be applied.

When you wish to build the project, simply build how you would for any Maven project: `mvn clean install`

### IntelliJ

At the time of writing, IntelliJ does not support importing remote archetype catalogs out of the box. Therefore, a plugin is needed. Follow the instructions on [this](https://plugins.jetbrains.com/plugin/7965-maven-archetype-catalogs) page to install and configure the plugin. 

The remote catalog for this archetype that you will use can be found at `https://repo.magicmq.dev/repository/archetypes/archetype-catalog.xml`.

If done correctly, you should see the archetype, labeled as `dev.magicmq:bukkit-plugin-archetype` in the list of available archetypes when you create a new Maven project. There will be several versions available; use the latest version, which can be found at the top of this page.

&#9888;&nbsp;Note: When you create a new Maven project in IntelliJ using the archetype, you **should** define the `author`, `version`, and `mc-version` properties when you create the project, or else unwanted default values will be applied.

When you wish to build the project, simply build how you would for any Maven project: `mvn clean install`

### Manual Installation

You may also use Maven to install and use the archetype manually. To do so, follow these steps:

Clone this repository, navigate to the directory of the repository via command line (in Git or Command Prompt), and run

    mvn install
    mvn archetype:crawl
    
The first command will install the archetype to your local Maven repository. The second command will crawl your local repository and create an `archetype-catalog.xml`, containing coordinates to all archetypes you have installed, so that they can be used.

To use the archetype, navigate to a directory where you wish to generate the project, and run the following, making sure to replace the properties with your desired values.

    mvn archetype:generate \
      -DarchetypeGroupId=dev.magicmq \
      -DarchetypeArtifactId=mvn-archetype-bukkit-base-plugin \
      -DarchetypeVersion=1.1.1 \
      -DgroupId="com.github.someauthor" \
      -DartifactId="someplugin" \
      -Dversion="1.0.0" \
      -Dname="SomePlugin" \
      -Dauthor="someauthor" \
      -Dmc-version="1.8.8"

With the above command, `com.github.someauthor` would be the package structure, the name of the plugin would be `SomePlugin`, the version would be `1.0.0`, the author would be `someauthor`, and the Spigot version that will be imported as a dependency would be `1.8.8-R0.1-SNAPSHOT`. Replace the properties to your liking. 

## Issues/Suggestions

Do you have any issues or suggestions? [Submit an issue report.](https://github.com/magicmq/mvn-archetype-bukkit-base-plugin/issues/new)
