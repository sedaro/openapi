#include <iostream>
#include <string>
using namespace std;
#include <Secrets.h>
#include <TestFunctions.h>
#include <cpprest/details/basic_types.h>
#include <boost/optional.hpp>
#include <cstring>   // For strncmp


#include "CppRestOpenAPIClient/ApiConfiguration.h"
#include "CppRestOpenAPIClient/ApiClient.h"
#include "CppRestOpenAPIClient/api/BranchesApi.h"
#include "CppRestOpenAPIClient/api/MetamodelsApi.h"
#include "CppRestOpenAPIClient/api/DataApi.h"
#include "CppRestOpenAPIClient/api/JobsApi.h"
#include "CppRestOpenAPIClient/api/ExternalsApi.h"
#include "CppRestOpenAPIClient/api/RepositoriesApi.h"
#include "CppRestOpenAPIClient/api/RepositoriesApi.h"



// #include "CppRestOpenAPIClient/model/BranchVerifyPassword.h"

using namespace org::openapitools::client::api;
using namespace org::openapitools::client::model;


static void pop(std::string str){
    if (str.back() == '\n' || str.back() == '\r'){
        str.pop_back();
    }
}

// A function that converts an istream to a sting
static std::string istream_to_string(std::__1::shared_ptr<std::__1::istream> in)
{   
    
    std::string ret;
    char buffer[4096];
    while (in->read(buffer, sizeof(buffer)))
        ret.append(buffer, sizeof(buffer));
    ret.append(buffer, in->gcount());
    return ret;
}

// A function that a map converts to a string
static std::string map_to_string(std::__1::map<utility::string_t, utility::string_t> hmap){
    std::string ret;

    std::__1::map<utility::string_t, utility::string_t>::iterator it;
    for (it = hmap.begin(); it != hmap.end(); it++){
        utility::string_t key = it->first;
        size_t klen = key.length();

        utility::string_t val = it->second;
        size_t vlen = key.length();

        ret.append(key,klen);
        ret.append(val,vlen);

    }
    return ret;
}

// A function that prints out a Map
static void print_map(std::__1::map<utility::string_t, utility::string_t> hmap){
    
    for (auto const& pair : hmap){
        auto key = pair.first;
        auto val = pair.second;

        std::cout << key << std::endl;
        std::cout << val << std::endl;
    }

}

/* ----------------------------------- Branch Testing Methods --------------------------------------- */
// createBranch() for Scenario
void testCreateBranchScenario(std::shared_ptr<const ApiClient> defaultClient){
   
    std::string branchId;
    try {
        Secrets secrets; // Create an instance of Secrets

        branchId = secrets.get("SIMPLE_SAT_SCEN_ID");
        pop(branchId);

    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
    }
    
    std::shared_ptr<BranchesApi> branchesApi = std::make_shared<BranchesApi>(defaultClient);
    
    try{
        // Create a new branch
        std::shared_ptr<BranchCreate> branchCreate = std::make_shared<BranchCreate>();
        branchCreate->setName("New_branch_with_C++");
        pplx::task<std::shared_ptr<BranchRes>> newBranch = branchesApi->createBranch(branchId, branchCreate);

        // Get new branch ID
        std::__1::shared_ptr<BranchRes> newBranchObj = newBranch.get();
        std::string newBranchId = newBranchObj->getId();
        std::cout << newBranch.get()->getMetamodelType() << std::endl;

        // Delete new branch
        pplx::task<std::shared_ptr<EntityDeleteRes>> entityDeleteRes = branchesApi->deleteBranch(newBranchId);
        std::cout << entityDeleteRes.get()->getMessage() << std::endl;
    }catch(ApiException e){
        
        std::cout << "Exception when calling BranchesApi#createBranch-Scenario" << std::endl;
        std::cout << "Status code: " << e.error_code() << std::endl;
        std::cout << "Reason: " << istream_to_string(e.getContent()) << std::endl;
        std::cout << "Response headers:" << std::endl;
        print_map(e.getHeaders());
        std::cout << e.what() <<  std::endl;        
    }
}

// createBranch() for Spacecraft
void testCreateBranchSpacecraft(std::shared_ptr<const ApiClient> defaultClient){
    
    std::string branchId;
    try {
        Secrets secrets; // Create an instance of Secrets

        branchId = secrets.get("SIMPLE_SAT_VEHI_ID");
        pop(branchId);

    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
    }
    
    std::shared_ptr<BranchesApi> branchesApi = std::make_shared<BranchesApi>(defaultClient);
    
    try{
        // Create a new branch
        std::shared_ptr<BranchCreate> branchCreate = std::make_shared<BranchCreate>();
        branchCreate->setName("New_branch_with_C++");
        pplx::task<std::shared_ptr<BranchRes>> newBranch = branchesApi->createBranch(branchId, branchCreate);

        // Get new branch ID
        std::__1::shared_ptr<BranchRes> newBranchObj = newBranch.get();
        std::string newBranchId = newBranchObj->getId();
        std::cout<< newBranch.get()->getMetamodelType() << std::endl;

        // Delete new branch
        pplx::task<std::shared_ptr<EntityDeleteRes>> entityDeleteRes = branchesApi->deleteBranch(newBranchId);
        std::cout << entityDeleteRes.get()->getMessage() << std::endl;
    }catch(ApiException e){
        
        std::cout << "Exception when calling BranchesApi#createBranch-Spacecraft" << std::endl;
        std::cout << "Status code: " << e.error_code() << std::endl;
        std::cout << "Reason: " << istream_to_string(e.getContent()) << std::endl;
        std::cout << "Response headers:" << std::endl;
        print_map(e.getHeaders());
        std::cout << e.what() <<  std::endl;        
    }
}

