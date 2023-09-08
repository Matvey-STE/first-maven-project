# First Maven Project

This project demonstrates the following features related to Jakarta EE technologies and Java development.

## Features

1. **Maven Project:**

   This project is structured as a Maven project, which makes it easy to manage dependencies and build processes.

2. **JSON Serialization and Deserialization:**

   We use the Jackson library to serialize Java objects to JSON and deserialize JSON back to Java objects. This enables efficient data exchange and storage.

3. **Jakarta Class:**

   The project includes a `Jakarta` class with the following fields:

   - `version`: The version of Jakarta.
   - `description`: A description of Jakarta.
   - `technologies`: A list of technologies related to Jakarta EE.

4. **Technology Class:**

   Each technology is represented by a `Technology` class, which includes:

   - `name`: The name of the technology.
   - `description`: A description of the technology.

5. **Implemented Methods:**

   - `void writeToJson(String path)`: Writes the Jakarta object to a JSON file specified by the `path`.
   - `Jakarta readFromJson(String path)`: Reads a Jakarta object from a JSON file specified by the `path`.
   - `void updateTechnology(Technology technology)`: Allows updating the list of technologies in the Jakarta object.

6. **JUnit Tests:**

   JUnit tests have been created to verify the functionality of the implemented methods. These tests ensure that the code behaves as expected.

7. **Environment Profiles:**

   Profiles for both development (dev) and production (prod) environments have been set up. Each profile specifies a different JSON file path for reading and writing data.

Feel free to explore the code and adapt it to your specific needs. Enjoy working with Jakarta EE technologies in this Maven-based Java project!

