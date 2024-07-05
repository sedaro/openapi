package Examples;

// import java.io.FileInputStream;
import java.io.IOException;
// import java.io.InputStream;
// import java.util.Properties;

import org.openapitools.client.*;
import org.openapitools.client.auth.*;
// import org.openapitools.client.model.*;
// import org.openapitools.client.api.JobsApi;

// import openapi.test_java.src.test.java.org.openapitools.client.Secrets;


/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args ) throws IOException, ApiException, InterruptedException
    {
        /* ********************************** Set up ApiClient ************************************** */

        //creating an ApiClient
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        // Loading secrets
        Secrets secrets = new Secrets();
        defaultClient.setBasePath(secrets.get("URL"));
        
        
        // Configure API key authorization: api_key_header_auth_handle (uncomment if needed)
        // ApiKeyAuth api_key_header_auth_handle = (ApiKeyAuth) defaultClient.getAuthentication("api_key_header_auth_handle");
        // api_key_header_auth_handle.setApiKey(secrets.get("X_AUTH_HANDLE"));
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //api_key_header_auth_handle.setApiKeyPrefix("Token");

        // Configure API key authorization: api_key_header_api_key
        ApiKeyAuth api_key_header_api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key_header_api_key");
        api_key_header_api_key.setApiKey(secrets.get("API_KEY"));
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //api_key_header_api_key.setApiKeyPrefix("Token");
        

        /* ###################################### Start Testing ############################################### */
        // Initializing Test() object
        Test test = new Test();        

        /* ----------------------------------- BranchesApi Testing --------------------------------------- */


        // 1. Testing commitToBranch
       
        //  test.testCommitToBranchScenario(defaultClient); // pass
        //  test.testCommitToBranchSpacecraft(defaultClient); // pass
        //  test.testCommitToBranchTerrestrialVehicle(defaultClient); // pass

        // 2. Testing createBranch()
        // test.testCreateBranchScenario(defaultClient); // pass
        // test.testCreateBranchSpacecraft(defaultClient); // pass
        // test.testCreateBranchTerrestrialVehicle(defaultClient); // pass

        // 3. Testing deleteBranch()
        // test.testDeleteBranchScenario(defaultClient); // pass
        // test.testDeleteBranchSpacecraft(defaultClient); // pass
        // test.testDeleteBranchTerrestrialVehicle(defaultClient); // pass


        // 4. Testing exportBranch()
        // test.testExportBranchScenario(defaultClient); // pass
        // test.testExportBranchSpacecraft(defaultClient); // pass
        // test.testExportBranchTerrestrialVehicle(defaultClient); // pass

        // 5. Testing getBranch()
        // test.testGetBranchScenario(defaultClient); // pass
        // test.testGetBranchSpacecraft(defaultClient); // pass
        // test.testGetTerrestrialVehicle(defaultClient); // pass

        // 6. Testing getBranchChanges
        // test.testGetBranchChangesScenario(defaultClient); // pass 
        // test.testGetBranchChangesSpacecraft(defaultClient); // pass
        // test.testGetBranchChangesTerrestrialVehicle(defaultClient); // pass

        // 7. Testing getCommittedBranchData()
        // test.testGetCommittedBranchDataScenario(defaultClient); // pass
        // test.testGetCommittedBranchDataSpacecraft(defaultClient); // pass

        // 8. Testing getSavedBranchData
        // test.testGetSavedBranchDataScenario(defaultClient); // pass
        // test.testGetSavedBranchDataSpacecraft(defaultClient); // pass

        // 9. Testing mergeBranches()
        // test.testMergeBranchesScenario(defaultClient); // pass
        // test.testMergeBranchesSpacecraft(defaultClient); // pass

        // 10. Testing updateBranch()
        // test.testUpdateBranchScenario(defaultClient); // pass
        // test.testUpdateBranchSpacecraft(defaultClient); // pass

        // 11. Testing verifyBranchPassword()
        // test.testVerifyBranchPasswordScenario(defaultClient); // pass
        // test.testVerifyBranchPasswordSpacecraft(defaultClient); // pass

        /* --------------------------------- DataApi Testing ------------------------------------- */
        
        // 12. Testing getData()
        // test.testGetDataScenario(defaultClient); // pass only supported for Scenario

        /* --------------------------------- ExternalsApi Testing ------------------------------------- */
        
        // 13. Testing getExternal()
        // test.testGetExternalScenario(defaultClient); // pass only supported for Scenario
        
        // 14. Testing putExternal()
        // test.testPutExternalScenario(defaultClient); // pass only supported for Scenario


        /* --------------------------------- JobsApi Testing ------------------------------------- */
         
        // 15. Testing startSimulation()      
        // test.testStartSimulationBodyScenario(defaultClient); // pass only supported for Scenario
        
        // 16. Testing terminateSimulation()      
        // test.testTerminateSimulationScenario(defaultClient); // pass only supported for Scenario

        // 17. Testing getSimulation()      
        // test.testGetSimulationScenario(defaultClient); // pass only supported for Scenario 

        // 18. Testing getSimulations()      
        // test.testGetSimulationsScenario(defaultClient); // pass only supported for Scenario

        
        // 19. Testing startStudy()
        // test.testStartStudyScenario(defaultClient); // pass only supported for Scenario ******
        
        // 20. Testing terminateStudy()
        // test.testTerminateStudyScenario(defaultClient); // pass only supported for Scenario
        
        // 21. Testing getStudy()
        // test.testGetStudyScenario(defaultClient); // pass only supported for Scenario
        
        // 22. Testing getStudies()
        // test.testGetStudiesScenario(defaultClient); // pass only supported for Scenario


        /* ----------------------------------- MetamodelsApi Testing --------------------------------------- */
        
        // 23. Testing crudTemplate()
        // test.testCrudTemplateScenario(defaultClient); // pass
        // test.testCrudTemplateSpacecraft(defaultClient); // pass
        // test.testCrudTemplateTerrestrialVehicle(defaultClient); // pass

        /* ----------------------------------- RepositoriesApi Testing --------------------------------------- */

        // 24. testing createRepo()
        // test.testCreateRepoScenario(defaultClient); //pass
        // test.testCreateRepoSpacecraft(defaultClient); // pass
        
        // 25. testing deleteRepo()
        // test.testDeleteRepoScenario(defaultClient); //pass
        // test.testDeleteRepoSpacecraft(defaultClient); //

        // 26. testing getRepo()
        // test.testGetRepoScenario(defaultClient); //pass
        // test.testGetRepoSpacecraft(defaultClient); // pass
        
        // 27. testing updateRepo()
        // test.testUpdateRepoScenario(defaultClient); // pass
        // test.testUpdateRepoSpacecraft(defaultClient); // pass


    }   
}
