import json
from pprint import pprint
from time import sleep
from openapi_client import *

# Open config.json and load secrets
with open('./config.json', 'r') as file:
    secrets = json.load(file)


# ----------------------------------- Branch Testing Methods --------------------------------------- #
        
# commit_to_branch() for Scenario
def test_commit_to_branch_scenario(default_client): 
    api_instance = BranchesApi(default_client)
    branch_id = secrets["SIMPLE_SAT_SCEN_ID"]
    
    # Create a new branch
    branch_create = BranchCreate(name="New_branch3")
    new_branch_res = api_instance.create_branch(branch_id, branch_create)
    new_branch_id = new_branch_res.id

    # Make changes to the new branch using crud()
    metamodels_api = MetamodelsApi(default_client)
   
    metamodel_update_interface = MetamodelUpdateInterface(
        delete=[secrets["BLOCK_IN_SCEN_ID"]]  # List containing the block ID to delete
    )
    metamodels_api.crud_template(new_branch_id, metamodel_update_interface)

    # Preparing commit message
    commit_message = CommitMessage(commitMessage="committed")
    try:
        # Commit changes
        api_response = api_instance.commit_to_branch(new_branch_id, commit_message)
        pprint(api_response)

        # Deleting the branch
        api_instance.delete_branch(new_branch_id)

    except ApiException as e:
        print("Exception when calling BranchesApi#commitToBranch-Scenario")
        print("Status code:", e.status)
        print("Reason:", e.body)
        print("Response headers:", e.headers)
        # Print full traceback if needed
        # traceback.print_exc()

        # Deleting the branch
        api_instance.delete_branch(new_branch_id)

# commit_to_branch() for Spacecraft
def test_commit_to_branch_spacecraft(default_client):
    api_instance = BranchesApi(default_client)
    branch_id = secrets["SIMPLE_SAT_VEHI_ID"]
    
    # Create a new branch
    branch_create = BranchCreate(name="New_branch3")
    new_branch_res = api_instance.create_branch(branch_id, branch_create)
    new_branch_id = new_branch_res.id

    # Make changes to the branch and commit
    metamodels_api = MetamodelsApi(default_client)
    
    metamodel_update_interface = MetamodelUpdateInterface(
        delete=[secrets["BLOCK_IN_VEHI_ID"]]  # List containing the block ID to delete
    )
    metamodels_api.crud_template(new_branch_id, metamodel_update_interface)

    # Preparing commit message
    commit_message = CommitMessage(commitMessage="committed")
    try:
        # Commit changes
        api_response = api_instance.commit_to_branch(new_branch_id, commit_message)
        pprint(api_response)

        # Deleting the branch
        api_instance.delete_branch(new_branch_id)

    except ApiException as e:
        print("Exception when calling BranchesApi#commitToBranch-Spacecraft")
        print("Status code:", e.status)
        print("Reason:", e.body)
        print("Response headers:", e.headers)
        # Print full traceback if needed
        # traceback.print_exc()

        # Deleting the branch
        api_instance.delete_branch(new_branch_id)

# commit_to_branch() for TerrestrialVehicle
def test_commit_to_branch_terrestrialVehicle(default_client):
    api_instance = BranchesApi(default_client)
    branch_id = secrets["SUPER_SAT_TERR_VEHICLE_ID"]
    
    # Create a new branch
    branch_create = BranchCreate(name="New_branch3")
    new_branch_res = api_instance.create_branch(branch_id, branch_create)
    new_branch_id = new_branch_res.id

    # Make changes to the branch and commit
    metamodels_api = MetamodelsApi(default_client)
    
    metamodel_update_interface = MetamodelUpdateInterface(
        delete=[secrets["BLOCK_IN_TERR_VEHI_ID"]]  # List containing the block ID to delete
    )
    metamodels_api.crud_template(new_branch_id, metamodel_update_interface)

    # Preparing commit message
    commit_message = CommitMessage(commitMessage="committed")
    try:
        # Commit changes
        api_response = api_instance.commit_to_branch(new_branch_id, commit_message)
        pprint(api_response)

        # Deleting the branch
        api_instance.delete_branch(new_branch_id)

    except ApiException as e:
        print("Exception when calling BranchesApi#commitToBranch-TerrestrialVehicle")
        print("Status code:", e.status)
        print("Reason:", e.body)
        print("Response headers:", e.headers)
        # Print full traceback if needed
        # traceback.print_exc()

        # Deleting the branch
        api_instance.delete_branch(new_branch_id)
        
