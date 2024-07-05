



#ifndef TESTFUNCTIONS_H
#define TESTFUNCTIONS_H

#include "CppRestOpenAPIClient/ApiConfiguration.h"
#include "CppRestOpenAPIClient/ApiClient.h"
#include "CppRestOpenAPIClient/api/BranchesApi.h"

using namespace std;
using namespace org::openapitools::client::api;
using namespace org::openapitools::client::model;

// The test functions
void testCreateBranchScenario(std::shared_ptr<const ApiClient> defaultClient);
void testCreateBranchSpacecraft(std::shared_ptr<const ApiClient> defaultClient);
void testCreateBranchTerrestrialVehicle(std::shared_ptr<const ApiClient> defaultClient);

void testGetBranchScenario(std::shared_ptr<const ApiClient> defaultClient);
void testGetBranchSpacecraft(std::shared_ptr<const ApiClient> defaultClient);
void testGetBranchTerrestrialVehicle(std::shared_ptr<const ApiClient> defaultClient);

void testCommitToBranchScenario(std::shared_ptr<const ApiClient> defaultClient);
void testCommitToBranchSpacecraft(std::shared_ptr<const ApiClient> defaultClient);
void testCommitToBranchTerrestrialVehicle(std::shared_ptr<const ApiClient> defaultClient);

void testVerifyBranchPasswordTerrestrialVehicle(std::shared_ptr<const ApiClient> defaultClient);

void testMergeBranchesTerrestrialVehicle(std::shared_ptr<const ApiClient> defaultClient);

void testGetDataScenario(std::shared_ptr<const ApiClient> defaultClient);

void testGetExternalScenario(std::shared_ptr<const ApiClient> defaultClient);
void testPutExternalScenario(std::shared_ptr<const ApiClient> defaultClient);

void testStartStudyScenario(std::shared_ptr<const ApiClient> defaultClient);

void testUpdateRepoScenario(std::shared_ptr<const ApiClient> defaultClient);
void testUpdateRepoSpacecraft(std::shared_ptr<const ApiClient> defaultClient);
void testUpdateRepoTerrestrialVehicle(std::shared_ptr<const ApiClient> defaultClient);

void testCrudTemplateScenario(std::shared_ptr<const ApiClient> defaultClient);
void testCrudTemplateSpacecraft(std::shared_ptr<const ApiClient> defaultClient);
void testCrudTemplateTerrestrialVehicle(std::shared_ptr<const ApiClient> defaultClient);





#endif // TESTFUNCTIONS_H