# C++ API Client: Practical Implementation
This document explain the steps to start working with your C++ client for consumption of Sedaro services.

Read more about Sedaro at [docs.sedaro.com](https://docs.sedaro.com).

### API Key

To access the Sedaro service via this API, you will need an API key.  You can generate an API key for your account in the
Sedaro [Management Console](https://satellite.sedaro.com/account). Once complete, pass the API key in all requests
via the `X_API_KEY` HTTP header.

*API keys grant full access to your account and should never be shared. If you think your API key has been compromised,
you can revoke it in the [Management Console](https://satellite.sedaro.com/account).*

### Community, Support, Discussion

If you have any issues or suggestions, please reach out:

1. Join the Sedaro Community [Slack](https://join.slack.com/t/sedaro-community/shared_invite/zt-1jps4i711-mXy88AZQ9AV7YcEXr8x7Ow)
2. Email us at support@sedarotech.com

### Known Issues

- Error responses are more specific than what is shown throughout the documentation.  A 4xx or 5xx error will be returned
in all error cases.  Only a `200` status indicates success.  See a given error response for additional details.
- The crudTemplate functionality is not fully supported for this client version.
## Overview
This document will provide a practical demo on how to get started with your C++ client:
1. How to generate the C++ client.
2. How to set up the C++ environment.
3. How to build the C++ Api Client project library.
4. A Breakdown of the content of the 'examples' directory.
5. Where to include your user defined header files.
6. How to compile your program.
7. How to run your program.

### 1. How to generate the C++ client:

#### Generate the C++ client

* To generate the C++ client navigate to your 'sedaro-openapi' project directory and run the following command:

```sh
openapi-generator generate -i ./spec.json -g cpp-restsdk -o ./openapi/cpp_client
```

* To get a better understanding on how to use the client it is recommended to use the examples present in your `'openapi/cpp_client/examples'` directory, which exits in the generated client. You will use the examples in this directory to interact with Sedaro API, this will be discussed in the upcoming steps.

### 2. How to set up the C++ environment:

#### Prerequisites

Install [cpprestsdk](https://github.com/Microsoft/cpprestsdk).

- Windows: `vcpkg install cpprestsdk cpprestsdk:x64-windows boost-uuid boost-uuid:x64-windows`
- Mac: `brew install cpprestsdk`
- Linux: `sudo apt-get install libcpprest-dev`


### 3. How to build the C++ Api Client project library:

You can choose one of the following two methods to built your project library (which will be called 'libCppRestOpenAPIClient.a') using your 'CMakeLists.txt' file.

#### Build using terminal
Now it is time to build the C++ Api Client library.

Navigate to your `'openapi/cpp_client'` directory (this directory should contain your `'CMakeLists.txt'` file) and run the following two commands (you can copy and paste both commands and run them at once):
```sh
cmake -DCPPREST_ROOT=/usr -DCMAKE_CXX_FLAGS="-I/usr/local/opt/openssl/include" -DCMAKE_MODULE_LINKER_FLAGS="-L/usr/local/opt/openssl/lib"
make
```

#### Build on Windows with Visual Studio (VS2017)

- Right click on folder containing source code
- Select 'Open in visual studio'
- Once visual studio opens, CMake should show up in top menu bar.
- Select CMake > Build All.

*Note: If the CMake menu item doesn't show up in Visual Studio, CMake
for Visual Studio must be installed. In this case, open the 'Visual Studio
Installer' application. Select 'modify' Visual Studio 2017. Make sure
'Desktop Development with C++' is installed, and specifically that 'Visual
C++ tools for CMake' is selected in the 'Installation Details' section.

Also, be sure to review the CMakeLists.txt file to confirm whether any necessary edits are required (though edits are likely unnecessary).*

### 4. A Breakdown of the content of the 'test' directory:
This is the hierarchy of your `'openapi/cpp_client'` folder so far:

    openapi

     cpp_client

      |>.openapi-generator

      |>CMakeFiles

      |>examples

      |>include

      |>src


     CMakeLists.txt
    
     libCppRestOpenAPIClient.a (This is the library that you just built)
    
     ... (other files)

Navigate to your the `'openapi/cpp_client/examples'` directory, where you will find the following files:

A `'Main.cpp'` file which contains the main function that that calls functions created in 'TestFunctions.cpp'.

A `'TestFunctions.cpp'` file which contains examples demonstrating how to interact with the Sedaro API. You can modify the existing functions in this file or create your own functions as needed. Before making any alterations, it is recommended to run the pre-existing functions to get familiar with how to interact with Sedaro end points.

A `'Secrets.cpp'` file that is used to retrieve the host URL, API key, branch IDs, workspace ID, or any other secrets from `'config.properties'`.

A `'resources/config.properties'` file that contains key-value pairs of the secrets used to access the API. You need to retrieve these credentials from the Sedaro website [Home Page](https://satellite.sedaro.com) and assign them to the corresponding key in this file.

Example: (Please follow the same format, leaving a space before and after the equal sign)

    URL = https://api.sedaro.com

    API_KEY = ABCD

    WORKSPACE_ID = EFG

    SUPER_SAT_SCEN_ID = HIJ


*Note: For every additional `'.cpp'` file that you create in `'examples'` you need to create a corresponding `'.h'` header file and include it in the `'examples/include'` directory. (This will be discussed in detail in step 5).

For example:

`'Secrets.cpp'` => `'Secrets.h'`

### 5. Where to include your user defined header files.

In the `'examples/include'` sub-directory, you will find all user defined header files. For any additional `'.cpp'` file that you create in `'examples'` you must create a corresponding `'.h'` file in `'examples/include'`.

You must also add the function prototype of any additional functions that you create in `'TestFunctions.cpp'` in `'TestFunctions.h'`. (You can follow the examples of the functions already created in `'TestFunctions.cpp'` and called from `'Main.cpp'` and how their prototypes were included in `'TestFunctions.h'`)

*Note: This include sub-directory is different from the `'cpp_client/include'` directory that is auto-generated in your project directory.

This is the hierarch of your `'examples'` sub-directory:

 

    examples
     
     |>include

        |>Secrets.h

        |>TestFunctions.h
        
        |>... (other corresponding .h files as needed)

     |>Main.cpp

     |>Secrets.cpp

     |>TestFunctions.cpp

     |>... (other helper .cpp files as needed)


### 6. How to compile your program.

For Mac users, in your `'openapi/examples'` directory run the following command to recompile your code every time you make changes to your code (copy and past the whole command into your terminal and edit as necessary):

```sh
g++ -o main Main.cpp Secrets.cpp TestFunctions.cpp -std=c++17 -I../include -I/opt/homebrew/include -I./include -v -L/opt/homebrew/Cellar/boost/1.85.0/lib -lboost_program_options -L/opt/homebrew/Cellar/openssl@3/3.3.0/lib -lssl -lcrypto -L../ -lCppRestOpenAPIClient -L/opt/homebrew/Cellar/cpprestsdk/2.10.19/lib -lcpprest
```
For non Mac users, follow a similar command by replacing the homebrew paths with your packet management paths.

*Note: Add any additional `'.cpp'` files next to `"Main.cpp Secrets.cpp TestFunctions.cpp ..."` in your command to be able to compile your code successfully.

### 7. How to run your program.

After you successfully compile your project, run the following command, where `'main'` is the name of the executable that you specified in the compilation command:

```sh
./main
```