# verify_branch_password() for Scenario
def test_verify_branch_password_scenario(default_client):  
    api_instance = BranchesApi(default_client)
    branch_id = secrets["protectedBranchScen_ID"]
    
    # Create BranchVerifyPassword object and set password
    branch_verify_password = BranchVerifyPassword(password=secrets["password"])
    
    try:
        # Verify branch password
        result = api_instance.verify_branch_password(branch_id, branch_verify_password)
        print(result)
    
    except ApiException as e:
        print("Exception when calling BranchesApi#verifyBranchPassword")
        print("Status code:", e.status)
        print("Reason:", e.body)
        print("Response headers:", e.headers)
        # Print full traceback if needed
        # traceback.print_exc()
        
# verify_branch_password() for Spacecraft
def test_verify_branch_password_spacecraft(default_client):  
    api_instance = BranchesApi(default_client)
    branch_id = secrets["protectedBranchVehi_ID"]
    
    # Create BranchVerifyPassword object and set password
    branch_verify_password = BranchVerifyPassword(password=secrets["password"])
    
    try:
        # Verify branch password
        result = api_instance.verify_branch_password(branch_id, branch_verify_password)
        print(result)
    
    except ApiException as e:
        print("Exception when calling BranchesApi#verifyBranchPassword")
        print("Status code:", e.status)
        print("Reason:", e.body)
        print("Response headers:", e.headers)
        # Print full traceback if needed
        # traceback.print_exc()
        
# verify_branch_password() for TerrestrialVehicle
def test_verify_branch_password_terrestrialVehicle(default_client):  
    api_instance = BranchesApi(default_client)
    branch_id = secrets["protectedBranchTerr_ID"]
    
    # Create BranchVerifyPassword object and set password
    branch_verify_password = BranchVerifyPassword(password=secrets["password"])
    
    try:
        # Verify branch password
        result = api_instance.verify_branch_password(branch_id, branch_verify_password)
        print(result)
    
    except ApiException as e:
        print("Exception when calling BranchesApi#verifyBranchPassword")
        print("Status code:", e.status)
        print("Reason:", e.body)
        print("Response headers:", e.headers)
        # Print full traceback if needed
        # traceback.print_exc()
        
# merge_branches() for Spacecraft     
def test_merge_branches_spacecraft(default_client):
    api_instance = BranchesApi(default_client)

    # Main branch id
    branch_id = secrets["SIMPLE_SAT_VEHI_ID"]

    # Create two new branches to test merging them
    branch_create1 = BranchCreate(name = "currentBranch")
    # branch_create.name = "currentBranch"
    current_branch = api_instance.create_branch(branch_id, branch_create1)
    current_branch_id = current_branch.id
    
    branch_create2 = BranchCreate(name = "incomingBranch")
    # branch_create.name = "incomingBranch"
    incoming_branch = api_instance.create_branch(branch_id, branch_create2)
    incoming_branch_id = incoming_branch.id

    metamodels_api = MetamodelsApi(default_client)
    
    metamodel_update_interface = MetamodelUpdateInterface(
        root={},  # Placeholder for root if needed
        blocks=[],  # Placeholder for blocks if needed
        delete=[secrets["BLOCK_IN_VEHI_ID"]]  # List containing the block ID to delete
    )

    # Apply metamodel updates to incoming branch
    metamodels_api.crud_template(incoming_branch_id, metamodel_update_interface)

    # Commit changes to both branches
    commit_message = CommitMessage(commitMessage=f"commit: deleted block with block ID {secrets['BLOCK_IN_VEHI_ID']}")
    # commit_message.commit_message = f"commit: deleted block with block ID {secrets['BLOCK_IN_TERR_VEHI_ID']}"
    api_instance.commit_to_branch(current_branch_id, commit_message)
    api_instance.commit_to_branch(incoming_branch_id, commit_message)

    # Merge the two branches
    branch_merge = BranchMerge()
    try:
        result = api_instance.merge_branches(current_branch_id, incoming_branch_id, branch_merge)
        
        print(f"Merged {incoming_branch.name} into {current_branch.name}")
        print(f"Date merged branch was modified: {result.actual_instance.date_modified}")

        # Delete new branches after merging
        api_instance.delete_branch(incoming_branch_id)
        api_instance.delete_branch(current_branch_id)

    except ApiException as e:
        print("Exception when calling BranchesApi#mergeBranches")
        print(f"Status code: {e.status}")
        print(f"Reason: {e.body}")
        print(f"Response headers: {e.headers}")
        # Handle exception as needed
        
        
