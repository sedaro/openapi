# Python API Client: Practical Implementation

This document explains the steps to start working with your Python client for consumption of Sedaro services.

Read more about Sedaro at [docs.sedaro.com](https://docs.sedaro.com).

### API Key

To access the Sedaro service via this API, you will need an API key.  You can generate an API key for your account in the
Sedaro [Management Console](https://satellite.sedaro.com/account). Once complete, pass the API key in all requests
via the `X_API_KEY` HTTP header.

*API keys grant full access to your account and should never be shared. If you think your API key has been compromised,
you can revoke it in the [Management Console](https://satellite.sedaro.com/account).*

### Jupyter Notebooks

For additional examples of how to use this API for modeling and simulation, see our [Mod-Sim Notebooks](https://github.com/sedaro/modsim-notebooks).

### Community, Support, Discussion

If you have any issues or suggestions, please reach out:

1. Join the Sedaro Community [Slack](https://join.slack.com/t/sedaro-community/shared_invite/zt-1jps4i711-mXy88AZQ9AV7YcEXr8x7Ow)
2. Email us at support@sedarotech.com

### Known Issues

- Error responses are more specific than what is shown throughout the documentation.  A 4xx or 5xx error will be returned
in all error cases.  Only a `200` status indicates success.  See a given error response for additional details.

- The crudTemplate functionality is not fully supported for this client version.


## Requirements.

Python 3.7+

## Generating the Python client

* To generate the Python client navigate to your `'sedaro-openapi'` project directory and run the following command:

```sh
openapi-generator generate -i ./spec.json -g python -o ./openapi/python_client
```

* To get a better understanding on how to use the client it is recommended to use the examples present in your `'openapi/python_client/examples'` directory. You will use the examples in this directory to interact with Sedaro API, this will be discussed in the upcoming steps.


## Installation & Usage

### Setuptools

Install via [Setuptools](http://pypi.python.org/pypi/setuptools).

Navigate to your `'openapi/python_client'` directory and run the following command:

```sh
python setup.py install --user
```
(or `sudo python setup.py install` to install the package for all users)

Then import the package into you code (This will can be found in the examples, which will be discussed in the upcoming steps)
```python
import openapi_client
```

## Getting Started

After following the [installation procedure](#installation--usage) instruction:

Navigate to your `'openapi/python_client/'examples'` directory, where you will find the following files:

* A `'Main.py'` file which contains the main method that calls methods created in `'Functions.py'`.

* A `'Functions.py'` file which contains examples demonstrating how to interact with the Sedaro API. You can modify the existing functions in this file or create your own functions as needed. Before making any alterations, it is recommended to run the pre-existing functions to get familiar with how to interact with Sedaro end points.

* A `'config.json'` file that contains key-value pairs of the secrets used to access the API. You need to retrieve these credentials from the Sedaro website [Home Page](https://satellite.sedaro.com) and assign them to the corresponding key in this file.

Example:

    {
        
        "URL": "http://localhost",

        "API_KEY" : "ABCD",

        "WORKSPACE_ID" : "EFG",

        "SUPER_SAT_SCEN_ID" : "HIJ"
    }

You can now navigate to your `'openapi/python_client/examples'` open your `'Main.py'` and run the methods implemented in `'Functions.py'` or modify them as needed.

You can also refer to the generated `'README.md'` in your `'openapi/python_client'` for more details on methods' implementation.