// createBranch() for TerrestrialVehicle
void testCreateBranchTerrestrialVehicle(std::shared_ptr<const ApiClient> defaultClient){
    
    std::string branchId;
    try {
        Secrets secrets; // Create an instance of Secrets

        branchId = secrets.get("SUPER_SAT_TERR_VEHICLE_ID");
        pop(branchId);

    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
    }
    
    std::shared_ptr<BranchesApi> branchesApi = std::make_shared<BranchesApi>(defaultClient);
    
    try{
        // Create a new branch
        std::shared_ptr<BranchCreate> branchCreate = std::make_shared<BranchCreate>();
        branchCreate->setName("New_branch_with_C++");
        pplx::task<std::shared_ptr<BranchRes>> newBranch = branchesApi->createBranch(branchId, branchCreate);

        // Get new branch ID
        std::__1::shared_ptr<BranchRes> newBranchObj = newBranch.get();
        std::string newBranchId = newBranchObj->getId();
        std::cout << newBranch.get()->getMetamodelType() << std::endl;

        // Delete new branch
        pplx::task<std::shared_ptr<EntityDeleteRes>> entityDeleteRes = branchesApi->deleteBranch(newBranchId);
        std::cout << entityDeleteRes.get()->getMessage() << std::endl;
    }catch(ApiException e){
        
        std::cout << "Exception when calling BranchesApi#createBranch-TerrestrialVehicle" << std::endl;
        std::cout << "Status code: " << e.error_code() << std::endl;
        std::cout << "Reason: " << istream_to_string(e.getContent()) << std::endl;
        std::cout << "Response headers:" << std::endl;
        print_map(e.getHeaders());
        std::cout << e.what() <<  std::endl;        
    }
    
}
// getBranch() for Scenario
void testGetBranchScenario(std::shared_ptr<const ApiClient> defaultClient){

    std::string branchId;
    try {
        Secrets secrets; // Create an instance of Secrets

        branchId = secrets.get("SIMPLE_SAT_SCEN_ID");
        pop(branchId);

    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
    }
    
    std::shared_ptr<BranchesApi> branchesApi = std::make_shared<BranchesApi>(defaultClient);
    
    try{

        // Get branch
        pplx::task<std::shared_ptr<BranchRes>> branch = branchesApi->getBranch(branchId);

        std::cout << "getBranch was successful from Scenario: " << branch.get()->getName() << std::endl;

    }catch (ApiException e){
        std::cout << "Exception when calling BranchesApi#getBranch-Scenario" << std::endl;
        std::cout << "Status code: " << e.error_code() << std::endl;
        std::cout << "Reason: " << istream_to_string(e.getContent()) << std::endl;
        std::cout << "Response headers:" << std::endl;
        print_map(e.getHeaders());
        std::cout << e.what() <<  std::endl;   
    }
}
// getBranch() for Spacecraft
void testGetBranchSpacecraft(std::shared_ptr<const ApiClient> defaultClient){

    std::string branchId;
    try {
        Secrets secrets; // Create an instance of Secrets

        branchId = secrets.get("SIMPLE_SAT_VEHI_ID");
        pop(branchId);

    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
    }
    
    std::shared_ptr<BranchesApi> branchesApi = std::make_shared<BranchesApi>(defaultClient);
    
    try{

        // Get branch
        pplx::task<std::shared_ptr<BranchRes>> branch = branchesApi->getBranch(branchId);

        std::cout << "getBranch was successful from Spacecraft: " << branch.get()->getName() << std::endl;

    }catch (ApiException e){
        std::cout << "Exception when calling BranchesApi#getBranch-Spacecraft" << std::endl;
        std::cout << "Status code: " << e.error_code() << std::endl;
        std::cout << "Reason: " << istream_to_string(e.getContent()) << std::endl;
        std::cout << "Response headers:" << std::endl;
        print_map(e.getHeaders());
        std::cout << e.what() <<  std::endl;   
    }

}
// getBranch() for TerrestrialVehicle
void testGetBranchTerrestrialVehicle(std::shared_ptr<const ApiClient> defaultClient){

    std::string branchId;
    try {
        Secrets secrets; // Create an instance of Secrets

        branchId = secrets.get("SUPER_SAT_TERR_VEHICLE_ID");
        pop(branchId);

    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
    }
    
    std::shared_ptr<BranchesApi> branchesApi = std::make_shared<BranchesApi>(defaultClient);
    
    try{

        // Get branch
        pplx::task<std::shared_ptr<BranchRes>> branch = branchesApi->getBranch(branchId);

        std::cout << "getBranch was successful from TerrestrialVehicle: " << branch.get()->getName() << std::endl;

    }catch (ApiException e){
        std::cout << "Exception when calling BranchesApi#getBranch-TerrestrialVehicle" << std::endl;
        std::cout << "Status code: " << e.error_code() << std::endl;
        std::cout << "Reason: " << istream_to_string(e.getContent()) << std::endl;
        std::cout << "Response headers:" << std::endl;
        print_map(e.getHeaders());
        std::cout << e.what() <<  std::endl;   
    }
}
// commitToBranchBranch() for Scenario
void testCommitToBranchScenario(std::shared_ptr<const ApiClient> defaultClient) {

    std::string branchId;
    Secrets secrets; // Create an instance of Secrets
    try {

        branchId = secrets.get("SIMPLE_SAT_SCEN_ID");
        pop(branchId);

    } catch (const std::exception& e) {
        std::cout << "Error: " << e.what() << std::endl;
    }
    
    std::shared_ptr<BranchesApi> branchesApi = std::make_shared<BranchesApi>(defaultClient);

    // Create a new branch
    std::shared_ptr<BranchCreate> branchCreate = std::make_shared<BranchCreate>();
    branchCreate->setName("New_branch_with_C++");

    pplx::task<std::shared_ptr<BranchRes>> newBranch;
    
    try{
        
        newBranch = branchesApi->createBranch(branchId, branchCreate);
        
    } catch (ApiException e){
        
        std::cout << "Error: " << e.what() << std::endl;
    }
    
    // Get new branch ID
    std::__1::shared_ptr<BranchRes> newBranchObj = newBranch.get();
    
    std::string newBranchId = newBranchObj->getId();
    
    // Make changes to the new branch using crud()
    std::shared_ptr<MetamodelsApi> metamodelsApi = std::make_shared<MetamodelsApi>(defaultClient);
    std::shared_ptr<MetamodelUpdateInterface> metamodelUpdateInterface = std::make_shared<MetamodelUpdateInterface>();
    
    std::__1::vector<utility::string_t, std::__1::allocator<utility::string_t>> del;
    
    del.assign(1, secrets.get("BLOCK_IN_SCEN_ID"));

    metamodelUpdateInterface->setRDelete(del); 
    metamodelsApi->crudTemplate(newBranchId, metamodelUpdateInterface);
    
    // Preparing commit message
    std::shared_ptr<CommitMessage> commitMessage = std::make_shared<CommitMessage>();
    commitMessage->setCommitMessage("Committed to Scenario");
    try{
        pplx::task<std::shared_ptr<MessageRes>> messageRes = branchesApi->commitToBranch(newBranchId, commitMessage);
        std::cout << messageRes.get()->getMessage() << std::endl;
        
        // Delete new branch
        pplx::task<std::shared_ptr<EntityDeleteRes>> entityDeleteRes = branchesApi->deleteBranch(newBranchId);
        std::cout << entityDeleteRes.get()->getMessage() << std::endl;

    }catch(ApiException e){
        
        std::cout << "Exception when calling BranchesApi#commitToBranch-Scenario" << std::endl;
        std::cout << "Status code: " << e.error_code() << std::endl;
        std::cout << "Reason: " << istream_to_string(e.getContent()) << std::endl;
        std::cout << "Response headers:" << std::endl;
        print_map(e.getHeaders());
        std::cout << e.what() <<  std::endl;

        // Delete new branch
        pplx::task<std::shared_ptr<EntityDeleteRes>> entityDeleteRes = branchesApi->deleteBranch(newBranchId);
        std::cout << entityDeleteRes.get()->getMessage() << std::endl;
    }

}
// commitToBranchBranch() for Spacecraft
void testCommitToBranchSpacecraft(std::shared_ptr<const ApiClient> defaultClient){

    std::string branchId;
    Secrets secrets; // Create an instance of Secrets
    try {

        branchId = secrets.get("SIMPLE_SAT_VEHI_ID");
        pop(branchId);

    } catch (const std::exception& e) {
        std::cout << "Error: " << e.what() << std::endl;
    }
    
    std::shared_ptr<BranchesApi> branchesApi = std::make_shared<BranchesApi>(defaultClient);

    // Create a new branch
    std::shared_ptr<BranchCreate> branchCreate = std::make_shared<BranchCreate>();
    branchCreate->setName("New_branch_with_C++");

    pplx::task<std::shared_ptr<BranchRes>> newBranch;
    
    try{
        
        newBranch = branchesApi->createBranch(branchId, branchCreate);
        
    } catch (ApiException e){
        
        std::cout << "Error: " << e.what() << std::endl;
    }
    
    // Get new branch ID
    std::__1::shared_ptr<BranchRes> newBranchObj = newBranch.get();
    
    std::string newBranchId = newBranchObj->getId();
    
    // Make changes to the new branch using crud()
    std::shared_ptr<MetamodelsApi> metamodelsApi = std::make_shared<MetamodelsApi>(defaultClient);
    std::shared_ptr<MetamodelUpdateInterface> metamodelUpdateInterface = std::make_shared<MetamodelUpdateInterface>();
    
    std::__1::vector<utility::string_t, std::__1::allocator<utility::string_t>> del;
    
    del.assign(1, secrets.get("BLOCK_IN_VEHI_ID"));

    metamodelUpdateInterface->setRDelete(del); 
    
    metamodelsApi->crudTemplate(newBranchId, metamodelUpdateInterface);
    
    // Preparing commit message
    std::shared_ptr<CommitMessage> commitMessage = std::make_shared<CommitMessage>();
    commitMessage->setCommitMessage("Committed to Spacecraft");
    try{
        pplx::task<std::shared_ptr<MessageRes>> messageRes = branchesApi->commitToBranch(newBranchId, commitMessage);
        std::cout << messageRes.get()->getMessage() << std::endl;

        // Delete new branch
        pplx::task<std::shared_ptr<EntityDeleteRes>> entityDeleteRes = branchesApi->deleteBranch(newBranchId);
        std::cout << entityDeleteRes.get()->getMessage() << std::endl;

    }catch(ApiException e){
        
        std::cout << "Exception when calling BranchesApi#commitToBranch-Spacecraft" << std::endl;
        std::cout << "Status code: " << e.error_code() << std::endl;
        std::cout << "Reason: " << istream_to_string(e.getContent()) << std::endl;
        std::cout << "Response headers:" << std::endl;
        print_map(e.getHeaders());
        std::cout << e.what() <<  std::endl;

        // Delete new branch
        pplx::task<std::shared_ptr<EntityDeleteRes>> entityDeleteRes = branchesApi->deleteBranch(newBranchId);
        std::cout << entityDeleteRes.get()->getMessage() << std::endl;
    }
    

}
// commitToBranchBranch() for TerrestrialVehicle
void testCommitToBranchTerrestrialVehicle(std::shared_ptr<const ApiClient> defaultClient){

    std::string branchId;
    Secrets secrets; // Create an instance of Secrets
    try {

        branchId = secrets.get("SUPER_SAT_TERR_VEHICLE_ID");
        pop(branchId);

    } catch (const std::exception& e) {
        std::cout << "Error: " << e.what() << std::endl;
    }
    
    std::shared_ptr<BranchesApi> branchesApi = std::make_shared<BranchesApi>(defaultClient);

    // Create a new branch
    std::shared_ptr<BranchCreate> branchCreate = std::make_shared<BranchCreate>();
    branchCreate->setName("New_branch_with_C++");

    pplx::task<std::shared_ptr<BranchRes>> newBranch;
    
    try{
        
        newBranch = branchesApi->createBranch(branchId, branchCreate);
        
    } catch (ApiException e){
        
        std::cout << "Error: " << e.what() << std::endl;
    }
    
    // Get new branch ID
    std::__1::shared_ptr<BranchRes> newBranchObj = newBranch.get();
    
    std::string newBranchId = newBranchObj->getId();
    
    // Make changes to the new branch using crud()
    std::shared_ptr<MetamodelsApi> metamodelsApi = std::make_shared<MetamodelsApi>(defaultClient);
    std::shared_ptr<MetamodelUpdateInterface> metamodelUpdateInterface = std::make_shared<MetamodelUpdateInterface>();
    
    std::__1::vector<utility::string_t, std::__1::allocator<utility::string_t>> del;
    
    del.assign(1, secrets.get("BLOCK_IN_TERR_VEHI_ID"));

    metamodelUpdateInterface->setRDelete(del); 
    metamodelsApi->crudTemplate(newBranchId, metamodelUpdateInterface);
    
    // Preparing commit message
    std::shared_ptr<CommitMessage> commitMessage = std::make_shared<CommitMessage>();
    commitMessage->setCommitMessage("Committed to TerrestrialVehicle");
    try{
        pplx::task<std::shared_ptr<MessageRes>> messageRes = branchesApi->commitToBranch(newBranchId, commitMessage);
        std::cout << messageRes.get()->getMessage() << std::endl;

        // Delete new branch
        pplx::task<std::shared_ptr<EntityDeleteRes>> entityDeleteRes = branchesApi->deleteBranch(newBranchId);
        std::cout << entityDeleteRes.get()->getMessage() << std::endl;

    }catch(ApiException e){
        
        std::cout << "Exception when calling BranchesApi#commitToBranch-TerrestrialVehicle" << std::endl;
        std::cout << "Status code: " << e.error_code() << std::endl;
        std::cout << "Reason: " << istream_to_string(e.getContent()) << std::endl;
        std::cout << "Response headers:" << std::endl;
        print_map(e.getHeaders());
        std::cout << e.what() <<  std::endl;

        // Delete new branch
        pplx::task<std::shared_ptr<EntityDeleteRes>> entityDeleteRes = branchesApi->deleteBranch(newBranchId);
        std::cout << entityDeleteRes.get()->getMessage() << std::endl;
    
    }

}