# merge_branches() for TerrestrialVehicle
def test_merge_branches_terrestrialVehicle(default_client):
    api_instance = BranchesApi(default_client)

    # Main branch id
    branch_id = secrets["SUPER_SAT_TERR_VEHICLE_ID"]

    # Create two new branches to test merging them
    branch_create1 = BranchCreate(name = "currentBranch")
    # branch_create.name = "currentBranch"
    current_branch = api_instance.create_branch(branch_id, branch_create1)
    current_branch_id = current_branch.id
    
    branch_create2 = BranchCreate(name = "incomingBranch")
    # branch_create.name = "incomingBranch"
    incoming_branch = api_instance.create_branch(branch_id, branch_create2)
    incoming_branch_id = incoming_branch.id

    metamodels_api = MetamodelsApi(default_client)
    
    metamodel_update_interface = MetamodelUpdateInterface(
        root={},  # Placeholder for root if needed
        blocks=[],  # Placeholder for blocks if needed
        delete=[secrets["BLOCK_IN_TERR_VEHI_ID"]]  # List containing the block ID to delete
    )

    # Apply metamodel updates to incoming branch
    metamodels_api.crud_template(incoming_branch_id, metamodel_update_interface)

    # Commit changes to both branches
    commit_message = CommitMessage(commitMessage=f"commit: deleted block with block ID {secrets['BLOCK_IN_TERR_VEHI_ID']}")
    # commit_message.commit_message = f"commit: deleted block with block ID {secrets['BLOCK_IN_TERR_VEHI_ID']}"
    api_instance.commit_to_branch(current_branch_id, commit_message)
    api_instance.commit_to_branch(incoming_branch_id, commit_message)

    # Merge the two branches
    branch_merge = BranchMerge()
    try:
        result = api_instance.merge_branches(current_branch_id, incoming_branch_id, branch_merge)
        
        print(f"Merged {incoming_branch.name} into {current_branch.name}")
        print(f"Date merged branch was modified: {result.actual_instance.date_modified}")

        # Delete new branches after merging
        api_instance.delete_branch(incoming_branch_id)
        api_instance.delete_branch(current_branch_id)

    except ApiException as e:
        print("Exception when calling BranchesApi#mergeBranches")
        print(f"Status code: {e.status}")
        print(f"Reason: {e.body}")
        print(f"Response headers: {e.headers}")
        # Handle exception as needed
        

