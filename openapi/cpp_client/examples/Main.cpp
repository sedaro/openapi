#include <iostream>
#include <string>
using namespace std;
#include "Secrets.h"
#include "TestFunctions.h"

#include "CppRestOpenAPIClient/ApiConfiguration.h"
#include "CppRestOpenAPIClient/ApiClient.h"
#include "CppRestOpenAPIClient/api/BranchesApi.h"

using namespace org::openapitools::client::api;
using namespace org::openapitools::client::model;

static void pop(std::string str){
    if (str.back() == '\n' || str.back() == '\r'){
        str.pop_back();
    }
}
int main(int args, char *argv[]){
    
    std::shared_ptr<ApiConfiguration> configuration = std::make_shared<ApiConfiguration>();
   
    std::string url;
    std::string api_key;
    std::string X_AUTH_HANDLE;
    try {
        Secrets secrets; // Create an instance of Secrets

        // Call the get method with a string parameter
        url = secrets.get("URL");
        pop(url);

        api_key = secrets.get("API_KEY");
        pop(api_key);

        X_AUTH_HANDLE = secrets.get("X_AUTH_HANDLE");

    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
    }

    // Set the base URL
    configuration->setBaseUrl(url);

    // Configure API key authorization: api_key_header_auth_handle
    // configuration->setApiKey("X_AUTH_HANDLE",X_AUTH_HANDLE);
    

    // Configure API key authorization: api_key_header_api_key
    configuration->setApiKey("X_API_KEY",api_key);

    // Create ApiClient instance using ApiConfiguration
    std::shared_ptr<const ApiClient> defaultClient = std::make_shared<ApiClient>(configuration);

    /* ###################################### Start Testing ############################################### */

    /* ----------------------------------- BranchesApi Testing --------------------------------------- */
    // testCreateBranchScenario(defaultClient); // pass
    // testCreateBranchSpacecraft(defaultClient); // pass
    // testCreateBranchTerrestrialVehicle(defaultClient); // pass

    // testGetBranchScenario(defaultClient); // pass
    // testGetBranchSpacecraft(defaultClient); // pass
    // testGetBranchTerrestrialVehicle(defaultClient); // pass
    
    // testCommitToBranchScenario(defaultClient); // pass
    // testCommitToBranchSpacecraft(defaultClient); // pass
    // testCommitToBranchTerrestrialVehicle(defaultClient); // pass

    // testVerifyBranchPasswordTerrestrialVehicle(defaultClient); // pass

    // testMergeBranchesTerrestrialVehicle(defaultClient); // pass

    /* --------------------------------- DataApi Testing ------------------------------------- */

    // This function tests getData(), startSimulation(), getSimulation(), terminateSimulation()
    // testGetDataScenario(defaultClient); // pass
    
    /* --------------------------------- ExternalsApi Testing ------------------------------------- */
        
    
    // testGetExternalScenario(defaultClient); // pass /Not **************
        
    
    // testPutExternalScenario(defaultClient); // pass

    /* --------------------------------- JobsApi Testing ------------------------------------- */

    // This function test: startStudy(), getStudy(), crudTemplate(), terminateSimulation(), terminateStudy(),
    // testStartStudyScenario(defaultClient); // pass

    /* ----------------------------------- RepositoriesApi Testing --------------------------------------- */
 
    // These functions test: createRepo(), updateRepo(), deleteRepo(), getRepo()
    // testUpdateRepoScenario(defaultClient); // pass
    // testUpdateRepoSpacecraft(defaultClient); // pass
    // testUpdateRepoTerrestrialVehicle(defaultClient); // pass

    /* ----------------------------------- MetamodelsApi Testing --------------------------------------- */
        
    // Testing crudTemplate()
    // testCrudTemplateScenario(defaultClient); // pass
    // testCrudTemplateSpacecraft(defaultClient); // pass
    // testCrudTemplateTerrestrialVehicle(defaultClient); // pass
        
    return 0;
}