// verifyBranchPassword() for TerrestrialVehicle
void testVerifyBranchPasswordTerrestrialVehicle(std::shared_ptr<const ApiClient> defaultClient){

    std::string branchId;
    Secrets secrets; // Create an instance of Secrets
    try {

        branchId = secrets.get("protectedBranchTerr_ID");
        pop(branchId);

    } catch (const std::exception& e) {
        std::cout << "Error: " << e.what() << std::endl;
    }
    
    std::shared_ptr<BranchesApi> branchesApi = std::make_shared<BranchesApi>(defaultClient);

    std::shared_ptr<BranchVerifyPassword> branchVerifyPassword = std::make_shared<BranchVerifyPassword>();
    branchVerifyPassword->setPassword(secrets.get("password"));

    try {
        pplx::task<std::shared_ptr<MessageRes>> messageRes = branchesApi->verifyBranchPassword(branchId, branchVerifyPassword);
        std::cout << messageRes.get()->getMessage() << std::endl;
        
    } catch (ApiException e) {
        std::cout << "Exception when calling BranchesApi#verifyBranchPassword-TerrestrialVehicle" << std::endl;
        std::cout << "Status code: " << e.error_code() << std::endl;
        std::cout << "Reason: " << istream_to_string(e.getContent()) << std::endl;
        std::cout << "Response headers:" << std::endl;
        print_map(e.getHeaders());
        std::cout << e.what() <<  std::endl;        
    }
}