# merge_branches() for Scenario
def test_merge_branches_scenario(default_client):
    api_instance = BranchesApi(default_client)

    # Main branch id
    branch_id = secrets["SIMPLE_SAT_SCEN_ID"]

    # Create two new branches to test merging them
    branch_create1 = BranchCreate(name="currentBranch")
    current_branch = api_instance.create_branch(branch_id, branch_create1)
    current_branch_id = current_branch.id
    
    branch_create2 = BranchCreate(name="incomingBranch")
    incoming_branch = api_instance.create_branch(branch_id, branch_create2)
    incoming_branch_id = incoming_branch.id

    metamodels_api = MetamodelsApi(default_client)
    
    metamodel_update_interface = MetamodelUpdateInterface(
        root={},  # Placeholder for root if needed
        blocks=[],  # Placeholder for blocks if needed
        delete=[secrets["BLOCK_IN_SCEN_ID"]]  # List containing the block ID to delete
    )

    # Apply metamodel updates to incoming branch
    metamodels_api.crud_template(incoming_branch_id, metamodel_update_interface)

    # Commit changes to both branches
    commit_message = CommitMessage(commit_message=f"commit: deleted block with block ID {secrets['BLOCK_IN_SCEN_ID']}")
    # api_instance.commit_to_branch(current_branch_id, commit_message)
    api_instance.commit_to_branch(incoming_branch_id, commit_message)

    # Merge the two branches
    branch_merge = BranchMerge()
    try:
        result = api_instance.merge_branches(current_branch_id, incoming_branch_id, branch_merge)
        
        print(f"Merged {incoming_branch.name} into {current_branch.name}")
        print(f"Date merged branch was modified: {result.actual_instance.date_modified}")

        # Delete new branches after merging
        api_instance.delete_branch(incoming_branch_id)
        api_instance.delete_branch(current_branch_id)

    except ApiException as e:
        print("Exception when calling BranchesApi#mergeBranches")
        print(f"Status code: {e.status}")
        print(f"Reason: {e.body}")
        print(f"Response headers: {e.headers}")
        # Handle exception as needed
        
# ------------------------------------ DataApi Testing ---------------------------------------- #

# getData() for Scenario
def test_get_data_scenario(default_client):
 
    # Create a DataApi
    data_api = DataApi(default_client)

    # Start a new simulation job
    jobs_api = JobsApi(default_client)
    branch_id = secrets["SIMPLE_SAT_SCEN_ID"]  # String | The ID of the Scenario Branch to start a simulation for.
    start_simulation_body = StartSimulationBody(seed=0)  # StartSimulationBody |
    start_simulation_body = {"seed":0}
    
    simulation_job = jobs_api.start_simulation(branch_id, start_simulation_body)
    job_id = simulation_job.id
    status = simulation_job.status.value
   
    # Keep getting simulation status until it's 'RUNNING'
    while status != "RUNNING":
        # Get status
        simulation_job = jobs_api.get_simulation(branch_id, job_id)
        status = simulation_job.status.value
        print(f"Waiting for simulation to start (ID: {job_id}). Current status: '{status}'")
        sleep(5)

    print("Simulation started.")

    # Uncomment if you want to print SimulationJob
    # print(jobs_api.get_simulation(branch_id, simulation_job.id))

    id = jobs_api.get_simulation(branch_id, simulation_job.id).data_array

    start = None
    stop = None
    streams = None
    streams_token = None
    shape = None
    axis_order = None
    bin_width = None
    sample_rate = 1024  # Need to be power of two
    continuation_token = None
    encoding = None

    try:
        response = data_api.get_data(id, start, stop, streams, streams_token, shape, axis_order, bin_width, sample_rate, continuation_token, encoding)
        print(response.series)

        # Terminate Simulation
        message_res = jobs_api.terminate_simulation(branch_id, simulation_job.id)
        print(message_res.message)

    except ApiException as e:
        print("Exception when calling DataApi#getData")
        print(f"Status code: {e.status}")
        print(f"Reason: {e.body}")
        print(f"Response headers: {e.headers}")
        # Print exception traceback
        print(e)
        
        # Terminate Simulation
        message_res = jobs_api.terminate_simulation(branch_id, simulation_job.id)
        print(message_res.message)
        

# --------------------------------- ExternalsApi Testing ------------------------------------- #

