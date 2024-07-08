
import json
from openapi_client.rest import ApiException
from pprint import pprint

import openapi_client
from openapi_client import *

from Functions import *




with open('./config.json', 'r') as file:
    keys = json.load(file)


# Defining the host is optional and defaults to https://api.sedaro.com
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = keys['URL']   
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure API key authorization: api_key_header_auth_handle
# configuration.api_key['api_key_header_auth_handle'] = keys['X_AUTH_HANDLE']
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['api_key_header_auth_handle'] = 'Bearer'

# Configure API key authorization: api_key_header_api_key
configuration.api_key['api_key_header_api_key'] = keys["API_KEY"]

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['api_key_header_api_key'] = 'Bearer'


# Enter a context with an instance of the API client
with ApiClient(configuration) as default_client:
    
    # ----------------------------------- BranchesApi Testing --------------------------------------- #
    
    test_commit_to_branch_scenario(default_client) # pass
    # test_commit_to_branch_spacecraft(default_client) # pass
    # test_commit_to_branch_terrestrialVehicle(default_client) # pass
    
    # test_verify_branch_password_scenario(default_client)
    # test_verify_branch_password_spacecraft(default_client); # pass
    # test_verify_branch_password_terrestrialVehicle(default_client); # pass
    
    
    # test_merge_branches_scenario(default_client); # pass
    # test_merge_branches_spacecraft(default_client); # pass
    # test_merge_branches_terrestrialVehicle(default_client); # pass
    
    # ------------------------------------ DataApi Testing ---------------------------------------- #
    
    # This method tests get_data(), start_simulation(), get_simulation(), terminate_simulation()
    # test_get_data_scenario(default_client); # pass only supported for Scenario
    
    # --------------------------------- ExternalsApi Testing ------------------------------------- #
    
    # test_get_external_scenario(default_client); # Not
    # test_put_external_scenario(default_client); #pass
    
    # ------------------------------------ JobsApi Testing ---------------------------------------- #

    # This function test: startStudy(), getStudy(), crudTemplate(), terminateSimulation(), terminateStudy(),
    # test_start_study_scenario(default_client); # pass
    
    # ----------------------------------- RepositoriesApi Testing --------------------------------------- #
 
    # These functions test: createRepo(), updateRepo(), deleteRepo(), getRepo()
    # test_update_repo_scenario(default_client); # pass
    # test_update_repo_spacecraft(default_client); # pass
    # test_update_repo_terrestrialVehicle(default_client); # pass
    # ----------------------------------- MetamodelsApi Testing --------------------------------------- #
        
    # Testing crud_template()
    # test_crud_template_scenario(default_client); # pass
    # test_crud_template_spacecraft(default_client); # pass
    # test_crud_template_terrestrialVehicle(default_client); # pass
    pass
    