// startStudy() for Scenario
void testMergeBranchesTerrestrialVehicle(std::shared_ptr<const ApiClient> defaultClient){

    // main branch id
    std::string branchId;
    Secrets secrets; // Create an instance of Secrets
    try {

        branchId = secrets.get("SUPER_SAT_TERR_VEHICLE_ID");
        pop(branchId);

    } catch (const std::exception& e) {
        std::cout << "Error: " << e.what() << std::endl;
    }
    
    std::shared_ptr<BranchesApi> branchesApi = std::make_shared<BranchesApi>(defaultClient);

    
    // Create a two new branches to test merging them

    std::shared_ptr<BranchCreate> branchCreate = std::make_shared<BranchCreate>();

    // Create currentBranch
    branchCreate->setName("New_branch1_C++");

    pplx::task<std::shared_ptr<BranchRes>> new_branchRes1;
    
    try{
        
        new_branchRes1 = branchesApi->createBranch(branchId, branchCreate);
        
    } catch (ApiException e){
        
        std::cout << "Error: " << e.what() << std::endl;
    }

    // Get currentBranch ID
    std::__1::shared_ptr<BranchRes> newBranchObj1 = new_branchRes1.get();
    
    std::string currentBranchId = newBranchObj1->getId();

    // Create incomingBranch
    branchCreate->setName("New_branch2_C++");

    pplx::task<std::shared_ptr<BranchRes>> new_branchRes2;
    
    try{
        
        new_branchRes2 = branchesApi->createBranch(branchId, branchCreate);
        
    } catch (ApiException e){
        
        std::cout << "Error: " << e.what() << std::endl;
    }

    // Get incomingBranch ID
    std::__1::shared_ptr<BranchRes> newBranchObj2 = new_branchRes2.get();
    
    std::string incomingBranchId = newBranchObj2->getId();

    // Make changes to the incomingBranch using crud()
    std::shared_ptr<MetamodelsApi> metamodelsApi = std::make_shared<MetamodelsApi>(defaultClient);
    std::shared_ptr<MetamodelUpdateInterface> metamodelUpdateInterface = std::make_shared<MetamodelUpdateInterface>();

    // Deleting a block in blocks
    std::__1::vector<utility::string_t, std::__1::allocator<utility::string_t>> del;
    
    del.assign(1, secrets.get("BLOCK_IN_TERR_VEHI_ID"));

    metamodelUpdateInterface->setRDelete(del);
    metamodelsApi->crudTemplate(incomingBranchId, metamodelUpdateInterface);
        
    // Preparing commit message
    std::shared_ptr<CommitMessage> commitMessage = std::make_shared<CommitMessage>();
    commitMessage->setCommitMessage("Committed to TerrestrialVehicle");

    // Commit to currentBranch
    pplx::task<std::shared_ptr<MessageRes>> messageRes1 = branchesApi->commitToBranch(currentBranchId, commitMessage);
    std::cout << messageRes1.get()->getMessage() << std::endl;

    // Commit to incomingBranch
    pplx::task<std::shared_ptr<MessageRes>> messageRes2 = branchesApi->commitToBranch(incomingBranchId, commitMessage);
    std::cout << messageRes2.get()->getMessage() << std::endl;

    // Merge the two newly created branches
    std::shared_ptr<BranchMerge> branchMerge = std::make_shared<BranchMerge>();
    try {
        // Call mergeBranches()
        pplx::task<std::__1::shared_ptr<Response_Merge_Branches>> result = branchesApi->mergeBranches(currentBranchId, incomingBranchId, branchMerge);
        std::cout << "Repo Type: " << result.get()->getRepoType() << std::endl;
        std::cout << "Date Modified: " << result.get()->getDateModified().to_string() << std::endl;
    
        // Delete new branches
        pplx::task<std::shared_ptr<EntityDeleteRes>> entityDeleteRes1 = branchesApi->deleteBranch(currentBranchId);
        std::cout << entityDeleteRes1.get()->getMessage() << std::endl;
        
        pplx::task<std::shared_ptr<EntityDeleteRes>> entityDeleteRes2 = branchesApi->deleteBranch(incomingBranchId);
        std::cout << entityDeleteRes2.get()->getMessage() << std::endl;
    
    } catch (ApiException e) {
        std::cout << "Exception when calling BranchesApi#mergeBranches-TerrestrialVehicle" << std::endl;
        std::cout << "Status code: " << e.error_code() << std::endl;
        std::cout << "Reason: " << istream_to_string(e.getContent()) << std::endl;
        std::cout << "Response headers:" << std::endl;
        print_map(e.getHeaders());
        std::cout << e.what() <<  std::endl;

        // Delete new branches
        pplx::task<std::shared_ptr<EntityDeleteRes>> entityDeleteRes1 = branchesApi->deleteBranch(currentBranchId);
        std::cout << entityDeleteRes1.get()->getMessage() << std::endl;
        
        pplx::task<std::shared_ptr<EntityDeleteRes>> entityDeleteRes2 = branchesApi->deleteBranch(incomingBranchId);
        std::cout << entityDeleteRes2.get()->getMessage() << std::endl;
    }

}

/* --------------------------------- DataApi Testing ------------------------------------- */

// getData() for Scenario
void testGetDataScenario(std::shared_ptr<const ApiClient> defaultClient){
    std::string branchId;
    Secrets secrets; // Create an instance of Secrets
    try {

        branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // The ID of the Scenario Branch to start a simulation for.
        pop(branchId);

    } catch (const std::exception& e) {
        std::cout << "Error: " << e.what() << std::endl;
    }
    // Create a DataApi
    std::shared_ptr<DataApi> dataApi = std::make_shared<DataApi>(defaultClient);
    
    // Start a new simulation job
    std::shared_ptr<JobsApi> jobsApi = std::make_shared<JobsApi>(defaultClient);
    std::shared_ptr<StartSimulationBody> startSimulationBody = std::make_shared<StartSimulationBody>(); // StartSimulationBody 
        
    pplx::task<std::shared_ptr<SimulationJob>> simulationJob = jobsApi->startSimulation(branchId, startSimulationBody);

    utility::string_t jobId = simulationJob.get()->getId();

    web::json::value status = jobsApi->getSimulation(branchId, simulationJob.get()->getId()).get()->getStatus()->toJson();

    // Keep getting simulation simulation is 'RUNNING'
    while(!status.is_string() || status.as_string() != U("RUNNING")){

        // Get status
        status = jobsApi->getSimulation(branchId, simulationJob.get()->getId()).get()->getStatus()->toJson();


        std::cout << "Waiting for simulation to start (ID: " << jobId << "). Current status: " << status  << std::endl;
        sleep(5);

    }
    std::cout << "Simulation started." << std::endl;
    
    // Uncomment if you want to print SimulationJob
    // std::cout << "SimulationJob: " << jobsApi->getSimulation(branchId, simulationJob.get()->getId()).get()->toJson() << std::endl;

        
    utility::string_t  id = jobsApi->getSimulation(branchId, simulationJob.get()->getId()).get()->getDataArray();

    boost::optional<double> start;
    boost::optional<double> stop;
    boost::optional<utility::string_t> streams;
    boost::optional<utility::string_t> streamsToken;
    boost::optional<utility::string_t> shape;
    boost::optional<utility::string_t> axisOrder;
    boost::optional<int32_t> binWidth;
    boost::optional<int32_t> sampleRate= 1024;
    boost::optional<utility::string_t> continuationToken;
    boost::optional<utility::string_t> encoding;

    try {
        pplx::task<std::shared_ptr<DataServiceResponse>> dataServiceResponse = dataApi->getData(id, start, stop, streams, streamsToken, shape, axisOrder, binWidth, sampleRate, continuationToken, encoding);
        std::cout << "series: " << dataServiceResponse.get()->getSeries().get()->toJson() << std::endl;

        // Terminate simulation
        pplx::task<std::shared_ptr<MessageRes>> messageRes = jobsApi->terminateSimulation(branchId, simulationJob.get()->getId());
        std::cout << messageRes.get()->toJson() <<  std::endl;

    } catch (ApiException e) {
        std::cout << "Exception when calling BranchesApi#getData-Scenario" << std::endl;
        std::cout << "Status code: " << e.error_code() << std::endl;
        std::cout << "Reason: " << istream_to_string(e.getContent()) << std::endl;
        std::cout << "Response headers:" << std::endl;
        print_map(e.getHeaders());
        std::cout << e.what() <<  std::endl;

        // Terminate simulation
        pplx::task<std::shared_ptr<MessageRes>> messageRes = jobsApi->terminateSimulation(branchId, simulationJob.get()->getId());
        std::cout << messageRes.get()->toJson() <<  std::endl;
    }
}

/* --------------------------------- ExternalsApi Testing ------------------------------------- */