# get_external_scenario() for Scenario      
def test_get_external_scenario(default_client):

    # Create an ExternalsApi
    externals_api = ExternalsApi(default_client)

    # Start a new simulation job
    jobs_api = JobsApi(default_client)
    branch_id = secrets["SIMPLE_SAT_SCEN_ID"]
    start_simulation_body = StartSimulationBody(seed=0)  # Assuming seed value
    simulation_job = jobs_api.start_simulation(branch_id, start_simulation_body)
    job_id = simulation_job.id

    status = simulation_job.status

    # Keep getting simulation status until 'RUNNING'
    while status != "RUNNING":
        simulation_job = jobs_api.get_simulation(branch_id, job_id)
        status = simulation_job.status
        print(f"Waiting for simulation to start (ID: {job_id}). Current status: '{status}'")
        sleep(1)

    print("Simulation started.")
    sleep(10)

    # Uncomment if you want to print SimulationJob
    # print(jobs_api.get_simulation(branch_id, job_id))

    agent_id = secrets["AGENT_EXTERNAL_ID"]
    external_state_block_id = secrets["EXTERNAL_STATE_BLOCK_ID"]
    time_value = None  # Provide a BigDecimal value if needed

    try:
        # Keep getting externals in a loop
        counter = 0
        while counter < 7:
            result = externals_api.get_external(job_id, agent_id, external_state_block_id, time_value)
            print(result)
            sleep(5)
            counter += 1

        # Terminate Simulation
        message_res = jobs_api.terminate_simulation(branch_id, job_id)
        print(message_res.message)

    except ApiException as e:
        print("Exception when calling ExternalsApi#get_external")
        print(f"Status code: {e.status}")
        print(f"Reason: {e.body}")
        print(f"Response headers: {e.headers}")

        # Terminate Simulation
        message_res = jobs_api.terminate_simulation(branch_id, job_id)
        print(message_res.message)


# put_external_scenario() for Scenario  
def test_put_external_scenario(default_client):

    # Create an ExternalsApi
    externals_api = ExternalsApi(default_client)

    # Start a new simulation job
    jobs_api = JobsApi(default_client)
    branch_id = secrets["SIMPLE_SAT_SCEN_ID"]
    start_simulation_body = StartSimulationBody(seed=0)  # Assuming seed value
    simulation_job = jobs_api.start_simulation(branch_id, start_simulation_body)
    job_id = simulation_job.id

    status = simulation_job.status

    # Keep getting simulation status until 'RUNNING'
    while status != "RUNNING":
        simulation_job = jobs_api.get_simulation(branch_id, job_id)
        status = simulation_job.status
        print(f"Waiting for simulation to start (ID: {job_id}). Current status: '{status}'")
        sleep(1)

    print("Simulation started.")

    # Uncomment if you want to print SimulationJob
    # print(jobs_api.get_simulation(branch_id, job_id))

    agent_id = secrets["AGENT_EXTERNAL_ID"]
    external_state_block_id = secrets["EXTERNAL_STATE_BLOCK_ID"]

    try:
        # Keep putting externals in a loop
        counter = 0
        while counter < 7:
            value_list = [77.11, 77.22, 77.33]  # List of values as BigDecimal
            external_state_set_request = ExternalStateSetRequest(values=value_list)

            result = externals_api.put_external(job_id, agent_id, external_state_block_id, external_state_set_request)
            print(result)

            sleep(5)
            counter += 1

        # Terminate Simulation
        message_res = jobs_api.terminate_simulation(branch_id, job_id)
        print(message_res.message)

    except ApiException as e:
        print("Exception when calling ExternalsApi#put_external")
        print(f"Status code: {e.status}")
        print(f"Reason: {e.body}")
        print(f"Response headers: {e.headers}")

        # Terminate Simulation
        message_res = jobs_api.terminate_simulation(branch_id, job_id)
        print(message_res.message)
        
# ------------------------------------ JobsApi Testing ---------------------------------------- #
        
