package Examples;
import org.openapitools.client.*;
// import org.openapitools.client.auth.*;
// import org.openapitools.client.model.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openapitools.client.api.BranchesApi;
import org.openapitools.client.api.DataApi;
import org.openapitools.client.api.ExternalsApi;
import org.openapitools.client.api.JobsApi;
import org.openapitools.client.api.MetamodelsApi;
import org.openapitools.client.api.RepositoriesApi;
import org.openapitools.client.model.BranchChangesRes;
import org.openapitools.client.model.BranchCreate;
import org.openapitools.client.model.BranchMerge;
import org.openapitools.client.model.BranchRes;
import org.openapitools.client.model.BranchUpdate;
import org.openapitools.client.model.BranchVerifyPassword;
import org.openapitools.client.model.CommitMessage;
import org.openapitools.client.model.DataServiceResponse;
import org.openapitools.client.model.EntityDeleteRes;
import org.openapitools.client.model.ExternalStateSetRequest;
import org.openapitools.client.model.MessageRes;
import org.openapitools.client.model.MetamodelUpdateInterface;
import org.openapitools.client.model.ModelCrudRes;
import org.openapitools.client.model.RepoCreateReq;
import org.openapitools.client.model.RepoRes;
import org.openapitools.client.model.RepoUpdateReq;
import org.openapitools.client.model.ResponseGetCommittedBranchData;
import org.openapitools.client.model.ResponseGetSavedBranchData;
import org.openapitools.client.model.ResponseGetSimulations;
import org.openapitools.client.model.ResponseGetStudies;
import org.openapitools.client.model.ResponseMergeBranches;
import org.openapitools.client.model.SimulationJob;
import org.openapitools.client.model.StartSimulationBody;
import org.openapitools.client.model.StartStudyBody;

public class Test {

    /* Constructor */
    Test(){

    }
   
    /* ----------------------------------- Branch Testing Methods --------------------------------------- */

    /* 1. Method that tests commitToBranch() */

    // commitToBranch() for Scenario
    void testCommitToBranchScenario(ApiClient defaultClient) throws IOException, ApiException{
        
        Secrets secrets = new Secrets();
        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // String |

        // Create a new branch
        BranchCreate branchCreate = new BranchCreate(); // BranchCreate |
        branchCreate.name("New_branch3");
        BranchRes new_branchRes = apiInstance.createBranch(branchId, branchCreate);
        String newBranchId = new_branchRes.getId();

        // Make changes to the new branch using crud()

        MetamodelsApi metamodelsApi = new MetamodelsApi(defaultClient);
        
        MetamodelUpdateInterface metamodelUpdateInterface = new MetamodelUpdateInterface(); // MetamodelUpdateInterface | 

        metamodelUpdateInterface.addDeleteItem(secrets.get("BLOCK_IN_SCEN_ID"));

        metamodelsApi.crudTemplate(newBranchId, metamodelUpdateInterface);


        // Preparing commit
        CommitMessage commitMessage = new CommitMessage(); // CommitMessage | 
        commitMessage.commitMessage("committed");
        try {
            
            //commit 
            System.out.println(apiInstance.commitToBranch(newBranchId, commitMessage));
            
            // Deleting the branch
            apiInstance.deleteBranch(newBranchId);

        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#commitToBranch");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();

            // Deleting the branch
            apiInstance.deleteBranch(newBranchId);
        }
    }

    // commitToBranch() for Spacecraft
    void testCommitToBranchSpacecraft(ApiClient defaultClient) throws IOException, ApiException{
        
        Secrets secrets = new Secrets();
        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_VEHI_ID"); // String |

        
        // Create a new branch
        BranchCreate branchCreate = new BranchCreate(); // BranchCreate |
        branchCreate.name("New_branch3");
        BranchRes new_branchRes = apiInstance.createBranch(branchId, branchCreate);
        String newBranchId = new_branchRes.getId();

        // Make changes to the branch an commit
        MetamodelsApi metamodelsApi = new MetamodelsApi(defaultClient);
        
        MetamodelUpdateInterface metamodelUpdateInterface = new MetamodelUpdateInterface(); // MetamodelUpdateInterface | 

        metamodelUpdateInterface.addDeleteItem(secrets.get("BLOCK_IN_VEHI_ID")); 
        

        metamodelsApi.crudTemplate(newBranchId, metamodelUpdateInterface);

        // Preparing commit
        CommitMessage commitMessage = new CommitMessage(); // CommitMessage | 
        commitMessage.commitMessage("committed");
        try {
            MessageRes result = apiInstance.commitToBranch(newBranchId, commitMessage);
            System.out.println(result);
            
            // Deleting the branch
            apiInstance.deleteBranch(newBranchId);

        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#commitToBranch");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();

            // Deleting the branch
            apiInstance.deleteBranch(newBranchId);
        }
    }


    // commitToBranch() for TerrestrialVehicle
    void testCommitToBranchTerrestrialVehicle(ApiClient defaultClient) throws IOException, ApiException{
        
        Secrets secrets = new Secrets();
        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SUPER_SAT_TERR_VEHICLE_ID"); // String |

        
        // Create a new branch
        BranchCreate branchCreate = new BranchCreate(); // BranchCreate |
        branchCreate.name("New_branch3");
        BranchRes new_branchRes = apiInstance.createBranch(branchId, branchCreate);
        String newBranchId = new_branchRes.getId();

        MetamodelsApi metamodelsApi = new MetamodelsApi(defaultClient);
        
        MetamodelUpdateInterface metamodelUpdateInterface = new MetamodelUpdateInterface(); // MetamodelUpdateInterface | 

        metamodelUpdateInterface.addDeleteItem(secrets.get("BLOCK_IN_TERR_VEHI_ID"));
        

        metamodelsApi.crudTemplate(newBranchId, metamodelUpdateInterface);

        // Preparing commit
        CommitMessage commitMessage = new CommitMessage(); // CommitMessage | 
        commitMessage.commitMessage("committed");
        try {
            MessageRes result = apiInstance.commitToBranch(newBranchId, commitMessage);
            System.out.println(result);
            
            // Deleting the branch
            apiInstance.deleteBranch(newBranchId);

        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#commitToBranch");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();

            // Deleting the branch
            apiInstance.deleteBranch(newBranchId);
        }
    }

     /* 2. Method that tests createBranch() */