// getExternal() for Scenario
void testGetExternalScenario(std::shared_ptr<const ApiClient> defaultClient){

    std::string branchId;
    Secrets secrets; // Create an instance of Secrets
    utility::string_t agentId;
    utility::string_t externalStateBlockId;
    try {

        branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // The ID of the Scenario Branch to start a simulation for.
        pop(branchId);
        agentId = secrets.get("AGENT_EXTERNAL_ID"); // EXTERNAL_STATE_BLOCK_ID
        pop(agentId);
        externalStateBlockId = secrets.get("EXTERNAL_STATE_BLOCK_ID"); // String
        pop(externalStateBlockId);

    } catch (const std::exception& e) {
        std::cout << "Error: " << e.what() << std::endl;
    }

    // Create an ExternalsApi
    std::shared_ptr<ExternalsApi> externalsApi = std::make_shared<ExternalsApi>(defaultClient);
        

    // Start a new simulation job
    std::shared_ptr<JobsApi> jobsApi = std::make_shared<JobsApi>(defaultClient);
    
    std::shared_ptr<StartSimulationBody> startSimulationBody = std::make_shared<StartSimulationBody>(); // StartSimulationBody 
        
    pplx::task<std::shared_ptr<SimulationJob>> simulationJob = jobsApi->startSimulation(branchId, startSimulationBody);

    utility::string_t jobId = simulationJob.get()->getId();

    web::json::value status = jobsApi->getSimulation(branchId, simulationJob.get()->getId()).get()->getStatus()->toJson();

    // Keep getting simulation simulation is 'RUNNING'
    while(!status.is_string() || status.as_string() != U("RUNNING")){

        // Get status
        status = jobsApi->getSimulation(branchId, simulationJob.get()->getId()).get()->getStatus()->toJson();


        std::cout << "Waiting for simulation to start (ID: " << jobId << "). Current status: " << status  << std::endl;
        sleep(1);

    }
    std::cout << "Simulation started." << std::endl;
    
    // Uncomment if you want to print SimulationJob
    // std::cout << "SimulationJob: " << jobsApi->getSimulation(branchId, simulationJob.get()->getId()).get()->toJson() << std::endl;

    boost::optional<double> time;
        
    try {
        // Keep getting externals in a loop
        int counter = 0;
        
        while(counter < 7){
             pplx::task<std::vector<std::shared_ptr<AnyType>>> externals = externalsApi->getExternal(jobId, agentId, externalStateBlockId, time);
        
            // Wait for the task to complete and get the result
            std::vector<std::shared_ptr<AnyType>> result = externals.get();

            // Print the JSON representation of result
            for (const auto& ptr : result) {
            // toJson() is a method of AnyType or its allocator
            std::cout << ptr->toJson() << std::endl;
            }

            sleep(5);
            counter ++;
        }
       
        // Terminate simulation
        pplx::task<std::shared_ptr<MessageRes>> messageRes = jobsApi->terminateSimulation(branchId, jobId);
        std::cout << messageRes.get()->toJson() <<  std::endl;
    } catch (ApiException e) {
        std::cout << "Exception when calling BranchesApi#getExternal-Scenario" << std::endl;
        std::cout << "Status code: " << e.error_code() << std::endl;
        std::cout << "Reason: " << istream_to_string(e.getContent()) << std::endl;
        std::cout << "Response headers:" << std::endl;
        print_map(e.getHeaders());
        std::cout << e.what() <<  std::endl;

        // Terminate simulation
        pplx::task<std::shared_ptr<MessageRes>> messageRes = jobsApi->terminateSimulation(branchId, jobId);
        std::cout << messageRes.get()->toJson() <<  std::endl;
    }

}

// putExternal() for Scenario
void testPutExternalScenario(std::shared_ptr<const ApiClient> defaultClient){

    std::string branchId;
    Secrets secrets; // Create an instance of Secrets
    utility::string_t agentId;
    utility::string_t externalStateBlockId;
    try {

        branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // The ID of the Scenario Branch to start a simulation for.
        pop(branchId);
        agentId = secrets.get("AGENT_EXTERNAL_ID"); // EXTERNAL_STATE_BLOCK_ID
        pop(agentId);
        externalStateBlockId = secrets.get("EXTERNAL_STATE_BLOCK_ID"); // String
        pop(externalStateBlockId);

    } catch (const std::exception& e) {
        std::cout << "Error: " << e.what() << std::endl;
    }

    // Create an ExternalsApi
    std::shared_ptr<ExternalsApi> externalsApi = std::make_shared<ExternalsApi>(defaultClient);
        

    // Start a new simulation job
    std::shared_ptr<JobsApi> jobsApi = std::make_shared<JobsApi>(defaultClient);
    std::shared_ptr<StartSimulationBody> startSimulationBody = std::make_shared<StartSimulationBody>(); // StartSimulationBody 
        
    pplx::task<std::shared_ptr<SimulationJob>> simulationJob = jobsApi->startSimulation(branchId, startSimulationBody);

    utility::string_t jobId = simulationJob.get()->getId(); 
    web::json::value status = jobsApi->getSimulation(branchId, simulationJob.get()->getId()).get()->getStatus()->toJson();

    // Keep getting simulation simulation is 'RUNNING'
    while(!status.is_string() || status.as_string() != U("RUNNING")){

        // Get status
        status = jobsApi->getSimulation(branchId, simulationJob.get()->getId()).get()->getStatus()->toJson();


        std::cout << "Waiting for simulation to start (ID: " << jobId << "). Current status: " << status  << std::endl;
        sleep(1);

    }
    std::cout << "Simulation started." << std::endl;
    
    // Uncomment if you want to print SimulationJob
    // std::cout << "SimulationJob: " << jobsApi->getSimulation(branchId, simulationJob.get()->getId()).get()->toJson() << std::endl;

    // Create an external set request
    std::shared_ptr<ExternalStateSetRequest> externalStateSetRequest = std::make_shared<ExternalStateSetRequest>();
     
    
    try {

        // Keep putting externals in a loop
        int counter = 0;
        
        while(counter < 7){

            std::vector<double> values  =  std::vector<double>();
            values.push_back(4.44);
            values.push_back(5.55);
            values.push_back(6.66);
            
            externalStateSetRequest->setValues(values);

            externalsApi->putExternal(jobId, agentId, externalStateBlockId, externalStateSetRequest);
        
            sleep(5);
            counter ++;
        }
  
        // Terminate simulation
        pplx::task<std::shared_ptr<MessageRes>> messageRes = jobsApi->terminateSimulation(branchId, jobId);
        std::cout << messageRes.get()->toJson() <<  std::endl;
    } catch (ApiException e) {
        std::cout << "Exception when calling BranchesApi#putExternal-Scenario" << std::endl;
        std::cout << "Status code: " << e.error_code() << std::endl;
        std::cout << "Reason: " << istream_to_string(e.getContent()) << std::endl;
        std::cout << "Response headers:" << std::endl;
        print_map(e.getHeaders());
        std::cout << e.what() <<  std::endl;

        // Terminate simulation
        pplx::task<std::shared_ptr<MessageRes>> messageRes = jobsApi->terminateSimulation(branchId, jobId);
        std::cout << messageRes.get()->toJson() <<  std::endl;
    }

}

/* --------------------------------- JobsApi Testing ------------------------------------- */