# test_start_study() for Scenario         
def test_start_study_scenario(default_client):

    # Create API instances
    api_instance = JobsApi(default_client)
    branches_api = BranchesApi(default_client)
    metamodels_api = MetamodelsApi(default_client)

    # Get branch ID from secrets
    branch_id = secrets["SIMPLE_SAT_SCEN_ID"]

    try:
        # Create a new branch to commit changes to it and get the committed changes
        branch_create = BranchCreate(name="newBranch")
        branch_res = branches_api.create_branch(branch_id, branch_create)
        new_branch_id = branch_res.id

        # Prepare metamodel update
        update_block = {
            "id": secrets["CLOCK_CONFIG_ID"],
            "type": "ClockConfig",
            "startTime": 59911.0,
            "stopTime": 59921.11
        }

        metamodel_update_interface = MetamodelUpdateInterface(blocks=[update_block])
        
        metamodels_api.crud_template(new_branch_id, metamodel_update_interface)

        # Commit changes to the new branch
        commit_message = CommitMessage(commit_message="committed stopTime")
        branches_api.commit_to_branch(new_branch_id, commit_message)

        # Start study after changing stopTime
        start_study_body = StartStudyBody(iterations=1)
        study_job = api_instance.start_study(new_branch_id, start_study_body)
        job_id = study_job.id

        status = study_job.status.value

        # Keep looping until study is "RUNNING" and jobs are not null and study is running
        while status != "RUNNING" or not api_instance.get_study(new_branch_id, job_id).simulation_jobs:

            # Get status
            study_job = api_instance.get_study(new_branch_id, job_id)
            status = study_job.status.value
            print(f"Waiting for study to start (ID: {job_id}). Current status: '{status}'")
            sleep(1)

        # Terminate Simulations created by study
        if study_job.simulation_jobs:
            for sim_job in study_job.simulation_jobs:
                print(api_instance.terminate_simulation(new_branch_id, sim_job))

        # Terminate Study
        print(api_instance.terminate_study(new_branch_id, job_id))

        # Deleting the new branch
        branches_api.delete_branch(new_branch_id)

    except ApiException as e:
        print("Exception when calling JobsApi#start_study")
        print(f"Status code: {e.status}")
        print(f"Reason: {e.body}")
        print(f"Response headers: {e.headers}")

        # Deleting the new branch
        branches_api.delete_branch(new_branch_id)

# ----------------------------------- RepositoriesApi Testing --------------------------------------- #
        
# test_update_repo() for Scenario        
def test_update_repo_scenario(default_client):

    # Create RepositoriesApi instance
    api_instance = RepositoriesApi(default_client)

    try:
        # Create a new repo to test updateRepo()
        repo_create_req = RepoCreateReq(
            metamodel_type="Scenario",
            name="scenarioRepo",
            workspace=secrets["WORKSPACE_ID"]
        )
        repo_res = api_instance.create_repo(repo_create_req)
        repository_id = repo_res.id

        # Name before update
        print(f"Name before update: {api_instance.get_repo(repository_id).name}")

        # Update repository name
        repo_update_req = RepoUpdateReq(name="scenarioRepo_renamed")
        api_instance.update_repo(repository_id, repo_update_req)

        # Name after update
        print(f"Name after update: {api_instance.get_repo(repository_id).name}")

        # Deleting the repo
        api_instance.delete_repo(repository_id)

    except ApiException as e:
        print("Exception when calling RepositoriesApi#update_repo")
        print(f"Status code: {e.status}")
        print(f"Reason: {e.body}")
        print(f"Response headers: {e.headers}")
        
# test_update_repo() for Spacecraft         
def test_update_repo_spacecraft(default_client):

    # Create RepositoriesApi instance
    api_instance = RepositoriesApi(default_client)

    try:
        # Create a new repo to test updateRepo()
        repo_create_req = RepoCreateReq(
            metamodel_type="Spacecraft",
            name="spacecraftRepo",
            workspace=secrets["WORKSPACE_ID"]
        )
        repo_res = api_instance.create_repo(repo_create_req)
        repository_id = repo_res.id

        # Name before update
        print(f"Name before update: {api_instance.get_repo(repository_id).name}")

        # Update repository name
        repo_update_req = RepoUpdateReq(name="scenarioRepo_renamed")
        api_instance.update_repo(repository_id, repo_update_req)

        # Name after update
        print(f"Name after update: {api_instance.get_repo(repository_id).name}")

        # Deleting the repo
        api_instance.delete_repo(repository_id)

    except ApiException as e:
        print("Exception when calling RepositoriesApi#update_repo")
        print(f"Status code: {e.status}")
        print(f"Reason: {e.body}")
        print(f"Response headers: {e.headers}")
        