     // createBranch() for Scenario
     @SuppressWarnings("unchecked")
     void testCreateBranchScenario(ApiClient defaultClient) throws IOException{
        Secrets secrets = new Secrets();

        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // String |

        // Create a bew branch from the main branch to perform crud() on it
        BranchCreate branchCreate = new BranchCreate(); // BranchCreate |
        branchCreate.name("New_branch3");
        try {
            BranchRes result = apiInstance.createBranch(branchId, branchCreate);
            String newBranchId = result.getId();

            // This is the clockConfig ID
            String clockConfigId = result.getData().getScenario().getClockConfig();

            System.out.println("ClockConfig for parent branch:");


            // Uncomment to print ClockConfig block
            // System.out.println(result.getData().getScenario().getBlocks().get(clockConfigId));

            BranchesApi branchesApi = new BranchesApi(defaultClient);

            System.out.println("ClockConfig before changing stopTime:");
            System.out.println(branchesApi.getBranch(newBranchId).getData().getScenario().getBlocks().get(clockConfigId));

            Double newStartTime = ((Double) ((Map<String, Object>) result.getData().getScenario().getBlocks().get(clockConfigId)).get("startTime")) + 1.0;

            // crud: change stopTime
            MetamodelUpdateInterface metamodelUpdateInterface = new MetamodelUpdateInterface(); // MetamodelUpdateInterface | 
        
            Map<String, Object> updateBlock = new HashMap<>();
            
            updateBlock.put("id", secrets.get("CLOCK_CONFIG_ID")); //
            updateBlock.put("type", "ClockConfig");
            updateBlock.put("startTime", new BigDecimal(newStartTime));
            updateBlock.put("stopTime", new BigDecimal(59914.1212));
            List<Object> list = new ArrayList<>();
            list.add(updateBlock);

            metamodelUpdateInterface.setBlocks(list);

            MetamodelsApi metamodelsApi = new MetamodelsApi();
            metamodelsApi.crudTemplate(newBranchId, metamodelUpdateInterface);

            // Commit the changed stopTime
            CommitMessage commitMessage = new CommitMessage(); // CommitMessage | 
            commitMessage.commitMessage("committed stopTime");
            branchesApi.commitToBranch(newBranchId, commitMessage);

            System.out.println("ClockConfig after changing stopTime:");
            System.out.println(branchesApi.getBranch(newBranchId).getData().getScenario().getBlocks().get(clockConfigId));

            // Delete the created branch
            EntityDeleteRes result2 = apiInstance.deleteBranch(result.getId());
            System.out.println(result2.getMessage());
        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#createBranch");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }


    // createBranch() for Spacecraft
    void testCreateBranchSpacecraft(ApiClient defaultClient) throws IOException{
        Secrets secrets = new Secrets();

        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_VEHI_ID"); // String |
        BranchCreate branchCreate = new BranchCreate(); // BranchCreate |
        branchCreate.name("New_branch3");

        try {
            BranchRes result = apiInstance.createBranch(branchId, branchCreate);
            System.out.println(result.getCreatedBy());
            EntityDeleteRes result2 = apiInstance.deleteBranch(result.getId());
            System.out.println(result2.getMessage());
        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#createBranch");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }

    // createBranch() for TerrestrialVehicle
    void testCreateBranchTerrestrialVehicle(ApiClient defaultClient) throws IOException{
        Secrets secrets = new Secrets();

        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SUPER_SAT_TERR_VEHICLE_ID"); // String |
        BranchCreate branchCreate = new BranchCreate(); // BranchCreate |
        branchCreate.name("New_branch3");

        try {
            BranchRes result = apiInstance.createBranch(branchId, branchCreate);
            System.out.println(result.getCreatedBy());
            EntityDeleteRes result2 = apiInstance.deleteBranch(result.getId());
            System.out.println(result2.getMessage());
        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#createBranch");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }

    /* 3. Method that tests deleteBranch() */
    
    // deleteBranch() for scenario
    void testDeleteBranchScenario(ApiClient defaultClient) throws IOException, ApiException{
        Secrets secrets = new Secrets();

        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // String |
        
        // Create a branch
        BranchCreate branchCreate = new BranchCreate(); // BranchCreate |
        branchCreate.name("New_branch3");
        BranchRes branchRes = apiInstance.createBranch(branchId, branchCreate);
        
        try {
            EntityDeleteRes result = apiInstance.deleteBranch(branchRes.getId()); 
            System.out.println(result.getMessage());
        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#deleteBranch");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }

    // deleteBranch() for Spacecraft
    void testDeleteBranchSpacecraft(ApiClient defaultClient) throws IOException, ApiException{
        Secrets secrets = new Secrets();
        
        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_VEHI_ID"); // String |
        
        // Create a branch
        BranchCreate branchCreate = new BranchCreate(); // BranchCreate |
        branchCreate.name("New_branch3");
        BranchRes branchRes = apiInstance.createBranch(branchId, branchCreate);
        
        try {
            EntityDeleteRes result = apiInstance.deleteBranch(branchRes.getId()); 
            System.out.println(result.getMessage());
        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#deleteBranch");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }

    // deleteBranch() for TerrestrialVehicle
    void testDeleteBranchTerrestrialVehicle(ApiClient defaultClient) throws IOException, ApiException{
        Secrets secrets = new Secrets();
        
        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SUPER_SAT_TERR_VEHICLE_ID"); // String |
        
        // Create a branch
        BranchCreate branchCreate = new BranchCreate(); // BranchCreate |
        branchCreate.name("New_branch3");
        BranchRes branchRes = apiInstance.createBranch(branchId, branchCreate);
        
        try {
            EntityDeleteRes result = apiInstance.deleteBranch(branchRes.getId()); 
            System.out.println(result.getMessage());
        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#deleteBranch");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }

    /* 4. Method that tests exportBranch() */

    // exportBranch() for Scenario
    void testExportBranchScenario(ApiClient defaultClient) throws IOException{
        Secrets secrets = new Secrets();
        
        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // String | 
        try {
            apiInstance.exportBranch(branchId);
        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#exportBranch");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }

    // exportBranch() for Spacecraft
    void testExportBranchSpacecraft(ApiClient defaultClient) throws IOException{
        Secrets secrets = new Secrets();
        
        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_VEHI_ID"); // String | 
        try {
            apiInstance.exportBranch(branchId);
        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#exportBranch");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
 
    // exportBranch() for Spacecraft
    void testExportBranchTerrestrialVehicle(ApiClient defaultClient) throws IOException{
        Secrets secrets = new Secrets();
        
        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SUPER_SAT_TERR_VEHICLE_ID"); // String | 
        try {
            apiInstance.exportBranch(branchId);
        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#exportBranch");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
    /* 5. Method that tests getBranch() */

    // getBranch() for Scenario
    void testGetBranchScenario(ApiClient defaultClient) throws IOException{

        Secrets secrets = new Secrets();
        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // String | 
        try {
        BranchRes result = apiInstance.getBranch(branchId);
        System.out.println(" The type of the branch created is: " + result.getData().getScenario().getType());
        } catch (ApiException e) {
        System.err.println("Exception when calling BranchesApi#getBranch");
        System.err.println("Status code: " + e.getCode());
        System.err.println("Reason: " + e.getResponseBody());
        System.err.println("Response headers: " + e.getResponseHeaders());
        e.printStackTrace();
        }
    }

    // getBranch() for Spacecraft
    void testGetBranchSpacecraft(ApiClient defaultClient) throws IOException{

        Secrets secrets = new Secrets();
        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_VEHI_ID"); // String | 
        try {
        BranchRes result = apiInstance.getBranch(branchId);
        System.out.println(" The type of the branch created is: " + result.getData().getSpacecraft().getType());
        } catch (ApiException e) {
        System.err.println("Exception when calling BranchesApi#getBranch");
        System.err.println("Status code: " + e.getCode());
        System.err.println("Reason: " + e.getResponseBody());
        System.err.println("Response headers: " + e.getResponseHeaders());
        e.printStackTrace();
        }
    }

     // getBranch() for TerrestrialVehicle
     void testGetTerrestrialVehicle(ApiClient defaultClient) throws IOException{

        Secrets secrets = new Secrets();
        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SUPER_SAT_TERR_VEHICLE_ID"); // String | 
        try {
        BranchRes result = apiInstance.getBranch(branchId);
        System.out.println(" The type of the branch created is: " + result.getData().getTerrestrialVehicle().getType());
        } catch (ApiException e) {
        System.err.println("Exception when calling BranchesApi#getBranch");
        System.err.println("Status code: " + e.getCode());
        System.err.println("Reason: " + e.getResponseBody());
        System.err.println("Response headers: " + e.getResponseHeaders());
        e.printStackTrace();
        }
    }

    /* 6. Method that tests getBranchChanges() */

    // getBranchChanges() for Scenario
    void testGetBranchChangesScenario(ApiClient defaultClient) throws IOException{
        Secrets secrets = new Secrets();

        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // String | 
        try {
            BranchChangesRes result = apiInstance.getBranchChanges(branchId);
            String clockConfigId1 = result.getCommitted().getScenario().getClockConfig();
            System.out.println("Committed: " + result.getCommitted().getScenario().getBlocks().get(clockConfigId1));

            String clockConfigId2 = result.getEdited().getScenario().getClockConfig();
            System.out.println("Edited: " + result.getEdited().getScenario().getBlocks().get(clockConfigId2));
        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#getBranchChanges");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
    
    // getBranchChanges() for Spacecraft
    void testGetBranchChangesSpacecraft(ApiClient defaultClient) throws IOException{
        Secrets secrets = new Secrets();

        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_VEHI_ID"); // String | 
        try {
            BranchChangesRes result = apiInstance.getBranchChanges(branchId);
            
            System.out.println("Committed: " + result.getCommitted().getSpacecraft().getBlocks().get(secrets.get("BLOCK_IN_VEHI_ID")));

            System.out.println("Edited: " + result.getCommitted().getSpacecraft().getBlocks().get(secrets.get("BLOCK_IN_VEHI_ID")));
        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#getBranchChanges");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }

    
    // getBranchChanges() for TerrestrialVehicle
    void testGetBranchChangesTerrestrialVehicle(ApiClient defaultClient) throws IOException, ApiException{
        Secrets secrets = new Secrets();

        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SUPER_SAT_TERR_VEHICLE_ID"); // String | 

        try {
            BranchChangesRes result = apiInstance.getBranchChanges(branchId);

            System.out.println("Committed: " + result.getCommitted().getTerrestrialVehicle().getBlocks().get(secrets.get("BLOCK_IN_TERR_VEHI_ID")));

            System.out.println("Edited: " + result.getCommitted().getTerrestrialVehicle().getBlocks().get(secrets.get("BLOCK_IN_TERR_VEHI_ID")));

        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#getBranchChanges");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }

    /* 7. Method that tests getCommittedBranchChanges() */

    // getCommittedBranchChanges() for Scenario
    void testGetCommittedBranchDataScenario(ApiClient defaultClient) throws IOException, ApiException{
        Secrets secrets = new Secrets();

        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // String |

        // Create a new branch to commit changes to it and get the committed changes
        BranchCreate branchCreate = new BranchCreate(); // BranchCreate |
        branchCreate.name("newBranch");
        BranchRes branchRes = apiInstance.createBranch(branchId, branchCreate);
        
        String newBranchId = branchRes.getId();
        
        // crud: change stopTime
        MetamodelUpdateInterface metamodelUpdateInterface = new MetamodelUpdateInterface(); // MetamodelUpdateInterface | 
      
        Map<String, Object> updateBlock = new HashMap<>();
        
        updateBlock.put("id", secrets.get("CLOCK_CONFIG_ID")); //
        updateBlock.put("type", "ClockConfig");
        updateBlock.put("startTime", new BigDecimal(59911.0));
        updateBlock.put("stopTime", new BigDecimal(59914.3131));
        List<Object> list = new ArrayList<>();
        list.add(updateBlock);
        
        metamodelUpdateInterface.setBlocks(list);

        MetamodelsApi metamodelsApi = new MetamodelsApi();
        metamodelsApi.crudTemplate(newBranchId, metamodelUpdateInterface);

        // Commit the changed stopTime
        BranchesApi branchesApi = new BranchesApi(defaultClient);

        // Preparing commit
        CommitMessage commitMessage = new CommitMessage(); // CommitMessage | 
        commitMessage.commitMessage("committed stopTime");
        branchesApi.commitToBranch(newBranchId, commitMessage);

        try {
            ResponseGetCommittedBranchData  result = apiInstance.getCommittedBranchData(newBranchId);
            System.out.println("Committed: " + result.getScenario().getBlocks().get(result.getScenario().getClockConfig()));

            // Deleting the new branch
            apiInstance.deleteBranch(newBranchId);
        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#getCommittedBranchData");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();

            // Deleting the new branch
            apiInstance.deleteBranch(newBranchId);
        }
    }

    // getCommittedBranchChanges() for Spacecraft
    void testGetCommittedBranchDataSpacecraft(ApiClient defaultClient) throws IOException, ApiException{
        Secrets secrets = new Secrets();

        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_VEHI_ID"); // String | 

        // Create a new branch to commit changes to it and get the committed changes
        BranchCreate branchCreate = new BranchCreate(); // BranchCreate |
        branchCreate.name("newBranch");
        BranchRes branchRes = apiInstance.createBranch(branchId, branchCreate);
        
        String newBranchId = branchRes.getId();


        MetamodelsApi metamodelsApi = new MetamodelsApi(defaultClient);
        
        MetamodelUpdateInterface metamodelUpdateInterface = new MetamodelUpdateInterface(); // MetamodelUpdateInterface | 

        // Deleting a block in blocks
        String blockToRemoveId = secrets.get("BLOCK_IN_VEHI_ID");
        metamodelUpdateInterface.addDeleteItem(blockToRemoveId);
   
        metamodelsApi.crudTemplate(newBranchId, metamodelUpdateInterface);
        
        // Commit to new branch
        CommitMessage commitMessage = new CommitMessage(); // CommitMessage | 
        
        commitMessage.commitMessage( "commit: deleted block with block ID " + blockToRemoveId);
        
        apiInstance.commitToBranch(newBranchId, commitMessage);
 
        try {
            ResponseGetCommittedBranchData  result = apiInstance.getCommittedBranchData(newBranchId);
            System.out.println("Committed: " + result.getSpacecraft().getBlocks().get(blockToRemoveId));

            // Deleting the new branch
            apiInstance.deleteBranch(newBranchId);

        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#getCommittedBranchData");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();

            // Deleting the new branch
            apiInstance.deleteBranch(newBranchId);
        }
    }

    /* 8. Method that tests getSavedBranchData() */

    // getSavedBranchData() for Scenario
    void testGetSavedBranchDataScenario(ApiClient defaultClient) throws IOException, ApiException{
        Secrets secrets = new Secrets();

        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // String | 

        // crud: change stopTime without committing
        MetamodelUpdateInterface metamodelUpdateInterface = new MetamodelUpdateInterface(); // MetamodelUpdateInterface | 
      
        Map<String, Object> updateBlock = new HashMap<>();
        
        updateBlock.put("id", secrets.get("CLOCK_CONFIG_ID")); //
        updateBlock.put("type", "ClockConfig");
        updateBlock.put("startTime", new BigDecimal(59911.0));
        updateBlock.put("stopTime", new BigDecimal(59914.1111));
        List<Object> list = new ArrayList<>();
        list.add(updateBlock);

        metamodelUpdateInterface.setBlocks(list);

        MetamodelsApi metamodelsApi = new MetamodelsApi();
        metamodelsApi.crudTemplate(branchId, metamodelUpdateInterface);
        try {
            ResponseGetSavedBranchData result = apiInstance.getSavedBranchData(branchId);  
            System.out.println("Saved: " + result.getScenario().getBlocks().get(result.getScenario().getClockConfig()));

        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#getSavedBranchData");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }

    // getSavedBranchData() for Spacecraft
    void testGetSavedBranchDataSpacecraft(ApiClient defaultClient) throws IOException, ApiException{
        Secrets secrets = new Secrets();

        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_VEHI_ID"); // String | 

        // Create a new branch to commit changes to it and get the committed changes
        BranchCreate branchCreate = new BranchCreate(); // BranchCreate |
        branchCreate.name("newBranch");
        BranchRes branchRes = apiInstance.createBranch(branchId, branchCreate);
        
        String newBranchId = branchRes.getId();


        MetamodelsApi metamodelsApi = new MetamodelsApi(defaultClient);
        
        MetamodelUpdateInterface metamodelUpdateInterface = new MetamodelUpdateInterface(); // MetamodelUpdateInterface | 

        // Deleting a block in blocks
        String blockToRemoveId = secrets.get("BLOCK_IN_VEHI_ID");
        metamodelUpdateInterface.addDeleteItem(blockToRemoveId);
   
        metamodelsApi.crudTemplate(newBranchId, metamodelUpdateInterface);

        try {
            ResponseGetSavedBranchData result = apiInstance.getSavedBranchData(newBranchId);
            System.out.println("Saved: " + result.getSpacecraft().getBlocks().get(blockToRemoveId));

            // Deleting the new branch
            apiInstance.deleteBranch(newBranchId);

        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#getSavedBranchData");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();

            // Deleting the new branch
            apiInstance.deleteBranch(newBranchId);
        }
    }

    /* 9. Method that tests mergeBranches() */

    // mergeBranches() for Scenario
    void testMergeBranchesScenario(ApiClient defaultClient) throws IOException, ApiException{
        Secrets secrets = new Secrets();

        BranchesApi apiInstance = new BranchesApi(defaultClient);

        // main branch id
        String branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // String |
        
        // Create a two new branches to test merging them
        BranchCreate branchCreate = new BranchCreate(); // BranchCreate |

        branchCreate.name("currentBranch");
        
        BranchRes currentBranch = apiInstance.createBranch(branchId, branchCreate);

        String currentBranchId = currentBranch.getId();
        
        branchCreate.name("incomingBranch");

        BranchRes incomingBranch = apiInstance.createBranch(branchId, branchCreate);
        
        String incomingBranchId = incomingBranch.getId();


        MetamodelsApi metamodelsApi = new MetamodelsApi(defaultClient);
        
        MetamodelUpdateInterface metamodelUpdateInterface = new MetamodelUpdateInterface(); // MetamodelUpdateInterface | 

        // Deleting a block in blocks
        String blockToRemoveId = secrets.get("BLOCK_IN_SCEN_ID");
        metamodelUpdateInterface.addDeleteItem(blockToRemoveId);
   
        metamodelsApi.crudTemplate(incomingBranchId, metamodelUpdateInterface);
        
        // Commit to new branch
        CommitMessage commitMessage = new CommitMessage(); // CommitMessage | 
        commitMessage.commitMessage( "commit: deleted block with block ID " + blockToRemoveId);
        apiInstance.commitToBranch(currentBranchId, commitMessage);
        apiInstance.commitToBranch(incomingBranchId, commitMessage);
        
        // Uncomment to check if block with specified block ID was deleted (is null) in the committed changes
        // System.out.println("deletedBlock: " + apiInstance.getCommittedBranchData(incomingBranchId).getBlocks().get(blockToRemoveId));

        // Merge the two newly created branches
        BranchMerge branchMerge = new BranchMerge(); // BranchMerge | 
        try {
            ResponseMergeBranches result = apiInstance.mergeBranches(currentBranchId, incomingBranchId, branchMerge);

            System.out.println("Merged " + incomingBranch.getName() + " into " + currentBranch.getName());
            System.out.println("Date merged branch was modified: " + result.getBranchRes().getDateModified());

            // Delete new branches
            apiInstance.deleteBranch(incomingBranchId);
            apiInstance.deleteBranch(currentBranchId);
        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#mergeBranches");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();

            // Delete new Branches
            apiInstance.deleteBranch(incomingBranchId);
            apiInstance.deleteBranch(currentBranchId);
        }
    }

    // mergeBranches() for Spacecraft
    void testMergeBranchesSpacecraft(ApiClient defaultClient) throws IOException, ApiException{
        Secrets secrets = new Secrets();

        BranchesApi apiInstance = new BranchesApi(defaultClient);

        // main branch id
        String branchId = secrets.get("SIMPLE_SAT_VEHI_ID"); // String |
        
        // Create a two new branches to test merging them
        BranchCreate branchCreate = new BranchCreate(); // BranchCreate |

        branchCreate.name("currentBranch");
        
        BranchRes currentBranch = apiInstance.createBranch(branchId, branchCreate);

        String currentBranchId = currentBranch.getId();
        
        branchCreate.name("incomingBranch");

        BranchRes incomingBranch = apiInstance.createBranch(branchId, branchCreate);
        
        String incomingBranchId = incomingBranch.getId();


        MetamodelsApi metamodelsApi = new MetamodelsApi(defaultClient);
        
        MetamodelUpdateInterface metamodelUpdateInterface = new MetamodelUpdateInterface(); // MetamodelUpdateInterface | 

        // Deleting a block in blocks
        String blockToRemoveId = secrets.get("BLOCK_IN_VEHI_ID");
        metamodelUpdateInterface.addDeleteItem(blockToRemoveId);
   
        metamodelsApi.crudTemplate(incomingBranchId, metamodelUpdateInterface);
        
        // Commit to new branch
        CommitMessage commitMessage = new CommitMessage(); // CommitMessage | 
        
        commitMessage.commitMessage( "commit: deleted block with block ID " + blockToRemoveId);
        apiInstance.commitToBranch(currentBranchId, commitMessage);
        apiInstance.commitToBranch(incomingBranchId, commitMessage);
        
        // Check if block with specified block ID was deleted (is null) in the committed changes
        // System.out.println("deletedBlock: " + apiInstance.getCommittedBranchData(incomingBranchId).getBlocks().get(blockToRemoveId));

        // Merge the two newly created branches
        BranchMerge branchMerge = new BranchMerge(); // BranchMerge | 
        try {
            ResponseMergeBranches result = apiInstance.mergeBranches(currentBranchId, incomingBranchId, branchMerge);
            
            System.out.println("Merged " + incomingBranch.getName() + " into " + currentBranch.getName());
            System.out.println("Date merged branch was modified: " + result.getBranchRes().getDateModified());
    
            // Delete new branches
            apiInstance.deleteBranch(incomingBranchId);
            apiInstance.deleteBranch(currentBranchId);
        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#mergeBranches");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();

            // Delete new Branches
            apiInstance.deleteBranch(incomingBranchId);
            apiInstance.deleteBranch(currentBranchId);
        }
    }

    /* 10. Method that tests updateBranch() */
    
    // updateBranch() for Scenario
    void testUpdateBranchScenario(ApiClient defaultClient) throws IOException{
        Secrets secrets = new Secrets();

        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // String | 
        BranchUpdate branchUpdate = new BranchUpdate(); // BranchUpdate | 
        branchUpdate.setDescription("DESCRIPTION");
        
        try {
            BranchRes result = apiInstance.updateBranch(branchId, branchUpdate);
            
            System.out.println("Updated: " + result.getDateModified());

        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#updateBranch");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }

    // updateBranch() for Spacecraft
    void testUpdateBranchSpacecraft(ApiClient defaultClient) throws IOException{
        Secrets secrets = new Secrets();

        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_VEHI_ID"); // String | 
        BranchUpdate branchUpdate = new BranchUpdate(); // BranchUpdate | 
        branchUpdate.setDescription("DESCRIPTION");
        
        try {
            BranchRes result = apiInstance.updateBranch(branchId, branchUpdate);
            
            System.out.println("Updated: " + result.getDateModified());

        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#updateBranch");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }

    /* 11. Method that tests verifyBranchPassword() */
    
    // verifyBranchPassword() for Scenario
    void testVerifyBranchPasswordScenario(ApiClient defaultClient) throws IOException{
        Secrets secrets = new Secrets();

        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("protectedBranchScen_ID"); // String | 
        BranchVerifyPassword branchVerifyPassword = new BranchVerifyPassword(); // BranchVerifyPassword | 
        branchVerifyPassword.password(secrets.get("password"));
        try {
            MessageRes result = apiInstance.verifyBranchPassword(branchId, branchVerifyPassword);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#verifyBranchPassword");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }

    // verifyBranchPassword() for Scenario
    void testVerifyBranchPasswordSpacecraft(ApiClient defaultClient) throws IOException{
        Secrets secrets = new Secrets();

        BranchesApi apiInstance = new BranchesApi(defaultClient);
        String branchId = secrets.get("protectedBranchVehi_ID"); // String | 
        BranchVerifyPassword branchVerifyPassword = new BranchVerifyPassword(); // BranchVerifyPassword | 
        branchVerifyPassword.password(secrets.get("password"));
        try {
            MessageRes result = apiInstance.verifyBranchPassword(branchId, branchVerifyPassword);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BranchesApi#verifyBranchPassword");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }


    /* --------------------------------- DataApi Testing ------------------------------------- */

    /* 12. Method that tests getData() */

    // getData() for Scenario
    void testGetDataScenario(ApiClient defaultClient) throws IOException, ApiException, InterruptedException{

        Secrets secrets = new Secrets();

        // Create a DataApi
        DataApi dataApi = new DataApi(defaultClient);

        // Start a new simulation job
        JobsApi jobsApi = new JobsApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // String | The ID of the Scenario Branch to start a simulation for.
        StartSimulationBody startSimulationBody = new StartSimulationBody(); // StartSimulationBody | 
        
        SimulationJob simulationJob = jobsApi.startSimulation(branchId, startSimulationBody);
        String jobId = simulationJob.getId();
        String status = simulationJob.getStatus().toString();

        // Keep getting simulation simulation is 'RUNNING'
        while(!status.equals("RUNNING")){

            
            // Get status
            status = jobsApi.getSimulation(branchId, jobId).getStatus().toString();
    
            System.out.println("Waiting for simulation to start (ID: " + jobId + "). Current status: " + "'" + status + "'");
            Thread.sleep(5000);
        }
        
        System.out.println("Simulation started.");

        // Uncomment if you want to print SimulationJob
        // System.out.println(jobsApi.getSimulation(branchId, simulationJob.getId()));

        
        String id = jobsApi.getSimulation(branchId, simulationJob.getId()).getDataArray();

        BigDecimal start = null;
        BigDecimal stop = null;
        String streams = null;
        String streamsToken = null;
        String shape = null;
        String axisOrder = null;
        Integer binWidth = null;
        Integer sampleRate = 1024; // Need to be power of two
        String continuationToken = null;
        String encoding = null;

        try {
            DataServiceResponse response = dataApi.getData(id, start, stop, streams, streamsToken, shape, axisOrder, binWidth, sampleRate, continuationToken, encoding);
            System.out.println(response.getSeries());

            // Terminate Simulation
            MessageRes messageRes = jobsApi.terminateSimulation(branchId, simulationJob.getId());
            System.out.println(messageRes.getMessage());

        } catch (ApiException e) {
            System.err.println("Exception when calling DataApi#getData");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();

            // Terminate Simulation
            MessageRes messageRes = jobsApi.terminateSimulation(branchId, simulationJob.getId());
            System.out.println(messageRes.getMessage());
        }
    }


    /* --------------------------------- ExternalsApi Testing ------------------------------------- */

    /* 13. Method that tests getExternal() */ 

    // getExternal() for Scenario
    void testGetExternalScenario(ApiClient defaultClient) throws IOException, ApiException, InterruptedException{

        Secrets secrets = new Secrets();

        // Create an ExternalsApi
        ExternalsApi externalsApi = new ExternalsApi(defaultClient);
        

        // Start a new simulation job
        JobsApi jobsApi = new JobsApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // String | The ID of the Scenario Branch to start a simulation for.
        StartSimulationBody startSimulationBody = new StartSimulationBody(); // StartSimulationBody | 
        
        SimulationJob simulationJob = jobsApi.startSimulation(branchId, startSimulationBody);
        String jobId = simulationJob.getId(); // String | 
         
        String status = simulationJob.getStatus().toString();

        // Keep getting simulation simulation is 'RUNNING'
        while(!status.equals("RUNNING")){

            
            // Get status
            status = jobsApi.getSimulation(branchId, jobId).getStatus().toString();
    
            System.out.println("Waiting for simulation to start (ID: " + jobId + "). Current status: " + "'" + status + "'");
            Thread.sleep(1000);
        }
        
        System.out.println("Simulation started.");

        Thread.sleep(1000);        
        
        // Uncomment if you want to print SimulationJob
        // System.out.println(jobsApi.getSimulation(branchId, jobId));
        
        String agentId = secrets.get("AGENT_EXTERNAL_ID"); // EXTERNAL_STATE_BLOCK_ID
        
        String externalStateBlockId = secrets.get("EXTERNAL_STATE_BLOCK_ID"); // String | 

        BigDecimal time = null; // new BigDecimal(5000); // BigDecimal | 
        
        try {
            // Keep getting externals in a loop
            int counter = 0;
            List<Object> result;
            while(counter < 7){
                result = externalsApi.getExternal(jobId, agentId, externalStateBlockId, time);
                System.out.println(result);
                Thread.sleep(5000);
                counter++;
            }
            
            // Terminate Simulation
            MessageRes messageRes = jobsApi.terminateSimulation(branchId, simulationJob.getId());
            System.out.println(messageRes.getMessage());

        } catch (ApiException e) {
            System.err.println("Exception when calling ExternalsApi#getExternal");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
            
            // Terminate Simulation
            MessageRes messageRes = jobsApi.terminateSimulation(branchId, simulationJob.getId());
            System.out.println(messageRes.getMessage());

        }
    }     
        
    /* 14. Method that tests putExternal() */

    // putExternal() for Scenario 
    void testPutExternalScenario(ApiClient defaultClient) throws IOException, ApiException, InterruptedException{

        Secrets secrets = new Secrets();

        // Create an ExternalsApi
        ExternalsApi externalsApi = new ExternalsApi(defaultClient);

        // Start a new simulation job
        JobsApi jobsApi = new JobsApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // String | The ID of the Scenario Branch to start a simulation for.
        StartSimulationBody startSimulationBody = new StartSimulationBody(); // StartSimulationBody | 
        
        SimulationJob simulationJob = jobsApi.startSimulation(branchId, startSimulationBody);
        String jobId = simulationJob.getId(); // String | 

        String status = simulationJob.getStatus().toString();

        // Keep getting simulation simulation is 'RUNNING'
        while(!status.equals("RUNNING")){

            
            // Get status
            status = jobsApi.getSimulation(branchId, jobId).getStatus().toString();
    
            System.out.println("Waiting for simulation to start (ID: " + jobId + "). Current status: " + "'" + status + "'");
            Thread.sleep(1000);
        }
        
        System.out.println("Simulation started.");
        
        // Uncomment if you want to print SimulationJob
        // System.out.println(jobsApi.getSimulation(branchId, jobId));
        
        String agentId = secrets.get("AGENT_EXTERNAL_ID"); // EXTERNAL_STATE_BLOCK_ID
        
        String externalStateBlockId = secrets.get("EXTERNAL_STATE_BLOCK_ID"); // String | 

        ExternalStateSetRequest externalStateSetRequest = new ExternalStateSetRequest(); // ExternalStateSetRequest | 
        
        try {
            // Keep putting externals in a loop
            int counter = 0;
            while(counter < 7){

            List<BigDecimal> valueList = new ArrayList<>();
            valueList.add(new BigDecimal(11.11));
            valueList.add(new BigDecimal(22.22));
            valueList.add(new BigDecimal(33.33));
            
            externalStateSetRequest.values(valueList);
            
            List<Object> result = externalsApi.putExternal(jobId, agentId, externalStateBlockId, externalStateSetRequest);
            System.out.println(result);

            Thread.sleep(5000);
            counter++;
            
            }
            
            // Terminate Simulation
            MessageRes messageRes = jobsApi.terminateSimulation(branchId, simulationJob.getId());
            System.out.println(messageRes.getMessage());

        } catch (ApiException e) {
            System.err.println("Exception when calling ExternalsApi#putExternal");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();

            // Terminate Simulation
            MessageRes messageRes = jobsApi.terminateSimulation(branchId, simulationJob.getId());
            System.out.println(messageRes.getMessage());

        }
    } 
    
    // /* --------------------------------- Simulation Testing Methods ------------------------------------- */
     
    /* 15. Method that tests StartSimulationBody */

    //  StartSimulationBody for Scenario
    void testStartSimulationBodyScenario(ApiClient defaultClient) throws IOException, InterruptedException{

        Secrets secrets = new Secrets();
        JobsApi apiInstance = new JobsApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // String | The ID of the Scenario Branch to start a simulation for.
        StartSimulationBody startSimulationBody = new StartSimulationBody(); // StartSimulationBody | 
        
        try {
            SimulationJob result = apiInstance.startSimulation(branchId, startSimulationBody);
            System.out.println(result);

            // Terminate Simulation
            apiInstance.terminateSimulation(branchId, result.getId());
        } catch (ApiException e) {
            System.err.println("Exception when calling JobsApi#startSimulation");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }

    /* 16. Method that test terminateSimulation() */

    // terminateSimulation() for Scenario
    void testTerminateSimulationScenario(ApiClient defaultClient) throws IOException, ApiException, InterruptedException{
        Secrets secrets = new Secrets();
        JobsApi apiInstance = new JobsApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // String | 

        // Start simulation
        StartSimulationBody startSimulationBody = new StartSimulationBody(); // StartSimulationBody | 
        String jobId = apiInstance.startSimulation(branchId, startSimulationBody).getId();

        try {
            MessageRes result = apiInstance.terminateSimulation(branchId, jobId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling JobsApi#terminateSimulation");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();

            // Terminate Simulation
            apiInstance.terminateSimulation(branchId, jobId);
        }
    }

    /* 17. Method that test getSimulation() */

    // getSimulation() for Scenario
    void testGetSimulationScenario(ApiClient defaultClient) throws IOException, ApiException, InterruptedException{
        Secrets secrets = new Secrets();
        JobsApi apiInstance = new JobsApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // String | 

        // Start simulation
        StartSimulationBody startSimulationBody = new StartSimulationBody(); // StartSimulationBody | 
        String jobId = apiInstance.startSimulation(branchId, startSimulationBody).getId();

        try {
            SimulationJob result = apiInstance.getSimulation(branchId, jobId);
            System.out.println(result);

            // Terminate Simulation
            apiInstance.terminateSimulation(branchId, jobId);
        } catch (ApiException e) {
            System.err.println("Exception when calling JobsApi#getSimulation");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();

            // Terminate Simulation
            apiInstance.terminateSimulation(branchId, jobId);
        }
    }

    /* 18. Method that test getSimulations() */
    void testGetSimulationsScenario(ApiClient defaultClient) throws IOException, ApiException, InterruptedException{
        Secrets secrets = new Secrets();
        JobsApi apiInstance = new JobsApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // String | 

        String latest = ""; // String | 
        try {
            ResponseGetSimulations result = apiInstance.getSimulations(branchId, latest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling JobsApi#getSimulations");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
        }
    }


    /* ----------------------------------- Study Testing Methods --------------------------------------- */

    /* 19. Method that tests StartStudy() */ 

    // StartStudy() for Scenario
    void testStartStudyScenario(ApiClient defaultClient) throws IOException, ApiException, InterruptedException{

        Secrets secrets = new Secrets();
        JobsApi apiInstance = new JobsApi(defaultClient);
        BranchesApi branchesApi = new BranchesApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // String | 

        // Create a new branch to commit changes to it and get the committed changes
         
        BranchCreate branchCreate = new BranchCreate(); // BranchCreate |
        branchCreate.name("newBranch");
        BranchRes branchRes = branchesApi.createBranch(branchId, branchCreate);
         
        String newBranchId = branchRes.getId();

        // crud: change stopTime
        MetamodelUpdateInterface metamodelUpdateInterface = new MetamodelUpdateInterface(); // MetamodelUpdateInterface | 
      
        Map<String, Object> updateBlock = new HashMap<>();
        
        updateBlock.put("id", secrets.get("CLOCK_CONFIG_ID")); //
        updateBlock.put("type", "ClockConfig");
        updateBlock.put("startTime", new BigDecimal(59911.0));
        updateBlock.put("stopTime", new BigDecimal(59914.181));

        List<Object> list = new ArrayList<>();
        list.add(updateBlock);

        metamodelUpdateInterface.setBlocks(list);

        MetamodelsApi metamodelsApi = new MetamodelsApi();
        metamodelsApi.crudTemplate(newBranchId, metamodelUpdateInterface);

    
        // Preparing commit
        CommitMessage commitMessage = new CommitMessage(); // CommitMessage | 
        commitMessage.commitMessage("committed stopTime");
        branchesApi.commitToBranch(newBranchId, commitMessage);

        // Start study after changing stopTime
        StartStudyBody startStudyBody = new StartStudyBody(); // StartStudyBody | 
        startStudyBody.iterations(1);

        try {
            String jobId = apiInstance.startStudy(newBranchId, startStudyBody).getId();

            String status = apiInstance.getStudy(newBranchId, jobId).getStatus().toString();

            // Keep looping until study is "RUNNING" and jobs != null ans Study is running
            while(!status.equals("RUNNING") || apiInstance.getStudy(newBranchId, jobId).getSimulationJobs() == null){

                // Get status
                status = apiInstance.getStudy(newBranchId, jobId).getStatus().toString();
        
                System.out.println("Waiting for study to start (ID: " + jobId + "). Current status: " + "'" + status + "'");
                Thread.sleep(1000);
            }
            
            // Terminate Simulation created by study
            System.out.println(apiInstance.terminateSimulation(newBranchId, apiInstance.getStudy(newBranchId, jobId).getSimulationJobs().get(0)));

            // Terminate Study
            System.out.println(apiInstance.terminateStudy(newBranchId, jobId));

            // Deleting the new branch
            branchesApi.deleteBranch(newBranchId);
    
        } catch (ApiException e) {
            System.err.println("Exception when calling JobsApi#startStudy");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();

            // Deleting the new branch
            branchesApi.deleteBranch(newBranchId);
            
        }

    }

    /* 22. Method to test terminateStudy() */

    // terminateStudy() for Scenario
    void testTerminateStudyScenario(ApiClient defaultClient) throws IOException, ApiException, InterruptedException{
        Secrets secrets = new Secrets();

        JobsApi apiInstance = new JobsApi(defaultClient);
        BranchesApi branchesApi = new BranchesApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // String | 


        // Create a new branch to commit changes to it and get the committed changes
         
        BranchCreate branchCreate = new BranchCreate(); // BranchCreate |
        branchCreate.name("newBranch");
        BranchRes branchRes = branchesApi.createBranch(branchId, branchCreate);
         
        String newBranchId = branchRes.getId();

        // crud: change stopTime
        MetamodelUpdateInterface metamodelUpdateInterface = new MetamodelUpdateInterface(); // MetamodelUpdateInterface | 
      
        Map<String, Object> updateBlock = new HashMap<>();
        
        updateBlock.put("id", secrets.get("CLOCK_CONFIG_ID")); //
        updateBlock.put("type", "ClockConfig");
        updateBlock.put("startTime", new BigDecimal(59911.0));
        updateBlock.put("stopTime", new BigDecimal(59914.20003));
        List<Object> list = new ArrayList<>();
        list.add(updateBlock);

        metamodelUpdateInterface.setBlocks(list);

        MetamodelsApi metamodelsApi = new MetamodelsApi();
        metamodelsApi.crudTemplate(newBranchId, metamodelUpdateInterface);

        // We can start study even with saved but uncommitted stopTime
        StartStudyBody startStudyBody = new StartStudyBody(); // StartStudyBody | 
        startStudyBody.iterations(1);
        String jobId = apiInstance.startStudy(newBranchId, startStudyBody).getId(); // String | 

        try {
            
            String status = apiInstance.getStudy(newBranchId, jobId).getStatus().toString();

            // Keep looping until study is "RUNNING" and jobs != null ans Study is running
            while(!status.equals("RUNNING") || apiInstance.getStudy(newBranchId, jobId).getSimulationJobs() == null){

                // Get status
                status = apiInstance.getStudy(newBranchId, jobId).getStatus().toString();
        
                System.out.println("Waiting for study to start (ID: " + jobId + "). Current status: " + "'" + status + "'");
                Thread.sleep(1000);
            }
    
            // Terminate Simulation created by study
            System.out.println(apiInstance.terminateSimulation(newBranchId, apiInstance.getStudy(newBranchId, jobId).getSimulationJobs().get(0)));
            // Terminate Study
            System.out.println(apiInstance.terminateStudy(newBranchId, jobId));

            // Deleting the new branch
            branchesApi.deleteBranch(newBranchId);
            
        } catch (ApiException e) {
            System.err.println("Exception when calling JobsApi#terminateStudy");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();

            // Deleting the new branch
            branchesApi.deleteBranch(newBranchId);
        }
    }

    /* 21. Method to test getStudy() */

    // getStudy() for Scenario
    void testGetStudyScenario(ApiClient defaultClient) throws IOException, ApiException, InterruptedException{
        Secrets secrets = new Secrets();

        JobsApi apiInstance = new JobsApi(defaultClient);
        BranchesApi branchesApi = new BranchesApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // String | 

         // Create a new branch to commit changes to it and get the committed changes
         
         BranchCreate branchCreate = new BranchCreate(); // BranchCreate |
         branchCreate.name("newBranch");
         BranchRes branchRes = branchesApi.createBranch(branchId, branchCreate);
          
         String newBranchId = branchRes.getId();

        // crud: change stopTime
        MetamodelUpdateInterface metamodelUpdateInterface = new MetamodelUpdateInterface(); // MetamodelUpdateInterface | 
      
        Map<String, Object> updateBlock = new HashMap<>();
        
        updateBlock.put("id", secrets.get("CLOCK_CONFIG_ID")); //
        updateBlock.put("type", "ClockConfig");
        updateBlock.put("startTime", new BigDecimal(59911.0));
        updateBlock.put("stopTime", new BigDecimal(59914.33333));
        List<Object> list = new ArrayList<>();
        list.add(updateBlock);

        metamodelUpdateInterface.setBlocks(list);

        MetamodelsApi metamodelsApi = new MetamodelsApi();
        metamodelsApi.crudTemplate(newBranchId, metamodelUpdateInterface);

        // We can start study even with saved but uncommitted stopTime
        StartStudyBody startStudyBody = new StartStudyBody(); // StartStudyBody | 
        startStudyBody.iterations(1);

        String jobId = apiInstance.startStudy(newBranchId, startStudyBody).getId(); // String | 

        try {

            String status = apiInstance.getStudy(newBranchId, jobId).getStatus().toString();

            // Keep looping until study is "RUNNING" and jobs != null ans Study is running
            while(!status.equals("RUNNING") || apiInstance.getStudy(newBranchId, jobId).getSimulationJobs() == null){

                // Get status
                status = apiInstance.getStudy(newBranchId, jobId).getStatus().toString();
        
                System.out.println("Waiting for study to start (ID: " + jobId + "). Current status: " + "'" + status + "'");
                Thread.sleep(1000);
            }
    
            // Terminate Simulation created by study
            System.out.println(apiInstance.terminateSimulation(newBranchId, apiInstance.getStudy(newBranchId, jobId).getSimulationJobs().get(0)));
            // Terminate Study
            System.out.println(apiInstance.terminateStudy(newBranchId, jobId));

            // Deleting the new branch
            branchesApi.deleteBranch(newBranchId);

        } catch (ApiException e) {
            System.err.println("Exception when calling JobsApi#getStudy");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
            
            // Terminate Simulation created by study
            System.out.println(apiInstance.terminateSimulation(newBranchId, apiInstance.getStudy(newBranchId, jobId).getSimulationJobs().get(0)));
            // Terminate Study
            System.out.println(apiInstance.terminateStudy(newBranchId, jobId));

            // Deleting the new branch
            branchesApi.deleteBranch(newBranchId);
        }
    }

    /* 22. Method to test getStudies() */

    // getStudies() for Scenario
    void testGetStudiesScenario(ApiClient defaultClient) throws IOException, ApiException{
        Secrets secrets = new Secrets();

        JobsApi apiInstance = new JobsApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // String | 

        String latest = ""; // String | 
        try {
            ResponseGetStudies result = apiInstance.getStudies(branchId, latest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling JobsApi#getStudies");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }

    /* ----------------------------------- crudTemplate Testing Methods --------------------------------------- */

    /* 23. Method to test crudTemplate() */

    // crudTemplate() for Scenario
    void testCrudTemplateScenario(ApiClient defaultClient) throws IOException, ApiException{
        Secrets secrets = new Secrets();

        MetamodelsApi apiInstance = new MetamodelsApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // String | 

        // Create a new branch

        BranchesApi api = new BranchesApi(defaultClient);

        BranchCreate branchCreate = new BranchCreate(); // BranchCreate |
        branchCreate.name("scenarioBranch");
        BranchRes new_branchRes = api.createBranch(branchId, branchCreate);
        String newBranchId = new_branchRes.getId();
        String clockConfigId = api.getBranch(newBranchId).getData().getScenario().getClockConfig();

        // print before crud
        System.out.println("Block before changes: ");
        System.out.println(api.getBranch(newBranchId).getData().getScenario().getBlocks().get(clockConfigId));
        // crud
        MetamodelUpdateInterface metamodelUpdateInterface = new MetamodelUpdateInterface(); // MetamodelUpdateInterface | 
      
        Map<String, Object> updateBlock = new HashMap<>();
        
        updateBlock.put("id", secrets.get("CLOCK_CONFIG_ID")); //
        updateBlock.put("stopTime", new BigDecimal(59911.44444));
        updateBlock.put("type", "ClockConfig");
        List<Object> list = new ArrayList<>();
        list.add(updateBlock);

        metamodelUpdateInterface.setBlocks(list);

        try {

            // crud 
            ModelCrudRes modelCrudRes = apiInstance.crudTemplate(newBranchId, metamodelUpdateInterface);
            System.out.println("dateModified: " + modelCrudRes.getBranch().getDateModified());

            // Commit the changed stopTime
            BranchesApi branchesApi = new BranchesApi(defaultClient);

            // Preparing commit
            CommitMessage commitMessage = new CommitMessage(); // CommitMessage | 
            commitMessage.commitMessage("committed stopTime");

            System.out.println(branchesApi.commitToBranch(newBranchId, commitMessage));

            // print after crud
            System.out.println("Block after changes: changed 'stopTime'.");
            System.out.println(api.getBranch(newBranchId).getData().getScenario().getBlocks().get(clockConfigId));

            // Deleting the branch
            api.deleteBranch(newBranchId);
        } catch (ApiException e) {
            System.err.println("Exception when calling MetamodelsApi#crudTemplate");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();

            // Deleting the branch
            api.deleteBranch(newBranchId);
        }
    }

    // crudTemplate() for Spacecraft
    @SuppressWarnings("unchecked")
    void testCrudTemplateSpacecraft(ApiClient defaultClient) throws IOException, ApiException{
        Secrets secrets = new Secrets();

        MetamodelsApi apiInstance = new MetamodelsApi(defaultClient);
        String branchId = secrets.get("SIMPLE_SAT_VEHI_ID"); // String | 

        // Create a new branch

        BranchesApi api = new BranchesApi(defaultClient);

        BranchCreate branchCreate = new BranchCreate(); // BranchCreate |
        branchCreate.name("spacecraftBranch");
        BranchRes new_branchRes = api.createBranch(branchId, branchCreate);
        String newBranchId = new_branchRes.getId();
        
        String blockId = secrets.get("BLOCK_IN_VEHI_ID");

        // Negate the current disabled value and set it as the new value
        boolean newDisabled = !(Boolean)((Map<String, Object>)(api.getBranch(newBranchId).getData().getSpacecraft().getBlocks().get(blockId))).get("disabled");

        // print before crud
        System.out.println("Block before changes: ");
        System.out.println(api.getBranch(newBranchId).getData().getSpacecraft().getBlocks().get(blockId));

        // Make changes using crud
        MetamodelUpdateInterface metamodelUpdateInterface = new MetamodelUpdateInterface(); // MetamodelUpdateInterface | 
      
        Map<String, Object> updateBlock = new HashMap<>();
        
        updateBlock.put("id", blockId); 
        updateBlock.put("disabled", newDisabled);
        updateBlock.put("type", "Battery");
        
        List<Object> list = new ArrayList<>();
        list.add(updateBlock);

        metamodelUpdateInterface.setBlocks(list);

        try {

            // crud 
            ModelCrudRes modelCrudRes = apiInstance.crudTemplate(newBranchId, metamodelUpdateInterface);
            System.out.println("dateModified: " + modelCrudRes.getBranch().getDateModified());

            // Commit the changed stopTime
            BranchesApi branchesApi = new BranchesApi(defaultClient);

            // Preparing commit
            CommitMessage commitMessage = new CommitMessage(); // CommitMessage | 
            commitMessage.commitMessage("committed disabled");

            System.out.println(branchesApi.commitToBranch(newBranchId, commitMessage));

            // print after crud
            System.out.println("Block after changes: changed 'disabled'.");
            System.out.println(api.getBranch(newBranchId).getData().getSpacecraft().getBlocks().get(blockId));

            // Deleting the branch
            api.deleteBranch(newBranchId);
        } catch (ApiException e) {
            System.err.println("Exception when calling MetamodelsApi#crudTemplate");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();

            // Deleting the branch
            api.deleteBranch(newBranchId);
        }
    }


    // crudTemplate() for TerrestrialVehicle
    void testCrudTemplateTerrestrialVehicle(ApiClient defaultClient) throws IOException, ApiException{
        Secrets secrets = new Secrets();

        MetamodelsApi apiInstance = new MetamodelsApi(defaultClient);
        String branchId = secrets.get("SUPER_SAT_TERR_VEHICLE_ID"); // String | 

        // Create a new branch

        BranchesApi api = new BranchesApi(defaultClient);

        BranchCreate branchCreate = new BranchCreate(); // BranchCreate |
        branchCreate.name("terrestrialVehicleBranch");
        BranchRes new_branchRes = api.createBranch(branchId, branchCreate);
        String newBranchId = new_branchRes.getId();

        String blockId = secrets.get("BLOCK_IN_TERR_VEHI_ID");

        // print before crud
        System.out.println("Block before changes: ");
        System.out.println(api.getBranch(newBranchId).getData().getTerrestrialVehicle().getBlocks().get(blockId));

        // Make changes using crud
        MetamodelUpdateInterface metamodelUpdateInterface = new MetamodelUpdateInterface(); // MetamodelUpdateInterface | 
        Map<String, Object> updateBlock = new HashMap<>();
        
        updateBlock.put("id", blockId); 
        updateBlock.put("configurationType", "SERIES"); //configurationType is required
        updateBlock.put("disabled", true);
        updateBlock.put("type", "Battery");
        
        List<Object> list = new ArrayList<>();
        list.add(updateBlock);

        metamodelUpdateInterface.setBlocks(list);
        
        try {

            // crud 
            ModelCrudRes modelCrudRes = apiInstance.crudTemplate(newBranchId, metamodelUpdateInterface);
            System.out.println("dateModified: " + modelCrudRes.getBranch().getDateModified());

            // Commit the changed stopTime
            BranchesApi branchesApi = new BranchesApi(defaultClient);

            // Preparing commit
            CommitMessage commitMessage = new CommitMessage(); // CommitMessage | 
            commitMessage.commitMessage("committed disabled");

            System.out.println(branchesApi.commitToBranch(newBranchId, commitMessage));

            // print before crud
            System.out.println("Block after changes: changed 'disabled'.");
            System.out.println(api.getBranch(newBranchId).getData().getTerrestrialVehicle().getBlocks().get(blockId));

            // Deleting the branch
            System.out.println(api.deleteBranch(newBranchId).getMessage());
        } catch (ApiException e) {
            System.err.println("Exception when calling MetamodelsApi#crudTemplate");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();

            // Deleting the branch
            System.out.println(api.deleteBranch(newBranchId).getMessage());
        }
    }

    
    /* ----------------------------------- Repo Testing Methods --------------------------------------- */

    /* 24 .Method that tests createRepo() */

    // createRepo() for Scenario
    void testCreateRepoScenario(ApiClient defaultClient) throws IOException{
        Secrets secrets = new Secrets();

        RepositoriesApi apiInstance = new RepositoriesApi(defaultClient);

        // Prepare create request
        RepoCreateReq repoCreateReq = new RepoCreateReq(); // RepoCreateReq |
        repoCreateReq.metamodelType("Scenario");
        repoCreateReq.name("new_repo"); 
        repoCreateReq.workspace(secrets.get("WORKSPACE_ID"));
        try {
            RepoRes result = apiInstance.createRepo(repoCreateReq);
            System.out.println(result.getCreatedBy());
            
            // Deleting the repo
            System.out.println(apiInstance.deleteRepo(result.getId()));

        } catch (ApiException e) {
            System.err.println("Exception when calling RepositoriesApi#createRepo");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }

    // createRepo() for Spacecraft
    void testCreateRepoSpacecraft(ApiClient defaultClient) throws IOException{
        Secrets secrets = new Secrets();

        RepositoriesApi apiInstance = new RepositoriesApi(defaultClient);

        // Prepare create request
        RepoCreateReq repoCreateReq = new RepoCreateReq(); // RepoCreateReq |
        repoCreateReq.metamodelType("Spacecraft");
        repoCreateReq.name("new_repo"); 
        repoCreateReq.workspace(secrets.get("WORKSPACE_ID"));
        try {
            RepoRes result = apiInstance.createRepo(repoCreateReq);
            System.out.println(result.getCreatedBy());
            
            // Deleting the repo
            System.out.println(apiInstance.deleteRepo(result.getId()));

        } catch (ApiException e) {
            System.err.println("Exception when calling RepositoriesApi#createRepo");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }

    /* 25 .Method that tests deleteRepo() */
    // deleteRepo() for Scenario
    void testDeleteRepoScenario(ApiClient defaultClient) throws IOException, ApiException{
        Secrets secrets = new Secrets();

        RepositoriesApi apiInstance = new RepositoriesApi(defaultClient);

        // Create a new repo to tst deleteRepo()
        RepoCreateReq repoCreateReq = new RepoCreateReq(); // RepoCreateReq |
        repoCreateReq.metamodelType("Scenario");
        repoCreateReq.name("scenarioRepo"); 
        repoCreateReq.workspace(secrets.get("WORKSPACE_ID"));
        RepoRes repoRes = apiInstance.createRepo(repoCreateReq);

        String repositoryId = repoRes.getId(); // String | 
        try {
            EntityDeleteRes result = apiInstance.deleteRepo(repositoryId);
            System.out.println(result);

        } catch (ApiException e) {
            System.err.println("Exception when calling RepositoriesApi#deleteRepo");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
        
    }

    // deleteRepo() for Spacecraft
    void testDeleteRepoSpacecraft(ApiClient defaultClient) throws IOException, ApiException{
        Secrets secrets = new Secrets();

        RepositoriesApi apiInstance = new RepositoriesApi(defaultClient);

        // Create a new repo to tst deleteRepo()
        RepoCreateReq repoCreateReq = new RepoCreateReq(); // RepoCreateReq |
        repoCreateReq.metamodelType("Spacecraft");
        repoCreateReq.name("spacecraftRepo"); 
        repoCreateReq.workspace(secrets.get("WORKSPACE_ID"));
        RepoRes repoRes = apiInstance.createRepo(repoCreateReq);

        String repositoryId = repoRes.getId(); // String | 
        try {
            EntityDeleteRes result = apiInstance.deleteRepo(repositoryId);
            System.out.println(result);

        } catch (ApiException e) {
            System.err.println("Exception when calling RepositoriesApi#deleteRepo");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
        
    }

    /* 26. Method that tests getRepo() */

    // getRepo() for Scenario
    void testGetRepoScenario(ApiClient defaultClient) throws IOException, ApiException{
        Secrets secrets = new Secrets();

        RepositoriesApi apiInstance = new RepositoriesApi(defaultClient);

        // Create a new repo to test getRepo()
        RepoCreateReq repoCreateReq = new RepoCreateReq(); // RepoCreateReq |
        repoCreateReq.metamodelType("Scenario");
        repoCreateReq.name("scenarioRepo"); 
        repoCreateReq.workspace(secrets.get("WORKSPACE_ID"));
        RepoRes repoRes = apiInstance.createRepo(repoCreateReq);

        String repositoryId = repoRes.getId(); // String | 
        try {
            RepoRes result = apiInstance.getRepo(repositoryId);
            System.out.println(result.getName());

            // Deleting the repo
            apiInstance.deleteRepo(result.getId());

        } catch (ApiException e) {
            System.err.println("Exception when calling RepositoriesApi#getRepo");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
        
    }

    // getRepo() for Spacecraft
    void testGetRepoSpacecraft(ApiClient defaultClient) throws IOException, ApiException{
        Secrets secrets = new Secrets();

        RepositoriesApi apiInstance = new RepositoriesApi(defaultClient);

        // Create a new repo to test getRepo()
        RepoCreateReq repoCreateReq = new RepoCreateReq(); // RepoCreateReq |
        repoCreateReq.metamodelType("Spacecraft");
        repoCreateReq.name("spacecraftRepo"); 
        repoCreateReq.workspace(secrets.get("WORKSPACE_ID"));
        RepoRes repoRes = apiInstance.createRepo(repoCreateReq);

        String repositoryId = repoRes.getId(); // String | 
        try {
            RepoRes result = apiInstance.getRepo(repositoryId);
            System.out.println(result.getName());

            // Deleting the repo
            apiInstance.deleteRepo(result.getId());

        } catch (ApiException e) {
            System.err.println("Exception when calling RepositoriesApi#getRepo");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
        
    }

    /* 27. Method that tests updateRepo() */

    // updateRepo() for Scenario
    void testUpdateRepoScenario(ApiClient defaultClient) throws IOException, ApiException{
        Secrets secrets = new Secrets();

        RepositoriesApi apiInstance = new RepositoriesApi(defaultClient);

        // Create a new repo to test updateRepo()
        RepoCreateReq repoCreateReq = new RepoCreateReq(); // RepoCreateReq |
        repoCreateReq.metamodelType("Scenario");
        repoCreateReq.name("scenarioRepo"); 
        repoCreateReq.workspace(secrets.get("WORKSPACE_ID"));
        RepoRes repoRes = apiInstance.createRepo(repoCreateReq);
        String repositoryId = repoRes.getId(); // String |

        // Name before update
        System.out.println("Name before update: " + apiInstance.getRepo(repositoryId).getName());

        RepoUpdateReq repoUpdateReq = new RepoUpdateReq(); // RepoUpdateReq | 
        repoUpdateReq.setName("scenarioRepo_renamed");
        try {
            apiInstance.updateRepo(repositoryId, repoUpdateReq);

            // Name after update
            System.out.println("Name after update: " + apiInstance.getRepo(repositoryId).getName());

            // Deleting the repo
            apiInstance.deleteRepo(repositoryId);

        } catch (ApiException e) {
            System.err.println("Exception when calling RepositoriesApi#updateRepo");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
        
    }

    // updateRepo() for Spacecraft
    void testUpdateRepoSpacecraft(ApiClient defaultClient) throws IOException, ApiException{
        Secrets secrets = new Secrets();

        RepositoriesApi apiInstance = new RepositoriesApi(defaultClient);

        // Create a new repo to test updateRepo()
        RepoCreateReq repoCreateReq = new RepoCreateReq(); // RepoCreateReq |
        repoCreateReq.metamodelType("Spacecraft");
        repoCreateReq.name("spacecraftRepo"); 
        repoCreateReq.workspace(secrets.get("WORKSPACE_ID"));
        RepoRes repoRes = apiInstance.createRepo(repoCreateReq);
        String repositoryId = repoRes.getId(); // String |

        // Name before update
        System.out.println("Name before update: " + apiInstance.getRepo(repositoryId).getName());

         
        RepoUpdateReq repoUpdateReq = new RepoUpdateReq(); // RepoUpdateReq | 
        repoUpdateReq.setName("spacecraftRepo_renamed");
        try {
            apiInstance.updateRepo(repositoryId, repoUpdateReq);

            // Name after update
            System.out.println("Name after update: " + apiInstance.getRepo(repositoryId).getName());

            // Deleting the repo
            apiInstance.deleteRepo(repositoryId);

        } catch (ApiException e) {
            System.err.println("Exception when calling RepositoriesApi#updateRepo");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();

            // Deleting the repo
            apiInstance.deleteRepo(repositoryId);
        }
        
    }

}