// startStudy() for Scenario
void testStartStudyScenario(std::shared_ptr<const ApiClient> defaultClient){
    std::string branchId;
    Secrets secrets; // Create an instance of Secrets
    try {

        branchId = secrets.get("SIMPLE_SAT_SCEN_ID"); // The ID of the Scenario Branch to start a simulation for.
        pop(branchId);

    } catch (const std::exception& e) {
        std::cout << "Error: " << e.what() << std::endl;
    }
    
    std::shared_ptr<BranchesApi> branchesApi = std::make_shared<BranchesApi>(defaultClient);
    std::string newBranchId;
    try{
        // Create a new branch
        std::shared_ptr<BranchCreate> branchCreate = std::make_shared<BranchCreate>();
        branchCreate->setName("New_branch_with_C++");
        pplx::task<std::shared_ptr<BranchRes>> newBranch = branchesApi->createBranch(branchId, branchCreate);

        // Get new branch ID
        std::__1::shared_ptr<BranchRes> newBranchObj = newBranch.get();
        newBranchId = newBranchObj->getId();
    }catch(ApiException e){
        std::cout << "Error: " << e.what() << std::endl;
    }

    // Start a new simulation job
    std::shared_ptr<JobsApi> jobsApi = std::make_shared<JobsApi>(defaultClient);
    
    // crud: change stopTime
    std::shared_ptr<MetamodelsApi> metamodelsApi = std::make_shared<MetamodelsApi>(defaultClient);
    std::shared_ptr<MetamodelUpdateInterface> metamodelUpdateInterface = std::make_shared<MetamodelUpdateInterface>();
    
    // Create a vector of shared pointers to Object
    std::vector<std::shared_ptr<Object>> list;

    std::shared_ptr<Object> obj1 = std::make_shared<Object>();
    obj1->setValue("id", web::json::value::string(U(secrets.get("CLOCK_CONFIG_ID"))));
    obj1->setValue("type", web::json::value::string(U("ClockConfig")));
    obj1->setValue("startTime", web::json::value::number(59911.0));
    obj1->setValue("stopTime", web::json::value::number(59914.5002));
    list.push_back(obj1);

    metamodelUpdateInterface->setBlocks(list);
    metamodelsApi->crudTemplate(newBranchId, metamodelUpdateInterface);

    // Start study after changing stopTime
    std::shared_ptr<StartStudyBody> startStudyBody = std::make_shared<StartStudyBody>();
    startStudyBody->setIterations(1);

    try {

    pplx::task<std::shared_ptr<StudyJob>> studyJob = jobsApi->startStudy(newBranchId, startStudyBody);
    utility::string_t jobId = studyJob.get()->getId(); 
    
    web::json::value status = jobsApi->getStudy(newBranchId, jobId).get()->getStatus()->toJson();

    // Keep looping until the study starts a simulation
    while(!status.is_string() || status.as_string() != U("RUNNING") || jobsApi->getStudy(newBranchId, jobId).get()->getSimulationJobs().empty()){

         // Get status
        status = jobsApi->getStudy(newBranchId, jobId).get()->getStatus()->toJson();

        std::cout << "Waiting for study to start (ID: " << jobId << "). Current status: " << status  << std::endl;
        sleep(1);
    }

    std::cout << "Study started." << std::endl;
        
    // Terminate Simulation created by study
    pplx::task<std::shared_ptr<MessageRes>> messageRes1 = jobsApi->terminateSimulation(newBranchId, jobsApi->getStudy(newBranchId, jobId).get()->getSimulationJobs().front());
    std::cout << messageRes1.get()->toJson() <<  std::endl;

    // Terminate Study
    pplx::task<std::shared_ptr<MessageRes>> messageRes2 = jobsApi->terminateStudy(newBranchId, jobId);
    std::cout << messageRes2.get()->toJson() <<  std::endl;

    // Delete new branch
    pplx::task<std::shared_ptr<EntityDeleteRes>> entityDeleteRes = branchesApi->deleteBranch(newBranchId);
    std::cout << entityDeleteRes.get()->getMessage() << std::endl;
    
    } catch (ApiException e) {
        std::cout << "Exception when calling BranchesApi#startStudy-Scenario" << std::endl;
        std::cout << "Status code: " << e.error_code() << std::endl;
        std::cout << "Reason: " << istream_to_string(e.getContent()) << std::endl;
        std::cout << "Response headers:" << std::endl;
        print_map(e.getHeaders());
        std::cout << e.what() <<  std::endl;

        // Delete new branch
    pplx::task<std::shared_ptr<EntityDeleteRes>> entityDeleteRes = branchesApi->deleteBranch(newBranchId);
    std::cout << entityDeleteRes.get()->getMessage() << std::endl;
            
    }
}

/* ----------------------------------- RepositoriesApi Testing --------------------------------------- */

// updateRepo() for Scenario
void testUpdateRepoScenario(std::shared_ptr<const ApiClient> defaultClient){
    std::string workspaceId;
    Secrets secrets; // Create an instance of Secrets
    try {

        workspaceId = secrets.get("WORKSPACE_ID"); // The ID of the workspace to create the repo in
        pop(workspaceId);

    } catch (const std::exception& e) {
        std::cout << "Error: " << e.what() << std::endl;
    }

    // Start a new simulation job
    std::shared_ptr<RepositoriesApi> repositoriesApi = std::make_shared<RepositoriesApi>(defaultClient);

    // Create a new repo to test updateRepo()
    std::shared_ptr<RepoCreateReq> repoCreateReq = std::make_shared<RepoCreateReq>();
    
    repoCreateReq->setMetamodelType("Scenario");
    repoCreateReq->setName("scenarioRepo");
    repoCreateReq->setWorkspace(workspaceId);

    pplx::task<std::shared_ptr<RepoRes>> repoRes = repositoriesApi->createRepo(repoCreateReq);
    std::string repositoryId = repoRes.get()->getId();

    // Name before update
    std::cout << "Name before update: " << repositoriesApi->getRepo(repositoryId).get()->getName() <<  std::endl;
    sleep(5);
    // Update repo
    std::shared_ptr<RepoUpdateReq> repoUpdateReq = std::make_shared<RepoUpdateReq>();
    repoUpdateReq->setName("scenarioRepo_renamed");
    sleep(3);
    try {
        pplx::task<std::shared_ptr<RepoRes>> result = repositoriesApi->updateRepo(repositoryId, repoUpdateReq);

        // Name after update
        std::cout << "Name after update: " << result.get()->getName() <<  std::endl;
        // sleep(5);
        // Delete the repo
        repositoriesApi->deleteRepo(repositoryId);
        sleep(5);

    } catch (ApiException e) {
        std::cout << "Exception when calling BranchesApi#updateRepo-Scenario" << std::endl;
        std::cout << "Status code: " << e.error_code() << std::endl;
        std::cout << "Reason: " << istream_to_string(e.getContent()) << std::endl;
        std::cout << "Response headers:" << std::endl;
        print_map(e.getHeaders());
        std::cout << e.what() <<  std::endl;
        sleep(5);
        // Delete the repo
        repositoriesApi->deleteRepo(repositoryId);
    }
}

// updateRepo() for Spacecraft
void testUpdateRepoSpacecraft(std::shared_ptr<const ApiClient> defaultClient){
    std::string workspaceId;
    Secrets secrets; // Create an instance of Secrets
    try {

        workspaceId = secrets.get("WORKSPACE_ID"); // The ID of the workspace to create the repo in
        pop(workspaceId);

    } catch (const std::exception& e) {
        std::cout << "Error: " << e.what() << std::endl;
    }

    // Start a new simulation job
    std::shared_ptr<RepositoriesApi> repositoriesApi = std::make_shared<RepositoriesApi>(defaultClient);

    // Create a new repo to test updateRepo()
    std::shared_ptr<RepoCreateReq> repoCreateReq = std::make_shared<RepoCreateReq>();
    
    repoCreateReq->setMetamodelType("Spacecraft");
    repoCreateReq->setName("spacecraftRepo");
    repoCreateReq->setWorkspace(workspaceId);

    pplx::task<std::shared_ptr<RepoRes>> repoRes = repositoriesApi->createRepo(repoCreateReq);
    std::string repositoryId = repoRes.get()->getId();

    // Name before update
    std::cout << "Name before update: " << repositoriesApi->getRepo(repositoryId).get()->getName() <<  std::endl;
    sleep(5);
    // Update repo
    std::shared_ptr<RepoUpdateReq> repoUpdateReq = std::make_shared<RepoUpdateReq>();
    repoUpdateReq->setName("spacecraftRepo_renamed");
    sleep(3);
    try {
        pplx::task<std::shared_ptr<RepoRes>> result = repositoriesApi->updateRepo(repositoryId, repoUpdateReq);

        // Name after update
        std::cout << "Name after update: " << result.get()->getName() <<  std::endl;
        // sleep(5);
        // Delete the repo
        repositoriesApi->deleteRepo(repositoryId);
        sleep(5);

    } catch (ApiException e) {
        std::cout << "Exception when calling BranchesApi#updateRepo-Spacecraft" << std::endl;
        std::cout << "Status code: " << e.error_code() << std::endl;
        std::cout << "Reason: " << istream_to_string(e.getContent()) << std::endl;
        std::cout << "Response headers:" << std::endl;
        print_map(e.getHeaders());
        std::cout << e.what() <<  std::endl;
        sleep(5);
        // Delete the repo
        repositoriesApi->deleteRepo(repositoryId);
    }
}