# test_update_repo() for TerrestrialVehicle          
def test_update_repo_terrestrialVehicle(default_client):

    # Create RepositoriesApi instance
    api_instance = RepositoriesApi(default_client)

    try:
        # Create a new repo to test updateRepo()
        repo_create_req = RepoCreateReq(
            metamodel_type="TerrestrialVehicle",
            name="terrestrialVehicleRepo",
            workspace=secrets["WORKSPACE_ID"]
        )
        repo_res = api_instance.create_repo(repo_create_req)
        repository_id = repo_res.id

        # Name before update
        print(f"Name before update: {api_instance.get_repo(repository_id).name}")

        # Update repository name
        repo_update_req = RepoUpdateReq(name="scenarioRepo_renamed")
        api_instance.update_repo(repository_id, repo_update_req)

        # Name after update
        print(f"Name after update: {api_instance.get_repo(repository_id).name}")

        # Deleting the repo
        api_instance.delete_repo(repository_id)

    except ApiException as e:
        print("Exception when calling RepositoriesApi#update_repo")
        print(f"Status code: {e.status}")
        print(f"Reason: {e.body}")
        print(f"Response headers: {e.headers}")
        
        
# ----------------------------------- MetamodelsApi Testing --------------------------------------- #

# crud_template_scenario() for Scenario
def test_crud_template_scenario(default_client):

    # Create MetamodelsApi and BranchesApi instances
    api_instance = MetamodelsApi(default_client)
    branches_api = BranchesApi(default_client)

    try:
        # Create a new branch
        branch_create = BranchCreate(name="scenarioBranch")
        new_branch_res = branches_api.create_branch(secrets["SIMPLE_SAT_SCEN_ID"], branch_create)
        new_branch_id = new_branch_res.id

        # Get branch_data and clockConfigId from the newly created branch
        branch_data = branches_api.get_branch(new_branch_id).data
        clock_config_id = branch_data.actual_instance.clock_config        

        # Print block before changes
        print("Block before changes: ")
        print(branch_data.actual_instance.blocks[clock_config_id])

        # Prepare metamodel update interface
        metamodel_update_interface = MetamodelUpdateInterface(
            blocks=[{                             # List of dictionaries of blocks to update
                "id": clock_config_id,                # clock_config_id
                "stopTime": 59911.6666,
                "type": "ClockConfig"
            }],
            delete=[secrets["BLOCK_IN_SCEN_ID"]]  # List containing the block ID to delete
        )  

        # Perform CRUD operation
        model_crud_res = api_instance.crud_template(new_branch_id, metamodel_update_interface)
        print(f"dateModified: {model_crud_res.branch.date_modified}")

        # Commit the changes
        commit_message = CommitMessage(commit_message="committed stopTime")
        print(branches_api.commit_to_branch(new_branch_id, commit_message))

        # Get branch_data and clockConfigId from the newly created branch after the update
        branch_data = branches_api.get_branch(new_branch_id).data
        clock_config_id = branch_data.actual_instance.clock_config 
        
        # Print block after changes
        print("Block after changes: changed 'stopTime'.")
        print(branch_data.actual_instance.blocks[clock_config_id])

        # Delete the branch
        branches_api.delete_branch(new_branch_id)

    except ApiException as e:
        print("Exception when calling MetamodelsApi#crud_template")
        print(f"Status code: {e.status}")
        print(f"Reason: {e.body}")
        print(f"Response headers: {e.headers}")

        
        
# crud_template_spacecraft() for Spacecraft
def test_crud_template_spacecraft(default_client):

    # Create MetamodelsApi and BranchesApi instances
    api_instance = MetamodelsApi(default_client)
    branches_api = BranchesApi(default_client)

    try:
        # Create a new branch
        branch_create = BranchCreate(name="spacecraftBranch")
        new_branch_res = branches_api.create_branch(secrets["SIMPLE_SAT_VEHI_ID"], branch_create)
        new_branch_id = new_branch_res.id

        # Get blockId and current disabled value
        block_id = secrets["BLOCK_IN_VEHI_ID"]
        new_disabled = not branches_api.get_branch(new_branch_id).data.actual_instance.blocks[block_id]["disabled"]

        # Print block before changes
        print("Block before changes: ")
        print(branches_api.get_branch(new_branch_id).data.actual_instance.blocks[block_id])

        # Prepare metamodel update interface
        metamodel_update_interface = MetamodelUpdateInterface(
            blocks=[
                {
                    "id": block_id,
                    "disabled": new_disabled,
                    "type": "Battery"
                }
            ]
        )

        # Perform CRUD operation
        model_crud_res = api_instance.crud_template(new_branch_id, metamodel_update_interface)
        print(f"dateModified: {model_crud_res.branch.date_modified}")

        # Commit the changes
        commit_message = CommitMessage(commit_message="committed disabled")
        print(branches_api.commit_to_branch(new_branch_id, commit_message))

        # Print block after changes
        print("Block after changes: changed 'disabled'.")
        print(branches_api.get_branch(new_branch_id).data.actual_instance.blocks[block_id])

        # Delete the branch
        branches_api.delete_branch(new_branch_id)

    except ApiException as e:
        print("Exception when calling MetamodelsApi#crud_template")
        print(f"Status code: {e.status}")
        print(f"Reason: {e.body}")
        print(f"Response headers: {e.headers}")
        e.print_stacktrace()
        # Delete the branch in case of exception
        branches_api.delete_branch(new_branch_id)
        
        
# crud_template_terrestrial_vehicle() for TerrestrialVehicle
def test_crud_template_terrestrialVehicle(default_client):

    # Create MetamodelsApi and BranchesApi instances
    api_instance = MetamodelsApi(default_client)
    branches_api = BranchesApi(default_client)

    try:
        # Create a new branch
        branch_create = BranchCreate(name="terrestrialVehicleBranch")
        new_branch_res = branches_api.create_branch(secrets["SUPER_SAT_TERR_VEHICLE_ID"], branch_create)
        new_branch_id = new_branch_res.id

        # Get blockId from secrets and print block before changes
        block_id = secrets["BLOCK_IN_TERR_VEHI_ID"]
        print("Block before changes: ")
        print(branches_api.get_branch(new_branch_id).data.actual_instance.blocks[block_id])

        # Prepare metamodel update interface
        metamodel_update_interface = MetamodelUpdateInterface(
            blocks=[
                {
                    "id": block_id,
                    "configurationType": "SERIES",  # configurationType is required
                    "disabled": True,
                    "type": "Battery"
                }
            ]
        )

        # Perform CRUD operation
        model_crud_res = api_instance.crud_template(new_branch_id, metamodel_update_interface)
        print(f"dateModified: {model_crud_res.branch.date_modified}")

        # Commit the changes
        commit_message = CommitMessage(commit_message="committed disabled")
        print(branches_api.commit_to_branch(new_branch_id, commit_message))

        # Print block after changes
        print("Block after changes: changed 'disabled'.")
        print(branches_api.get_branch(new_branch_id).data.actual_instance.blocks[block_id])

        # Delete the branch
        print(branches_api.delete_branch(new_branch_id).message)

    except ApiException as e:
        print("Exception when calling MetamodelsApi#crud_template")
        print(f"Status code: {e.status}")
        print(f"Reason: {e.body}")
        print(f"Response headers: {e.headers}")