// updateRepo() for TerrestrialVehicle
void testUpdateRepoTerrestrialVehicle(std::shared_ptr<const ApiClient> defaultClient){
    std::string workspaceId;
    Secrets secrets; // Create an instance of Secrets
    try {

        workspaceId = secrets.get("WORKSPACE_ID"); // The ID of the workspace to create the repo in
        pop(workspaceId);

    } catch (const std::exception& e) {
        std::cout << "Error: " << e.what() << std::endl;
    }

    // Start a new simulation job
    std::shared_ptr<RepositoriesApi> repositoriesApi = std::make_shared<RepositoriesApi>(defaultClient);

    // Create a new repo to test updateRepo()
    std::shared_ptr<RepoCreateReq> repoCreateReq = std::make_shared<RepoCreateReq>();
    
    repoCreateReq->setMetamodelType("TerrestrialVehicle");
    repoCreateReq->setName("terrestrialVehicleRepo");
    repoCreateReq->setWorkspace(workspaceId);

    pplx::task<std::shared_ptr<RepoRes>> repoRes = repositoriesApi->createRepo(repoCreateReq);
    std::string repositoryId = repoRes.get()->getId();

    // Name before update
    std::cout << "Name before update: " << repositoriesApi->getRepo(repositoryId).get()->getName() <<  std::endl;
    sleep(5);
    // Update repo
    std::shared_ptr<RepoUpdateReq> repoUpdateReq = std::make_shared<RepoUpdateReq>();
    repoUpdateReq->setName("terrestrialVehicleRepo_renamed");
    sleep(3);
    try {
        pplx::task<std::shared_ptr<RepoRes>> result = repositoriesApi->updateRepo(repositoryId, repoUpdateReq);

        // Name after update
        std::cout << "Name after update: " << result.get()->getName() <<  std::endl;
        // sleep(5);
        // Delete the repo
        repositoriesApi->deleteRepo(repositoryId);
        sleep(5);

    } catch (ApiException e) {
        std::cout << "Exception when calling BranchesApi#updateRepo-TerrestrialVehicle" << std::endl;
        std::cout << "Status code: " << e.error_code() << std::endl;
        std::cout << "Reason: " << istream_to_string(e.getContent()) << std::endl;
        std::cout << "Response headers:" << std::endl;
        print_map(e.getHeaders());
        std::cout << e.what() <<  std::endl;
        sleep(5);
        // Delete the repo
        repositoriesApi->deleteRepo(repositoryId);
    }
}

/* ----------------------------------- MetamodelsApi Testing --------------------------------------- */
        
// Testing crudTemplate() for Scenario
void testCrudTemplateScenario(std::shared_ptr<const ApiClient> defaultClient){

    std::string branchId;
    Secrets secrets; // Create an instance of Secrets
    try {

        branchId = secrets.get("SIMPLE_SAT_SCEN_ID");
        pop(branchId);

    } catch (const std::exception& e) {
        std::cout << "Error: " << e.what() << std::endl;
    }
    
    std::shared_ptr<BranchesApi> branchesApi = std::make_shared<BranchesApi>(defaultClient);

    // Create a new branch
    std::shared_ptr<BranchCreate> branchCreate = std::make_shared<BranchCreate>();
    branchCreate->setName("New_branch_with_C++");

    pplx::task<std::shared_ptr<BranchRes>> newBranch;
    
    try{
        
        newBranch = branchesApi->createBranch(branchId, branchCreate);
        
    } catch (ApiException e){
        
        std::cout << "Error: " << e.what() << std::endl;
    }

    // Get new branch ID
    std::__1::shared_ptr<BranchRes> newBranchObj = newBranch.get();
    
    std::string newBranchId = newBranchObj->getId();
    
    // Print block before changes:
    std::string clockConfigId = branchesApi->getBranch(newBranchId).get()->getData()->getClockConfig();
    web::json::value blocks1 = branchesApi->getBranch(newBranchId).get()->getData()->toJson().at("blocks");
    web::json::value block1 = blocks1[clockConfigId];
    // increment the current startTime by 1
    double newStartTime = block1["startTime"].as_double() + 1;

    std::cout <<  "Block before changes: " << std::endl;
    std::cout <<  block1 << std::endl;

    // crud: change stopTime in the new branch
    std::shared_ptr<MetamodelsApi> metamodelsApi = std::make_shared<MetamodelsApi>(defaultClient);
    std::shared_ptr<MetamodelUpdateInterface> metamodelUpdateInterface = std::make_shared<MetamodelUpdateInterface>();

    // Create a vector of shared pointers to Object
    std::vector<std::shared_ptr<Object>> list;

    std::shared_ptr<Object> obj1 = std::make_shared<Object>();
    
    obj1->setValue("id", web::json::value::string(U(secrets.get("CLOCK_CONFIG_ID"))));
    obj1->setValue("type", web::json::value::string(U("ClockConfig")));
    obj1->setValue("startTime", web::json::value::number(newStartTime));
    obj1->setValue("stopTime", web::json::value::number(59914.515151));
    list.push_back(obj1);
    
    metamodelUpdateInterface->setBlocks(list);

    try{
        pplx::task<std::shared_ptr<ModelCrudRes>> modelCrudRes = metamodelsApi->crudTemplate(newBranchId, metamodelUpdateInterface);

        std::cout << "dateModified: " << modelCrudRes.get()->getBranch().get()->getDateModified().to_string() << std::endl;

        // Preparing commit message
        std::shared_ptr<CommitMessage> commitMessage = std::make_shared<CommitMessage>();
        commitMessage->setCommitMessage("Committed to Scenario");
    
        pplx::task<std::shared_ptr<MessageRes>> messageRes = branchesApi->commitToBranch(newBranchId, commitMessage);
        std::cout << messageRes.get()->toJson() << std::endl;
        
        web::json::value blocks2 = branchesApi->getBranch(newBranchId).get()->getData()->toJson().at("blocks");
        web::json::value block2 = blocks2[clockConfigId];
        
        std::cout << "Block after crud: changed the value of 'startTime' and 'stopTime'." << std::endl;
        std::cout <<  block2 << std::endl;

        // Delete new branch
        pplx::task<std::shared_ptr<EntityDeleteRes>> entityDeleteRes = branchesApi->deleteBranch(newBranchId);
        std::cout << entityDeleteRes.get()->getMessage() << std::endl;
    } catch(ApiException e){
        std::cout << "Exception when calling BranchesApi#crudTemplate-Scenario" << std::endl;
        std::cout << "Status code: " << e.error_code() << std::endl;
        std::cout << "Reason: " << istream_to_string(e.getContent()) << std::endl;
        std::cout << "Response headers:" << std::endl;
        print_map(e.getHeaders());
        std::cout << e.what() <<  std::endl;

        // Delete new branch
        pplx::task<std::shared_ptr<EntityDeleteRes>> entityDeleteRes = branchesApi->deleteBranch(newBranchId);
        std::cout << entityDeleteRes.get()->getMessage() << std::endl;
    } 

}

// Testing crudTemplate() for Spacecraft
void testCrudTemplateSpacecraft(std::shared_ptr<const ApiClient> defaultClient){
    std::string branchId;
    Secrets secrets; // Create an instance of Secrets
    try {

        branchId = secrets.get("SIMPLE_SAT_VEHI_ID");
        pop(branchId);

    } catch (const std::exception& e) {
        std::cout << "Error: " << e.what() << std::endl;
    }
    
    std::shared_ptr<BranchesApi> branchesApi = std::make_shared<BranchesApi>(defaultClient);

    // Create a new branch
    std::shared_ptr<BranchCreate> branchCreate = std::make_shared<BranchCreate>();
    branchCreate->setName("New_branch_with_C++");

    pplx::task<std::shared_ptr<BranchRes>> newBranch;
    
    try{
        
        newBranch = branchesApi->createBranch(branchId, branchCreate);
        
    } catch (ApiException e){
        
        std::cout << "Error: " << e.what() << std::endl;
    }

    // Get new branch ID
    std::__1::shared_ptr<BranchRes> newBranchObj = newBranch.get();
    
    std::string newBranchId = newBranchObj->getId();
    
    
    // Print block before crud
    std::string clockConfigId = branchesApi->getBranch(newBranchId).get()->getData()->getClockConfig();
    web::json::value blocks1 = branchesApi->getBranch(newBranchId).get()->getData()->toJson().at("blocks");
    web::json::value block1 = blocks1[secrets.get("BLOCK_IN_VEHI_ID")];
    bool newDisabled = !block1[U("disabled")].as_bool();

    std::cout << "Block before crud: " << std::endl;
    std::cout << block1 << std::endl;

    // crud: change stopTime in the new branch
    std::shared_ptr<MetamodelsApi> metamodelsApi = std::make_shared<MetamodelsApi>(defaultClient);
    std::shared_ptr<MetamodelUpdateInterface> metamodelUpdateInterface = std::make_shared<MetamodelUpdateInterface>();

    // Create a vector of shared pointers to Object
    std::vector<std::shared_ptr<Object>> list;

    std::shared_ptr<Object> obj1 = std::make_shared<Object>();
    
    obj1->setValue("id", web::json::value::string(U(secrets.get("BLOCK_IN_VEHI_ID"))));
    obj1->setValue("disabled", web::json::value::boolean(newDisabled ? "true" : "false"));
    obj1->setValue("type", web::json::value::string(U("Battery")));
    list.push_back(obj1);
    
    metamodelUpdateInterface->setBlocks(list);

    try{
        pplx::task<std::shared_ptr<ModelCrudRes>> modelCrudRes = metamodelsApi->crudTemplate(newBranchId, metamodelUpdateInterface);
        std::cout << "dateModified: " << modelCrudRes.get()->getBranch().get()->getDateModified().to_string() << std::endl;

        // Preparing commit message
        std::shared_ptr<CommitMessage> commitMessage = std::make_shared<CommitMessage>();
        commitMessage->setCommitMessage("Committed to Spacecraft");
    
        pplx::task<std::shared_ptr<MessageRes>> messageRes = branchesApi->commitToBranch(newBranchId, commitMessage);

        std::cout << messageRes.get()->toJson() << std::endl;
        
        web::json::value blocks2 = branchesApi->getBranch(newBranchId).get()->getData()->toJson().at("blocks");
        web::json::value block2 = blocks2[secrets.get("BLOCK_IN_VEHI_ID")];

        // Print block after crud
        std::cout << "Block after crud: changed the value of 'disabled' " << std::endl;
        std::cout <<  block2 << std::endl;

        // Delete new branch
        pplx::task<std::shared_ptr<EntityDeleteRes>> entityDeleteRes = branchesApi->deleteBranch(newBranchId);
        std::cout << entityDeleteRes.get()->getMessage() << std::endl;

    } catch(ApiException e){
        std::cout << "Exception when calling BranchesApi#crudTemplate-Spacecraft" << std::endl;
        std::cout << "Status code: " << e.error_code() << std::endl;
        std::cout << "Reason: " << istream_to_string(e.getContent()) << std::endl;
        std::cout << "Response headers:" << std::endl;
        print_map(e.getHeaders());
        std::cout << e.what() <<  std::endl;

        // Delete new branch
        pplx::task<std::shared_ptr<EntityDeleteRes>> entityDeleteRes = branchesApi->deleteBranch(newBranchId);
        std::cout << entityDeleteRes.get()->getMessage() << std::endl;
    } 
}

// Testing crudTemplate() for TerrestrialVehicle
void testCrudTemplateTerrestrialVehicle(std::shared_ptr<const ApiClient> defaultClient){
    std::string branchId;
    Secrets secrets; // Create an instance of Secrets
    try {

        branchId = secrets.get("SUPER_SAT_TERR_VEHICLE_ID");
        pop(branchId);

    } catch (const std::exception& e) {
        std::cout << "Error: " << e.what() << std::endl;
    }
    
    std::shared_ptr<BranchesApi> branchesApi = std::make_shared<BranchesApi>(defaultClient);

    // Create a new branch
    std::shared_ptr<BranchCreate> branchCreate = std::make_shared<BranchCreate>();
    branchCreate->setName("New_branch_with_C++");

    pplx::task<std::shared_ptr<BranchRes>> newBranch;
    
    try{
        
        newBranch = branchesApi->createBranch(branchId, branchCreate);
        
    } catch (ApiException e){
        
        std::cout << "Error: " << e.what() << std::endl;
    }

    // Get new branch ID
    std::__1::shared_ptr<BranchRes> newBranchObj = newBranch.get();
    
    std::string newBranchId = newBranchObj->getId();
    
    
    
    // Print block before crud
    std::string clockConfigId = branchesApi->getBranch(newBranchId).get()->getData()->getClockConfig();
    web::json::value blocks1 = branchesApi->getBranch(newBranchId).get()->getData()->toJson().at("blocks");
    web::json::value block1 = blocks1[secrets.get("BLOCK_IN_TERR_VEHI_ID")];
    bool newDisabled = !block1[U("disabled")].as_bool();

    std::cout << "Block before crud: " << std::endl;
    std::cout << block1 << std::endl;

    // crud: change stopTime in the new branch
    std::shared_ptr<MetamodelsApi> metamodelsApi = std::make_shared<MetamodelsApi>(defaultClient);
    std::shared_ptr<MetamodelUpdateInterface> metamodelUpdateInterface = std::make_shared<MetamodelUpdateInterface>();


    // Create a vector of shared pointers to Object
    std::vector<std::shared_ptr<Object>> list;

    std::shared_ptr<Object> obj1 = std::make_shared<Object>();
    
    obj1->setValue("id", web::json::value::string(U(secrets.get("BLOCK_IN_TERR_VEHI_ID"))));
    obj1->setValue("configurationType", web::json::value::string(U("SERIES"))); //configurationType is required
    obj1->setValue("disabled", web::json::value::boolean(newDisabled ? "true" : "false"));
    obj1->setValue("type", web::json::value::string(U("Battery")));
    list.push_back(obj1);
    
    metamodelUpdateInterface->setBlocks(list);

    try{
        pplx::task<std::shared_ptr<ModelCrudRes>> modelCrudRes = metamodelsApi->crudTemplate(newBranchId, metamodelUpdateInterface);
        std::cout << "dateModified: " << modelCrudRes.get()->getBranch().get()->getDateModified().to_string() << std::endl;

        // Preparing commit message
        std::shared_ptr<CommitMessage> commitMessage = std::make_shared<CommitMessage>();
        commitMessage->setCommitMessage("Committed to TerrestrialVehicle");
    
        pplx::task<std::shared_ptr<MessageRes>> messageRes = branchesApi->commitToBranch(newBranchId, commitMessage);

        std::cout << messageRes.get()->toJson() << std::endl;
        
        web::json::value blocks2 = branchesApi->getBranch(newBranchId).get()->getData()->toJson().at("blocks");
        web::json::value block2 = blocks2[secrets.get("BLOCK_IN_TERR_VEHI_ID")];

        // Print block after crud
        std::cout << "Block after crud: changed the value of 'disabled' " << std::endl;
        std::cout <<  block2 << std::endl;

        // Delete new branch
        pplx::task<std::shared_ptr<EntityDeleteRes>> entityDeleteRes = branchesApi->deleteBranch(newBranchId);
        std::cout << entityDeleteRes.get()->getMessage() << std::endl;

    } catch(ApiException e){
        std::cout << "Exception when calling BranchesApi#crudTemplate-TerrestrialVehicle" << std::endl;
        std::cout << "Status code: " << e.error_code() << std::endl;
        std::cout << "Reason: " << istream_to_string(e.getContent()) << std::endl;
        std::cout << "Response headers:" << std::endl;
        print_map(e.getHeaders());
        std::cout << e.what() <<  std::endl;

        // Delete new branch
        pplx::task<std::shared_ptr<EntityDeleteRes>> entityDeleteRes = branchesApi->deleteBranch(newBranchId);
        std::cout << entityDeleteRes.get()->getMessage() << std::endl;
    } 
}
